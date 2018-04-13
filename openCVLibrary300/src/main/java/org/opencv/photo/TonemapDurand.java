//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

// C++: class TonemapDurand
//javadoc: TonemapDurand
public class TonemapDurand extends Tonemap {

    protected TonemapDurand(long addr) {
        super(addr);
    }

    //
    // C++:  float getSaturation()
    //

    // C++:  float getSaturation()
    private static native float getSaturation_0(long nativeObj);

    //
    // C++:  void setSaturation(float saturation)
    //

    // C++:  void setSaturation(float saturation)
    private static native void setSaturation_0(long nativeObj, float saturation);

    //
    // C++:  float getContrast()
    //

    // C++:  float getContrast()
    private static native float getContrast_0(long nativeObj);

    //
    // C++:  void setContrast(float contrast)
    //

    // C++:  void setContrast(float contrast)
    private static native void setContrast_0(long nativeObj, float contrast);

    //
    // C++:  float getSigmaSpace()
    //

    // C++:  float getSigmaSpace()
    private static native float getSigmaSpace_0(long nativeObj);

    //
    // C++:  void setSigmaSpace(float sigma_space)
    //

    // C++:  void setSigmaSpace(float sigma_space)
    private static native void setSigmaSpace_0(long nativeObj, float sigma_space);

    //
    // C++:  float getSigmaColor()
    //

    // C++:  float getSigmaColor()
    private static native float getSigmaColor_0(long nativeObj);

    //
    // C++:  void setSigmaColor(float sigma_color)
    //

    // C++:  void setSigmaColor(float sigma_color)
    private static native void setSigmaColor_0(long nativeObj, float sigma_color);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: TonemapDurand::getSaturation()
    public float getSaturation() {

        return getSaturation_0(nativeObj);
    }

    //javadoc: TonemapDurand::setSaturation(saturation)
    public void setSaturation(float saturation) {

        setSaturation_0(nativeObj, saturation);
    }

    //javadoc: TonemapDurand::getContrast()
    public float getContrast() {

        return getContrast_0(nativeObj);
    }

    //javadoc: TonemapDurand::setContrast(contrast)
    public void setContrast(float contrast) {

        setContrast_0(nativeObj, contrast);
    }

    //javadoc: TonemapDurand::getSigmaSpace()
    public float getSigmaSpace() {

        return getSigmaSpace_0(nativeObj);
    }

    //javadoc: TonemapDurand::setSigmaSpace(sigma_space)
    public void setSigmaSpace(float sigma_space) {

        setSigmaSpace_0(nativeObj, sigma_space);
    }

    //javadoc: TonemapDurand::getSigmaColor()
    public float getSigmaColor() {

        return getSigmaColor_0(nativeObj);
    }

    //javadoc: TonemapDurand::setSigmaColor(sigma_color)
    public void setSigmaColor(float sigma_color) {

        setSigmaColor_0(nativeObj, sigma_color);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
