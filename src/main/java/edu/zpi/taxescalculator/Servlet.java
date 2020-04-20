package edu.zpi.taxescalculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "edu.zpi.taxescalculator.Servlet", urlPatterns = "/margin_calculator")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("act");
        if (str.equalsIgnoreCase("margin")) {
            request.getRequestDispatcher("info.jsp").forward(request, response);
        } else if (str.equalsIgnoreCase("margin_calculate")) {
            String productName = request.getParameter("product");
            int margin = Integer.parseInt(request.getParameter("margin"));
            int stockPrice = Integer.parseInt(request.getParameter("stock_price"));

            Product product = new Product(productName, stockPrice, margin);

            List<State> states = new ArrayList<>();
            states.add(new State("Arizona", 0.056));
            states.add(new State("California", 0.0725));
            states.add(new State("Florida", 0.06));

            var margins = product.calculateMargins(states);

            List<MarginTableEntry> entries = new ArrayList<>();

            margins.forEach((key, value) -> {
                entries.add(new MarginTableEntry(key.getStateName(),
                        product.getStockPrice(),
                        value,
                        (stockPrice + value) * (1 + key.getBaseTax()),
                        key.getBaseTax() * 100.0
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
