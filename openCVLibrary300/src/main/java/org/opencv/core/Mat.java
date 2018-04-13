package org.opencv.core;

// C++: class Mat
//javadoc: Mat
public class Mat {

    public final long nativeObj;

    public Mat(long addr) {
        if (addr == 0) {
            throw new java.lang.UnsupportedOperationException("Native object address is NULL");
        }
        nativeObj = addr;
    }

    //
    // C++: Mat::Mat()
    //

    // javadoc: Mat::Mat()
    public Mat() {

        nativeObj = n_Mat();
    }

    //
    // C++: Mat::Mat(int rows, int cols, int type)
    //

    // javadoc: Mat::Mat(rows, cols, type)
    public Mat(int rows, int cols, int type) {

        nativeObj = n_Mat(rows, cols, type);
    }

    //
    // C++: Mat::Mat(Size size, int type)
    //

    // javadoc: Mat::Mat(size, type)
    public Mat(Size size, int type) {

        nativeObj = n_Mat(size.width, size.height, type);
    }

    //
    // C++: Mat::Mat(int rows, int cols, int type, Scalar s)
    //

    // javadoc: Mat::Mat(rows, cols, type, s)
    public Mat(int rows, int cols, int type, Scalar s) {

        nativeObj = n_Mat(rows, cols, type, s.val[0], s.val[1], s.val[2], s.val[3]);
    }

    //
    // C++: Mat::Mat(Size size, int type, Scalar s)
    //

    // javadoc: Mat::Mat(size, type, s)
    public Mat(Size size, int type, Scalar s) {

        nativeObj = n_Mat(size.width, size.height, type, s.val[0], s.val[1], s.val[2], s.val[3]);
    }

    //
    // C++: Mat::Mat(Mat m, Range rowRange, Range colRange = Range::all())
    //

    // javadoc: Mat::Mat(m, rowRange, colRange)
    public Mat(Mat m, Range rowRange, Range colRange) {

        nativeObj = n_Mat(m.nativeObj, rowRange.start, rowRange.end, colRange.start, colRange.end);
    }

    // javadoc: Mat::Mat(m, rowRange)
    public Mat(Mat m, Range rowRange) {

        nativeObj = n_Mat(m.nativeObj, rowRange.start, rowRange.end);
    }

    //
    // C++: Mat::Mat(Mat m, Rect roi)
    //

    // javadoc: Mat::Mat(m, roi)
    public Mat(Mat m, Rect roi) {

        nativeObj = n_Mat(m.nativeObj, roi.y, roi.y + roi.height, roi.x, roi.x + roi.width);
    }

    //
    // C++: Mat Mat::adjustROI(int dtop, int dbottom, int dleft, int dright)
    //

    // javadoc: Mat::diag(d)
    public static Mat diag(Mat d) {

        return new Mat(n_diag(d.nativeObj));
    }

    //
    // C++: void Mat::assignTo(Mat m, int type = -1)
    //

    // javadoc: Mat::eye(rows, cols, type)
    public static Mat eye(int rows, int cols, int type) {

        return new Mat(n_eye(rows, cols, type));
    }

    // javadoc: Mat::eye(size, type)
    public static Mat eye(Size size, int type) {

        return new Mat(n_eye(size.width, size.height, type));
    }

    //
    // C++: int Mat::channels()
    //

    // javadoc: Mat::ones(rows, cols, type)
    public static Mat ones(int rows, int cols, int type) {

        return new Mat(n_ones(rows, cols, type));
    }

    //
    // C++: int Mat::checkVector(int elemChannels, int depth = -1, bool
    // requireContinuous = true)
    //

    // javadoc: Mat::ones(size, type)
    public static Mat ones(Size size, int type) {

        return new Mat(n_ones(size.width, size.height, type));
    }

    // javadoc: Mat::zeros(rows, cols, type)
    public static Mat zeros(int rows, int cols, int type) {

        return new Mat(n_zeros(rows, cols, type));
    }

    // javadoc: Mat::zeros(size, type)
    public static Mat zeros(Size size, int type) {

        return new Mat(n_zeros(size.width, size.height, type));
    }

