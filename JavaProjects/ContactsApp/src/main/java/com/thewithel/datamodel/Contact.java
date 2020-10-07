package com.thewithel.datamodel;

import javafx.beans.property.SimpleStringProperty;

/**
 * Class that represents simple contact
 * @author Mateusz Klimas
 */

public class Contact {

    SimpleStringProperty firstName = new SimpleStringProperty("");
    SimpleStringProperty lastName = new SimpleStringProperty("");
    SimpleStringProperty phoneNumber = new SimpleStringProperty("");
    SimpleStringProperty email = new SimpleStringProperty("");
    SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact() {
    }

    public Contact(String name, String lastName, String number, String email, String notes) {
        this.firstName.set(name);
        this.lastName.set(lastName);
        this.phoneNumber.set(number);
        this.email.set(email);
        this.notes.set(notes);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", phoneNumber=" + phoneNumber +
                ", notes=" + notes +
                '}';
    }
}
