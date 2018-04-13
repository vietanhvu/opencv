//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ml;

import org.opencv.core.Mat;

// C++: class TrainData
//javadoc: TrainData
public class TrainData {

    protected final long nativeObj;

    protected TrainData(long addr) {
        nativeObj = addr;
    }

    //
    // C++:  int getLayout()
    //

    //javadoc: TrainData::getSubVector(vec, idx)
    public static Mat getSubVector(Mat vec, Mat idx) {

        return new Mat(getSubVector_0(vec.nativeObj, idx.nativeObj));
    }

    //
    // C++:  int getNSamples()
    //

    // C++:  int getLayout()
    private static native int getLayout_0(long nativeObj);

    //
    // C++:  int getNTestSamples()
    //

    // C++:  int getNSamples()
    private static native int getNSamples_0(long nativeObj);

    //
    // C++:  int getNTrainSamples()
    //

    // C++:  int getNTestSamples()
    private static native int getNTestSamples_0(long nativeObj);

    //
    // C++:  int getNVars()
    //

    // C++:  int getNTrainSamples()
    private static native int getNTrainSamples_0(long nativeObj);

    //
    // C++:  int getNAllVars()
    //

    // C++:  int getNVars()
    private static native int getNVars_0(long nativeObj);

    //
    // C++:  void getSample(Mat varIdx, int sidx, float* buf)
    //

    // C++:  int getNAllVars()
    private static native int getNAllVars_0(long nativeObj);

    //
    // C++:  Mat getSamples()
    //

    // C++:  void getSample(Mat varIdx, int sidx, float* buf)
    private static native void getSample_0(long nativeObj, long varIdx_nativeObj, int sidx,
            float buf);

    //
    // C++:  Mat getMissing()
    //

    // C++:  Mat getSamples()
    private static native long getSamples_0(long nativeObj);

    //
    // C++:  Mat getTrainSamples(int layout = ROW_SAMPLE, bool compressSamples = true, bool compressVars = true)
    //

    // C++:  Mat getMissing()
    private static native long getMissing_0(long nativeObj);

    // C++:  Mat getTrainSamples(int layout = ROW_SAMPLE, bool compressSamples = true, bool compressVars = true)
    private static native long getTrainSamples_0(long nativeObj, int layout,
            boolean compressSamples, boolean compressVars);

    //
    // C++:  Mat getTrainResponses()
    //

    private static native long getTrainSamples_1(long nativeObj);

    //
    // C++:  Mat getTrainNormCatResponses()
    //

    // C++:  Mat getTrainResponses()
    private static native long getTrainResponses_0(long nativeObj);

    //
    // C++:  Mat getTestResponses()
    //

    // C++:  Mat getTrainNormCatResponses()
    private static native long getTrainNormCatResponses_0(long nativeObj);

    //
    // C++:  Mat getTestNormCatResponses()
    //

    // C++:  Mat getTestResponses()
    private static native long getTestResponses_0(long nativeObj);

    //
    // C++:  Mat getResponses()
    //

    // C++:  Mat getTestNormCatResponses()
    private static native long getTestNormCatResponses_0(long nativeObj);

    //
    // C++:  Mat getNormCatResponses()
    //

    // C++:  Mat getResponses()
    private static native long getResponses_0(long nativeObj);

    //
    // C++:  Mat getSampleWeights()
    //

    // C++:  Mat getNormCatResponses()
    private static native long getNormCatResponses_0(long nativeObj);

    //
    // C++:  Mat getTrainSampleWeights()
    //

    // C++:  Mat getSampleWeights()
    private static native long getSampleWeights_0(long nativeObj);

    //
    // C++:  Mat getTestSampleWeights()
    //

    // C++:  Mat getTrainSampleWeights()
    private static native long getTrainSampleWeights_0(long nativeObj);

    //
    // C++:  Mat getVarIdx()
    //

    // C++:  Mat getTestSampleWeights()
    private static native long getTestSampleWeights_0(long nativeObj);

    //
    // C++:  Mat getVarType()
    //

    // C++:  Mat getVarIdx()
    private static native long getVarIdx_0(long nativeObj);

    //
    // C++:  int getResponseType()
    //

    // C++:  Mat getVarType()
    private static native long getVarType_0(long nativeObj);

    //
    // C++:  Mat getTrainSampleIdx()
    //

    // C++:  int getResponseType()
    private static native int getResponseType_0(long nativeObj);

