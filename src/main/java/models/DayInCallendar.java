package models;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayInCallendar {//  String day; String month; String year; public LoadBigCallendarE(String day, String
  // month, String year) { day = day;
  /*    month = month; */
  /*    this.year = year; */
  /*  } */

//  public List<String> eventDay(List<Event> events, List<String> getWeekNbDays) {
//    List<String> eventDays = new ArrayList<>();
//    for (Event event : events) {
//      String firstDayEvent = event.getStartDay();
//      String lastDayEvent = event.getEndDay();
//      if (firstDayEvent.equals(lastDayEvent)) {
//        if (!eventDays.contains(firstDayEvent)) {
//          eventDays.add(firstDayEvent);
//        }
//      } else {
//        Integer firstDayInt = Integer.parseInt(firstDayEvent);
//        Integer lastDayInt = Integer.parseInt(lastDayEvent);
//        while (firstDayInt == lastDayInt) {
//          String firstDayAfterTransormation = String.valueOf(firstDayInt);
//          if (!eventDays.contains(firstDayAfterTransormation)) {
//            eventDays.add(firstDayAfterTransormation);
//          }
//        }
//      }
//    }
//    return eventDays;
  /*  } */

  public List<List<Integer>> whichEventInDay(List<String> getWeekNbDays, List<Event> events) {
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < getWeekNbDays.size(); i++) {
      List<Integer> singleDay = new ArrayList<>();
      for (int j = 0; j < events.size(); j++) {
        Integer dayEvent = Integer.valueOf(events.get(j).getStartDay());
        String dayEventString = String.valueOf(dayEvent);
        String dayInWeek = getWeekNbDays.get(i);
        if (dayEventString.equals(dayInWeek)) {
          singleDay.add(j);
        }
      }
      res.add(singleDay);
    }
    return res;
  }

  //  public List<List<String>> generateEventsDays(List<Event> eventsInChoosedWeek, List<String> fullHoursToShowCss,
//                                               List<String> fullActiveHoursToShowCss,
//                                               List<String> firstHalfHoursToShowCss,
//                                               List<String> lastHalfHoursToShowCss) {
//
//    return null;
//
//  }
  /**/
  public List<List<Integer>> getActiveHoursInEvents(List<Event> eventsInChoosedWeek, List<String> times) {
    List<Integer> singleEvent = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    for (Event event : eventsInChoosedWeek) {
      singleEvent = new ArrayList<>();
      Integer startHour = Integer.valueOf(event.getStartTime().substring(0, 2));
      Integer endHour = Integer.valueOf(event.getEndTime().substring(0, 2));
      if (startHour == endHour) {
        singleEvent.add((startHour - 7) * 2);
      } else {
        Boolean activeTime = false;
        for (int i = 0; i < times.size(); i++) {
          String start = event.getStartTime();

          if (activeTime) {
            singleEvent.add(i);
          }
          if (times.get(i).equals(event.getStartTime())) {
            singleEvent.add(i);
            activeTime = true;
          }
          String a = event.getEndTime();
          if (times.get(i).equals(event.getEndTime())) {
            singleEvent.add(i);
            activeTime = false;
          }

        }
      }
      result.add(singleEvent);
    }
    return result;
  }

  public List<List<Integer>> createEmptyHourWeek(List<String> getWeekNbDays, List<String> times) {
    //empty hour -1
    /*events>0*/
    List<Integer> singleDay = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    for (String day : getWeekNbDays) {
      singleDay = new ArrayList<>();
      for (String time : times) {
        singleDay.add(-1);
      }
      result.add(singleDay);
    }
    return result;
  }

  public List<List<Integer>> setActiveEvents(List<List<Integer>> emptyWeek, List<List<Integer>> hoursInEvents,
                                             List<List<Integer>> whichEventInDay) {

    List<List<Integer>> emptyWeekInside = new ArrayList<>(emptyWeek);
    List<List<Integer>> whichEventInDay2 = new ArrayList<>(whichEventInDay);
    List<List<Integer>> hoursInEvents2 = new ArrayList<>(hoursInEvents);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> singleDayEmpty = new ArrayList<>(emptyWeek.get(0));

    for (int i = 0; i < whichEventInDay2.size(); i++) {
      singleDayEmpty = new ArrayList<>(emptyWeek.get(0));
      for (int j = 0; j < whichEventInDay2.get(i).size(); j++) {
        Integer nbOfEvent = whichEventInDay2.get(i).get(j);
        List<Integer> singleDay = singleDayEmpty;
        for (int k = 0; k < hoursInEvents2.get(nbOfEvent).size(); k++) {
          singleDay.set(hoursInEvents2.get(nbOfEvent).get(k), nbOfEvent);
        }
        emptyWeekInside.set(i, singleDay);
      }
    }
    return emptyWeekInside;
  }

  public int getDayNumber(LocalDate date) {
    int dayInt = 0;
    DayOfWeek day = date.getDayOfWeek();
    dayInt = day.getValue();
    if (day == DayOfWeek.SUNDAY) {
      dayInt = 0;
    }
    return dayInt + 1;
  }

  public List<String> getWeekNbDays(int dataDay, int dayNumber, int monthNumber) {
    List<String> weekDays = new ArrayList<String>();
    String firstDayOfWeek = dataDay - (dayNumber - 1) > 0 && dataDay - dayNumber < monthNumber ?
        String.valueOf(dataDay - dayNumber + 1) : "";
    String secDayOfWeek = dataDay - (dayNumber - 2) > 0 && dataDay - dayNumber + 1 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 2) : "";
    String thirdDayOfWeek = dataDay - (dayNumber - 3) > 0 && dataDay - dayNumber + 2 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 3) : "";
    String fourthDayOfWeek = dataDay - (dayNumber - 4) > 0 && dataDay - dayNumber + 3 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 4) : "";
    String fivethDayOfWeek = dataDay - (dayNumber - 5) > 0 && dataDay - dayNumber + 4 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 5) : "";
    String sixthDayOfWeek = dataDay - (dayNumber - 6) > 0 && dataDay - dayNumber + 5 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 6) : "";
    String seventhDayOfWeek = dataDay - (dayNumber - 7) > 0 && dataDay - dayNumber + 6 < monthNumber ?
        String.valueOf(dataDay - dayNumber + 7) : "";

    return weekDays = new ArrayList<>(Arrays.asList(firstDayOfWeek, secDayOfWeek, thirdDayOfWeek, fourthDayOfWeek,
        fivethDayOfWeek, sixthDayOfWeek, seventhDayOfWeek));

  }

  public List<List<Integer>> whichEventInDayAsc(List<List<Integer>> whichEventInDay, List<Event> eventsInChoosedWeek) {
    List<List<Integer>> res = whichEventInDay;
    for (int i = 0; i < res.size(); i++) {
      if (res.get(i).size() != 0) {
        for (int j = 0; j < res.get(i).size(); j++) {
          for (int k = j; k < res.get(i).size(); k++) {
            Integer firstDayInList =
                Integer.valueOf(eventsInChoosedWeek.get(res.get(i).get(j)).getStartTime().substring(0, 2));
            Integer secDayInList =
                Integer.valueOf(eventsInChoosedWeek.get(res.get(i).get(k)).getStartTime().substring(0, 2));
            if (firstDayInList > secDayInList && k != j) {
              Integer firstEl = res.get(i).get(j);
              res.get(i).set(j, res.get(i).get(k));
              res.get(i).set(k, firstEl);
            }
          }
        }
      }
    }
    return res;
  }
}