    //
    // C++: Mat Mat::clone()
    //

    // C++: Mat::Mat()
    private static native long n_Mat();

    //
    // C++: Mat Mat::col(int x)
    //

    // C++: Mat::Mat(int rows, int cols, int type)
    private static native long n_Mat(int rows, int cols, int type);

    //
    // C++: Mat Mat::colRange(int startcol, int endcol)
    //

    // C++: Mat::Mat(Size size, int type)
    private static native long n_Mat(double size_width, double size_height, int type);

    //
    // C++: Mat Mat::colRange(Range r)
    //

    // C++: Mat::Mat(int rows, int cols, int type, Scalar s)
    private static native long n_Mat(int rows, int cols, int type, double s_val0, double s_val1,
            double s_val2, double s_val3);

    //
    // C++: int Mat::dims()
    //

    // C++: Mat::Mat(Size size, int type, Scalar s)
    private static native long n_Mat(double size_width, double size_height, int type, double s_val0,
            double s_val1, double s_val2, double s_val3);

    //
    // C++: int Mat::cols()
    //

    // C++: Mat::Mat(Mat m, Range rowRange, Range colRange = Range::all())
    private static native long n_Mat(long m_nativeObj, int rowRange_start, int rowRange_end,
            int colRange_start, int colRange_end);

    //
    // C++: void Mat::convertTo(Mat& m, int rtype, double alpha = 1, double beta
    // = 0)
    //

    private static native long n_Mat(long m_nativeObj, int rowRange_start, int rowRange_end);

    // C++: Mat Mat::adjustROI(int dtop, int dbottom, int dleft, int dright)
    private static native long n_adjustROI(long nativeObj, int dtop, int dbottom, int dleft,
            int dright);

    // C++: void Mat::assignTo(Mat m, int type = -1)
    private static native void n_assignTo(long nativeObj, long m_nativeObj, int type);

    //
    // C++: void Mat::copyTo(Mat& m)
    //

    private static native void n_assignTo(long nativeObj, long m_nativeObj);

    //
    // C++: void Mat::copyTo(Mat& m, Mat mask)
    //

    // C++: int Mat::channels()
    private static native int n_channels(long nativeObj);

    //
    // C++: void Mat::create(int rows, int cols, int type)
    //

    // C++: int Mat::checkVector(int elemChannels, int depth = -1, bool
    // requireContinuous = true)
    private static native int n_checkVector(long nativeObj, int elemChannels, int depth,
            boolean requireContinuous);

    //
    // C++: void Mat::create(Size size, int type)
    //

    private static native int n_checkVector(long nativeObj, int elemChannels, int depth);

    //
    // C++: Mat Mat::cross(Mat m)
    //

    private static native int n_checkVector(long nativeObj, int elemChannels);

    //
    // C++: long Mat::dataAddr()
    //

    // C++: Mat Mat::clone()
    private static native long n_clone(long nativeObj);

    //
    // C++: int Mat::depth()
    //

    // C++: Mat Mat::col(int x)
    private static native long n_col(long nativeObj, int x);

    //
    // C++: Mat Mat::diag(int d = 0)
    //

    // C++: Mat Mat::colRange(int startcol, int endcol)
    private static native long n_colRange(long nativeObj, int startcol, int endcol);

    // C++: int Mat::dims()
    private static native int n_dims(long nativeObj);

    //
    // C++: static Mat Mat::diag(Mat d)
    //

    // C++: int Mat::cols()
    private static native int n_cols(long nativeObj);

    //
    // C++: double Mat::dot(Mat m)
    //

    // C++: void Mat::convertTo(Mat& m, int rtype, double alpha = 1, double beta
    // = 0)
    private static native void n_convertTo(long nativeObj, long m_nativeObj, int rtype,
            double alpha, double beta);

    //
    // C++: size_t Mat::elemSize()
    //

    private static native void n_convertTo(long nativeObj, long m_nativeObj, int rtype,
            double alpha);

    //
    // C++: size_t Mat::elemSize1()
    //

    private static native void n_convertTo(long nativeObj, long m_nativeObj, int rtype);

