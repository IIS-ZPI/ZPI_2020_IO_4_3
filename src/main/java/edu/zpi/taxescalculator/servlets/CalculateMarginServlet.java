package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.utils.MarginTableEntry;
import edu.zpi.taxescalculator.utils.Product;
import edu.zpi.taxescalculator.utils.ProductCategory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet(name = "CalculateMarginServlet", urlPatterns = "/margin_calculator")
public class CalculateMarginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("product") == null ||
                request.getParameter("value_calc") == null
                || request.getParameter("wholesale_price") == null
                || request.getParameter("calculation_type") == null
                || request.getParameter("quantity") == null) {
            response.sendRedirect("select_product_price");
        } else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            nf.setMinimumFractionDigits(2);

            String productName = request.getParameter("product");
            String calculationType = request.getParameter("calculation_type");
            double calculationValue = Double.parseDouble(request.getParameter("value_calc"));
            double wholesalePrice = Double.parseDouble(request.getParameter("wholesale_price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            ProductCategory category = null;
            try {
                category = ProductCategory.valueOf(request.getParameter("category").toUpperCase());
            } catch (IllegalArgumentException e) {
                response.sendRedirect("select_product_price");
                return;
            }

            if (calculationValue < 0 || wholesalePrice < 0) {
                response.sendRedirect("select_product_price");
                return;
            }

            Product product = new Product(productName, wholesalePrice, quantity, category);

            var entries = MarginTableEntry.createEntriesList(product, calculationValue, calculationType);
            if (entries == null) {
                response.sendRedirect("select_product_price");
                return;
            }

            request.setAttribute("entries", entries);
            request.setAttribute("product", productName);
            request.setAttribute("category", category);
            request.getRequestDispatcher("/margin.jsp").forward(request, response);

        }
    }
}
