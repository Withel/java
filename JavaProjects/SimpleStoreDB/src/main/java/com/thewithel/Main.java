package com.thewithel;

import com.thewithel.model.DataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage stage;

    public void init() throws IOException {
        DataSource.getInstance().openDatabase();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/startingWindow.fxml"));
            root = loader.load();
            stage.setTitle("Sign In System");
            stage.setScene(new Scene(root, 420, 320));
            stage.show();

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
        DataSource.getInstance().closeDatabase();
    }
}
