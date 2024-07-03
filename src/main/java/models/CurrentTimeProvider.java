package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CurrentTimeProvider {

  public String getCurrentTime(){

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime now = LocalDateTime.now();
    String nowFomrated = dtf.format(now);

    return nowFomrated;
  }
}
