package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DB.ReadDB;
import models.DB.Update;
import models.Event;


import java.io.IOException;
import java.util.List;


@WebServlet("/confirmation")
public class ConfirmationEmail extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) {

    Integer idEmail = Integer.valueOf(request.getParameter("p1"));
    Integer idDB = Integer.valueOf(request.getParameter("p2"));

    System.out.println("idEmail: " + idEmail + " idDB: " + idDB);
    ReadDB readDB = new ReadDB("root", "root");
    Event event = readDB.takeEvent(idDB);
    List<Boolean> eventConfirmation = event.getConfirmationEmail();
    eventConfirmation.set(idEmail, true);
    String queryEmails = "";
    for (int i = 0; i < eventConfirmation.size(); i++) {
      queryEmails += event.getEmailsList().get(i) + " " + eventConfirmation.get(i) + " ";
    }
    System.out.println(queryEmails);

    Update update = new Update("root", "root");
    update.UpdateColumnInRecord(idDB,"emails",queryEmails,"events");


    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/confirmation.jsp");
    try {
      rd.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
