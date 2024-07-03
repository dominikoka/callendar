package resources.models;
//import main.java.helloClasses.Helloe;


//import jdk.internal.event.Event;
import models.DB.ReadDB;
//import models.ScheduledSmsSender;
import models.DB.Update;
import org.junit.Test;

    import java.util.List;


public class ScheduledSmsSenderTest {

  @Test
  public void getIdToSendSmsShouldGiveIdWithAllEventWithNotification()
  {
    ReadDB db = new ReadDB("root","root");
    String idInDbToSendSms = db.getIdToSendSms();
    System.out.println("aaa");
  }
  @Test
  public void getIdOlderThan5hAndYounger6hShouldGiveIdToSendNotification()
  {
    ReadDB db = new ReadDB("root","root");
    String allIdInDbToSendSms = db.getIdToSendSms();

    String idToSend = db.getIdOlderThan5hAndYounger6h(allIdInDbToSendSms);
    System.out.println("aaa");
  }
  @Test
  public void getSMSContentFromId()
  {
    ReadDB db = new ReadDB("root","root");
    String allIdInDbToSendSms = db.getIdToSendSms();

    String idToSend = db.getIdOlderThan5hAndYounger6h(allIdInDbToSendSms);

    List<List<String>> contentToSend = db.contentToSendSMS(idToSend);

    Update update = new Update("root","root");
    update.updateNotification(idToSend);
    System.out.println("aa");
  }
}
