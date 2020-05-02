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

@WebServlet(name = "ProductPriceSelection", urlPatterns = "/select_product_price")
public class SelectProductPriceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("product") == null){
            response.sendRedirect("product_description");
        }
        else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");

            request.setAttribute("product", productName);
            request.getRequestDispatcher("/select_product_price.jsp").forward(request, response);
        }
    }
}
