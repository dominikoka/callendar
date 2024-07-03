package resources.models;

import models.CurrentTimeProvider;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CurrentTimeProviderTest {

  @Test
  public void getCurrentTimeShouldGiveCurrentTimeInList() throws Exception {
    CurrentTimeProvider currentTimeProvider = new CurrentTimeProvider();

    String currenttime = currentTimeProvider.getCurrentTime();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");
    LocalDateTime now = LocalDateTime.now();
    String formattedNow = dtf.format(now);

    Assert.assertEquals(List.of(formattedNow.split("/")),currenttime);
  }
}
