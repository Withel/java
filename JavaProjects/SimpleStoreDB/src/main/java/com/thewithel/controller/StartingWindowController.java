package com.thewithel.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

public class StartingWindowController {

    private static final String REGISTER_DIALOG = "registerDialog.fxml";
    private static final String SING_IN_DIALOG = "signInDialog.fxml";

    @FXML
    Button signIn;

    @FXML
    Button register;

    @FXML
    GridPane startingWindow;

    @FXML
    public void showSignInDialog(){
        FXMLLoader fxmlLoader = createLoader(SING_IN_DIALOG);
        Dialog<ButtonType> dialog = createDialog("Sign in", fxmlLoader, SING_IN_DIALOG);
        SignInDialogController controller = createSignInDialogController(fxmlLoader);
        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            controller.signIn();
        }
    }

    @FXML
    public void showRegisterDialog(){
        FXMLLoader fxmlLoader = createLoader(REGISTER_DIALOG);
        Dialog<ButtonType> dialog = createDialog("Sign in", fxmlLoader, REGISTER_DIALOG);
        RegisterDialogController controller = createRegisterDialogController(fxmlLoader);
        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            controller.register();
        }
    }

    public FXMLLoader createLoader(String fxmlName){
        FXMLLoader fxmlLoader = new FXMLLoader();
        if(fxmlName.equals(REGISTER_DIALOG)){
            fxmlLoader.setLocation(getClass().getResource("/" + fxmlName));
            return fxmlLoader;
        } else {
            fxmlLoader.setLocation(getClass().getResource("/" + fxmlName));
            return fxmlLoader;
        }
    }

    public Dialog<ButtonType> createDialog(String dialogName, FXMLLoader loader, String fxmlName){
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(startingWindow.getScene().getWindow());
        dialog.setTitle(dialogName);

        loader.setLocation(getClass().getResource("/" + fxmlName));
        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        return dialog;
    }

    public RegisterDialogController createRegisterDialogController(FXMLLoader loader){
            loader.setLocation(getClass().getResource("/" + REGISTER_DIALOG));
            return loader.getController();

    }

    public SignInDialogController createSignInDialogController(FXMLLoader loader){
        loader.setLocation(getClass().getResource("/ " + SING_IN_DIALOG));
        return loader.getController();
    }

    public static EventHandler<KeyEvent> createHandlerForTab() {

        EventHandler<KeyEvent> handler = (event) -> {
            KeyCode code = event.getCode();

            if (code == KeyCode.TAB && !event.isShiftDown() && !event.isControlDown()) {
                event.consume();
                Node node = (Node) event.getSource();
                KeyEvent newEvent
                        = new KeyEvent(event.getSource(),
                        event.getTarget(), event.getEventType(),
                        event.getCharacter(), event.getText(),
                        event.getCode(), event.isShiftDown(),
                        true, event.isAltDown(),
                        event.isMetaDown());

                node.fireEvent(newEvent);
            }
        };

        return handler;
    }
}
