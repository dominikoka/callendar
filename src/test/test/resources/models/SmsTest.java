package resources.models;
//import main.java.helloClasses.Helloe;

import main.java.helloClasses.Helloe;


//import jdk.internal.event.Event;
import models.DayInCallendar;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import models.SmsSender;

public class SmsTest {

  @Test
  public void sendMsgShouldSendMsgToSender()
  {
    //given
      SmsSender sms = new SmsSender.Builder(730432932)
          .build();
      Integer number = sms.getNumber();
      String msg = "wyslano smsa";
    //when
      Boolean result = sms.sendSms(number,msg);
    //then
    Assert.assertEquals(true, result);

  }}
