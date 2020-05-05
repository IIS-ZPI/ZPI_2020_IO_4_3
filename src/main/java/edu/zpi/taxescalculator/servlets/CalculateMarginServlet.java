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
                request.getParameter("margin") == null
                || request.getParameter("wholesale_price") == null)
        {
            response.sendRedirect("product_price_selection");
        }
        else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");
            ProductCategory categoryName = ProductCategory.valueOf(request.getParameter("category").toUpperCase());
            double margin = Double.parseDouble(request.getParameter("margin"));
            double wholesalePrice = Double.parseDouble(request.getParameter("wholesale_price"));

            Product product = new Product(productName, wholesalePrice, margin);

            var statesAndCategoriesMap = TaxDataParser.fromUrlIncludeCategories("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
            var statesAndTaxMap = new TreeMap<State, Double>();
            statesAndCategoriesMap.forEach((k, v) -> {
                var optionalCategoryTax = v.stream()
                        .filter(el -> el.getProductCategory().equals(categoryName))
                        .findFirst();
                double tax = 0.0;
                if (optionalCategoryTax.isPresent()) {
                    tax = optionalCategoryTax.get().getTax() / 100.0;
                }
                statesAndTaxMap.put(k, tax);
            });

            var margins = product.calculateMargins(statesAndTaxMap);

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
