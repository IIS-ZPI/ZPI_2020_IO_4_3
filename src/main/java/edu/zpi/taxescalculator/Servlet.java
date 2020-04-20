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
            String product = request.getParameter("product");
            int margin = Integer.parseInt(request.getParameter("margin"));
            int stockPrice = Integer.parseInt(request.getParameter("stock_price"));
            List<State> states = new ArrayList<>();
            states.add(new State("Arizona", 0.056));
            states.add(new State("California", 0.0725));
            states.add(new State("Florida", 0.06));
            request.setAttribute("states", states);
            request.setAttribute("product", product);
            request.setAttribute("stock_price", stockPrice);
            double maxTax = states.stream().mapToDouble(State::getBaseTax).max().orElse(0);
            double maxPrice = (stockPrice + margin) * (1 + maxTax);
            request.setAttribute("max_price", maxPrice);
            request.getRequestDispatcher("margin.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
