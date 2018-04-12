package com.example.framgiavuvietanh.opencvdemo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.IOException;

/**
 * Created by nguyen.van.mui on 11/04/2018.
 */

public class ImageUtils {
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Bitmap retVal;

        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        retVal = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);

        return retVal;
    }

    public static Bitmap fixImageOrientation(Bitmap bitmap, String imgUri) {
        Bitmap finalBitmap;

        ExifInterface ei;
        try {
            ei = new ExifInterface(imgUri);
            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);

            switch (orientation) {
                case ExifInterface.ORIENTATION_NORMAL:
                    finalBitmap = rotateImage(bitmap, 90);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    finalBitmap = rotateImage(bitmap, 90);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    finalBitmap = rotateImage(bitmap, 180);
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    finalBitmap = rotateImage(bitmap, 270);
                    break;
                default:
                    finalBitmap = bitmap;
                    break;
            }

            return finalBitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
