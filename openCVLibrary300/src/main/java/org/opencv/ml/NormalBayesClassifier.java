//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ml;

import org.opencv.core.Mat;

// C++: class NormalBayesClassifier
//javadoc: NormalBayesClassifier
public class NormalBayesClassifier extends StatModel {

    protected NormalBayesClassifier(long addr) {
        super(addr);
    }

    //
    // C++:  float predictProb(Mat inputs, Mat& outputs, Mat& outputProbs, int flags = 0)
    //

    //javadoc: NormalBayesClassifier::create()
    public static NormalBayesClassifier create() {

        return new NormalBayesClassifier(create_0());
    }

    // C++:  float predictProb(Mat inputs, Mat& outputs, Mat& outputProbs, int flags = 0)
    private static native float predictProb_0(long nativeObj, long inputs_nativeObj,
            long outputs_nativeObj, long outputProbs_nativeObj, int flags);

    //
    // C++: static Ptr_NormalBayesClassifier create()
    //

    private static native float predictProb_1(long nativeObj, long inputs_nativeObj,
            long outputs_nativeObj, long outputProbs_nativeObj);

    // C++: static Ptr_NormalBayesClassifier create()
    private static native long create_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: NormalBayesClassifier::predictProb(inputs, outputs, outputProbs, flags)
    public float predictProb(Mat inputs, Mat outputs, Mat outputProbs, int flags) {

        return predictProb_0(nativeObj, inputs.nativeObj, outputs.nativeObj, outputProbs.nativeObj,
                flags);
    }

    //javadoc: NormalBayesClassifier::predictProb(inputs, outputs, outputProbs)
    public float predictProb(Mat inputs, Mat outputs, Mat outputProbs) {

        return predictProb_1(nativeObj, inputs.nativeObj, outputs.nativeObj, outputProbs.nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
