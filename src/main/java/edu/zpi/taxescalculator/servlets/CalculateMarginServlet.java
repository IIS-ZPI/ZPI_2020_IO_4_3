package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;

@WebServlet(name = "CalculateMarginServlet", urlPatterns = "/margin_calculator")
public class CalculateMarginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("product") == null ||
                request.getParameter("value_calc") == null
                || request.getParameter("wholesale_price") == null 
                || request.getParameter("calculation_type") == null)
        {
            response.sendRedirect("select_product_price");
        }
        else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");
            ProductCategory categoryName = null;
            try {
                categoryName = ProductCategory.valueOf(request.getParameter("category").toUpperCase());
            } catch (IllegalArgumentException e) {
                response.sendRedirect("select_product_price");
                return;
            }
            double value_calc = Double.parseDouble(request.getParameter("value_calc"));
            double wholesalePrice = Double.parseDouble(request.getParameter("wholesale_price"));
            if (value_calc < 0 || wholesalePrice < 0) {
                response.sendRedirect("select_product_price");
                return;
            }
            String calculation_type = request.getParameter("calculation_type");

            Product product = new Product(productName, wholesalePrice);

            var statesAndCategoriesMap = TaxDataParser.fromUrlIncludeCategories("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
            var statesAndTaxMap = new TreeMap<State, Double>();
            ProductCategory finalCategoryName = categoryName;
            statesAndCategoriesMap.forEach((k, v) -> {
                var optionalCategoryTax = v.stream()
                        .filter(el -> el.getProductCategory().equals(finalCategoryName))
                        .findFirst();
                double tax = 0.0;
                if (optionalCategoryTax.isPresent()) {
                    tax = optionalCategoryTax.get().getTax() / 100.0;
                }
                statesAndTaxMap.put(k, tax);
            });
            
            Map<State, Double> margins = null;
            if (calculation_type.equalsIgnoreCase("min_margin")) {
                margins = product.calculateMarginsBasedOnMinMargin(statesAndTaxMap, value_calc);
            } else if (calculation_type.equalsIgnoreCase("expected_price")) {
                margins = product.calculateMarginsBasedOnMaxPrice(statesAndTaxMap, value_calc);
            } else {
                response.sendRedirect("select_product_price");
                return;
            }
            List<MarginTableEntry> entries = new ArrayList<>();
            
            margins.forEach((key, value) -> {
                entries.add(new MarginTableEntry(key.getStateName(),
                        nf.format(product.getWholesalePrice()),
                        nf.format(value),
                        nf.format((wholesalePrice + value) * (1 + statesAndTaxMap.get(key))),
                        nf.format(key.getBaseTax()),
                        nf.format(wholesalePrice + value),
                        nf.format(statesAndTaxMap.get(key) * 100)));
            });

            request.setAttribute("entries", entries);
            request.setAttribute("product", productName);
            request.setAttribute("category", categoryName);
            request.getRequestDispatcher("/margin.jsp").forward(request, response);
        
        }
    }
}
