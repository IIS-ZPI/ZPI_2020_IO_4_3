package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.databaseReader.DatabaseSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TypeProductDataServlet", urlPatterns = "/select_product")
public class SelectProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var productNames = DatabaseSingleton.getInstance().connect().getProductDescriptionList();
        request.setAttribute("products", productNames);
        request.getRequestDispatcher("select_product.jsp").forward(request, response);
    }
}
