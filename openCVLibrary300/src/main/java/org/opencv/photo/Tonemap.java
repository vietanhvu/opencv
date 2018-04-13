//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

import org.opencv.core.Algorithm;
import org.opencv.core.Mat;

// C++: class Tonemap
//javadoc: Tonemap
public class Tonemap extends Algorithm {

    protected Tonemap(long addr) {
        super(addr);
    }

    //
    // C++:  void process(Mat src, Mat& dst)
    //

    // C++:  void process(Mat src, Mat& dst)
    private static native void process_0(long nativeObj, long src_nativeObj, long dst_nativeObj);

    //
    // C++:  float getGamma()
    //

    // C++:  float getGamma()
    private static native float getGamma_0(long nativeObj);

    //
    // C++:  void setGamma(float gamma)
    //

    // C++:  void setGamma(float gamma)
    private static native void setGamma_0(long nativeObj, float gamma);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: Tonemap::process(src, dst)
    public void process(Mat src, Mat dst) {

        process_0(nativeObj, src.nativeObj, dst.nativeObj);
    }

    //javadoc: Tonemap::getGamma()
    public float getGamma() {

        return getGamma_0(nativeObj);
    }

    //javadoc: Tonemap::setGamma(gamma)
    public void setGamma(float gamma) {

        setGamma_0(nativeObj, gamma);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