    //
    // C++:  Mat getTestSampleIdx()
    //

    // C++:  Mat getTrainSampleIdx()
    private static native long getTrainSampleIdx_0(long nativeObj);

    //
    // C++:  void getValues(int vi, Mat sidx, float* values)
    //

    // C++:  Mat getTestSampleIdx()
    private static native long getTestSampleIdx_0(long nativeObj);

    //
    // C++:  Mat getDefaultSubstValues()
    //

    // C++:  void getValues(int vi, Mat sidx, float* values)
    private static native void getValues_0(long nativeObj, int vi, long sidx_nativeObj,
            float values);

    //
    // C++:  int getCatCount(int vi)
    //

    // C++:  Mat getDefaultSubstValues()
    private static native long getDefaultSubstValues_0(long nativeObj);

    //
    // C++:  Mat getClassLabels()
    //

    // C++:  int getCatCount(int vi)
    private static native int getCatCount_0(long nativeObj, int vi);

    //
    // C++:  Mat getCatOfs()
    //

    // C++:  Mat getClassLabels()
    private static native long getClassLabels_0(long nativeObj);

    //
    // C++:  Mat getCatMap()
    //

    // C++:  Mat getCatOfs()
    private static native long getCatOfs_0(long nativeObj);

    //
    // C++:  void setTrainTestSplit(int count, bool shuffle = true)
    //

    // C++:  Mat getCatMap()
    private static native long getCatMap_0(long nativeObj);

    // C++:  void setTrainTestSplit(int count, bool shuffle = true)
    private static native void setTrainTestSplit_0(long nativeObj, int count, boolean shuffle);

    //
    // C++:  void setTrainTestSplitRatio(double ratio, bool shuffle = true)
    //

    private static native void setTrainTestSplit_1(long nativeObj, int count);

    // C++:  void setTrainTestSplitRatio(double ratio, bool shuffle = true)
    private static native void setTrainTestSplitRatio_0(long nativeObj, double ratio,
            boolean shuffle);

    //
    // C++:  void shuffleTrainTest()
    //

    private static native void setTrainTestSplitRatio_1(long nativeObj, double ratio);

    //
    // C++: static Mat getSubVector(Mat vec, Mat idx)
    //

    // C++:  void shuffleTrainTest()
    private static native void shuffleTrainTest_0(long nativeObj);

    //
    // C++: static Ptr_TrainData create(Mat samples, int layout, Mat responses, Mat varIdx = Mat(), Mat sampleIdx = Mat(), Mat sampleWeights = Mat(), Mat varType = Mat())
    //

    // Return type 'Ptr_TrainData' is not supported, skipping the function

    // C++: static Mat getSubVector(Mat vec, Mat idx)
    private static native long getSubVector_0(long vec_nativeObj, long idx_nativeObj);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: TrainData::getLayout()
    public int getLayout() {

        return getLayout_0(nativeObj);
    }

    //javadoc: TrainData::getNSamples()
    public int getNSamples() {

        return getNSamples_0(nativeObj);
    }

    //javadoc: TrainData::getNTestSamples()
    public int getNTestSamples() {

        return getNTestSamples_0(nativeObj);
    }

    //javadoc: TrainData::getNTrainSamples()
    public int getNTrainSamples() {

        return getNTrainSamples_0(nativeObj);
    }

    //javadoc: TrainData::getNVars()
    public int getNVars() {

        return getNVars_0(nativeObj);
    }

    //javadoc: TrainData::getNAllVars()
    public int getNAllVars() {

        return getNAllVars_0(nativeObj);
    }

    //javadoc: TrainData::getSample(varIdx, sidx, buf)
    public void getSample(Mat varIdx, int sidx, float buf) {

        getSample_0(nativeObj, varIdx.nativeObj, sidx, buf);
    }

    //javadoc: TrainData::getSamples()
    public Mat getSamples() {

        return new Mat(getSamples_0(nativeObj));
    }

    //javadoc: TrainData::getMissing()
    public Mat getMissing() {

        return new Mat(getMissing_0(nativeObj));
    }

    //javadoc: TrainData::getTrainSamples(layout, compressSamples, compressVars)
    public Mat getTrainSamples(int layout, boolean compressSamples, boolean compressVars) {

        return new Mat(getTrainSamples_0(nativeObj, layout, compressSamples, compressVars));
    }

