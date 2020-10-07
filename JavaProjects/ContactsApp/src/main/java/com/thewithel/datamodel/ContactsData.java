package com.thewithel.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * Function is responsible for holding Contacts Data.
 * It is made as singleton as where not using more that one list at the time.
 */

public class ContactsData {
    private static ContactsData instance = new ContactsData();

    /**
     * {@ObservableList} is used to connect it to the view
     */

    private ObservableList<Contact> contacts;

    public static ContactsData getInstance() {
        return instance;
    }

    public void addContact(Contact item) {
        contacts.add(item);
    }

    public void deleteContact(Contact item) { contacts.remove(item); }

    public ObservableList<Contact> getContacts() {
        return contacts;
    }

    private ContactsData() {
        contacts = FXCollections.observableArrayList();
    }

    /**
     * Function loads contacts from file.
     *
     * @param path gets path wher file is located
     * @throws IOException when coulnd't read file
     */

    public void loadContacts(Path path) throws IOException{

        contacts.clear();
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try{
            while((input = br.readLine()) != null){
                String splited[] = input.split("\t");

                contacts.add(new Contact(splited[0], splited[1], splited[2], splited[3], splited[4]));
                System.out.println("added new contact " + splited[0]);
            }
        } finally {
            if(br != null){
                br.close();
            }
        }

    }

    public void clearContacts(){
        contacts.clear();
    }

    /**
     * Function that saves contacts to file.
     *
     * @param path where file should be saved
     * @throws IOException when saving failed.
     */

    public void saveContacts(Path path) throws IOException {

        BufferedWriter bw = Files.newBufferedWriter(path);

        try{
            Iterator<Contact> iterator = contacts.iterator();
            while(iterator.hasNext()){
                Contact temp = iterator.next();
                //TODO change this validadion into something more spectacular! :D
                if(temp.getFirstName() == ""){
                    temp.setFirstName(" ");
                }
                if(temp.getLastName() == ""){
                    temp.setLastName(" ");
                }
                if(temp.getPhoneNumber() == ""){
                    temp.setPhoneNumber(" ");
                }
                if(temp.getEmail() == ""){
                    temp.setEmail(" ");
                }
                if(temp.getNotes() == ""){
                    temp.setNotes(" ");
                }
                try{
                    bw.write(String.format("%s\t%s\t%s\t%s\t%s",
                            temp.getFirstName(),
                            temp.getLastName(),
                            temp.getPhoneNumber(),
                            temp.getEmail(),
                            temp.getNotes()));
                    bw.newLine();
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }
        } finally {
            if(bw != null){
                bw.close();
            }
        }
    }
}
