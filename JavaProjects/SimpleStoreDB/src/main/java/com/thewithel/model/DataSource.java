package com.thewithel.model;

import java.sql.*;

public class DataSource {

    private static DataSource instance = new DataSource();

    private DataSource() {
    }

    public static DataSource getInstance() {
        return instance;
    }


    public static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/store";
    public static final String USER = "postgres";
    public static final String PASSWORD = "admin";

    public static final String TABLE_CLIENTS = "clients";
    public static final String COLUMN_CLIENT_LOGIN = "login";
    public static final String COLUMN_CLIENT_PASSWORD = "password";
    public static final String COLUMN_CLIENT_NAME = "name";
    public static final String COLUMN_CLIENT_LAST_NAME = "last_name";

    private Connection conn;

    public boolean openDatabase() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to data base: " + e.getMessage());
            return false;
        }
    }

    public Client queryClient(String login) {

        StringBuilder query = new StringBuilder("SELECT * FROM clients WHERE login='" + login + "'" + ";");
        Client client = new Client();

        try (Statement statement = conn.createStatement();
             ResultSet result = statement.executeQuery(query.toString())) {

                if (result.next()) {
                    client.setLogin(result.getString(COLUMN_CLIENT_LOGIN));
                    client.setPassword(result.getString(COLUMN_CLIENT_PASSWORD));
                    client.setName(result.getString(COLUMN_CLIENT_NAME));
                    client.setSecondName(COLUMN_CLIENT_LAST_NAME);
                }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed " + e.getMessage());
            return null;
        }

        return client;
    }

    public void instertClient(Client client) {
        StringBuilder update = new StringBuilder("INSERT INTO clients VALUES ('" + client.getLogin()
                + "', '" + client.getPassword() + "', '" + client.getName()
                + "', '" + client.getSecondName() + "');");

        try(Statement statement = conn.createStatement()){
            statement.executeUpdate(update.toString());
        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Update failed " + e.getMessage());
        }
    }

    public void closeDatabase() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connectio: " + e.getMessage());
        }
    }
}