    //javadoc: TrainData::getTrainSamples()
    public Mat getTrainSamples() {

        return new Mat(getTrainSamples_1(nativeObj));
    }

    //javadoc: TrainData::getTrainResponses()
    public Mat getTrainResponses() {

        return new Mat(getTrainResponses_0(nativeObj));
    }

    //javadoc: TrainData::getTrainNormCatResponses()
    public Mat getTrainNormCatResponses() {

        return new Mat(getTrainNormCatResponses_0(nativeObj));
    }

    //javadoc: TrainData::getTestResponses()
    public Mat getTestResponses() {

        return new Mat(getTestResponses_0(nativeObj));
    }

    //javadoc: TrainData::getTestNormCatResponses()
    public Mat getTestNormCatResponses() {

        return new Mat(getTestNormCatResponses_0(nativeObj));
    }

    //javadoc: TrainData::getResponses()
    public Mat getResponses() {

        return new Mat(getResponses_0(nativeObj));
    }

    //javadoc: TrainData::getNormCatResponses()
    public Mat getNormCatResponses() {

        return new Mat(getNormCatResponses_0(nativeObj));
    }

    //javadoc: TrainData::getSampleWeights()
    public Mat getSampleWeights() {

        return new Mat(getSampleWeights_0(nativeObj));
    }

    //javadoc: TrainData::getTrainSampleWeights()
    public Mat getTrainSampleWeights() {

        return new Mat(getTrainSampleWeights_0(nativeObj));
    }

    //javadoc: TrainData::getTestSampleWeights()
    public Mat getTestSampleWeights() {

        return new Mat(getTestSampleWeights_0(nativeObj));
    }

    //javadoc: TrainData::getVarIdx()
    public Mat getVarIdx() {

        return new Mat(getVarIdx_0(nativeObj));
    }

    //javadoc: TrainData::getVarType()
    public Mat getVarType() {

        return new Mat(getVarType_0(nativeObj));
    }

    //javadoc: TrainData::getResponseType()
    public int getResponseType() {

        return getResponseType_0(nativeObj);
    }

    //javadoc: TrainData::getTrainSampleIdx()
    public Mat getTrainSampleIdx() {

        return new Mat(getTrainSampleIdx_0(nativeObj));
    }

    //javadoc: TrainData::getTestSampleIdx()
    public Mat getTestSampleIdx() {

        return new Mat(getTestSampleIdx_0(nativeObj));
    }

    //javadoc: TrainData::getValues(vi, sidx, values)
    public void getValues(int vi, Mat sidx, float values) {

        getValues_0(nativeObj, vi, sidx.nativeObj, values);
    }

    //javadoc: TrainData::getDefaultSubstValues()
    public Mat getDefaultSubstValues() {

        return new Mat(getDefaultSubstValues_0(nativeObj));
    }

    //javadoc: TrainData::getCatCount(vi)
    public int getCatCount(int vi) {

        return getCatCount_0(nativeObj, vi);
    }

    //javadoc: TrainData::getClassLabels()
    public Mat getClassLabels() {

        return new Mat(getClassLabels_0(nativeObj));
    }

    //javadoc: TrainData::getCatOfs()
    public Mat getCatOfs() {

        return new Mat(getCatOfs_0(nativeObj));
    }

    //javadoc: TrainData::getCatMap()
    public Mat getCatMap() {

        return new Mat(getCatMap_0(nativeObj));
    }

    //javadoc: TrainData::setTrainTestSplit(count, shuffle)
    public void setTrainTestSplit(int count, boolean shuffle) {

        setTrainTestSplit_0(nativeObj, count, shuffle);
    }

    //javadoc: TrainData::setTrainTestSplit(count)
    public void setTrainTestSplit(int count) {

        setTrainTestSplit_1(nativeObj, count);
    }

    //javadoc: TrainData::setTrainTestSplitRatio(ratio, shuffle)
    public void setTrainTestSplitRatio(double ratio, boolean shuffle) {

        setTrainTestSplitRatio_0(nativeObj, ratio, shuffle);
    }

    //javadoc: TrainData::setTrainTestSplitRatio(ratio)
    public void setTrainTestSplitRatio(double ratio) {

        setTrainTestSplitRatio_1(nativeObj, ratio);
    }

    //javadoc: TrainData::shuffleTrainTest()
    public void shuffleTrainTest() {

        shuffleTrainTest_0(nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
