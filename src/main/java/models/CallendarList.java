package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CallendarList {

  String closeDiv = "</div>";

  List<String> times = new ArrayList<>(Arrays.asList("07:00","07:30", "08:00","08:30", "09:00","09:30", "10:00","10:30", "11:00","11:30", "12:00","12:30", "13:00","13:30", "14:00","14:30",
      "15:00","15:30", "16:00","16:30", "17:00"));
  List<String> fullhoursToShowCss = new ArrayList<>(Arrays.asList("<div class=\"callendarBig_time time_7\">",
      "<div class=\"callendarBig_time time_8\">",
      "<div class=\"callendarBig_time time_9\">", "<div class=\"callendarBig_time time_10\">",
      "<div class=\"callendarBig_time time_11\">", "<div class=\"callendarBig_time time_12\">",
      "<div class=\"callendarBig_time time_13\">", "<div class=\"callendarBig_time time_14\">", "<div " +
          "class=\"callendarBig_time time_15\">", "<div class=\"callendarBig_time time_16\">", "<div " +
          "class=\"callendarBig_time time_17\">"));

  List<String> fullActivehoursToShowCss = new ArrayList<>(Arrays.asList("<div class=\"callendarBig_time time_7 " +
          "atime_7\">",
      "<div class=\"callendarBig_time time_8 " +
          "atime_8\">", "<div class=\"callendarBig_time time_9 atime_9\">", "<div class=\"callendarBig_time time_10" +
          " " +
          "atime_10\">", "<div class=\"callendarBig_time time_11 time_11\">", "<div class=\"callendarBig_time " +
          "time_12 " +
          "atime_12\">", "<div class=\"callendarBig_time time_13 atime_13\">", "<div " +
          "class=\"callendarBig_time " +
          "time_14 atime_14\">", "<div class=\"callendarBig_time time_15 atime_15\">", "<div " +
          "class=\"callendarBig_time time_16 atime_16\">", "<div class=\"callendarBig_time time_17 " +
          "atime_17\">"));

  List<String> firstHalfHoursToShowCss = new ArrayList<>(Arrays.asList("<div class=\"callendarBig_time time_7 ftime_7\">",
      "<div class=\"callendarBig_time time_8 ftime_8" +
          "ftime_8\">", "<div class=\"callendarBig_time time_9 ftime_9\">", "<div class=\"callendarBig_time time_10" +
          " " +
          "ftime_10\">", "<div class=\"callendarBig_time time_11 ftime_11\">", "<div class=\"callendarBig_time " +
          "time_12 " +
          "ftime_12\">", "<div class=\"callendarBig_time time_13 ftime_13\">", "<div " +
          "class=\"callendarBig_time " +
          "time_14 ftime_14\">", "<div class=\"callendarBig_time time_15 ftime_15\">", "<div " +
          "class=\"callendarBig_time time_16 ftime_16\">", "<div class=\"callendarBig_time time_17 " +
          "ftime_17\">"));

  List<String> lastHalfHoursToShowCss = new ArrayList<>(Arrays.asList("<div class=\"callendarBig_time time_7 ltime_7\">",
      "<div class=\"callendarBig_time time_8 ltime_8" +
          "etime_8\">", "<div class=\"callendarBig_time time_9 ltime_9\">", "<div class=\"callendarBig_time time_10" +
          " " +
          "ltime_10\">", "<div class=\"callendarBig_time time_11 ltime_11\">", "<div class=\"callendarBig_time " +
          "time_12 " +
          "ltime_12\">", "<div class=\"callendarBig_time time_13 ltime_13\">", "<div " +
          "class=\"callendarBig_time " +
          "time_14 ltime_14\">", "<div class=\"callendarBig_time time_15 ltime_15\">", "<div " +
          "class=\"callendarBig_time time_16 ltime_16\">", "<div class=\"callendarBig_time time_17 " +
          "ltime_17\">"));

  public String getCloseDiv()
  {
    return closeDiv;
  }

  public List<String> getTimes()
  {
    return times;
  }
  public List<String> getFullhoursToShowCss()
  {
    return fullhoursToShowCss;
  }
  public  List<String>getFullActivehoursToShowCss()
  {
    return fullActivehoursToShowCss;
  }
  public List<String> getFirstHalfHoursToShowCss()
  {
    return firstHalfHoursToShowCss;
  }
  public List<String> getLastHalfHoursToShowCss()
  {
    return lastHalfHoursToShowCss;
  }

}
