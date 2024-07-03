package models.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDB {


  public int createUserEvent(int userID, int eventID) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clients", "root", "root")) {
      String query = "INSERT INTO user_event (user_id, event_id) VALUES (?, ?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, String.valueOf(userID));
        preparedStatement.setInt(2, eventID);
        int rowsAffected = preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public int createEvent(String eventName, String location, String msgTitle, String msgDesc, String dateStart, String dateEnd, String emails, Integer type) {
    try  {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/calendar", "root", "root"
      );
      String query = "INSERT INTO events (name, startData, endData,location,messageTitle,messageDescription,emails,eventType) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, eventName);
        preparedStatement.setString(2, dateStart);
        preparedStatement.setString(3, dateEnd);
        preparedStatement.setString(4, location);
        preparedStatement.setString(5, msgTitle);
        preparedStatement.setString(6, msgDesc);
        preparedStatement.setString(7, emails);
        preparedStatement.setInt(8, type);
        int rowsAffected = preparedStatement.executeUpdate();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return -1;
  }
}
