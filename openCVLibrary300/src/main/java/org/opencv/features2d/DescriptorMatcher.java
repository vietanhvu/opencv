//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.features2d;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.utils.Converters;

// C++: class javaDescriptorMatcher
//javadoc: javaDescriptorMatcher
public class DescriptorMatcher {

    public static final int FLANNBASED = 1, BRUTEFORCE = 2, BRUTEFORCE_L1 = 3, BRUTEFORCE_HAMMING =
            4, BRUTEFORCE_HAMMINGLUT = 5, BRUTEFORCE_SL2 = 6;
    protected final long nativeObj;

    protected DescriptorMatcher(long addr) {
        nativeObj = addr;
    }

    //
    // C++:  bool isMaskSupported()
    //

    //javadoc: javaDescriptorMatcher::create(matcherType)
    public static DescriptorMatcher create(int matcherType) {

        return new DescriptorMatcher(create_0(matcherType));
    }

    //
    // C++:  void add(vector_Mat descriptors)
    //

    // C++:  bool isMaskSupported()
    private static native boolean isMaskSupported_0(long nativeObj);

    //
    // C++:  vector_Mat getTrainDescriptors()
    //

    // C++:  void add(vector_Mat descriptors)
    private static native void add_0(long nativeObj, long descriptors_mat_nativeObj);

    //
    // C++:  void clear()
    //

    // C++:  vector_Mat getTrainDescriptors()
    private static native long getTrainDescriptors_0(long nativeObj);

    //
    // C++:  bool empty()
    //

    // C++:  void clear()
    private static native void clear_0(long nativeObj);

    //
    // C++:  void train()
    //

    // C++:  bool empty()
    private static native boolean empty_0(long nativeObj);

    //
    // C++:  void match(Mat queryDescriptors, Mat trainDescriptors, vector_DMatch& matches, Mat mask = Mat())
    //

    // C++:  void train()
    private static native void train_0(long nativeObj);

    // C++:  void match(Mat queryDescriptors, Mat trainDescriptors, vector_DMatch& matches, Mat mask = Mat())
    private static native void match_0(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj, long mask_nativeObj);

    //
    // C++:  void knnMatch(Mat queryDescriptors, Mat trainDescriptors, vector_vector_DMatch& matches, int k, Mat mask = Mat(), bool compactResult = false)
    //

    private static native void match_1(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj);

    // C++:  void knnMatch(Mat queryDescriptors, Mat trainDescriptors, vector_vector_DMatch& matches, int k, Mat mask = Mat(), bool compactResult = false)
    private static native void knnMatch_0(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj, int k, long mask_nativeObj,
            boolean compactResult);

    //
    // C++:  void radiusMatch(Mat queryDescriptors, Mat trainDescriptors, vector_vector_DMatch& matches, float maxDistance, Mat mask = Mat(), bool compactResult = false)
    //

    private static native void knnMatch_1(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj, int k);

    // C++:  void radiusMatch(Mat queryDescriptors, Mat trainDescriptors, vector_vector_DMatch& matches, float maxDistance, Mat mask = Mat(), bool compactResult = false)
    private static native void radiusMatch_0(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj, float maxDistance,
            long mask_nativeObj, boolean compactResult);

    //
    // C++:  void match(Mat queryDescriptors, vector_DMatch& matches, vector_Mat masks = std::vector<Mat>())
    //

    private static native void radiusMatch_1(long nativeObj, long queryDescriptors_nativeObj,
            long trainDescriptors_nativeObj, long matches_mat_nativeObj, float maxDistance);

    // C++:  void match(Mat queryDescriptors, vector_DMatch& matches, vector_Mat masks = std::vector<Mat>())
    private static native void match_2(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj, long masks_mat_nativeObj);

    //
    // C++:  void knnMatch(Mat queryDescriptors, vector_vector_DMatch& matches, int k, vector_Mat masks = std::vector<Mat>(), bool compactResult = false)
    //

    private static native void match_3(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj);

