package edu.zpi.taxescalculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        Statement statement = connection.createStatement();
        Database sampleDatabase = new Database(connection, statement);

        sampleDatabase.addToDatabase("Milk", "Dairy");

    }


}
