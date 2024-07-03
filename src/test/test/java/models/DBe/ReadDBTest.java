package java.models.DBe;


import models.CurrentTimeProvider;
import models.DB.ReadDB;
import models.DayInCallendar;
//import models.ScheduledSmsSender;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import models.SmsSender;

public class ReadDBTest {

  @Test
  public void getIdToSendSmsShouldGiveIdWithNotification()
  {
   ReadDB db = new ReadDB("root","root");
   String idInDbToSendSms = db.getIdToSendSms();
   System.out.println("aaa");

  }}
