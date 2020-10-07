package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    //CAN BE DONE BY FXML FILE OR BY CODING IT MANUALLY
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        //"Horizontal Gap" and "Vertical Gap" respectively and are used to provide horizontal
//        //and vertical space between adjacent components.
//        root.setVgap(10);
//        root.setHgap(10);

        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(new Scene(root, 1000, 275));
        primaryStage.show();

//      remember about correct importing
//        //greeting is just a simple label (etykieta/naklejka) on the screen
//        Label greeting = new Label("Welcome to JavaFX");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//        root.getChildren().add(greeting);
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
