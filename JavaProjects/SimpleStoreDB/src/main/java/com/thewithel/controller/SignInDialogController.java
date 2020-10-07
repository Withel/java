package com.thewithel.controller;

import com.thewithel.model.Client;
import com.thewithel.model.DataSource;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class SignInDialogController {

    public void initialize() {

        EventHandler<KeyEvent> handler = StartingWindowController.createHandlerForTab();

        login.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }

    @FXML
    TextArea login;

    @FXML
    PasswordField password;

    public boolean signIn(){
        String loginString = login.getText().trim();
        String passwordString = password.getText().trim();

        Client client = DataSource.getInstance().queryClient(loginString);

        if(client.getName() == null){
            System.out.println("No data");
            return false;
        }

        client.toString();

        if(client.getLogin().equals(loginString) && client.getPassword().equals(passwordString)){
            System.out.println("You have logged in");
            return true;
        } else {
            return false;
        }
    }
}
