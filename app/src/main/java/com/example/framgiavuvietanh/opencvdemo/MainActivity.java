package com.example.framgiavuvietanh.opencvdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.framgiavuvietanh.opencvdemo.widgets.CropImageView;
import com.example.framgiavuvietanh.opencvdemo.widgets.HighlightView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.utils.Converters;

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

    private List<Point> mApproxCurve = new ArrayList<>();

    private CropImageView mCropImageView;

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case SUCCESS:
                    ready = true;
                    break;
                default:
                    Toast.makeText(MainActivity.this, "OpenCV init fail.", Toast.LENGTH_SHORT)
                            .show();
                    super.onManagerConnected(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mCropImageView = findViewById(R.id.crop_image_view);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ready) {
                    mSrc = null;
                    mCropImageView.setHighlightView(null);
                    mCropImageView.setImageBitmapResetBase(null, true);
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
                            Uri photoURI = FileProvider.getUriForFile(MainActivity.this,
                                    "com.example.android.fileprovider", photoFile);
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                            startActivityForResult(takePictureIntent, 101);
                        }
                    }
                    //try {
                    //    mImageView.setImageBitmapResetBase(findRectangle(
                    //            Utils.loadResource(MainActivity.this, R.drawable.test)));
                    //} catch (Exception e) {
                    //    e.printStackTrace();
                    //}
                } else {
                    Snackbar.make(view, "OpenCV is not loaded.", Snackbar.LENGTH_LONG)
                            .setAction("Hide", null)
                            .show();
                }
            }
        });
        findViewById(R.id.fab_rotate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSrc != null && mApproxCurve != null && !mApproxCurve.isEmpty()) {
                    mCropImageView.setHighlightView(null);
                    mCropImageView.setImageBitmapResetBase(fixPerspective(mSrc, mApproxCurve),
                            true);
                } else {
                    Snackbar.make(view, "Cannot detect any rectangle.", Snackbar.LENGTH_LONG)
                            .setAction("Hide", null)
                            .show();
                }
            }
        });

        findViewById(R.id.fab_crop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSrc != null) {
                    float[] pts = mCropImageView.getHighlightView().getTrapezoid();
                    mCropImageView.setHighlightView(null);
                    mCropImageView.setImageBitmapResetBase(fixPerspective(mSrc, pts), true);
                } else {
                    Snackbar.make(view, "Cannot detect any rectangle.", Snackbar.LENGTH_LONG)
                            .setAction("Hide", null)
                            .show();
                }
            }
        });
        mProgressBar = findViewById(R.id.progress_bar);
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, getApplicationContext(),
                mLoaderCallback);
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
                        Utils.bitmapToMat(
                                com.example.framgiavuvietanh.opencvdemo.Utils.rotateBitmap(
                                        BitmapFactory.decodeFile(mCurrentPhotoPath),
                                        com.example.framgiavuvietanh.opencvdemo.Utils.getExifOrientation(
                                                mCurrentPhotoPath)), mat);
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
                        mCropImageView.setImageBitmapResetBase(bitmap, true);
                        if (mApproxCurve != null && !mApproxCurve.isEmpty()) {
                            mCropImageView.setHighlightView(new HighlightView(mCropImageView,
                                    new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
                                    mApproxCurve));
                        } else {
                            List<Point> lp = new ArrayList<>();
                            lp.add(new Point(0, 0));
                            lp.add(new Point(bitmap.getWidth(), 0));
                            lp.add(new Point(bitmap.getWidth(), bitmap.getHeight()));
                            lp.add(new Point(0, bitmap.getHeight()));
                            mCropImageView.setHighlightView(new HighlightView(mCropImageView,
                                    new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), lp));
                        }
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
                        mCropImageView.setImageBitmapResetBase(bitmap, true);
                        if (mApproxCurve != null && !mApproxCurve.isEmpty()) {
                            mCropImageView.setHighlightView(new HighlightView(mCropImageView,
                                    new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
                                    mApproxCurve));
                        } else {
                            List<Point> lp = new ArrayList<>();
                            lp.add(new Point(0, 0));
                            lp.add(new Point(bitmap.getWidth(), 0));
                            lp.add(new Point(bitmap.getWidth(), bitmap.getHeight()));
                            lp.add(new Point(0, bitmap.getHeight()));
                            mCropImageView.setHighlightView(new HighlightView(mCropImageView,
                                    new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), lp));
                        }
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
        //Imgproc.medianBlur(src, blurred, 9);
        //
        //Mat gray0 = new Mat(blurred.size(), CvType.CV_8U), gray = new Mat();
        //
        List<MatOfPoint> contours = new ArrayList<>();
        //
        //List<Mat> blurredChannel = new ArrayList<>();
        //blurredChannel.setHighlightView(blurred);
        //List<Mat> gray0Channel = new ArrayList<>();
        //gray0Channel.setHighlightView(gray0);

        MatOfPoint2f approxCurve = null;

        double maxArea = 5000;
        int maxId = -1;

        //for (int c = 0; c < 3; c++) {
        //    int ch[] = { c, 0 };
        //    Core.mixChannels(blurredChannel, gray0Channel, new MatOfInt(ch));

        Imgproc.Canny(blur, canny, 0, 100, 3, true); // true ?
        Imgproc.dilate(canny, canny, new Mat(), new Point(-1, -1), 1); // 1

        Imgproc.findContours(canny, contours, new Mat(), Imgproc.RETR_EXTERNAL,
                Imgproc.CHAIN_APPROX_SIMPLE);

        for (MatOfPoint contour : contours) {
            MatOfPoint2f temp = new MatOfPoint2f(contour.toArray());

            double area = Imgproc.contourArea(contour);
            if (area < maxArea) continue;

            approxCurve = new MatOfPoint2f();
            Imgproc.approxPolyDP(temp, approxCurve, Imgproc.arcLength(temp, true) * 0.02, true);

            if (approxCurve.total() == 4) {
                //double maxCosine = 0;

                //List<Point> curves = approxCurve.toList();
                //for (int j = 2; j < 5; j++) {

                //double cosine = Math.abs(
                //        angle(curves.get(j % 4), curves.get(j - 2), curves.get(j - 1)));
                //maxCosine = Math.max(maxCosine, cosine);
                //}

                //if (maxCosine < 0.3) {
                maxArea = area;
                maxId = contours.indexOf(contour);
                //}
            }
        }
        //}

        if (maxId >= 0) {
            mApproxCurve = approxCurve.toList();
            //circle(src, approxCurve.toList().get(0), 150, new Scalar(0, 0, 255, 255), 10);
        }

        Bitmap bmp = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(src, bmp);

        return bmp;
    }

    private Bitmap fixPerspective(Mat src, float[] trapezoid) {
        //the 4 points of the quad
        Point ocvPIn1 = new Point((int) trapezoid[6], (int) trapezoid[7]);//tl
        Point ocvPIn2 = new Point((int) trapezoid[4], (int) trapezoid[5]); //tr
        Point ocvPIn3 = new Point((int) trapezoid[2], (int) trapezoid[3]);//br
        Point ocvPIn4 = new Point((int) trapezoid[0], (int) trapezoid[1]);//bl
        List<Point> p = new ArrayList<>();
        p.add(ocvPIn1);
        p.add(ocvPIn2);
        p.add(ocvPIn3);
        p.add(ocvPIn4);
        return fixPerspective(src, p);
    }

    private Bitmap fixPerspective(Mat src, List<Point> approxCurve) {
        RotatedRect rect = Imgproc.minAreaRect(
                new MatOfPoint2f(approxCurve.toArray(new Point[approxCurve.size()])));
        // Be sure that largest side is the height
        if (rect.size.width > rect.size.height) {
            double tempW = rect.size.width;
            rect.size.width = rect.size.height;
            rect.size.height = tempW;
            rect.angle -= 90.f;
        }

        double rightEdge = euclideanDistance(approxCurve.get(0), approxCurve.get(1));
        double leftEdge = euclideanDistance(approxCurve.get(0), approxCurve.get(3));
        Mat src1;
        List<Point> lp = new ArrayList<>();
        if (leftEdge > rightEdge) {
            lp.add(approxCurve.get(1));
            lp.add(approxCurve.get(0));
            lp.add(approxCurve.get(3));
            lp.add(approxCurve.get(2));
        } else {
            lp.add(approxCurve.get(2));
            lp.add(approxCurve.get(1));
            lp.add(approxCurve.get(0));
            lp.add(approxCurve.get(3));
        }
        src1 = Converters.vector_Point2f_to_Mat(lp);

        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));
        list.add(new Point(rect.size.width - 1, 0));
        list.add(new Point(rect.size.width - 1, rect.size.height - 1));
        list.add(new Point(0, rect.size.height - 1));
        Mat dst = Converters.vector_Point2f_to_Mat(list);

        Mat perspective_matrix = getPerspectiveTransform(src1, dst);
        Mat dstImg =
                new Mat((int) (rect.size.height - 1), (int) (rect.size.width - 1), CvType.CV_8UC1);
        warpPerspective(src, dstImg, perspective_matrix,
                new Size(rect.size.width - 1, rect.size.height - 1), INTER_LINEAR);

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
        return (dx1 * dx2 + dy1 * dy2) / Math.sqrt(
                (dx1 * dx1 + dy1 * dy1) * (dx2 * dx2 + dy2 * dy2) + 1e-10);
    }
}
