package edu.zpi.taxescalculator.servlets;


import edu.zpi.taxescalculator.utils.*;

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
        if (request.getParameter("product") == null || request.getParameter("category") == null) {
            response.sendRedirect("product_description");
        } else {
            String product = request.getParameter("product");
            ProductCategory category = ProductCategory.valueOf(request.getParameter("category").toUpperCase());

            request.setAttribute("product", product);
            request.setAttribute("category", category);
            request.getRequestDispatcher("/select_product_price.jsp").forward(request, response);
        }
    }
}
