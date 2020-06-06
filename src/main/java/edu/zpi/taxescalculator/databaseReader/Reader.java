package edu.zpi.taxescalculator.databaseReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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

    public boolean insertTaxBaseOnCategory(int stateId, int categoryId, double taxValue, Integer taxAbove){
        System.out.println(stateId + " " + categoryId);
        try {
            String sql;
            if(taxAbove != null){
                sql = "INSERT INTO zpi2020io43.taxesoncategories (IdCategory, IdState, TaxOnCategoryValue, IsTaxedAbovePrice) " +
                        "VALUES (\"" + categoryId + "\", \"" + stateId + "\", \"" + taxValue + "\" , \"" + taxAbove + "\")";
            }else{
                sql = "INSERT INTO zpi2020io43.taxesoncategories (IdCategory, IdState, TaxOnCategoryValue) " +
                        "VALUES (\"" + categoryId + "\", \"" + stateId + "\", \"" + taxValue + "\")";
            }


            int result = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertState(String stateName, String baseSalesTax){
        try {
            String sql = "INSERT INTO zpi2020io43.states " +
                    "(StateName, StateBaseTax) " +
                    "VALUES (\"" + stateName + "\", \"" + baseSalesTax + "\")";
            int result = statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
            String sql = "select TaxOnCategoryValue, IsTaxedAbovePrice from taxesoncategories\n" +
                    "JOIN categories ON categories.IdCategory = taxesoncategories.IdCategory\n" +
                    "JOIN states ON states.IdState = taxesoncategories.IdState\n" +
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
