package com.thewithel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public void init() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/mainWindow.fxml"));
            root = loader.load();
            primaryStage.setTitle("ContactApp");
            primaryStage.setScene(new Scene(root, 640, 480));
            primaryStage.show();

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.err.println("Couldn' load main window.");
            System.exit(-1);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void stop() throws IOException {
        //@TODO find a way to execute this before leaving probably some listener for "X" button
    }
}