    // C++:  void knnMatch(Mat queryDescriptors, vector_vector_DMatch& matches, int k, vector_Mat masks = std::vector<Mat>(), bool compactResult = false)
    private static native void knnMatch_2(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj, int k, long masks_mat_nativeObj, boolean compactResult);

    //
    // C++:  void radiusMatch(Mat queryDescriptors, vector_vector_DMatch& matches, float maxDistance, vector_Mat masks = std::vector<Mat>(), bool compactResult = false)
    //

    private static native void knnMatch_3(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj, int k);

    // C++:  void radiusMatch(Mat queryDescriptors, vector_vector_DMatch& matches, float maxDistance, vector_Mat masks = std::vector<Mat>(), bool compactResult = false)
    private static native void radiusMatch_2(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj, float maxDistance, long masks_mat_nativeObj,
            boolean compactResult);

    //
    // C++:  javaDescriptorMatcher* jclone(bool emptyTrainData = false)
    //

    private static native void radiusMatch_3(long nativeObj, long queryDescriptors_nativeObj,
            long matches_mat_nativeObj, float maxDistance);

    // C++:  javaDescriptorMatcher* jclone(bool emptyTrainData = false)
    private static native long clone_0(long nativeObj, boolean emptyTrainData);

    //
    // C++: static javaDescriptorMatcher* create(int matcherType)
    //

    private static native long clone_1(long nativeObj);

    //
    // C++:  void write(String fileName)
    //

    // C++: static javaDescriptorMatcher* create(int matcherType)
    private static native long create_0(int matcherType);

    //
    // C++:  void read(String fileName)
    //

    // C++:  void write(String fileName)
    private static native void write_0(long nativeObj, String fileName);

    // C++:  void read(String fileName)
    private static native void read_0(long nativeObj, String fileName);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: javaDescriptorMatcher::isMaskSupported()
    public boolean isMaskSupported() {

        return isMaskSupported_0(nativeObj);
    }

    //javadoc: javaDescriptorMatcher::add(descriptors)
    public void add(List<Mat> descriptors) {
        Mat descriptors_mat = Converters.vector_Mat_to_Mat(descriptors);
        add_0(nativeObj, descriptors_mat.nativeObj);
    }

    //javadoc: javaDescriptorMatcher::getTrainDescriptors()
    public List<Mat> getTrainDescriptors() {
        List<Mat> retVal = new ArrayList<Mat>();
        Mat retValMat = new Mat(getTrainDescriptors_0(nativeObj));
        Converters.Mat_to_vector_Mat(retValMat, retVal);
        return retVal;
    }

    //javadoc: javaDescriptorMatcher::clear()
    public void clear() {

        clear_0(nativeObj);
    }

    //javadoc: javaDescriptorMatcher::empty()
    public boolean empty() {

        return empty_0(nativeObj);
    }

    //javadoc: javaDescriptorMatcher::train()
    public void train() {

        train_0(nativeObj);
    }

    //javadoc: javaDescriptorMatcher::match(queryDescriptors, trainDescriptors, matches, mask)
    public void match(Mat queryDescriptors, Mat trainDescriptors, MatOfDMatch matches, Mat mask) {
        match_0(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches.nativeObj, mask.nativeObj);
    }

    //javadoc: javaDescriptorMatcher::match(queryDescriptors, trainDescriptors, matches)
    public void match(Mat queryDescriptors, Mat trainDescriptors, MatOfDMatch matches) {
        match_1(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches.nativeObj);
    }