    //
    // C++: bool Mat::empty()
    //

    // C++: void Mat::copyTo(Mat& m)
    private static native void n_copyTo(long nativeObj, long m_nativeObj);

    //
    // C++: static Mat Mat::eye(int rows, int cols, int type)
    //

    // C++: void Mat::copyTo(Mat& m, Mat mask)
    private static native void n_copyTo(long nativeObj, long m_nativeObj, long mask_nativeObj);

    //
    // C++: static Mat Mat::eye(Size size, int type)
    //

    // C++: void Mat::create(int rows, int cols, int type)
    private static native void n_create(long nativeObj, int rows, int cols, int type);

    //
    // C++: Mat Mat::inv(int method = DECOMP_LU)
    //

    // C++: void Mat::create(Size size, int type)
    private static native void n_create(long nativeObj, double size_width, double size_height,
            int type);

    // C++: Mat Mat::cross(Mat m)
    private static native long n_cross(long nativeObj, long m_nativeObj);

    //
    // C++: bool Mat::isContinuous()
    //

    // C++: long Mat::dataAddr()
    private static native long n_dataAddr(long nativeObj);

    //
    // C++: bool Mat::isSubmatrix()
    //

    // C++: int Mat::depth()
    private static native int n_depth(long nativeObj);

    //
    // C++: void Mat::locateROI(Size wholeSize, Point ofs)
    //

    // C++: Mat Mat::diag(int d = 0)
    private static native long n_diag(long nativeObj, int d);

    //
    // C++: Mat Mat::mul(Mat m, double scale = 1)
    //

    // C++: static Mat Mat::diag(Mat d)
    private static native long n_diag(long d_nativeObj);

    // C++: double Mat::dot(Mat m)
    private static native double n_dot(long nativeObj, long m_nativeObj);

    //
    // C++: static Mat Mat::ones(int rows, int cols, int type)
    //

    // C++: size_t Mat::elemSize()
    private static native long n_elemSize(long nativeObj);

    //
    // C++: static Mat Mat::ones(Size size, int type)
    //

    // C++: size_t Mat::elemSize1()
    private static native long n_elemSize1(long nativeObj);

    //
    // C++: void Mat::push_back(Mat m)
    //

    // C++: bool Mat::empty()
    private static native boolean n_empty(long nativeObj);

    //
    // C++: void Mat::release()
    //

    // C++: static Mat Mat::eye(int rows, int cols, int type)
    private static native long n_eye(int rows, int cols, int type);

    //
    // C++: Mat Mat::reshape(int cn, int rows = 0)
    //

    // C++: static Mat Mat::eye(Size size, int type)
    private static native long n_eye(double size_width, double size_height, int type);

    // C++: Mat Mat::inv(int method = DECOMP_LU)
    private static native long n_inv(long nativeObj, int method);

    //
    // C++: Mat Mat::row(int y)
    //

    private static native long n_inv(long nativeObj);

    //
    // C++: Mat Mat::rowRange(int startrow, int endrow)
    //

    // C++: bool Mat::isContinuous()
    private static native boolean n_isContinuous(long nativeObj);

    //
    // C++: Mat Mat::rowRange(Range r)
    //

    // C++: bool Mat::isSubmatrix()
    private static native boolean n_isSubmatrix(long nativeObj);

    //
    // C++: int Mat::rows()
    //

    // C++: void Mat::locateROI(Size wholeSize, Point ofs)
    private static native void locateROI_0(long nativeObj, double[] wholeSize_out,
            double[] ofs_out);

    //
    // C++: Mat Mat::operator =(Scalar s)
    //

    // C++: Mat Mat::mul(Mat m, double scale = 1)
    private static native long n_mul(long nativeObj, long m_nativeObj, double scale);

    //
    // C++: Mat Mat::setTo(Scalar value, Mat mask = Mat())
    //

    private static native long n_mul(long nativeObj, long m_nativeObj);

    //
    // C++: Mat Mat::setTo(Mat value, Mat mask = Mat())
    //

