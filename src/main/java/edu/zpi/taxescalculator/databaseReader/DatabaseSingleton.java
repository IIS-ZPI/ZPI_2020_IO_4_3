package edu.zpi.taxescalculator.databaseReader;

import edu.zpi.taxescalculator.utils.*;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Singleton for manage database connection and data access
 */
public class DatabaseSingleton {

    private static DatabaseSingleton singleton = null;
    private static Reader reader;
    private static DataSourceProvider provider;

    private DatabaseSingleton() {
        provider = new DataSourceProvider();
        provider.init();
        reader = new Reader(provider.getDataStatement());
    }

    /**
     * @return Instance of DatabaseSingleton
     */
    public static DatabaseSingleton getInstance() {
        if (singleton == null)
            singleton = new DatabaseSingleton();
        return singleton;
    }

    /**
     * Closes the connection if it is not already closed
     */
    public void closeConnection() {
        provider.closeConnection();
        singleton = null;
    }

    /**
     * Makes the connection if it is not already connected
     *
     * @return Instance of DatabaseSingleton
     */
    public DatabaseSingleton connect() {
        provider.connect();
        return singleton;
    }

    /**
     * Method to create a map including States and corresponding taxes
     *
     * @return A map with States and corresponding list of taxes based on categories
     * @throws ConnectException When detects a database connection problem
     */
    public Map<State, List<ProductCategoryStateTaxData>> getStatesAndTaxes() throws ConnectException {
        List<State> states = new ArrayList<>();
        var statesNames = reader.getAllStateName();
        var categoriesNames = reader.getAllCategoryName().stream().map(ProductCategory::valueOf).collect(Collectors.toList());
        statesNames.forEach(s -> {
            var baseTaxString = reader.getStateBaseTax(s).stream().findAny().orElse("");
            if (!baseTaxString.isBlank()) {
                double baseTax = Double.parseDouble(baseTaxString);
                states.add(new State(s, baseTax));
            }
        });
        var statesMap = new TreeMap<State, List<ProductCategoryStateTaxData>>();
        states.forEach(state -> {
            List<ProductCategoryStateTaxData> taxesList = new ArrayList<>();
            categoriesNames.forEach(category -> {
                var categoryTaxes = reader.getTaxValueBaseOnCategoryInState(state.getStateName(), category.toString());
                if (categoryTaxes.size() > 0) {
                    var tax = Double.parseDouble(categoryTaxes.get(0));
                    var taxedAboveString = categoryTaxes.get(1);
                    Integer taxedAbove = taxedAboveString != null ? Integer.parseInt(taxedAboveString) : null;
                    ProductCategoryStateTaxData tmp = new ProductCategoryStateTaxData(category, state.getBaseTax(), tax != 0.0d);
                    tmp.setTax(tax);
                    if (taxedAbove != null) {
                        tmp.setTaxedAbovePrice(taxedAbove);
                    }
                    taxesList.add(tmp);
                }
            });
            statesMap.put(state, taxesList);
        });
        return statesMap;
    }
    
    public List<ProductDescription> getProductDescriptionList() throws ConnectException {
        var productNamesList = new ArrayList<ProductDescription>();
        var productNames = reader.getAllProductName();
        productNames.forEach(productName -> {
            var displayName = reader.getProductDisplayName(productName);
            var img = reader.getProductImage(productName);
            if (displayName.size() > 0 && img.size() > 0) {
                productNamesList.add(new ProductDescription(productName, displayName.get(0), img.get(0)));
            }
        });
        return productNamesList;
    }
    
    public ProductCategory getCategory(String productName) throws ConnectException {
        var categories = reader.getProductCategory(productName);
        if (categories.size() > 0) {
            return ProductCategory.valueOf(categories.get(0));
        }
        return null;
    }
    
    public String getProductDisplayName(String productName) throws ConnectException {
        var displayNames = reader.getProductDisplayName(productName);
        if (displayNames.size() > 0) {
            return displayNames.get(0);
        }
        return "";
    }

    public ProductDescription getProductDescription(String productName) throws ConnectException {
        var displayNames = reader.getProductDisplayName(productName);
        var img = reader.getProductImage(productName);
        if (displayNames.size() > 0 && img.size() > 0) {
            return new ProductDescription(productName, displayNames.get(0), img.get(0));
        }
        return null;
    }
}
