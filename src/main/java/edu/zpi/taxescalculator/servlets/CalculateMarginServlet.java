package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.utils.MarginTableEntry;
import edu.zpi.taxescalculator.utils.Product;
import edu.zpi.taxescalculator.utils.State;
import edu.zpi.taxescalculator.utils.TaxDataParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "CalculateMarginServlet", urlPatterns = "/product_description/product_price_selection/margin_calculator")
public class CalculateMarginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (//request.getParameter("product") == null ||
                request.getParameter("margin") == null
                || request.getParameter("wholesale_price") == null)
        {
            response.sendRedirect("/product_description/product_price_selection");
        }
        else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");
            double margin = Double.parseDouble(request.getParameter("margin"));
            double wholesalePrice = Double.parseDouble(request.getParameter("wholesale_price"));

            Product product = new Product(productName, wholesalePrice, margin);

            List<State> states = new ArrayList<>();
            var statesMap = TaxDataParser.fromURL("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
            statesMap.forEach((k, v) -> {
                states.add(new State(k, v / 100.0));
            });

            var margins = product.calculateMargins(states);

            List<MarginTableEntry> entries = new ArrayList<>();

            margins.forEach((key, value) -> {
                entries.add(new MarginTableEntry(key.getStateName(),
                        nf.format(product.getWholesalePrice()),
                        nf.format(value),
                        nf.format((wholesalePrice + value) * (1 + key.getBaseTax())),
                        nf.format(key.getBaseTax() * 100),
                        nf.format(wholesalePrice + value)
                ));
            });

            request.setAttribute("entries", entries);
            request.setAttribute("productName", productName);
            request.getRequestDispatcher("/margin.jsp").forward(request, response);
        }
    }
}
