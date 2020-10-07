package com.thewithel.controller;

import com.thewithel.model.Client;
import com.thewithel.model.DataSource;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;


public class RegisterDialogController {

    public void initialize(){

        EventHandler<KeyEvent> handler = StartingWindowController.createHandlerForTab();

        login.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        name.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        lastName.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }

    @FXML
    TextArea login;

    @FXML
    PasswordField password;

    @FXML
    PasswordField repeatPassword;

    @FXML
    TextArea name;

    @FXML
    TextArea lastName;

    public void register(){
        String loginString = login.getText().trim();
        String passwordString = password.getText().trim();
        String repeatPasswordString = repeatPassword.getText().trim();
        String nameString = name.getText().trim();
        String lastNameString = lastName.getText().trim();

        Client client = new Client(loginString, passwordString, nameString, lastNameString);

        client.toString();

        if(!passwordString.equals(repeatPasswordString)){
            System.out.println("Passwords don't match each other.");
            return;
        } else {
            DataSource.getInstance().instertClient(client);
            System.out.println("You have registered succesfully");
        }
    }
}
