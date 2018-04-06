package com.example.framgiavuvietanh.opencvdemo;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import java.util.List;
import org.opencv.android.JavaCameraView;

/**
 * Created by FRAMGIA\vu.viet.anh on 06/04/2018.
 */

public class CameraView extends JavaCameraView implements Camera.PictureCallback {

    private Camera.PictureCallback mPictureCallback;

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public List<Camera.Size> getResolutionList() {
        return mCamera.getParameters().getSupportedPictureSizes();
    }

    public void setResolution(Camera.Size resolution) {
        disconnectCamera();
        mMaxHeight = resolution.height;
        mMaxWidth = resolution.width;
        connectCamera(getWidth(), getHeight());
    }

    public Camera.Size getResolution() {
        return mCamera.getParameters().getPreviewSize();
    }

    public void takePicture() {
        // Postview and jpeg are sent in the same buffers if the queue is not empty when performing a capture.
        // Clear up buffers to avoid mCamera.takePicture to be stuck because of a memory issue
        mCamera.setPreviewCallback(null);

        // PictureCallback is implemented by the current class
        mCamera.takePicture(null, null, this);
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        // The camera preview was automatically stopped. Start it again.
        mCamera.startPreview();
        mCamera.setPreviewCallback(this);
        if (mPictureCallback != null) {
            mPictureCallback.onPictureTaken(data, camera);
        }
    }

    public void setPictureCallback(Camera.PictureCallback pictureCallback) {
        mPictureCallback = pictureCallback;
    }
}
