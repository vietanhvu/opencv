//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.videoio;

import org.opencv.core.Mat;

// C++: class VideoCapture
//javadoc: VideoCapture
public class VideoCapture {

    protected final long nativeObj;

    protected VideoCapture(long addr) {
        nativeObj = addr;
    }

    //
    // C++:   VideoCapture()
    //

    //javadoc: VideoCapture::VideoCapture()
    public VideoCapture() {

        nativeObj = VideoCapture_0();
    }

    //
    // C++:   VideoCapture(String filename)
    //

    //javadoc: VideoCapture::VideoCapture(filename)
    public VideoCapture(String filename) {

        nativeObj = VideoCapture_1(filename);
    }

    //
    // C++:   VideoCapture(int device)
    //

    //javadoc: VideoCapture::VideoCapture(device)
    public VideoCapture(int device) {

        nativeObj = VideoCapture_2(device);
    }

    //
    // C++:  bool open(String filename)
    //

    // C++:   VideoCapture()
    private static native long VideoCapture_0();

    //
    // C++:  bool open(int device)
    //

    // C++:   VideoCapture(String filename)
    private static native long VideoCapture_1(String filename);

    //
    // C++:  bool isOpened()
    //

    // C++:   VideoCapture(int device)
    private static native long VideoCapture_2(int device);

    //
    // C++:  void release()
    //

    // C++:  bool open(String filename)
    private static native boolean open_0(long nativeObj, String filename);

    //
    // C++:  bool grab()
    //

    // C++:  bool open(int device)
    private static native boolean open_1(long nativeObj, int device);

    //
    // C++:  bool read(Mat& image)
    //

    // C++:  bool isOpened()
    private static native boolean isOpened_0(long nativeObj);

    //
    // C++:  bool retrieve(Mat& image, int flag = 0)
    //

    // C++:  void release()
    private static native void release_0(long nativeObj);

    // C++:  bool grab()
    private static native boolean grab_0(long nativeObj);

    //
    // C++:  double get(int propId)
    //

    // C++:  bool read(Mat& image)
    private static native boolean read_0(long nativeObj, long image_nativeObj);

    //
    // C++:  bool set(int propId, double value)
    //

    // C++:  bool retrieve(Mat& image, int flag = 0)
    private static native boolean retrieve_0(long nativeObj, long image_nativeObj, int flag);

    private static native boolean retrieve_1(long nativeObj, long image_nativeObj);

    // C++:  double get(int propId)
    private static native double get_0(long nativeObj, int propId);

    // C++:  bool set(int propId, double value)
    private static native boolean set_0(long nativeObj, int propId, double value);

    // native support for java finalize()
    private static native void delete(long nativeObj);

    //javadoc: VideoCapture::open(filename)
    public boolean open(String filename) {

        return open_0(nativeObj, filename);
    }

    //javadoc: VideoCapture::open(device)
    public boolean open(int device) {

        return open_1(nativeObj, device);
    }

    //javadoc: VideoCapture::isOpened()
    public boolean isOpened() {

        return isOpened_0(nativeObj);
    }

    //javadoc: VideoCapture::release()
    public void release() {

        release_0(nativeObj);
    }

    //javadoc: VideoCapture::grab()
    public boolean grab() {

        return grab_0(nativeObj);
    }

    //javadoc: VideoCapture::read(image)
    public boolean read(Mat image) {

        return read_0(nativeObj, image.nativeObj);
    }

    //javadoc: VideoCapture::retrieve(image, flag)
    public boolean retrieve(Mat image, int flag) {

        return retrieve_0(nativeObj, image.nativeObj, flag);
    }

    //javadoc: VideoCapture::retrieve(image)
    public boolean retrieve(Mat image) {

        return retrieve_1(nativeObj, image.nativeObj);
    }

    //javadoc: VideoCapture::get(propId)
    public double get(int propId) {

        return get_0(nativeObj, propId);
    }

    //javadoc: VideoCapture::set(propId, value)
    public boolean set(int propId, double value) {

        return set_0(nativeObj, propId, value);
    }

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }
}