    // C++: static Mat Mat::ones(int rows, int cols, int type)
    private static native long n_ones(int rows, int cols, int type);

    // C++: static Mat Mat::ones(Size size, int type)
    private static native long n_ones(double size_width, double size_height, int type);

    //
    // C++: Size Mat::size()
    //

    // C++: void Mat::push_back(Mat m)
    private static native void n_push_back(long nativeObj, long m_nativeObj);

    //
    // C++: size_t Mat::step1(int i = 0)
    //

    // C++: void Mat::release()
    private static native void n_release(long nativeObj);

    // C++: Mat Mat::reshape(int cn, int rows = 0)
    private static native long n_reshape(long nativeObj, int cn, int rows);

    //
    // C++: Mat Mat::operator()(int rowStart, int rowEnd, int colStart, int
    // colEnd)
    //

    private static native long n_reshape(long nativeObj, int cn);

    //
    // C++: Mat Mat::operator()(Range rowRange, Range colRange)
    //

    // C++: Mat Mat::row(int y)
    private static native long n_row(long nativeObj, int y);

    //
    // C++: Mat Mat::operator()(Rect roi)
    //

    // C++: Mat Mat::rowRange(int startrow, int endrow)
    private static native long n_rowRange(long nativeObj, int startrow, int endrow);

    //
    // C++: Mat Mat::t()
    //

    // C++: int Mat::rows()
    private static native int n_rows(long nativeObj);

    //
    // C++: size_t Mat::total()
    //

    // C++: Mat Mat::operator =(Scalar s)
    private static native long n_setTo(long nativeObj, double s_val0, double s_val1, double s_val2,
            double s_val3);

    //
    // C++: int Mat::type()
    //

    // C++: Mat Mat::setTo(Scalar value, Mat mask = Mat())
    private static native long n_setTo(long nativeObj, double s_val0, double s_val1, double s_val2,
            double s_val3, long mask_nativeObj);

    //
    // C++: static Mat Mat::zeros(int rows, int cols, int type)
    //

    // C++: Mat Mat::setTo(Mat value, Mat mask = Mat())
    private static native long n_setTo(long nativeObj, long value_nativeObj, long mask_nativeObj);

    //
    // C++: static Mat Mat::zeros(Size size, int type)
    //

    private static native long n_setTo(long nativeObj, long value_nativeObj);

    // C++: Size Mat::size()
    private static native double[] n_size(long nativeObj);

    // C++: size_t Mat::step1(int i = 0)
    private static native long n_step1(long nativeObj, int i);

    private static native long n_step1(long nativeObj);

    // C++: Mat Mat::operator()(Range rowRange, Range colRange)
    private static native long n_submat_rr(long nativeObj, int rowRange_start, int rowRange_end,
            int colRange_start, int colRange_end);

    // C++: Mat Mat::operator()(Rect roi)
    private static native long n_submat(long nativeObj, int roi_x, int roi_y, int roi_width,
            int roi_height);

    // C++: Mat Mat::t()
    private static native long n_t(long nativeObj);

    // C++: size_t Mat::total()
    private static native long n_total(long nativeObj);

    // C++: int Mat::type()
    private static native int n_type(long nativeObj);

    // C++: static Mat Mat::zeros(int rows, int cols, int type)
    private static native long n_zeros(int rows, int cols, int type);

    // C++: static Mat Mat::zeros(Size size, int type)
    private static native long n_zeros(double size_width, double size_height, int type);

    // native support for java finalize()
    private static native void n_delete(long nativeObj);

    private static native int nPutD(long self, int row, int col, int count, double[] data);

    private static native int nPutF(long self, int row, int col, int count, float[] data);

    private static native int nPutI(long self, int row, int col, int count, int[] data);

    private static native int nPutS(long self, int row, int col, int count, short[] data);

    private static native int nPutB(long self, int row, int col, int count, byte[] data);

    private static native int nGetB(long self, int row, int col, int count, byte[] vals);

    private static native int nGetS(long self, int row, int col, int count, short[] vals);

    private static native int nGetI(long self, int row, int col, int count, int[] vals);

    private static native int nGetF(long self, int row, int col, int count, float[] vals);

