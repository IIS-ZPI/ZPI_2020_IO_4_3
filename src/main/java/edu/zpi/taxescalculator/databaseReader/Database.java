package edu.zpi.taxescalculator.databaseReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    Connection connection;
    Statement statement;


    public Database(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    public int addToDatabase(String productName, String productCategory) {
        try {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS PRODUCT (name String, category String)");
            statement.executeUpdate(
                    String.format("INSERT INTO PRODUCT VALUES('%s', '%s')", productName, productCategory));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
/*

    String url = "jdbc:mysql://localhost:3306/zpi2020io43?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "root";
        try{
                //Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                String sql = "select * from categories";
                ResultSet rs = statement.executeQuery(sql);

                while(rs.next()){
                System.out.println(rs.getString(2));
                }
                }catch (SQLException e){
                e.printStackTrace();
                }*/
