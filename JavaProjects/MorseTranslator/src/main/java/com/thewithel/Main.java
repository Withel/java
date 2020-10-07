package com.thewithel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class is entry point for Application.
 *
 * @author Mateusz Klimas
 * @since 20.10.2019
 */

public class Main extends Application {
    /**
     * Method that will be used in future to initiate everything
     * needed for correct working
     */
    public void init(){
        //@TODO update init() method
    }

    /**
     * Start method starts gui for application. Takes primaryStage as
     * as an argument. Function creates root for every object in javaFX.
     * It also creates FMXLLoader. Its purpose is to load gui from file
     * called "mainWindow.fxml". If it fails it throws and catches IllegalStateException,
     * and then exits program with code -1.
     * @param primaryStage basic parameter for every javaFX app
     * @throws Exception when it could not real fxml file
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/mainWindow.fxml"));
            root = loader.load();
            primaryStage.setTitle("Morse Converter");
            primaryStage.setScene(new Scene(root, 640, 480));
            primaryStage.show();

        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.err.println("Couldn' load main window.");
            System.exit(-1);
        }
    }

    /**
     * Main method just call launch from Application class
     *
     * @param args as in any java app
     * @see javafx.application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method that might be used in the future to make some
     * "cleaning" after program ends.
     */
    public void stop(){
        //@TODO update stop() method
    }
}
