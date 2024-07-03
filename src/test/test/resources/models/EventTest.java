package resources.models;
//import main.java.helloClasses.Helloe;

import main.java.helloClasses.Helloe;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//import jdk.internal.event.Event;
import models.DayInCallendar;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class EventTest {


  @Test
  public void createEmptyHourWeekShouldCreateListWithDayWeekAndMinusOneValueInEachDay() {
    //given
    List<String> dayWeek = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
    List<String> times = Arrays.asList("7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17");
    DayInCallendar dayInCallendar = new DayInCallendar();

    //when
    List<List<Integer>> res = new ArrayList<>();
    for (String day : dayWeek) {
      List<Integer> oneDay = new ArrayList<>();
      for (String time : times) {

        oneDay.add(-1);
      }
      res.add(oneDay);
    }

    List<List<Integer>> expected = dayInCallendar.createEmptyHourWeek(dayWeek,times);
    //then
   Assert.assertEquals(res, expected);

  }

}
