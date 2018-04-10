package com.example.framgiavuvietanh.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.IOException;

/**
 * Created by FRAMGIA\vu.viet.anh on 10/04/2018.
 */

public class Utils {

    public static int getExifOrientation(String src) {
        int orientation = ExifInterface.ORIENTATION_NORMAL;
        try {
            ExifInterface exifInterface = new ExifInterface(src);
            orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_NORMAL:
                    return 90;
                case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                    return 0;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return 180;
                case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                    return 0;
                case ExifInterface.ORIENTATION_TRANSPOSE:
                    return 0;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return 90;
                case ExifInterface.ORIENTATION_TRANSVERSE:
                    return 0;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    return 270;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return orientation;
    }

    public static Bitmap rotateBitmap(Bitmap in, int angle) {
        Matrix matrix = new Matrix();

        matrix.postRotate(angle);

        return Bitmap.createBitmap(in, 0, 0, in.getWidth(), in.getHeight(), matrix, true);
    }
}
