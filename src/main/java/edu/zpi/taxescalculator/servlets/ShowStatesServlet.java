package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.utils.StatesTableEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowStatesServlet", urlPatterns = "/states")
public class ShowStatesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var statesEntries = StatesTableEntry.createEntriesList();
        request.setAttribute("entries", statesEntries);
        request.getRequestDispatcher("show_states.jsp").forward(request, response);
    }
}
