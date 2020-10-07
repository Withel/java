package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static sample.Main.flag;

public class Controller {

    @FXML
    Button toChange;

    public void changeStage() throws IOException {
        Parent root;
        if (flag == 0) {
            root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
            flag = 1;
        } else {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            flag = 0;
        }
        Main.stage.setTitle("Hello World");
        Main.stage.setScene(new Scene(root));
        Main.stage.show();
    }
}