    //javadoc: javaDescriptorMatcher::knnMatch(queryDescriptors, trainDescriptors, matches, k, mask, compactResult)
    public void knnMatch(Mat queryDescriptors, Mat trainDescriptors, List<MatOfDMatch> matches,
            int k, Mat mask, boolean compactResult) {
        Mat matches_mat = new Mat();
        knnMatch_0(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches_mat.nativeObj, k, mask.nativeObj, compactResult);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::knnMatch(queryDescriptors, trainDescriptors, matches, k)
    public void knnMatch(Mat queryDescriptors, Mat trainDescriptors, List<MatOfDMatch> matches,
            int k) {
        Mat matches_mat = new Mat();
        knnMatch_1(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches_mat.nativeObj, k);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::radiusMatch(queryDescriptors, trainDescriptors, matches, maxDistance, mask, compactResult)
    public void radiusMatch(Mat queryDescriptors, Mat trainDescriptors, List<MatOfDMatch> matches,
            float maxDistance, Mat mask, boolean compactResult) {
        Mat matches_mat = new Mat();
        radiusMatch_0(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches_mat.nativeObj, maxDistance, mask.nativeObj, compactResult);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::radiusMatch(queryDescriptors, trainDescriptors, matches, maxDistance)
    public void radiusMatch(Mat queryDescriptors, Mat trainDescriptors, List<MatOfDMatch> matches,
            float maxDistance) {
        Mat matches_mat = new Mat();
        radiusMatch_1(nativeObj, queryDescriptors.nativeObj, trainDescriptors.nativeObj,
                matches_mat.nativeObj, maxDistance);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::match(queryDescriptors, matches, masks)
    public void match(Mat queryDescriptors, MatOfDMatch matches, List<Mat> masks) {
        Mat masks_mat = Converters.vector_Mat_to_Mat(masks);
        match_2(nativeObj, queryDescriptors.nativeObj, matches.nativeObj, masks_mat.nativeObj);
    }

    //javadoc: javaDescriptorMatcher::match(queryDescriptors, matches)
    public void match(Mat queryDescriptors, MatOfDMatch matches) {
        match_3(nativeObj, queryDescriptors.nativeObj, matches.nativeObj);
    }

    //javadoc: javaDescriptorMatcher::knnMatch(queryDescriptors, matches, k, masks, compactResult)
    public void knnMatch(Mat queryDescriptors, List<MatOfDMatch> matches, int k, List<Mat> masks,
            boolean compactResult) {
        Mat matches_mat = new Mat();
        Mat masks_mat = Converters.vector_Mat_to_Mat(masks);
        knnMatch_2(nativeObj, queryDescriptors.nativeObj, matches_mat.nativeObj, k,
                masks_mat.nativeObj, compactResult);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::knnMatch(queryDescriptors, matches, k)
    public void knnMatch(Mat queryDescriptors, List<MatOfDMatch> matches, int k) {
        Mat matches_mat = new Mat();
        knnMatch_3(nativeObj, queryDescriptors.nativeObj, matches_mat.nativeObj, k);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::radiusMatch(queryDescriptors, matches, maxDistance, masks, compactResult)
    public void radiusMatch(Mat queryDescriptors, List<MatOfDMatch> matches, float maxDistance,
            List<Mat> masks, boolean compactResult) {
        Mat matches_mat = new Mat();
        Mat masks_mat = Converters.vector_Mat_to_Mat(masks);
        radiusMatch_2(nativeObj, queryDescriptors.nativeObj, matches_mat.nativeObj, maxDistance,
                masks_mat.nativeObj, compactResult);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::radiusMatch(queryDescriptors, matches, maxDistance)
    public void radiusMatch(Mat queryDescriptors, List<MatOfDMatch> matches, float maxDistance) {
        Mat matches_mat = new Mat();
        radiusMatch_3(nativeObj, queryDescriptors.nativeObj, matches_mat.nativeObj, maxDistance);
        Converters.Mat_to_vector_vector_DMatch(matches_mat, matches);
        matches_mat.release();
    }

    //javadoc: javaDescriptorMatcher::jclone(emptyTrainData)
    public DescriptorMatcher clone(boolean emptyTrainData) {

        return new DescriptorMatcher(clone_0(nativeObj, emptyTrainData));
    }

    //javadoc: javaDescriptorMatcher::jclone()
    public DescriptorMatcher clone() {

        return new DescriptorMatcher(clone_1(nativeObj));
    }

    //javadoc: javaDescriptorMatcher::write(fileName)
    public void write(String fileName) {

        write_0(nativeObj, fileName);
    }

    //javadoc: javaDescriptorMatcher::read(fileName)
    public void read(String fileName) {

        read_0(nativeObj, fileName);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
