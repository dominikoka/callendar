package controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.DB.Update;
import models.Email.Email;
import models.Email.EmailSender;
import models.Event;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@WebServlet("/updateEvent")
public class UpdateEvent extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) {

    int eventId = Integer.parseInt(req.getParameter("eventID"));
    int type = Integer.parseInt(req.getParameter("type"));

    String eventName = String.valueOf(req.getParameter("eventName"));
    String startTime = String.valueOf(req.getParameter("startTime"));
    String endTime = String.valueOf(req.getParameter("endTime"));
    String location = String.valueOf(req.getParameter("location"));
    String msgTitle = String.valueOf(req.getParameter("msgTitle"));
    String msgDesc = String.valueOf(req.getParameter("msgDesc"));

    String mailList = String.valueOf(req.getParameter("mailList"));
    Gson gson = new Gson();
    List<String> emailsFromForm = gson.fromJson(mailList, new TypeToken<List<String>>() {
    }.getType());
    Email email = new Email();
    String preparedEmail = email.prepareEmails(emailsFromForm);

    EmailSender emailSender = new EmailSender("666test666@o2.pl", "Dupadupa666");
    if (!emailsFromForm.isEmpty()) {
      CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
        for (int i = 0; i < emailsFromForm.size(); i++) {
          Integer emailNumber = i;
//          Integer eventID = readDB.lastIdEvent();
          String adressConfirmation = "http://localhost:8088/confirmation?p1=" + emailNumber + "&p2=" + eventId;
          String body = "corrected email" +
              msgDesc + "\n" + "start " + startTime + " end " + endTime + "\n" + "location " + location + "\n" +
              "clicking on the link you confirm your presence" + "\n" + adressConfirmation;
          emailSender.sendEmail(emailsFromForm.get(i), msgTitle, body);
        }
      });
    }
//    Event corectedEvent = new Event(eventName,startTime,endTime,location,msgTitle,msgDesc,preparedEmail);
//    corectedEvent.setID(eventId);
//    corectedEvent.setType(type);
    Event corectedEvent = new Event.Builder(eventName, startTime, endTime, msgDesc)
        .id(eventId)
        .type(type)
        .location(location)
        .msgTitle(msgTitle)
        .emails(preparedEmail)
        .build();
    Update update = new Update("root", "root");
    update.UpdateRecord(corectedEvent, eventId, "events");


    RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
    try {
      rd.forward(req, res);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
