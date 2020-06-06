package edu.zpi.taxescalculator.databaseReader;

import edu.zpi.taxescalculator.utils.TaxDataParser;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        DataSourceProvider dataSourceProvider = new DataSourceProvider();
        dataSourceProvider.init();
        Reader r = new Reader(dataSourceProvider.getDataStatement());
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
//        try {
//            var statesMap = TaxDataParser.fromUrlIncludeCategories("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
//            AtomicInteger stateCount= new AtomicInteger(1);
//            statesMap.forEach((k, v) -> {
//                r.insertState(k.getStateName(), nf.format(k.getBaseTax()));
//                for(int i=0; i<v.size();i++){
//                    r.insertTaxBaseOnCategory(stateCount.get(), i+1, v.get(i).getTax(), v.get(i).getTaxedAbovePrice());
//                }
//                stateCount.getAndIncrement();

//                System.out.println(k.getStateName() + " - " + nf.format(k.getBaseTax()) + " - " + v.get(4).isTaxIncluded() + " - " + v.get(4).getTax() + " - " + v.get(4).getTaxedAbovePrice());
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ArrayList arrayList = r.getAllStateName();
//        System.out.println(arrayList);
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
        ArrayList arrayList = r.getTaxValueBaseOnCategoryInState("Arkansas", "Prescription drug");
        System.out.println(arrayList);

    }


}
