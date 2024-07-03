package controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Email.Email;
import models.DB.CreateDB;
import models.Email.EmailSender;
import models.DB.ReadDB;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@WebServlet("/saveEvent")
public class SaveEvent extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("zapisuuj dane");

    String eventName = request.getParameter("eventName");
    String location = request.getParameter("location");
    String messageTitle = request.getParameter("messageTitle");
    String messageDesc = request.getParameter("messageDesc");
    String dateStartInput = request.getParameter("dateStart");
    dateStartInput = dateStartInput.replace("T", " ");
    final String dateStart = dateStartInput;
    String dateEndInput = request.getParameter("dateEnd");
    dateEndInput = dateEndInput.replace("T", " ");
    final String dateEnd = dateEndInput;
    String orderList = request.getParameter("listOrder");
    Integer type = Integer.parseInt(request.getParameter("type"));
    System.out.println(type);
    Gson gson = new Gson();
    List<String> emailsFromForm = gson.fromJson(orderList, new TypeToken<List<String>>() {
    }.getType());

    Email email = new Email();
    String emails = email.prepareEmails(emailsFromForm);
    CreateDB create = new CreateDB();
    create.createEvent(eventName, location, messageTitle, messageDesc, dateStartInput, dateEndInput, emails, type);
    ReadDB readDB = new ReadDB("root", "root");

    EmailSender emailSender = new EmailSender("666test666@o2.pl", "Dupadupa666");

    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
      for (int i = 0; i < emailsFromForm.size(); i++) {
        Integer emailNumber = i;
        Integer eventID = readDB.lastIdEvent();
        String adressConfirmation = "http://localhost:8088/confirmation?p1=" + emailNumber + "&p2=" + eventID;
        String body =
            messageDesc + "\n" + "start " + dateStart + " end " + dateEnd + "\n" + "location " + location + "\n" +
                "clicking on the link you confirm your presence" + "\n" + adressConfirmation;
        emailSender.sendEmail(emailsFromForm.get(i), messageTitle, body);
      }
    });


//    System.out.println(eventName + " event name");
//    System.out.println(location + " location");
//    System.out.println(messageTitle + " messageTitle");
//    System.out.println(messageDesc + " messageDesc");
//    System.out.println(dateStart + " dateStart");
//    System.out.println(dateEnd + " dateEnd");
//    System.out.println("meilee");


  }
}
