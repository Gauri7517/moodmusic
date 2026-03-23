package com.example.moodmusic.camera;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class FaceDetection {

    static {
        System.load("C:/Users/Admin/Downloads/opencv-4.12.0-windows/opencv/build/java/x64/opencv_java4120.dll");
    }

    public static String detectEmotion() {

        VideoCapture camera = null;   // initialize variable

        camera = new VideoCapture(0, Videoio.CAP_DSHOW);

        if (!camera.isOpened()) {
            System.out.println("Camera not opened");
            return "Neutral";
        }

        Mat frame = new Mat();

        camera.read(frame);

        if (frame.empty()) {
            System.out.println("Frame not captured");
            return "Neutral";
        }

        camera.release();

        return "Happy";   // demo emotion
    }
}