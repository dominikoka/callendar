package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
  private String name, startDate, endDate, location, msgTitle, msgDesc, emails;
  private Integer id;
  private Integer type;

  private Event(Integer id,String name, String startDate, String endDate, String location, String msgTitle, String msgDesc,
               String emails,Integer type) {
    this.id = id;
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
    this.location = location;
    this.msgTitle = msgTitle;
    this.msgDesc = msgDesc;
    this.emails = emails;
    this.type = type;
  }

  public String getStartDay() {
    return startDate.substring(8, 10);
  }

  public String getEndDay() {
    return endDate.substring(8, 10);
  }

//  public void setID(int id) {
//    this.id = id;
//  }

  public Integer getID() {
    return id;
  }

//  public void setType(int type) {
//    this.type = type;
//  }

  public Integer getType() {
    return type;
  }

  public String getStartTime() {
    return startDate.substring(11, 16);
  }

  public String getYear() {
    return startDate.substring(0, 4);
  }

  public String getMonth() {
    return startDate.substring(5, 7);
  }

  public String getEndTime() {
    return endDate.substring(11, 16);
  }

  public String getName() {
    return name;
  }

//  public void setName(String name) {
//    this.name = name;
//  }

  public String getStartDate() {
    return startDate;
  }

//  public void setStartDate(String startDate) {
//    this.startDate = startDate;
//  }

  public String getEndDate() {
    return endDate;
  }

//  public void setEndDate(String endDate) {
//    this.endDate = endDate;
//  }

  public String getLocation() {
    return location;
  }

//  public void setLocation(String location) {
//    this.location = location;
//  }

  public String getMsgTitle() {
    return msgTitle;
  }

//  public void setMsgTitle(String msgTitle) {
//    this.msgTitle = msgTitle;
//  }

  public String getMsgDesc() {
    return msgDesc;
  }

//  public void setMsgDesc(String msgDesc) {
//    this.msgDesc = msgDesc;
//  }

  public static class Builder
  {
    private Integer id;
    private Integer type;
    private String namee;
    private String startDate;
    private String end;
    private String location;
    private String msgTitle;
    private String msgDesc;
    private String emails;

    public Builder(String name, String startDate, String endDate, String msgDesc) {
      this.namee = name;
      this.startDate = startDate;
      this.end = endDate;
      this.msgDesc = msgDesc;
    }
    public Builder location(String location) {
      this.location = location;
      return this;
    }
    public Builder msgTitle(String msgTitle) {
      this.msgTitle = msgTitle;
      return this;
    }
    public Builder emails(String emails) {
      this.emails = emails;
      return this;
    }
    public Builder id(Integer id) {
      this.id = id;
      return this;
    }
    public Builder type(Integer type) {
      this.type = type;
      return this;
    }
    public Event build() {
      return new Event(id,namee, startDate, end, location, msgTitle, msgDesc, emails,type);
    }

  }
  public List<String> getEmailsList() {
    String allEmails = emails;
    List<String> items = Arrays.asList(allEmails.split(" ")), result = new ArrayList<String>();
    for (int i = 0; i < items.size(); i++) if (i % 2 == 0) result.add(items.get(i));
    return result;
  }
  public String getEmails()
  {
    return emails;
  }

  public List<Boolean> getConfirmationEmail() {
    String allEmails = emails;
    List<String> items = Arrays.asList(allEmails.split(" "));
    List<Boolean> result = new ArrayList<Boolean>();
    for (int i = 0; i < items.size(); i++)
      if (!(i % 2 == 0)) if (items.get(i).equals("false")) result.add(Boolean.FALSE);
      else result.add(Boolean.TRUE);
    return result;
  }

  public void setEmails(String emails) {
    this.emails = emails;
  }
}
