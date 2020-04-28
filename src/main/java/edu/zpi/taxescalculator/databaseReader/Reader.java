package edu.zpi.taxescalculator.databaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Reader {
    public Statement statement;

    public Reader(Statement statement) {
        this.statement = statement;
    }

    public ArrayList<String> getAllCategoryName(){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select CategoryName from categories";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
