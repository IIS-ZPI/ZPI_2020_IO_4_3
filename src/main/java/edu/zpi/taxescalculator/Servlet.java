package edu.zpi.taxescalculator;

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

@WebServlet(name = "edu.zpi.taxescalculator.Servlet", urlPatterns = "/margin_calculator")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("act");
        if (str.equalsIgnoreCase("margin")) {
            request.getRequestDispatcher("info.jsp").forward(request, response);
        } else if (str.equalsIgnoreCase("margin_calculate")) {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");
            double margin = Double.parseDouble(request.getParameter("margin"));
            double wholesalePrice = Double.parseDouble(request.getParameter("wholesale_price"));

            Product product = new Product(productName, wholesalePrice, margin);

            List<State> states = new ArrayList<>();
            states.add(new State("Arizona", 0.056));
            states.add(new State("California", 0.0725));
            states.add(new State("Florida", 0.06));

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
            request.getRequestDispatcher("margin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