    private static native int nGetD(long self, int row, int col, int count, double[] vals);

    private static native double[] nGet(long self, int row, int col);

    private static native String nDump(long self);

    // javadoc: Mat::adjustROI(dtop, dbottom, dleft, dright)
    public Mat adjustROI(int dtop, int dbottom, int dleft, int dright) {

        return new Mat(n_adjustROI(nativeObj, dtop, dbottom, dleft, dright));
    }

    // javadoc: Mat::assignTo(m, type)
    public void assignTo(Mat m, int type) {

        n_assignTo(nativeObj, m.nativeObj, type);
    }

    // javadoc: Mat::assignTo(m)
    public void assignTo(Mat m) {

        n_assignTo(nativeObj, m.nativeObj);
    }

    // javadoc: Mat::channels()
    public int channels() {

        return n_channels(nativeObj);
    }

    // javadoc: Mat::checkVector(elemChannels, depth, requireContinuous)
    public int checkVector(int elemChannels, int depth, boolean requireContinuous) {

        return n_checkVector(nativeObj, elemChannels, depth, requireContinuous);
    }

    // javadoc: Mat::checkVector(elemChannels, depth)
    public int checkVector(int elemChannels, int depth) {

        return n_checkVector(nativeObj, elemChannels, depth);
    }

    // javadoc: Mat::checkVector(elemChannels)
    public int checkVector(int elemChannels) {

        return n_checkVector(nativeObj, elemChannels);
    }

    // javadoc: Mat::clone()
    public Mat clone() {

        return new Mat(n_clone(nativeObj));
    }

    // javadoc: Mat::col(x)
    public Mat col(int x) {

        return new Mat(n_col(nativeObj, x));
    }

    // javadoc: Mat::colRange(startcol, endcol)
    public Mat colRange(int startcol, int endcol) {

        return new Mat(n_colRange(nativeObj, startcol, endcol));
    }

    // javadoc: Mat::colRange(r)
    public Mat colRange(Range r) {

        return new Mat(n_colRange(nativeObj, r.start, r.end));
    }

    // javadoc: Mat::dims()
    public int dims() {

        return n_dims(nativeObj);
    }

    // javadoc: Mat::cols()
    public int cols() {

        return n_cols(nativeObj);
    }

    // javadoc: Mat::convertTo(m, rtype, alpha, beta)
    public void convertTo(Mat m, int rtype, double alpha, double beta) {

        n_convertTo(nativeObj, m.nativeObj, rtype, alpha, beta);
    }

    // javadoc: Mat::convertTo(m, rtype, alpha)
    public void convertTo(Mat m, int rtype, double alpha) {

        n_convertTo(nativeObj, m.nativeObj, rtype, alpha);
    }

    // javadoc: Mat::convertTo(m, rtype)
    public void convertTo(Mat m, int rtype) {

        n_convertTo(nativeObj, m.nativeObj, rtype);
    }

    // javadoc: Mat::copyTo(m)
    public void copyTo(Mat m) {

        n_copyTo(nativeObj, m.nativeObj);
    }

    // javadoc: Mat::copyTo(m, mask)
    public void copyTo(Mat m, Mat mask) {

        n_copyTo(nativeObj, m.nativeObj, mask.nativeObj);
    }

    // javadoc: Mat::create(rows, cols, type)
    public void create(int rows, int cols, int type) {

        n_create(nativeObj, rows, cols, type);
    }

    // javadoc: Mat::create(size, type)
    public void create(Size size, int type) {

        n_create(nativeObj, size.width, size.height, type);
    }

    // javadoc: Mat::cross(m)
    public Mat cross(Mat m) {

        return new Mat(n_cross(nativeObj, m.nativeObj));
    }

    // javadoc: Mat::dataAddr()
    public long dataAddr() {

        return n_dataAddr(nativeObj);
    }

    // javadoc: Mat::depth()
    public int depth() {

        return n_depth(nativeObj);
    }

    // javadoc: Mat::diag(d)
    public Mat diag(int d) {

        return new Mat(n_diag(nativeObj, d));
    }

