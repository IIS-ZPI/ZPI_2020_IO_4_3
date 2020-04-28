package edu.zpi.taxescalculator.databaseReader;

import edu.zpi.taxescalculator.utils.State;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        dataSourceProvider.init();
        Reader r = new Reader(dataSourceProvider.getDataStatement());
        ArrayList arrayList = r.getAllCategoryName();
        System.out.println(arrayList);
    }


}
