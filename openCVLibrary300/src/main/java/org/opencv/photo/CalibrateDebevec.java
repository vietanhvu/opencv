//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

// C++: class CalibrateDebevec
//javadoc: CalibrateDebevec
public class CalibrateDebevec extends CalibrateCRF {

    protected CalibrateDebevec(long addr) {
        super(addr);
    }

    //
    // C++:  float getLambda()
    //

    // C++:  float getLambda()
    private static native float getLambda_0(long nativeObj);

    //
    // C++:  void setLambda(float lambda)
    //

    // C++:  void setLambda(float lambda)
    private static native void setLambda_0(long nativeObj, float lambda);

    //
    // C++:  int getSamples()
    //

    // C++:  int getSamples()
    private static native int getSamples_0(long nativeObj);

    //
    // C++:  void setSamples(int samples)
    //

    // C++:  void setSamples(int samples)
    private static native void setSamples_0(long nativeObj, int samples);

    //
    // C++:  bool getRandom()
    //

    // C++:  bool getRandom()
    private static native boolean getRandom_0(long nativeObj);

    //
    // C++:  void setRandom(bool random)
    //

    // C++:  void setRandom(bool random)
    private static native void setRandom_0(long nativeObj, boolean random);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: CalibrateDebevec::getLambda()
    public float getLambda() {

        return getLambda_0(nativeObj);
    }

    //javadoc: CalibrateDebevec::setLambda(lambda)
    public void setLambda(float lambda) {

        setLambda_0(nativeObj, lambda);
    }

    //javadoc: CalibrateDebevec::getSamples()
    public int getSamples() {

        return getSamples_0(nativeObj);
    }

    //javadoc: CalibrateDebevec::setSamples(samples)
    public void setSamples(int samples) {

        setSamples_0(nativeObj, samples);
    }

    //javadoc: CalibrateDebevec::getRandom()
    public boolean getRandom() {

        return getRandom_0(nativeObj);
    }

    //javadoc: CalibrateDebevec::setRandom(random)
    public void setRandom(boolean random) {

        setRandom_0(nativeObj, random);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
