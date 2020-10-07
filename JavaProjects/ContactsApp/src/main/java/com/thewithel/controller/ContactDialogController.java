package com.thewithel.controller;

import com.thewithel.datamodel.Contact;
import com.thewithel.datamodel.ContactsData;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * This class is responsible for handling data that it gets from its dialog.
 * It is connected to fxml file where five variables {@code TextArea} are used
 *
 * @author Mateusz Klimas
 */

public class ContactDialogController {

    /**
     * Function that is made for initialization of class.
     * It creates EventHandlers for every {@code TextArea} in this class.
     * Its purpuse is to ensure that TAB Key instead of writing value
     * to the fild will skip to the next area.
     */
    public void initialize(){
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

        firstNameArea.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        lastNameArea.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        phoneNumberArea.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        emailArea.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        notesArea.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }

    @FXML
    TextArea firstNameArea;

    @FXML
    TextArea lastNameArea;

    @FXML
    TextArea phoneNumberArea;

    @FXML
    TextArea emailArea;

    @FXML
    TextArea notesArea;

    /**
     * Fucntion that convert files in {@code TextArea} to {@code String}
     * values and then it creates contact and returns it.
     *
     * @return it returns created contact from input its getting
     */

    public Contact processData() {
        String name = firstNameArea.getText().trim();
        String last = lastNameArea.getText().trim();
        String phone = phoneNumberArea.getText().trim();
        String tempEmail = emailArea.getText().trim();
        String tempNotes = notesArea.getText().trim();

        Contact temp = new Contact(name, last, phone, tempEmail, tempNotes);
        ContactsData.getInstance().addContact(temp);
        return temp;
    }

    /**
     * Function that updates newly created dialog with contact
     * that is selected in the main window
     * @param contact accepts contact that will be displayed id dialog
     */

    public void editContact(Contact contact) {
        System.out.println(contact.getFirstName());
        firstNameArea.setText(contact.getFirstName());
        lastNameArea.setText(contact.getLastName());
        phoneNumberArea.setText(contact.getPhoneNumber());
        emailArea.setText(contact.getEmail());
        notesArea.setText(contact.getNotes());
    }

    /**
     * Funcion updates selected contact
     * @param contact parameter that tells which contact to update
     */
    public void updateContact(Contact contact) {
        contact.setFirstName(firstNameArea.getText());
        contact.setLastName(lastNameArea.getText());
        contact.setPhoneNumber(phoneNumberArea.getText());
        contact.setEmail(emailArea.getText());
        contact.setNotes(notesArea.getText());
    }
}
