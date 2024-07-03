package controllers;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DB.Delete;

import java.io.IOException;

@WebServlet("/remove")
public class RemoveEvent extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    Integer eventID = Integer.parseInt(request.getParameter("ide"));

    System.out.println("event id z klasy servlet remove " + eventID);

    Delete deleteDb = new Delete("root","root");
    deleteDb.deleteEvent(eventID);

    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    try {
      dispatcher.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
