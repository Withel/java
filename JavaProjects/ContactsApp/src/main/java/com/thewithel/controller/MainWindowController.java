package com.thewithel.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import com.thewithel.datamodel.Contact;
import com.thewithel.datamodel.ContactsData;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Class is responsible for handling flow of the program.
 * When program is started this class decides how to handle user's
 * input and what to display.
 *
 * @author Mateusz Klimas
 */

public class MainWindowController {

    private static final String CONTACT_DIALOG_NAME = "contactDialog.fxml";

    /**
     * {@code TableView} is used to connect and dispay list from program
     * on the screen.
     */

    @FXML
    private TableView<Contact> contactsTableView;

    @FXML
    BorderPane mainWindow;

    public void initialize(){
        System.out.println("Initialize in control ");
        contactsTableView.setItems(ContactsData.getInstance().getContacts());
        contactsTableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * Function that creats allert about no selection
     * contact. If user didnt select anything this allert will pop.
     */

    private void noSelectionAllert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("No Contact selected");
        alert.setHeaderText(null);
        alert.setContentText("Please select contact You want to edit or delete.");
        alert.showAndWait();
        return;
    }

    /**
     * Function that show and handles results from new contact dialog.
     */
    @FXML
    public void showNewContactDialog() {
        FXMLLoader loader = createLoader();
        Dialog<ButtonType> dialog = createDialog("Add new contact", loader);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            ContactDialogController controller = createNewDialogController(loader);

            Contact newContact = controller.processData();
            contactsTableView.getSelectionModel().select(newContact);
        }
    }

    /**
     * Function that show and handles results from edit contact dialog.
     */
    @FXML
    public void showEditContactDialog() {
        Contact selectedContact = contactsTableView.getSelectionModel().getSelectedItem();
        if(selectedContact == null){
            noSelectionAllert();
            return;
        }
        FXMLLoader loader = createLoader();
        Dialog<ButtonType> dialog = createDialog("Edit Contact", loader);

        ContactDialogController dialogController = createNewDialogController(loader);
        dialogController.editContact(selectedContact);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {
            dialogController.updateContact(selectedContact);
        }
    }

    /**
     * Function creates Allert and expects user to decide whetere he really
     * wants to delete contact from the list and handles his input.
     */
    public void showDeleteContactDialog() {
        Contact selectedContact = contactsTableView.getSelectionModel().getSelectedItem();
        if(selectedContact == null){
            noSelectionAllert();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delet Contact");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected contact: " +
                selectedContact.getFirstName() + " " + selectedContact.getLastName()+"?");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            ContactsData.getInstance().deleteContact(selectedContact);
        }
    }

    /**
     * Function creates new {@codeFXMLLoader}
     * @return newly created {@codeFXMLLoader}
     */
    public FXMLLoader createLoader(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/" + CONTACT_DIALOG_NAME));
        return fxmlLoader;
    }

    /**
     * Creates Dialog.
     *
     * @param dialogName name of a dialog
     * @param loader need loader to know in which fxml file its located
     * @return newly Dialog
     */
    public Dialog<ButtonType> createDialog(String dialogName, FXMLLoader loader){
        Dialog<ButtonType> dialog = new Dialog();
        dialog.initOwner(mainWindow.getScene().getWindow());
        dialog.setTitle(dialogName);

        loader.setLocation(getClass().getResource("/" + CONTACT_DIALOG_NAME));
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

    /**
     * Creates contreller
     * @param loader loader is connecting it to correct fxmlFile
     * @return newly created controller
     */

    public ContactDialogController createNewDialogController(FXMLLoader loader){
        loader.setLocation(getClass().getResource("/" + CONTACT_DIALOG_NAME));
        return loader.getController();
    }

    /**
     * Function shows and ask about exiting program.
     */
    public void showExitDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delet Contact");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            Platform.exit();
        }
    }

    /**
     * Documentation will be written here.
     */
    public void newFile() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Create new File");
        alert.setHeaderText(null);
        alert.setContentText("Do you want to save current file?\nUnsaved changes will be lost.");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            saveFile();
            ContactsData.getInstance().clearContacts();
        }

    }

    /**
     * Function that handles opening contacts from filer
     */
    public void openFile() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Choose Contact File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Contacts", "*.cnt")
        );

        File file = chooser.showOpenDialog(mainWindow.getScene().getWindow());
        if(file != null) {
            try {
                System.out.println("Opening file " + file.getPath());
                ContactsData.getInstance().loadContacts(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
                //@TODO someday maybe allert with "couldnt load the file message here"
            }
        } else {
            System.out.println("File opening canceled.");
        }
    }

    /**
     * Function saves our input to file
     */
    public void saveFile() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("Contacts", "*.cnt")
        );

        File file = chooser.showSaveDialog(mainWindow.getScene().getWindow());
        if(file != null){
            try {
                System.out.println("Opening file " + file.getPath());
                ContactsData.getInstance().saveContacts(file.toPath());
            } catch (IOException e){
                e.printStackTrace();
                //@TODO same shit as above
            }
        } else {
            System.out.println("File saving canceled.");
        }
    }
}
