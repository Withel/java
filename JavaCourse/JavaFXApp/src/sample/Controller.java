package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private GridPane gridPane;

    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private WebView webView;

    public void initialize(){
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handlerMouseEnter(){
        //to wypierdala program xD
//        for(int i=0;i<360;i++){
//            label.setRotate(i);
//            if(i==359) i=0;
//        }
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handlerMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick(){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Applications File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("All files", "*.*")
        );
//        chooser.showOpenDialog(gridPane.getScene().getWindow());
//        DirectoryChooser chooser = new DirectoryChooser();
//        chooser.showDialog(gridPane.getScene().getWindow());
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if(file != null){
            for(int i=0;i<file.size();i++){
                System.out.println(file.get(i).getPath());
            }
//            System.out.println(file.getPath());
        } else {
            System.out.println("Chooser was canceled");
        }
    }

    @FXML
    public void handleLinkClick(){
//        System.out.println("The link was clicked");
//        try{
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch (IOException e){
//            e.printStackTrace();
//        } catch (URISyntaxException e){
//            e.printStackTrace();
//        }

        WebEngine engine = webView.getEngine();
        engine.load("http://www.javafx.com");
    }


}
