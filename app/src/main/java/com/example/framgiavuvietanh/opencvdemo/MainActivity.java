package com.example.framgiavuvietanh.opencvdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.framgiavuvietanh.opencvdemo.widgets.PolygonView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;

import static android.graphics.Canvas.EdgeType.BW;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import static org.opencv.imgproc.Imgproc.INTER_LINEAR;
import static org.opencv.imgproc.Imgproc.THRESH_OTSU;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.getPerspectiveTransform;
import static org.opencv.imgproc.Imgproc.threshold;
import static org.opencv.imgproc.Imgproc.warpPerspective;

public class MainActivity extends AppCompatActivity {

    private String mCurrentPhotoPath;

    private boolean ready;

    private View mProgressBar;

    private Mat mSrc;

    private MatOfPoint2f mApproxCurve;
    private List<PointF> listPoint = new ArrayList<>();
    private PolygonView mPolygonView;
    private FrameLayout sourceFrame;

    private ImageView mCropImageView;

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case SUCCESS:
                    ready = true;
                    break;
                default:
                    Toast.makeText(MainActivity.this, "OpenCV init fail.", Toast.LENGTH_SHORT).show();
                    super.onManagerConnected(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mPolygonView = findViewById(R.id.polygon_view);
        sourceFrame = (FrameLayout) findViewById(R.id.source_frame);

        setSupportActionBar(toolbar);

        mCropImageView = findViewById(R.id.crop_image_view);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPolygonView.setVisibility(View.GONE);
                if (ready) {
                    mSrc = null;
                    mApproxCurve = null;
                    mCropImageView.setImageBitmap(null);
                    //startActivityForResult(new Intent(MainActivity.this, CameraActivity.class),
                    //        102);
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    // Ensure that there's a camera activity to handle the intent
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        // Create the File where the photo should go
                        File photoFile = null;
                        try {
                            photoFile = createImageFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            // Error occurred while creating the File
                        }
                        // Continue only if the File was successfully created
                        if (photoFile != null) {
                            Uri photoURI =
                                    FileProvider.getUriForFile(MainActivity.this, "com.example.android.fileprovider",
                                            photoFile);
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                            startActivityForResult(takePictureIntent, 101);
                        }
                    }
                    //try {
                    //    mImageView.setImageBitmap(findRectangle(
                    //            Utils.loadResource(MainActivity.this, R.drawable.test)));
                    //} catch (Exception e) {
                    //    e.printStackTrace();
                    //}
                } else {
                    Snackbar.make(view, "OpenCV is not loaded.", Snackbar.LENGTH_LONG).setAction("Hide", null).show();
                }
            }
        });
        findViewById(R.id.fab_rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPolygonView.setVisibility(View.GONE);
                if (mSrc != null && mApproxCurve != null) {
                    getImageFromPolygonView();
                    mCropImageView.setImageBitmap(fixPerspective(mSrc, mApproxCurve));
                } else {
                    Snackbar.make(view, "Cannot detect any rectangle.", Snackbar.LENGTH_LONG)
                            .setAction("Hide", null)
                            .show();
                }
            }
        });
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.sae);
        mCropImageView.setImageBitmap(bm); //
        List<Point> lp = new ArrayList<>();
        lp.add(new Point(0, 0));
        lp.add(new Point(bm.getWidth(), 0));
        lp.add(new Point(bm.getWidth(), bm.getHeight()));
        lp.add(new Point(0, bm.getHeight()));
        mProgressBar = findViewById(R.id.progress_bar);
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, getApplicationContext(), mLoaderCallback);
    }

    private void setBitmap(Bitmap bitmap) {
        mPolygonView.setVisibility(View.VISIBLE);
        Bitmap scaledBitmap = scaledBitmap(bitmap, sourceFrame.getWidth(), sourceFrame.getHeight());
        mCropImageView.setImageBitmap(scaledBitmap);
        Bitmap tempBitmap = ((BitmapDrawable) mCropImageView.getDrawable()).getBitmap();
        Mat mat = new Mat();
        Utils.bitmapToMat(tempBitmap, mat);

        mSrc = mat;
        float sWidth = 0;
        float sHeight = 0;
        for (PointF point : listPoint) {
            point.x *= mat.size().width / bitmap.getWidth();
            point.y *= mat.size().height / bitmap.getHeight();
            sWidth += point.x;
            sHeight += point.y;
        }

        if (listPoint.size() == 0) {
            listPoint.add(new PointF(0, 0));
            listPoint.add(new PointF(0, (float) mat.size().height));
            listPoint.add(new PointF((float) mat.size().width, (float) mat.size().height));
            listPoint.add(new PointF((float) mat.size().width, 0));
            sWidth += mat.size().width;
            sHeight += mat.size().height;
        }

        PointF[] tmpPoints = new PointF[4];
        for (PointF point : listPoint) {
            if (point.x < sWidth / 4 && point.y < sHeight / 4) {
                tmpPoints[0] = point;
            }
            if (point.x < sWidth / 4 && point.y > sHeight / 4) {
                tmpPoints[1] = point;
            }
            if (point.x > sWidth / 4 && point.y < sHeight / 4) {
                tmpPoints[3] = point;
            }
            if (point.x > sWidth / 4 && point.y > sHeight / 4) {
                tmpPoints[2] = point;
            }
        }

        listPoint.clear();
        for (PointF pointF : tmpPoints) {
            listPoint.add(pointF);
        }
        initPolygonView(tempBitmap, listPoint);
    }

    private Bitmap scaledBitmap(Bitmap bitmap, int width, int height) {
        Matrix m = new Matrix();
        m.setRectToRect(new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0, 0, width, height),
                Matrix.ScaleToFit.CENTER);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
    }

    private void initPolygonView(Bitmap bitmap, List<PointF> pointFs) {
        Map<Integer, PointF> orderedPoints = orderedValidEdgePoints(bitmap, pointFs);
        mPolygonView.setPoints(orderedPoints);
        int padding = (int) getResources().getDimension(R.dimen.fab_margin);
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(bitmap.getWidth() + 2 * padding, bitmap.getHeight() + 2 * padding);
        layoutParams.gravity = Gravity.CENTER;
        mPolygonView.setLayoutParams(layoutParams);
    }

    private Map<Integer, PointF> orderedValidEdgePoints(Bitmap tempBitmap, List<PointF> pointFs) {
        Map<Integer, PointF> orderedPoints = mPolygonView.getOrderedPoints(pointFs);
        if (!mPolygonView.isValidShape(orderedPoints)) {
            orderedPoints = getOutlinePoints(tempBitmap);
        }
        return orderedPoints;
    }

    private Map<Integer, PointF> getOutlinePoints(Bitmap tempBitmap) {
        Map<Integer, PointF> outlinePoints = new HashMap<>();
        outlinePoints.put(0, new PointF(0, 0));
        outlinePoints.put(1, new PointF(tempBitmap.getWidth(), 0));
        outlinePoints.put(2, new PointF(0, tempBitmap.getHeight()));
        outlinePoints.put(3, new PointF(tempBitmap.getWidth(), tempBitmap.getHeight()));
        return outlinePoints;
    }

    private void getImageFromPolygonView() {
        Map<Integer, PointF> mapPoint = mPolygonView.getPoints();
        PointF[] pointFS = new PointF[4];
        float sWidth = 0;
        float sHeight = 0;
        for (int i = 0; i < 4; i++) {
            pointFS[i] = mapPoint.get(i);
            sWidth += mapPoint.get(i).x;
            sHeight += mapPoint.get(i).y;
        }

        PointF[] tmpPoints = new PointF[4];
        for (PointF point : pointFS) {
            if (point.x < sWidth / 4 && point.y < sHeight / 4) {
                tmpPoints[0] = point;
            }
            if (point.x < sWidth / 4 && point.y > sHeight / 4) {
                tmpPoints[1] = point;
            }
            if (point.x > sWidth / 4 && point.y < sHeight / 4) {
                tmpPoints[3] = point;
            }
            if (point.x > sWidth / 4 && point.y > sHeight / 4) {
                tmpPoints[2] = point;
            }
        }

        listPoint.clear();
        for (PointF pointF : tmpPoints) {
            listPoint.add(pointF);
        }

        List<Point> points = new ArrayList<>();
        for (PointF pointF : listPoint) {
            Point point = new Point(pointF.x, pointF.y);
            points.add(point);
        }
        mApproxCurve.fromList(points);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 101) {
            mProgressBar.setVisibility(View.VISIBLE);
            new AsyncTask<Void, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(Void... voids) {
                    try {
                        Mat mat = new Mat();
                        Bitmap bitmap = ImageUtils.fixImageOrientation(BitmapFactory.decodeFile(mCurrentPhotoPath),
                                mCurrentPhotoPath);
                        Utils.bitmapToMat(bitmap, mat);
                        mSrc = mat;
                        return findRectangle(mat);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    if (bitmap != null) {
                        //mCropImageView.setImageBitmap(bitmap);
                        setBitmap(bitmap);
                    }
                    mProgressBar.setVisibility(View.GONE);
                }
            }.execute();
            return;
        }

        if (resultCode == RESULT_OK && requestCode == 102) {
            mProgressBar.setVisibility(View.VISIBLE);
            new AsyncTask<Void, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(Void... voids) {
                    try {
                        return findRectangle(CameraActivity.mat);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    if (bitmap != null) {
                        mCropImageView.setImageBitmap(bitmap);
                    }
                    mProgressBar.setVisibility(View.GONE);
                }
            }.execute();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */);

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private Bitmap findRectangle(Mat src) throws Exception {
        Mat clone = src.clone(), gray = new Mat(), blur = new Mat(), canny = new Mat();
        cvtColor(clone, gray, COLOR_BGR2GRAY);
        threshold(gray, gray, 0, 255, THRESH_OTSU);
        Imgproc.blur(gray, blur, new Size(3, 3));
        List<MatOfPoint> contours = new ArrayList<>();

        MatOfPoint2f approxCurve = null;

        double maxArea = 5000;
        int maxId = -1;

        Imgproc.Canny(blur, canny, 0, 100, 3, true); // true ?
        Imgproc.dilate(canny, canny, new Mat(), new Point(-1, -1), 1); // 1

        Imgproc.findContours(canny, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            MatOfPoint2f temp = new MatOfPoint2f(contour.toArray());

            double area = Imgproc.contourArea(contour);
            if (area < maxArea) continue;

            approxCurve = new MatOfPoint2f();
            Imgproc.approxPolyDP(temp, approxCurve, Imgproc.arcLength(temp, true) * 0.02, true);

            if (approxCurve.total() == 4) {
                maxArea = area;
                maxId = contours.indexOf(contour);
            }
        }

        if (maxId >= 0) {
            Imgproc.drawContours(src, contours, maxId, new Scalar(255, 0, 0, 255), 8, BW.ordinal(), new Mat(), 1,
                    new Point());
            mApproxCurve = approxCurve;

            MatOfPoint2f approxCurve2 = null;
            MatOfPoint2f temp = new MatOfPoint2f(contours.get(maxId).toArray());
            approxCurve2 = new MatOfPoint2f();
            Imgproc.approxPolyDP(temp, approxCurve2, Imgproc.arcLength(temp, true) * 0.02, true);
            listPoint.clear();
            for (Point point : approxCurve2.toList()) {
                PointF pointF = new PointF((float) point.x, (float) point.y);
                listPoint.add(pointF);
            }
        }

        Bitmap bmp = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(src, bmp);

        return bmp;
    }

    private Bitmap fixPerspective(Mat src, MatOfPoint2f approxCurve) {
        RotatedRect rect = Imgproc.minAreaRect(approxCurve);
        // Be sure that largest side is the height
        if (rect.size.width > rect.size.height) {
            double tempW = rect.size.width;
            rect.size.width = rect.size.height;
            rect.size.height = tempW;
            rect.angle -= 90.f;
        }

        List<Point> l = approxCurve.toList();
        double rightEdge = euclideanDistance(l.get(0), l.get(1));
        double leftEdge = euclideanDistance(l.get(0), l.get(3));
        Mat src1;
        List<Point> lp = new ArrayList<>();
        if (leftEdge > rightEdge) {
            lp.add(l.get(1));
            lp.add(l.get(0));
            lp.add(l.get(3));
            lp.add(l.get(2));
        } else {
            lp.add(l.get(2));
            lp.add(l.get(1));
            lp.add(l.get(0));
            lp.add(l.get(3));
        }
        src1 = Converters.vector_Point2f_to_Mat(lp);

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));
        list.add(new Point(rect.size.width - 1, 0));
        list.add(new Point(rect.size.width - 1, rect.size.height - 1));
        list.add(new Point(0, rect.size.height - 1));
        Mat dst = Converters.vector_Point2f_to_Mat(list);

        Mat perspective_matrix = getPerspectiveTransform(src1, dst);
        Mat dstImg = new Mat((int) (rect.size.height - 1), (int) (rect.size.width - 1), CvType.CV_8UC1);
        warpPerspective(src, dstImg, perspective_matrix, new Size(rect.size.width - 1, rect.size.height - 1),
                INTER_LINEAR);

        Bitmap bmp = Bitmap.createBitmap(dstImg.cols(), dstImg.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(dstImg, bmp);

        return bmp;
    }

    public double euclideanDistance(Point a, Point b) {
        double distance = 0.0;
        try {
            if (a != null && b != null) {
                double xDiff = a.x - b.x;
                double yDiff = a.y - b.y;
                distance = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return distance;
    }

    private double angle(Point p1, Point p2, Point p0) {
        double dx1 = p1.x - p0.x;
        double dy1 = p1.y - p0.y;
        double dx2 = p2.x - p0.x;
        double dy2 = p2.y - p0.y;
        return (dx1 * dx2 + dy1 * dy2) / Math.sqrt((dx1 * dx1 + dy1 * dy1) * (dx2 * dx2 + dy2 * dy2) + 1e-10);
    }
}
