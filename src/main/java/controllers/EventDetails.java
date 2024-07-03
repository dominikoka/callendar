package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Event;

import models.DB.ReadDB;

import java.util.List;

@WebServlet("/eventDetails")
public class EventDetails extends HttpServlet {
  List<Event> events;

  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    int idEvent = Integer.parseInt(request.getParameter("eventID"));
    ReadDB readDB = new ReadDB("root", "root");
    Event event = readDB.takeEvent(idEvent);
    List<String> emails = event.getEmailsList();
    if (emails.get(0).equals("")) {
      emails.remove(0);
    }
    request.setAttribute("name", event.getName());
    request.setAttribute("startDate", event.getStartDate());
    request.setAttribute("endDate", event.getEndDate());
    request.setAttribute("location", event.getLocation());
    request.setAttribute("msgTitle", event.getMsgTitle());
    request.setAttribute("msgDesc", event.getMsgDesc());
    request.setAttribute("emails", emails);
    request.setAttribute("confirmationEmail", event.getConfirmationEmail());
    RequestDispatcher rd;

    System.out.println("pokazanie");
    if (event.getType() == 0) {
      rd = request.getRequestDispatcher("WEB-INF/views/details/eventDetails_Event.jsp");
    } else {
      rd = request.getRequestDispatcher("WEB-INF/views/details/eventDetails_Task.jsp");
    }
    try {
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
