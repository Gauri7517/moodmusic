package com.example.moodmusic.camera;

import org.opencv.core.*;
import org.opencv.videoio.*;
import org.opencv.highgui.*;

public class CameraTest {

    static {
        System.load("C:/Users/Admin/Downloads/opencv-4.12.0-windows/opencv/build/java/x64/opencv_java4120.dll");
    }

    public static void main(String[] args) {

        VideoCapture camera = null;

        // Try camera indexes 0 to 5
        for (int i = 0; i < 5; i++) {
            camera = new VideoCapture(i, Videoio.CAP_DSHOW);
            if (camera.isOpened()) {
                System.out.println("Camera opened at index: " + i);
                break;
            }
        }

        if (camera == null || !camera.isOpened()) {
            System.out.println("No camera detected");
            return;
        }

        Mat frame = new Mat();

        while (true) {

            camera.read(frame);

            if (frame.empty()) {
                System.out.println("Frame not captured");
                break;
            }

            HighGui.imshow("Webcam Working", frame);

            if (HighGui.waitKey(30) == 27) {
                break;
            }
        }

        camera.release();
        HighGui.destroyAllWindows();
    }
}