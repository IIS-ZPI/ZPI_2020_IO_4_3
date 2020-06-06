package edu.zpi.taxescalculator.databaseReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceProvider {
    private String dbUrl = "jdbc:mysql://localhost:3306/zpi2020io43?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPassword = "root";
//    private String url = "jdbc:sqlite:zpi2020io43.db";
    private Statement dbStatement;

    public void init() {
        createStatement();
    }

    public Statement getDataStatement() {
        return dbStatement;
    }

    private void createStatement() {
        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            dbStatement = connection.createStatement();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

}
