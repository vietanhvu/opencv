//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.objdetect;

import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;

// C++: class CascadeClassifier
//javadoc: CascadeClassifier
public class CascadeClassifier {

    protected final long nativeObj;

    protected CascadeClassifier(long addr) {
        nativeObj = addr;
    }

    //
    // C++:   CascadeClassifier()
    //

    //javadoc: CascadeClassifier::CascadeClassifier()
    public CascadeClassifier() {

        nativeObj = CascadeClassifier_0();
    }

    //
    // C++:   CascadeClassifier(String filename)
    //

    //javadoc: CascadeClassifier::CascadeClassifier(filename)
    public CascadeClassifier(String filename) {

        nativeObj = CascadeClassifier_1(filename);
    }

    //
    // C++:  bool load(String filename)
    //

    //javadoc: CascadeClassifier::convert(oldcascade, newcascade)
    public static boolean convert(String oldcascade, String newcascade) {

        return convert_0(oldcascade, newcascade);
    }

    //
    // C++:  bool empty()
    //

    // C++:   CascadeClassifier()
    private static native long CascadeClassifier_0();

    //
    // C++:  bool read(FileNode node)
    //

    // Unknown type 'FileNode' (I), skipping the function

    //
    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size())
    //

    // C++:   CascadeClassifier(String filename)
    private static native long CascadeClassifier_1(String filename);

    // C++:  bool load(String filename)
    private static native boolean load_0(long nativeObj, String filename);

    //
    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, vector_int& numDetections, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size())
    //

    // C++:  bool empty()
    private static native boolean empty_0(long nativeObj);

    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size())
    private static native void detectMultiScale_0(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj, double scaleFactor, int minNeighbors, int flags,
            double minSize_width, double minSize_height, double maxSize_width,
            double maxSize_height);

    //
    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, vector_int& rejectLevels, vector_double& levelWeights, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size(), bool outputRejectLevels = false)
    //

    private static native void detectMultiScale_1(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj);

    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, vector_int& numDetections, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size())
    private static native void detectMultiScale2_0(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj, long numDetections_mat_nativeObj, double scaleFactor,
            int minNeighbors, int flags, double minSize_width, double minSize_height,
            double maxSize_width, double maxSize_height);

    //
    // C++:  bool isOldFormatCascade()
    //

    private static native void detectMultiScale2_1(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj, long numDetections_mat_nativeObj);

    //
    // C++:  Size getOriginalWindowSize()
    //

    // C++:  void detectMultiScale(Mat image, vector_Rect& objects, vector_int& rejectLevels, vector_double& levelWeights, double scaleFactor = 1.1, int minNeighbors = 3, int flags = 0, Size minSize = Size(), Size maxSize = Size(), bool outputRejectLevels = false)
    private static native void detectMultiScale3_0(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj, long rejectLevels_mat_nativeObj,
            long levelWeights_mat_nativeObj, double scaleFactor, int minNeighbors, int flags,
            double minSize_width, double minSize_height, double maxSize_width,
            double maxSize_height, boolean outputRejectLevels);

    //
    // C++:  int getFeatureType()
    //

    private static native void detectMultiScale3_1(long nativeObj, long image_nativeObj,
            long objects_mat_nativeObj, long rejectLevels_mat_nativeObj,
            long levelWeights_mat_nativeObj);

    //
    // C++: static bool convert(String oldcascade, String newcascade)
    //

    // C++:  bool isOldFormatCascade()
    private static native boolean isOldFormatCascade_0(long nativeObj);

    // C++:  Size getOriginalWindowSize()
    private static native double[] getOriginalWindowSize_0(long nativeObj);

    // C++:  int getFeatureType()
    private static native int getFeatureType_0(long nativeObj);

    // C++: static bool convert(String oldcascade, String newcascade)
    private static native boolean convert_0(String oldcascade, String newcascade);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: CascadeClassifier::load(filename)
    public boolean load(String filename) {

        return load_0(nativeObj, filename);
    }

    //javadoc: CascadeClassifier::empty()
    public boolean empty() {

        return empty_0(nativeObj);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects, scaleFactor, minNeighbors, flags, minSize, maxSize)
    public void detectMultiScale(Mat image, MatOfRect objects, double scaleFactor, int minNeighbors,
            int flags, Size minSize, Size maxSize) {
        detectMultiScale_0(nativeObj, image.nativeObj, objects.nativeObj, scaleFactor, minNeighbors,
                flags, minSize.width, minSize.height, maxSize.width, maxSize.height);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects)
    public void detectMultiScale(Mat image, MatOfRect objects) {
        detectMultiScale_1(nativeObj, image.nativeObj, objects.nativeObj);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects, numDetections, scaleFactor, minNeighbors, flags, minSize, maxSize)
    public void detectMultiScale2(Mat image, MatOfRect objects, MatOfInt numDetections,
            double scaleFactor, int minNeighbors, int flags, Size minSize, Size maxSize) {
        detectMultiScale2_0(nativeObj, image.nativeObj, objects.nativeObj, numDetections.nativeObj,
                scaleFactor, minNeighbors, flags, minSize.width, minSize.height, maxSize.width,
                maxSize.height);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects, numDetections)
    public void detectMultiScale2(Mat image, MatOfRect objects, MatOfInt numDetections) {
        detectMultiScale2_1(nativeObj, image.nativeObj, objects.nativeObj, numDetections.nativeObj);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects, rejectLevels, levelWeights, scaleFactor, minNeighbors, flags, minSize, maxSize, outputRejectLevels)
    public void detectMultiScale3(Mat image, MatOfRect objects, MatOfInt rejectLevels,
            MatOfDouble levelWeights, double scaleFactor, int minNeighbors, int flags, Size minSize,
            Size maxSize, boolean outputRejectLevels) {
        detectMultiScale3_0(nativeObj, image.nativeObj, objects.nativeObj, rejectLevels.nativeObj,
                levelWeights.nativeObj, scaleFactor, minNeighbors, flags, minSize.width,
                minSize.height, maxSize.width, maxSize.height, outputRejectLevels);
    }

    //javadoc: CascadeClassifier::detectMultiScale(image, objects, rejectLevels, levelWeights)
    public void detectMultiScale3(Mat image, MatOfRect objects, MatOfInt rejectLevels,
            MatOfDouble levelWeights) {
        detectMultiScale3_1(nativeObj, image.nativeObj, objects.nativeObj, rejectLevels.nativeObj,
                levelWeights.nativeObj);
    }

    //javadoc: CascadeClassifier::isOldFormatCascade()
    public boolean isOldFormatCascade() {

        return isOldFormatCascade_0(nativeObj);
    }

    //javadoc: CascadeClassifier::getOriginalWindowSize()
    public Size getOriginalWindowSize() {

        return new Size(getOriginalWindowSize_0(nativeObj));
    }

    //javadoc: CascadeClassifier::getFeatureType()
    public int getFeatureType() {

        return getFeatureType_0(nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