    // javadoc: Mat::diag()
    public Mat diag() {

        return new Mat(n_diag(nativeObj, 0));
    }

    // javadoc: Mat::dot(m)
    public double dot(Mat m) {

        return n_dot(nativeObj, m.nativeObj);
    }

    // javadoc: Mat::elemSize()
    public long elemSize() {

        return n_elemSize(nativeObj);
    }

    // javadoc: Mat::elemSize1()
    public long elemSize1() {

        return n_elemSize1(nativeObj);
    }

    // javadoc: Mat::empty()
    public boolean empty() {

        return n_empty(nativeObj);
    }

    // javadoc: Mat::inv(method)
    public Mat inv(int method) {

        return new Mat(n_inv(nativeObj, method));
    }

    // javadoc: Mat::inv()
    public Mat inv() {

        return new Mat(n_inv(nativeObj));
    }

    // javadoc: Mat::isContinuous()
    public boolean isContinuous() {

        return n_isContinuous(nativeObj);
    }

    // javadoc: Mat::isSubmatrix()
    public boolean isSubmatrix() {

        return n_isSubmatrix(nativeObj);
    }

    // javadoc: Mat::locateROI(wholeSize, ofs)
    public void locateROI(Size wholeSize, Point ofs) {
        double[] wholeSize_out = new double[2];
        double[] ofs_out = new double[2];
        locateROI_0(nativeObj, wholeSize_out, ofs_out);
        if (wholeSize != null) {
            wholeSize.width = wholeSize_out[0];
            wholeSize.height = wholeSize_out[1];
        }
        if (ofs != null) {
            ofs.x = ofs_out[0];
            ofs.y = ofs_out[1];
        }
    }

    // javadoc: Mat::mul(m, scale)
    public Mat mul(Mat m, double scale) {

        return new Mat(n_mul(nativeObj, m.nativeObj, scale));
    }

    // javadoc: Mat::mul(m)
    public Mat mul(Mat m) {

        return new Mat(n_mul(nativeObj, m.nativeObj));
    }

    // javadoc: Mat::push_back(m)
    public void push_back(Mat m) {

        n_push_back(nativeObj, m.nativeObj);
    }

    // javadoc: Mat::release()
    public void release() {

        n_release(nativeObj);
    }

    // javadoc: Mat::reshape(cn, rows)
    public Mat reshape(int cn, int rows) {

        return new Mat(n_reshape(nativeObj, cn, rows));
    }

    // javadoc: Mat::reshape(cn)
    public Mat reshape(int cn) {

        return new Mat(n_reshape(nativeObj, cn));
    }

    // javadoc: Mat::row(y)
    public Mat row(int y) {

        return new Mat(n_row(nativeObj, y));
    }

    // javadoc: Mat::rowRange(startrow, endrow)
    public Mat rowRange(int startrow, int endrow) {

        return new Mat(n_rowRange(nativeObj, startrow, endrow));
    }

    // javadoc: Mat::rowRange(r)
    public Mat rowRange(Range r) {

        return new Mat(n_rowRange(nativeObj, r.start, r.end));
    }

    // javadoc: Mat::rows()
    public int rows() {

        return n_rows(nativeObj);
    }

    // javadoc: Mat::operator =(s)
    public Mat setTo(Scalar s) {

        return new Mat(n_setTo(nativeObj, s.val[0], s.val[1], s.val[2], s.val[3]));
    }

    // javadoc: Mat::setTo(value, mask)
    public Mat setTo(Scalar value, Mat mask) {

        return new Mat(n_setTo(nativeObj, value.val[0], value.val[1], value.val[2], value.val[3],
                mask.nativeObj));
    }

    // javadoc: Mat::setTo(value, mask)
    public Mat setTo(Mat value, Mat mask) {

        return new Mat(n_setTo(nativeObj, value.nativeObj, mask.nativeObj));
    }

    // javadoc: Mat::setTo(value)
    public Mat setTo(Mat value) {

        return new Mat(n_setTo(nativeObj, value.nativeObj));
    }

    // javadoc: Mat::size()
    public Size size() {

        return new Size(n_size(nativeObj));
    }

