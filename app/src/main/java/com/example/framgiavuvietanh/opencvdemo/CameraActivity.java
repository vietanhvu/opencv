package com.example.framgiavuvietanh.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

/**
 * Created by FRAMGIA\vu.viet.anh on 06/04/2018.
 */

public class CameraActivity extends AppCompatActivity
        implements CameraBridgeViewBase.CvCameraViewListener2 {

    private CameraView mOpenCvCameraView;

    public static Mat mat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mOpenCvCameraView = findViewById(R.id.camera_view);
        mOpenCvCameraView.setVisibility(View.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);
        mOpenCvCameraView.setPictureCallback(new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                mat = new Mat();
                Utils.bitmapToMat(bmp, mat);
                setResult(RESULT_OK);
                finish();
            }
        });
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOpenCvCameraView.takePicture();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mOpenCvCameraView != null) mOpenCvCameraView.enableView();
    }

    @Override
    protected void onPause() {
        if (mOpenCvCameraView != null) mOpenCvCameraView.disableView();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mOpenCvCameraView != null) mOpenCvCameraView.disableView();
        super.onDestroy();
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
    }

    @Override
    public void onCameraViewStopped() {
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        return inputFrame.rgba();
    }
}
