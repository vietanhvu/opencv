//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

// C++: class RTrees
//javadoc: RTrees
public class RTrees extends DTrees {

    protected RTrees(long addr) {
        super(addr);
    }

    //
    // C++:  bool getCalculateVarImportance()
    //

    //javadoc: RTrees::create()
    public static RTrees create() {

        return new RTrees(create_0());
    }

    //
    // C++:  void setCalculateVarImportance(bool val)
    //

    // C++:  bool getCalculateVarImportance()
    private static native boolean getCalculateVarImportance_0(long nativeObj);

    //
    // C++:  int getActiveVarCount()
    //

    // C++:  void setCalculateVarImportance(bool val)
    private static native void setCalculateVarImportance_0(long nativeObj, boolean val);

    //
    // C++:  void setActiveVarCount(int val)
    //

    // C++:  int getActiveVarCount()
    private static native int getActiveVarCount_0(long nativeObj);

    //
    // C++:  TermCriteria getTermCriteria()
    //

    // C++:  void setActiveVarCount(int val)
    private static native void setActiveVarCount_0(long nativeObj, int val);

    //
    // C++:  void setTermCriteria(TermCriteria val)
    //

    // C++:  TermCriteria getTermCriteria()
    private static native double[] getTermCriteria_0(long nativeObj);

    //
    // C++:  Mat getVarImportance()
    //

    // C++:  void setTermCriteria(TermCriteria val)
    private static native void setTermCriteria_0(long nativeObj, int val_type, int val_maxCount,
            double val_epsilon);

    //
    // C++: static Ptr_RTrees create()
    //

    // C++:  Mat getVarImportance()
    private static native long getVarImportance_0(long nativeObj);

    // C++: static Ptr_RTrees create()
    private static native long create_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: RTrees::getCalculateVarImportance()
    public boolean getCalculateVarImportance() {

        return getCalculateVarImportance_0(nativeObj);
    }

    //javadoc: RTrees::setCalculateVarImportance(val)
    public void setCalculateVarImportance(boolean val) {

        setCalculateVarImportance_0(nativeObj, val);
    }

    //javadoc: RTrees::getActiveVarCount()
    public int getActiveVarCount() {

        return getActiveVarCount_0(nativeObj);
    }

    //javadoc: RTrees::setActiveVarCount(val)
    public void setActiveVarCount(int val) {

        setActiveVarCount_0(nativeObj, val);
    }

    //javadoc: RTrees::getTermCriteria()
    public TermCriteria getTermCriteria() {

        return new TermCriteria(getTermCriteria_0(nativeObj));
    }

    //javadoc: RTrees::setTermCriteria(val)
    public void setTermCriteria(TermCriteria val) {

        setTermCriteria_0(nativeObj, val.type, val.maxCount, val.epsilon);
    }

    //javadoc: RTrees::getVarImportance()
    public Mat getVarImportance() {

        return new Mat(getVarImportance_0(nativeObj));
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
