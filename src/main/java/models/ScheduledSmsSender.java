package models;

import models.DB.ReadDB;
import models.DB.Update;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduledSmsSender {
  ReadDB readDb = new ReadDB("root", "root");
  Update updateDB = new Update("root", "root");

  public void sendSms() {
    TimerTask senderSms = new TimerTask() {
      public void run() {
        String notifications = readDb.getIdToSendSms();
        String notificationReady = readDb.getIdOlderThan5hAndYounger6h(notifications);
        if (!notificationReady.isEmpty()) {
          List<List<String>> contentSms = readDb.contentToSendSMS(notificationReady);

          SmsSender senderSms = new SmsSender.Builder(730432932)
              .build();
          Integer numberPhone = senderSms.getNumber();
          for (List<String> contentSm : contentSms) {
            StringBuilder content = new StringBuilder();
            for (String s : contentSm) {
              content.append(s);
            }
            senderSms.sendSms(numberPhone, content.toString());
            System.out.println("wysyla smsa na numer " + numberPhone + " o tresci " + content.toString());
          }
          updateDB.updateNotification(notificationReady);
        }
      }

    };
    Timer timer = new Timer();
    long delay = 100L;
    timer.schedule(senderSms, 5000, 1000);
  }
}
