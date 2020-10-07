package com.thewithel;

//You can use an AnimationTimer.
//The AnimationTimer's handle method is called once on each frame, and the value passed
//in is the current time in nanoseconds (a best approximation). So you can track how long since the previous frame.
//Here's an implementation that tracks the times of the last 100 frames and computes the frame rate using them:

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleFrameRateMeter extends Application {

    private final long[] frameTimes = new long[100];
    private int frameTimeIndex = 0 ;
    private boolean arrayFilled = false ;

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label();
        AnimationTimer frameRateMeter = new AnimationTimer() {

            @Override
            public void handle(long now) {
                long oldFrameTime = frameTimes[frameTimeIndex] ;
                frameTimes[frameTimeIndex] = now ;
                frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
                if (frameTimeIndex == 0) {
                    arrayFilled = true ;
                }
                if (arrayFilled) {
                    long elapsedNanos = now - oldFrameTime ;
                    long elapsedNanosPerFrame = elapsedNanos / frameTimes.length ;
                    double frameRate = 1_000_000_000.0 / elapsedNanosPerFrame ;
                    label.setText(String.format("Current frame rate: %.3f", frameRate));
                }
            }
        };

        frameRateMeter.start();

        primaryStage.setScene(new Scene(new StackPane(label), 250, 150));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
