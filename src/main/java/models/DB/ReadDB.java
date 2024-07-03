package models.DB;

import models.Event;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadDB {

  String user;
  String password;
  public ReadDB(String user, String password)
  {
    this.user = user;
    this.password = password;
  }

  public List<Event> weekEvents(LocalDate start, LocalDate end) {
    List<Event> events = new ArrayList<>();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events where startData >=" + "\'" + start + " 00:00:00" + "\'" + " AND endData <=" + "\'" + end + " 18:00:00" + "\'" + ";";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
//        Event event = new Event(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
//        event.setID(resultSet.getInt(1));
//        event.setType(resultSet.getInt(9));
        Event event = new Event.Builder(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(7))
                .id(resultSet.getInt(1))
                .type(resultSet.getInt(9))
                    .location(resultSet.getString(5))
                        .msgTitle(resultSet.getString(6))
                            .emails(resultSet.getString(8))
                                .build();
        events.add(event);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(start + " data poczatkowa do wczytania");
    System.out.println(end + " data koncowa do wczytania");
    return events;
  }

  public Event takeEvent(int id) {
    Event event=null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events where id =" + "\'" + id + "\'";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
//        event = new Event(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8));
//        event.setID(resultSet.getInt(1));
//        event.setType(resultSet.getInt(9));
         event = new Event.Builder(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(7))
            .id(resultSet.getInt(1))
            .type(resultSet.getInt(9))
            .location(resultSet.getString(5))
            .msgTitle(resultSet.getString(6))
            .emails(resultSet.getString(8))
            .build();

      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return event;
  }
  public int lastIdEvent()
  {
    int result = 0;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events Order By id desc limit 1";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
        result = resultSet.getInt(1);

      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return result;
  }

  public String getIdToSendSms()
  {
    String ids = "";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events where notification = true";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));

        ids+=resultSet.getInt(1)+", ";
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return ids.substring(0, ids.length()-2);
  }
  public String getIdOlderThan5hAndYounger6h(String idWithNotifications)
  {
    String ids = "";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events where startData < NOW() - INTERVAL 5 HOUR and startData >= NOW() - INTERVAL 6 HOUR and id IN ("+idWithNotifications+");";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
        ids+=resultSet.getInt(1)+", ";

      }
    } catch (Exception e) {
      System.out.println(e);
    }
    if(ids.length()>=3)
    {
      ids = ids.substring(0, ids.length()-2);
    }
    return ids;
  }

  public List<List<String>> contentToSendSMS(String idToSend) {
    List<List<String>> contentToSend = new ArrayList<>();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "select * from events where id IN ("+idToSend+");";
      System.out.println(query);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
        List<String> singleContent = new ArrayList<>(Arrays.asList(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        contentToSend.add(singleContent);

      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return contentToSend;
  }
}