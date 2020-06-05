package edu.zpi.taxescalculator.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = "/index")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("act") == null) {
            response.sendRedirect("/");
        } else {
            String str = request.getParameter("act");
            if (str.equalsIgnoreCase("margin")) {
                response.sendRedirect("/select_product");
            } else if (str.equalsIgnoreCase("states")) {
                response.sendRedirect("/states");
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
}
