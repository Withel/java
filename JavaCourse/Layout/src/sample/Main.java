package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

//different Layouts are stored in seperate fxml files

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        Parent root;
//        if(x==1) {
//            root = FXMLLoader.load(getClass().getResource("hBox.fxml"));
//        } else {
//            root = FXMLLoader.load(getClass().getResource("gridPane.fxml"));
//        }

        Parent root = FXMLLoader.load(getClass().getResource("flowPane.fxml"));
        primaryStage.setTitle("Fuck YOU FXML");
        Scene scene = new Scene(root, 500, 275);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
