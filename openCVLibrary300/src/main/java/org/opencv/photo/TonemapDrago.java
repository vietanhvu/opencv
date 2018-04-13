//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.photo;

// C++: class TonemapDrago
//javadoc: TonemapDrago
public class TonemapDrago extends Tonemap {

    protected TonemapDrago(long addr) {
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
    // C++:  float getBias()
    //

    // C++:  float getBias()
    private static native float getBias_0(long nativeObj);

    //
    // C++:  void setBias(float bias)
    //

    // C++:  void setBias(float bias)
    private static native void setBias_0(long nativeObj, float bias);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: TonemapDrago::getSaturation()
    public float getSaturation() {

        return getSaturation_0(nativeObj);
    }

    //javadoc: TonemapDrago::setSaturation(saturation)
    public void setSaturation(float saturation) {

        setSaturation_0(nativeObj, saturation);
    }

    //javadoc: TonemapDrago::getBias()
    public float getBias() {

        return getBias_0(nativeObj);
    }

    //javadoc: TonemapDrago::setBias(bias)
    public void setBias(float bias) {

        setBias_0(nativeObj, bias);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
