package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
       // root = new Pane();
        primaryStage.setTitle("Fuck the button");
        primaryStage.setScene(new Scene(root, 1300, 500));
//        Button button = new Button("Fuck me");
//        button.prefHeight(400);               <== NIE DZIAŁA KUWA
//        button.prefWidth(400);
//        button.setMaxSize(400, 400);
//        button.setPreferredSize(new Dimension(400, 400));

//        ((Pane) root).getChildren().add(button);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
