//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.objdetect;

import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;

public class Objdetect {

    public static final int CASCADE_DO_CANNY_PRUNING = 1, CASCADE_SCALE_IMAGE = 2,
            CASCADE_FIND_BIGGEST_OBJECT = 4, CASCADE_DO_ROUGH_SEARCH = 8;

    //
    // C++:  void groupRectangles(vector_Rect& rectList, vector_int& weights, int groupThreshold, double eps = 0.2)
    //

    //javadoc: groupRectangles(rectList, weights, groupThreshold, eps)
    public static void groupRectangles(MatOfRect rectList, MatOfInt weights, int groupThreshold,
            double eps) {
        groupRectangles_0(rectList.nativeObj, weights.nativeObj, groupThreshold, eps);
    }

    //javadoc: groupRectangles(rectList, weights, groupThreshold)
    public static void groupRectangles(MatOfRect rectList, MatOfInt weights, int groupThreshold) {
        groupRectangles_1(rectList.nativeObj, weights.nativeObj, groupThreshold);
    }

    // C++:  void groupRectangles(vector_Rect& rectList, vector_int& weights, int groupThreshold, double eps = 0.2)
    private static native void groupRectangles_0(long rectList_mat_nativeObj,
            long weights_mat_nativeObj, int groupThreshold, double eps);

    private static native void groupRectangles_1(long rectList_mat_nativeObj,
            long weights_mat_nativeObj, int groupThreshold);
}
