//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.video;

// C++: class BackgroundSubtractorKNN
//javadoc: BackgroundSubtractorKNN
public class BackgroundSubtractorKNN extends BackgroundSubtractor {

    protected BackgroundSubtractorKNN(long addr) {
        super(addr);
    }

    //
    // C++:  int getHistory()
    //

    // C++:  int getHistory()
    private static native int getHistory_0(long nativeObj);

    //
    // C++:  void setHistory(int history)
    //

    // C++:  void setHistory(int history)
    private static native void setHistory_0(long nativeObj, int history);

    //
    // C++:  int getNSamples()
    //

    // C++:  int getNSamples()
    private static native int getNSamples_0(long nativeObj);

    //
    // C++:  void setNSamples(int _nN)
    //

    // C++:  void setNSamples(int _nN)
    private static native void setNSamples_0(long nativeObj, int _nN);

    //
    // C++:  double getDist2Threshold()
    //

    // C++:  double getDist2Threshold()
    private static native double getDist2Threshold_0(long nativeObj);

    //
    // C++:  void setDist2Threshold(double _dist2Threshold)
    //

    // C++:  void setDist2Threshold(double _dist2Threshold)
    private static native void setDist2Threshold_0(long nativeObj, double _dist2Threshold);

    //
    // C++:  int getkNNSamples()
    //

    // C++:  int getkNNSamples()
    private static native int getkNNSamples_0(long nativeObj);

    //
    // C++:  void setkNNSamples(int _nkNN)
    //

    // C++:  void setkNNSamples(int _nkNN)
    private static native void setkNNSamples_0(long nativeObj, int _nkNN);

    //
    // C++:  bool getDetectShadows()
    //

    // C++:  bool getDetectShadows()
    private static native boolean getDetectShadows_0(long nativeObj);

    //
    // C++:  void setDetectShadows(bool detectShadows)
    //

    // C++:  void setDetectShadows(bool detectShadows)
    private static native void setDetectShadows_0(long nativeObj, boolean detectShadows);

    //
    // C++:  int getShadowValue()
    //

    // C++:  int getShadowValue()
    private static native int getShadowValue_0(long nativeObj);

    //
    // C++:  void setShadowValue(int value)
    //

    // C++:  void setShadowValue(int value)
    private static native void setShadowValue_0(long nativeObj, int value);

    //
    // C++:  double getShadowThreshold()
    //

    // C++:  double getShadowThreshold()
    private static native double getShadowThreshold_0(long nativeObj);

    //
    // C++:  void setShadowThreshold(double threshold)
    //

    // C++:  void setShadowThreshold(double threshold)
    private static native void setShadowThreshold_0(long nativeObj, double threshold);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: BackgroundSubtractorKNN::getHistory()
    public int getHistory() {

        return getHistory_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setHistory(history)
    public void setHistory(int history) {

        setHistory_0(nativeObj, history);
    }

    //javadoc: BackgroundSubtractorKNN::getNSamples()
    public int getNSamples() {

        return getNSamples_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setNSamples(_nN)
    public void setNSamples(int _nN) {

        setNSamples_0(nativeObj, _nN);
    }

    //javadoc: BackgroundSubtractorKNN::getDist2Threshold()
    public double getDist2Threshold() {

        return getDist2Threshold_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setDist2Threshold(_dist2Threshold)
    public void setDist2Threshold(double _dist2Threshold) {

        setDist2Threshold_0(nativeObj, _dist2Threshold);
    }

    //javadoc: BackgroundSubtractorKNN::getkNNSamples()
    public int getkNNSamples() {

        return getkNNSamples_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setkNNSamples(_nkNN)
    public void setkNNSamples(int _nkNN) {

        setkNNSamples_0(nativeObj, _nkNN);
    }

    //javadoc: BackgroundSubtractorKNN::getDetectShadows()
    public boolean getDetectShadows() {

        return getDetectShadows_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setDetectShadows(detectShadows)
    public void setDetectShadows(boolean detectShadows) {

        setDetectShadows_0(nativeObj, detectShadows);
    }

    //javadoc: BackgroundSubtractorKNN::getShadowValue()
    public int getShadowValue() {

        return getShadowValue_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setShadowValue(value)
    public void setShadowValue(int value) {

        setShadowValue_0(nativeObj, value);
    }

    //javadoc: BackgroundSubtractorKNN::getShadowThreshold()
    public double getShadowThreshold() {

        return getShadowThreshold_0(nativeObj);
    }

    //javadoc: BackgroundSubtractorKNN::setShadowThreshold(threshold)
    public void setShadowThreshold(double threshold) {

        setShadowThreshold_0(nativeObj, threshold);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
