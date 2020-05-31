package edu.zpi.taxescalculator.databaseReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        dataSourceProvider.init();
        Reader r = new Reader(dataSourceProvider.getDataStatement());

        ArrayList arrayList = r.getAllStateName();
        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getAllProductName();
//        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getAllCategoryName();
//        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getStateBaseTax("California");
//        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getProductCategory("Milk");
//        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getProductWholesalePrice("Milk");
//        System.out.println(arrayList);
//
//        ArrayList arrayList = r.getTaxValueBaseOnCategoryInState("Arkansas", "Prescription drug");
//        System.out.println(arrayList);

    }


}
