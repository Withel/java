package com.thewithel;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

public class Main {


    public static void main(String[] args) {

//        try (Connection con = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\testjava.db");
//             Statement statement = con.createStatement()){
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        Path path = FileSystems.getDefault().getPath("src\\main\\resources\\testjava.db");
        Path absolutePath = path.toAbsolutePath();

        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:" + absolutePath.toString());
//            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts  " +
                    "(name TEXT, phone INTEGER, email TEXT)");

//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                     "VALUES('Joe', 111111, 'joe@anywhere.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Jane', 9482672, 'jane@somewhere.com')");
//
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Frode', 991, 'frode@xlm.com')");

//            statement.execute("UPDATE contacts SET phone=556789 WHERE name='Jane'");

//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");

            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close();

            //we always want to close our resources
            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Something wnet wrong: " + e.getMessage());
        }
    }
}
