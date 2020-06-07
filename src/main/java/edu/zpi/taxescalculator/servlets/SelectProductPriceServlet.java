package edu.zpi.taxescalculator.servlets;


import edu.zpi.taxescalculator.databaseReader.DatabaseSingleton;
import edu.zpi.taxescalculator.utils.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductPriceSelection", urlPatterns = "/select_product_price")
public class SelectProductPriceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("product") == null || request.getParameter("calculation_type") == null) {
            response.sendRedirect("select_product");
        } else {
            var databaseSingleton = DatabaseSingleton.getInstance().connect();
            String product = request.getParameter("product");
            String calculation_type = request.getParameter("calculation_type");
            ProductCategory category = databaseSingleton.getCategory(product);
            if (category == null) {
                response.sendRedirect("select_product");
                return;
            }
            var productDescription = databaseSingleton.getProductDescription(product);
            request.setAttribute("product", productDescription);
            request.setAttribute("category", category);
            request.setAttribute("calculation_type", calculation_type);
            request.getRequestDispatcher("/select_product_price.jsp").forward(request, response);
        }
    }
}
