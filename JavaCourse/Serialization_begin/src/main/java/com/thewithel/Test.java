package com.thewithel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String3");

        try {
            writeList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("============");

        try {
            writeListSeparetly(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readListSeparetly();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeListSeparetly(List p) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objectSep.txt"));

        for (int i = 0; i < p.size(); i++) {
            objectOutputStream.writeObject(p.get(i));
        }

        objectOutputStream.close();
    }

    public static void writeList(List p) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));

        objectOutputStream.writeObject(p);

        objectOutputStream.close();
    }

    public static void readListSeparetly() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objectSep.txt"));

        String temp;
        while((temp =(String) objectInputStream.readObject()) != null){
            System.out.println(temp);
        }

        objectInputStream.close();
    }

    public static ArrayList<String> readList() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));

        ArrayList<String> newList;

        newList = (ArrayList<String>) objectInputStream.readObject();

        for (String i : newList) {
            System.out.println(i);
        }

        objectInputStream.close();

        return newList;
    }

    public static void writeToFile(Person p) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin", true));

        objectOutputStream.writeObject(p);

        objectOutputStream.close();
    }

    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));

        boolean cont = true;
        while (cont) {
            Object obj = (Person) objectInputStream.readObject();
            if (obj != null) {
                System.out.println(obj.toString());
            } else {
                cont = false;
            }
        }

//        Person name = (Person) objectInputStream.readObject();
//        System.out.println(name);
//        name = (Person) objectInputStream.readObject();
//        System.out.println(name);

        objectInputStream.close();
    }
}
