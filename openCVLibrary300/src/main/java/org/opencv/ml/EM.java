//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.ml;

import org.opencv.core.Mat;
import org.opencv.core.TermCriteria;

// C++: class EM
//javadoc: EM
public class EM extends StatModel {

    public static final int COV_MAT_SPHERICAL = 0, COV_MAT_DIAGONAL = 1, COV_MAT_GENERIC = 2,
            COV_MAT_DEFAULT = COV_MAT_DIAGONAL, DEFAULT_NCLUSTERS = 5, DEFAULT_MAX_ITERS = 100,
            START_E_STEP = 1, START_M_STEP = 2, START_AUTO_STEP = 0;

    protected EM(long addr) {
        super(addr);
    }

    //
    // C++:  int getClustersNumber()
    //

    //javadoc: EM::create()
    public static EM create() {

        return new EM(create_0());
    }

    //
    // C++:  void setClustersNumber(int val)
    //

    // C++:  int getClustersNumber()
    private static native int getClustersNumber_0(long nativeObj);

    //
    // C++:  int getCovarianceMatrixType()
    //

    // C++:  void setClustersNumber(int val)
    private static native void setClustersNumber_0(long nativeObj, int val);

    //
    // C++:  void setCovarianceMatrixType(int val)
    //

    // C++:  int getCovarianceMatrixType()
    private static native int getCovarianceMatrixType_0(long nativeObj);

    //
    // C++:  TermCriteria getTermCriteria()
    //

    // C++:  void setCovarianceMatrixType(int val)
    private static native void setCovarianceMatrixType_0(long nativeObj, int val);

    //
    // C++:  void setTermCriteria(TermCriteria val)
    //

    // C++:  TermCriteria getTermCriteria()
    private static native double[] getTermCriteria_0(long nativeObj);

    //
    // C++:  Mat getWeights()
    //

    // C++:  void setTermCriteria(TermCriteria val)
    private static native void setTermCriteria_0(long nativeObj, int val_type, int val_maxCount,
            double val_epsilon);

    //
    // C++:  Mat getMeans()
    //

    // C++:  Mat getWeights()
    private static native long getWeights_0(long nativeObj);

    //
    // C++:  Vec2d predict2(Mat sample, Mat& probs)
    //

    // C++:  Mat getMeans()
    private static native long getMeans_0(long nativeObj);

    //
    // C++:  bool trainEM(Mat samples, Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    //

    // C++:  Vec2d predict2(Mat sample, Mat& probs)
    private static native double[] predict2_0(long nativeObj, long sample_nativeObj,
            long probs_nativeObj);

    // C++:  bool trainEM(Mat samples, Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    private static native boolean trainEM_0(long nativeObj, long samples_nativeObj,
            long logLikelihoods_nativeObj, long labels_nativeObj, long probs_nativeObj);

    //
    // C++:  bool trainE(Mat samples, Mat means0, Mat covs0 = Mat(), Mat weights0 = Mat(), Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    //

    private static native boolean trainEM_1(long nativeObj, long samples_nativeObj);

    // C++:  bool trainE(Mat samples, Mat means0, Mat covs0 = Mat(), Mat weights0 = Mat(), Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    private static native boolean trainE_0(long nativeObj, long samples_nativeObj,
            long means0_nativeObj, long covs0_nativeObj, long weights0_nativeObj,
            long logLikelihoods_nativeObj, long labels_nativeObj, long probs_nativeObj);

    //
    // C++:  bool trainM(Mat samples, Mat probs0, Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    //

    private static native boolean trainE_1(long nativeObj, long samples_nativeObj,
            long means0_nativeObj);

    // C++:  bool trainM(Mat samples, Mat probs0, Mat& logLikelihoods = Mat(), Mat& labels = Mat(), Mat& probs = Mat())
    private static native boolean trainM_0(long nativeObj, long samples_nativeObj,
            long probs0_nativeObj, long logLikelihoods_nativeObj, long labels_nativeObj,
            long probs_nativeObj);

    //
    // C++: static Ptr_EM create()
    //

    private static native boolean trainM_1(long nativeObj, long samples_nativeObj,
            long probs0_nativeObj);

    // C++: static Ptr_EM create()
    private static native long create_0();

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: EM::getClustersNumber()
    public int getClustersNumber() {

        return getClustersNumber_0(nativeObj);
    }

    //javadoc: EM::setClustersNumber(val)
    public void setClustersNumber(int val) {

        setClustersNumber_0(nativeObj, val);
    }

    //javadoc: EM::getCovarianceMatrixType()
    public int getCovarianceMatrixType() {

        return getCovarianceMatrixType_0(nativeObj);
    }

    //javadoc: EM::setCovarianceMatrixType(val)
    public void setCovarianceMatrixType(int val) {

        setCovarianceMatrixType_0(nativeObj, val);
    }

    //javadoc: EM::getTermCriteria()
    public TermCriteria getTermCriteria() {

        return new TermCriteria(getTermCriteria_0(nativeObj));
    }

    //javadoc: EM::setTermCriteria(val)
    public void setTermCriteria(TermCriteria val) {

        setTermCriteria_0(nativeObj, val.type, val.maxCount, val.epsilon);
    }

    //javadoc: EM::getWeights()
    public Mat getWeights() {

        return new Mat(getWeights_0(nativeObj));
    }

    //javadoc: EM::getMeans()
    public Mat getMeans() {

        return new Mat(getMeans_0(nativeObj));
    }

    //javadoc: EM::predict2(sample, probs)
    public double[] predict2(Mat sample, Mat probs) {

        return predict2_0(nativeObj, sample.nativeObj, probs.nativeObj);
    }

    //javadoc: EM::trainEM(samples, logLikelihoods, labels, probs)
    public boolean trainEM(Mat samples, Mat logLikelihoods, Mat labels, Mat probs) {

        return trainEM_0(nativeObj, samples.nativeObj, logLikelihoods.nativeObj, labels.nativeObj,
                probs.nativeObj);
    }

    //javadoc: EM::trainEM(samples)
    public boolean trainEM(Mat samples) {

        return trainEM_1(nativeObj, samples.nativeObj);
    }

    //javadoc: EM::trainE(samples, means0, covs0, weights0, logLikelihoods, labels, probs)
    public boolean trainE(Mat samples, Mat means0, Mat covs0, Mat weights0, Mat logLikelihoods,
            Mat labels, Mat probs) {

        return trainE_0(nativeObj, samples.nativeObj, means0.nativeObj, covs0.nativeObj,
                weights0.nativeObj, logLikelihoods.nativeObj, labels.nativeObj, probs.nativeObj);
    }

    //javadoc: EM::trainE(samples, means0)
    public boolean trainE(Mat samples, Mat means0) {

        return trainE_1(nativeObj, samples.nativeObj, means0.nativeObj);
    }

    //javadoc: EM::trainM(samples, probs0, logLikelihoods, labels, probs)
    public boolean trainM(Mat samples, Mat probs0, Mat logLikelihoods, Mat labels, Mat probs) {

        return trainM_0(nativeObj, samples.nativeObj, probs0.nativeObj, logLikelihoods.nativeObj,
                labels.nativeObj, probs.nativeObj);
    }

    //javadoc: EM::trainM(samples, probs0)
    public boolean trainM(Mat samples, Mat probs0) {

        return trainM_1(nativeObj, samples.nativeObj, probs0.nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
