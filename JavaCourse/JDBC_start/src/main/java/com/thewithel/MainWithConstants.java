package com.thewithel;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

public class MainWithConstants {
    public static final String DB_NAME = "testjava.db";
    public static final String JDBC_CONN = "jdbc:sqlite:";
    public static Path path = FileSystems.getDefault().getPath("src\\main\\resources\\testjava.db");
    public static final String CONNECTION_STRING = path.toAbsolutePath().toString();

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(JDBC_CONN + CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " text, " +
                    COLUMN_PHONE + " integer, " +
                    COLUMN_EMAIL + " text " + ")");

//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    " (" + COLUMN_NAME + ", " +
//                    COLUMN_PHONE + "," +
//                    COLUMN_EMAIL + ")" +
//                    "VALUES ('Tim', 654321, 'tim@email.com')");
//
//            statement.execute("INSERT INTO " + TABLE_CONTACTS +
//                    " (" + COLUMN_NAME + ", " +
//                    COLUMN_PHONE + "," +
//                    COLUMN_EMAIL + ")" +
//                    "VALUES ('Joe', 9999999, 'joe@anywhere.com')");

            insertContact(statement, "Tim", 654321, "tim@email.com");
            insertContact(statement, "Joe", 999999, "joe@anyware.com");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + "," +
                    COLUMN_EMAIL + ")" +
                    "VALUES ('Jane', 1111111, 'jane@somewhere.com')");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_PHONE + "," +
                    COLUMN_EMAIL + ")" +
                    "VALUES ('Fido', 4444444, 'dog@dogowhere.com')");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                        COLUMN_PHONE + "=5566789" +
                        " WHERE " + COLUMN_NAME + "='Jane'");

            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                            " WHERE " + COLUMN_NAME + "='Joe'");

            ResultSet results = statement.executeQuery("SELECT * FROM "+ TABLE_CONTACTS );
            while(results.next()){
                System.out.println(results.getString(COLUMN_NAME) + " " +
                                    results.getInt(COLUMN_PHONE) + " " +
                                    results.getString(COLUMN_EMAIL));
            }

            results.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong" + e.getMessage());
        }

    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                " (" + COLUMN_NAME + ", " +
                COLUMN_PHONE + ", " +
                COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }

}
