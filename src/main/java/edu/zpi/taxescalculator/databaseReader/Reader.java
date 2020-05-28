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

    public void loadCommand(String command){
        try {
            statement.executeUpdate(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public ArrayList<String> getAllProductName(){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select ProductName from products";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getProductCategory(String productName){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select CategoryName from categories JOIN products " +
                    "ON categories.IdCategory = products.IdCategory where products.ProductName = \"" + productName +"\"";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getProductWholesalePrice(String productName){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select ProductWholesalePrice from products where products.ProductName = \"" + productName +"\"";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getAllStateName(){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select StateName from states";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getStateBaseTax(String state){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select StateBaseTax from states WHERE states.STATENAME = \"" + state + "\"";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getTaxValueBaseOnCategoryInState(String state, String category){
        ResultSet rs = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select TaxOnCategoryValue, taxexplanation.ExplanationName from taxesoncategories\n" +
                    "JOIN categories ON categories.IdCategory = taxesoncategories.IdCategory\n" +
                    "JOIN states ON states.IdState = taxesoncategories.IdState\n" +
                    "JOIN taxexplanation ON taxexplanation.IdTaxExplanation = taxesoncategories.IdTaxExplanation\n" +
                    "where states.StateName = \"" + state + "\" and categories.CategoryName = \"" + category + "\"";
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                arrayList.add(rs.getString(1));
                arrayList.add(rs.getString(2));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