    // javadoc: Mat::step1(i)
    public long step1(int i) {

        return n_step1(nativeObj, i);
    }

    // javadoc: Mat::step1()
    public long step1() {

        return n_step1(nativeObj);
    }

    // javadoc: Mat::operator()(rowStart, rowEnd, colStart, colEnd)
    public Mat submat(int rowStart, int rowEnd, int colStart, int colEnd) {

        return new Mat(n_submat_rr(nativeObj, rowStart, rowEnd, colStart, colEnd));
    }

    // javadoc: Mat::operator()(rowRange, colRange)
    public Mat submat(Range rowRange, Range colRange) {

        return new Mat(
                n_submat_rr(nativeObj, rowRange.start, rowRange.end, colRange.start, colRange.end));
    }

    // javadoc: Mat::operator()(roi)
    public Mat submat(Rect roi) {

        return new Mat(n_submat(nativeObj, roi.x, roi.y, roi.width, roi.height));
    }

    // javadoc: Mat::t()
    public Mat t() {

        return new Mat(n_t(nativeObj));
    }

    // javadoc: Mat::total()
    public long total() {

        return n_total(nativeObj);
    }

    // javadoc: Mat::type()
    public int type() {

        return n_type(nativeObj);
    }

    @Override
    protected void finalize() throws Throwable {
        n_delete(nativeObj);
        super.finalize();
    }

    // javadoc:Mat::toString()
    @Override
    public String toString() {
        return "Mat [ "
                + rows()
                + "*"
                + cols()
                + "*"
                + CvType.typeToString(type())
                + ", isCont="
                + isContinuous()
                + ", isSubmat="
                + isSubmatrix()
                + ", nativeObj=0x"
                + Long.toHexString(nativeObj)
                + ", dataAddr=0x"
                + Long.toHexString(dataAddr())
                + " ]";
    }

    // javadoc:Mat::dump()
    public String dump() {
        return nDump(nativeObj);
    }

    // javadoc:Mat::put(row,col,data)
    public int put(int row, int col, double... data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        return nPutD(nativeObj, row, col, data.length, data);
    }

    // javadoc:Mat::put(row,col,data)
    public int put(int row, int col, float[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_32F) {
            return nPutF(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::put(row,col,data)
    public int put(int row, int col, int[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_32S) {
            return nPutI(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::put(row,col,data)
    public int put(int row, int col, short[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_16U || CvType.depth(t) == CvType.CV_16S) {
            return nPutS(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::put(row,col,data)
    public int put(int row, int col, byte[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_8U || CvType.depth(t) == CvType.CV_8S) {
            return nPutB(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col,data)
    public int get(int row, int col, byte[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_8U || CvType.depth(t) == CvType.CV_8S) {
            return nGetB(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col,data)
    public int get(int row, int col, short[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_16U || CvType.depth(t) == CvType.CV_16S) {
            return nGetS(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col,data)
    public int get(int row, int col, int[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_32S) {
            return nGetI(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col,data)
    public int get(int row, int col, float[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_32F) {
            return nGetF(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col,data)
    public int get(int row, int col, double[] data) {
        int t = type();
        if (data == null || data.length % CvType.channels(t) != 0) {
            throw new java.lang.UnsupportedOperationException("Provided data element number ("
                    + (data == null ? 0 : data.length)
                    + ") should be multiple of the Mat channels count ("
                    + CvType.channels(t)
                    + ")");
        }
        if (CvType.depth(t) == CvType.CV_64F) {
            return nGetD(nativeObj, row, col, data.length, data);
        }
        throw new java.lang.UnsupportedOperationException("Mat data type is not compatible: " + t);
    }

    // javadoc:Mat::get(row,col)
    public double[] get(int row, int col) {
        return nGet(nativeObj, row, col);
    }

    // javadoc:Mat::height()
    public int height() {
        return rows();
    }

    // javadoc:Mat::width()
    public int width() {
        return cols();
    }

    // javadoc:Mat::getNativeObjAddr()
    public long getNativeObjAddr() {
        return nativeObj;
    }
}
