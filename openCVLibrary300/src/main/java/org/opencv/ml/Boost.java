//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ml;

// C++: class Boost
//javadoc: Boost
public class Boost extends DTrees {

    public static final int DISCRETE = 0, REAL = 1, LOGIT = 2, GENTLE = 3;

    protected Boost(long addr) {
        super(addr);
    }

    //
    // C++:  int getBoostType()
    //

    //javadoc: Boost::create()
    public static Boost create() {

        return new Boost(create_0());
    }

    //
    // C++:  void setBoostType(int val)
    //

    // C++:  int getBoostType()
    private static native int getBoostType_0(long nativeObj);

    //
    // C++:  int getWeakCount()
    //

    // C++:  void setBoostType(int val)
    private static native void setBoostType_0(long nativeObj, int val);

    //
    // C++:  void setWeakCount(int val)
    //

    // C++:  int getWeakCount()
    private static native int getWeakCount_0(long nativeObj);

    //
    // C++:  double getWeightTrimRate()
    //

    // C++:  void setWeakCount(int val)
    private static native void setWeakCount_0(long nativeObj, int val);

    //
    // C++:  void setWeightTrimRate(double val)
    //

    // C++:  double getWeightTrimRate()
    private static native double getWeightTrimRate_0(long nativeObj);

    //
    // C++: static Ptr_Boost create()
    //

    // C++:  void setWeightTrimRate(double val)
    private static native void setWeightTrimRate_0(long nativeObj, double val);

    // C++: static Ptr_Boost create()
    private static native long create_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: Boost::getBoostType()
    public int getBoostType() {

        return getBoostType_0(nativeObj);
    }

    //javadoc: Boost::setBoostType(val)
    public void setBoostType(int val) {

        setBoostType_0(nativeObj, val);
    }

    //javadoc: Boost::getWeakCount()
    public int getWeakCount() {

        return getWeakCount_0(nativeObj);
    }

    //javadoc: Boost::setWeakCount(val)
    public void setWeakCount(int val) {

        setWeakCount_0(nativeObj, val);
    }

    //javadoc: Boost::getWeightTrimRate()
    public double getWeightTrimRate() {

        return getWeightTrimRate_0(nativeObj);
    }

    //javadoc: Boost::setWeightTrimRate(val)
    public void setWeightTrimRate(double val) {

        setWeightTrimRate_0(nativeObj, val);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
