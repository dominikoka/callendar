package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/eventWindow")
public class eventWindow extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Integer year = Integer.valueOf(req.getParameter("actuallYear")), month = Integer.valueOf(req.getParameter("actuallMonth")) + 1, day = Integer.valueOf(req.getParameter("actualDay"));
    System.out.println(year + "rok" + month + "miesiac" + day + "dzien");
    String chapter = "do IT";
    req.setAttribute("year", year);
    req.setAttribute("month", month);
    req.setAttribute("day", day);
    RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/eventWindow.jsp");
    try {
      rd.forward(req, res);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
