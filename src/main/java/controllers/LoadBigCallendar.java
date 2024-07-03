package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;
import models.DB.ReadDB;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/LoadBigCallendar")
public class LoadBigCallendar extends HttpServlet {
  private List<Event> eventsInChoosedWeek = new ArrayList<>();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EventDetails eventDetails = new EventDetails();
    Integer year = Integer.valueOf(request.getParameter("actuallYear"));
    Integer month = Integer.valueOf(request.getParameter("actuallMonth")) + 1;
    Integer day = Integer.valueOf(request.getParameter("actualDay"));
//    SmsSender sender  = new SmsSender.Builder(730432932)
//        .build();
//    sender.sendSms(730432932,"ouuu");


    //timer task
//    ScheduledSmsSender smsSender = new ScheduledSmsSender();
//    smsSender.sendSms();

    //timer task

//    System.out.println(year + " actuall Year");
//    System.out.println(month + " actuall Month");
//    System.out.println(day + " actuall Day");

    DayInCallendar loadBigCallendar = new DayInCallendar();
    LocalDate clickedDate = LocalDate.of(year, month, day);
    int clickedDayNumber = loadBigCallendar.getDayNumber(clickedDate);

//    System.out.println(clickedDayNumber);
    List<String> days = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
        , "Saturday"));
    request.setAttribute("days", days);

    LocalDate date = LocalDate.of(year, month, day);
    int lenghtOfMonth = date.lengthOfMonth();

    List<String> nbOfDays = loadBigCallendar.getWeekNbDays(day, clickedDayNumber, lenghtOfMonth);

    Boolean loadFirstDayOfWeek = true;
    Integer firstDay = 0;
    Integer lastDay = 0;
    for (int i = 0; i < nbOfDays.size(); i++) {
      if (!nbOfDays.get(i).equals("") && loadFirstDayOfWeek) {
        firstDay = Integer.parseInt(nbOfDays.get(i));
        lastDay = Integer.parseInt(nbOfDays.get(i));
        loadFirstDayOfWeek = false;
      }
      if (!nbOfDays.get(i).equals("")) {
        lastDay = Integer.parseInt(nbOfDays.get(i));
      }
    }
    System.out.println("pierwszy dzien ytgodnia " + firstDay + " drugi dzien tygodnia " + lastDay);


    LocalDate firstDayOfWeek = LocalDate.of(year, month, firstDay);
    LocalDate lastDayOfWeek = LocalDate.of(year, month, lastDay);
    ReadDB readDB = new ReadDB("root", "root");
    eventsInChoosedWeek = readDB.weekEvents(firstDayOfWeek, lastDayOfWeek);


    for (Event event : eventsInChoosedWeek) {
      System.out.println("to jest z mojej metodyyyy gotowe do pokazania na ekranie");
      System.out.println(event.getEmailsList());
      System.out.println(event.getConfirmationEmail());

      System.out.println(event.getName());
      String start = event.getStartDate();
      start = start.substring(11, 16);

      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
    }

//    List<String> eventDays = loadBigCallendar.eventDay(eventsInChoosedWeek,nbOfDays);

    //List<Boolean> ifIsEventOfDay = loadBigCallendar.ifIsEventOfTheDay(eventDays,nbOfDays);
    CallendarList calendar = new CallendarList();
    List<String> times = calendar.getTimes();
    List<String> fullHoursToShowCss = calendar.getFullhoursToShowCss();
    List<String> fullActiveHoursToShowCss = calendar.getFullActivehoursToShowCss();
    List<String> firstHalfHoursToShowCss = calendar.getFirstHalfHoursToShowCss();
    List<String> lastHalfHoursToShowCss = calendar.getLastHalfHoursToShowCss();


    List<List<Integer>> emptyHoursWeek = loadBigCallendar.createEmptyHourWeek(nbOfDays, times);
    List<List<Integer>> hourInEvents = loadBigCallendar.getActiveHoursInEvents(eventsInChoosedWeek,times);
    List<List<Integer>> whichEventInDay = loadBigCallendar.whichEventInDay(nbOfDays, eventsInChoosedWeek);

    List<List<Integer>> activeEvents = loadBigCallendar.setActiveEvents(emptyHoursWeek, hourInEvents, whichEventInDay);

    System.out.println("aaa");


    //List<List<Integer>> whichEventInDayAsc = loadBigCallendar.whichEventInDayAsc( whichEventInDay,
    // eventsInChoosedWeek);
//    List<List<String>> eventsDays = loadBigCallendar.generateEventsDays(eventsInChoosedWeek,fullHoursToShowCss,
//    fullActiveHoursToShowCss,firstHalfHoursToShowCss,lastHalfHoursToShowCss);
    //List<Integer> showHourEvents = loadBigCallendar.getHoursInEveryEvents(eventsInChoosedWeek);

    //System.out.println("aaa");

    //List<List<String>> timeDay = loadBigCallendar.getActiveTime(eventsInChoosedWeek,nbOfDays,whichEventInDayAsc,
    // times,fullHoursToShowCss,fullActiveHoursToShowCss);


    request.setAttribute("events", eventsInChoosedWeek);
    request.setAttribute("hoursAndEvents", activeEvents);
    request.setAttribute("nbOfDays", nbOfDays);
    request.setAttribute("month", month);
    request.setAttribute("year", year);
    request.setAttribute("clickedDayNumber", clickedDayNumber - 1);

    RequestDispatcher req = request.getRequestDispatcher("WEB-INF/views/LoadBigCallendar.jsp");

    try {
      req.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<Event>getEventInChooseWeek()
  {
    return eventsInChoosedWeek;
  }
}