package models.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

  String user;
  String pass;
  public Delete(String user, String pass) {
    this.user = user;
    this.pass = pass;
  }

  public void deleteEvent(int idEvent)
  {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar", user, pass)) {
      String query = "DELETE FROM events WHERE id = ?";
      try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, idEvent);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
          System.out.println("Rekord o id " + idEvent + " został pomyślnie usunięty.");
        } else {
          System.out.println("Nie znaleziono rekordu o id " + idEvent + " do usunięcia.");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
