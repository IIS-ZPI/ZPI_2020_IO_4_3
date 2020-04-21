package edu.zpi.taxescalculator.servlets;

import edu.zpi.taxescalculator.utils.StatesTableEntry;
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

@WebServlet(name = "ShowStatesServlet", urlPatterns = "/states")
public class ShowStatesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        List<StatesTableEntry> statesEntries = new ArrayList<>();
        var statesMap = TaxDataParser.fromURL("https://en.wikipedia.org/wiki/Sales_taxes_in_the_United_States");
        statesMap.forEach((k, v) -> {
            statesEntries.add(new StatesTableEntry(k, nf.format(v)));
        });

        request.setAttribute("entries", statesEntries);
        request.getRequestDispatcher("show_states.jsp").forward(request, response);
    }
}
