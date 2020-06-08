package edu.zpi.taxescalculator.databaseReader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceProvider {
    //    private String dbUrl = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7344999?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private String dbUser = "sql7344999";
//    private String dbPassword = "MQHiUDfMkR";
    private String dbName = "/zpi.db";
    private Statement dbStatement;
    private Connection connection;

    public void init() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        createStatement();
    }

    public Statement getDataStatement() {
        return dbStatement;
    }

    public void closeConnection() {
        try {
            dbStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        createStatement();
    }

    private void createStatement() {
        try {
            URL resource = this.getClass().getResource(dbName);
            String dbUrl = String.format("jdbc:sqlite:%s", new File(resource.toURI()).getAbsolutePath());
            connection = DriverManager.getConnection(dbUrl);
            dbStatement = connection.createStatement();
        } catch (
                SQLException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
