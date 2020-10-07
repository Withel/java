package com.thewithel.Controller;

import com.thewithel.model.MorseMessage;
import com.thewithel.model.TextMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * Controller class, that connects buttons from fxml file
 * to correct functions.
 *
 * @author Mateusz Klimas
 * @since 20.10.2019
 */

public class Controller {

    /**
     * Properties of class are two buttons which are used
     * to initiate conversion from methods. Also class has two
     * TextArea classes. There are used for getting text, and
     * converting it to string.
      */

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private TextArea leftArea;

    @FXML
    private TextArea rightArea;

    /**
     * Methods that are connected to buttons in fxml file.
     * They are used to get text from TextAreas, then create and initiate
     * classes that holds messages. After translation they put translated
     * message to the other side.
     */
    @FXML
    public void convertToText(){
        MorseMessage message = new MorseMessage(leftArea.getText().trim());
        rightArea.setText(message.convert());
    }

    @FXML
    public void convertToMorse(){
        TextMessage message = new TextMessage(rightArea.getText().trim());
        leftArea.setText(message.convert());
    }
}
