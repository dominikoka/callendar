package models.DB;

import models.Event;

import java.sql.*;

public class Update {
  String user;
  String password;

  public Update(String user, String password) {
    this.user = user;
    this.password = password;
  }

//  public String take(int idEvent, String user, String password)
//  {
//    String emails =
//    try {
//      Class.forName("com.mysql.cj.jdbc.Driver");
//      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
//      String query = "select * from events where id =" + "\'" + idEvent + "\'";
//      System.out.println(query);
//      Statement statement = connection.createStatement();
//      ResultSet resultSet = statement.executeQuery(query);
//      while (resultSet.next()) {
//        System.out.println(resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
//      }
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//    return "";
//  }

  public void updateNotification(String notificationsID)
  {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "UPDATE events  SET notification =? WHERE id IN (" + notificationsID+")";


      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setBoolean(1, false);

      System.out.println(query);
      int row = preparedStatement.executeUpdate();



    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public void UpdateColumnInRecord(int idEvent, String columnName, String queryBody, String table) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password);
      String query = "UPDATE "+table+ " SET " + columnName + "=?"  + " WHERE id=" + idEvent;


      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, queryBody);

      System.out.println(query);
      int row = preparedStatement.executeUpdate();



    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public void UpdateRecord(Event event, int idEvent,String tableName)
  {
    Event asd = event;
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, password)) {
      String query = "UPDATE "+ tableName +" SET name=?, startData=?,endData=?,location=?,messageTitle=?,messageDescription=?,emails=?,eventType=? WHERE id=" + idEvent;
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, event.getName());
        preparedStatement.setString(2, event.getStartDate());
        preparedStatement.setString(3, event.getEndDate());
        preparedStatement.setString(4, event.getLocation());
        preparedStatement.setString(5, event.getMsgTitle());
        preparedStatement.setString(6, event.getMsgDesc());
        preparedStatement.setString(7, event.getEmails());
        preparedStatement.setInt(8, event.getType());

        // Wykonanie zapytania
        int rowsAffected = preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      // Obsługa wyjątków
      e.printStackTrace();
    }
  }

}
