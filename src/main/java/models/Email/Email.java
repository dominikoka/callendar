package models.Email;

import java.util.List;

public class Email {


  public String prepareEmails(List<String> emails) {
    String result="";
    for (String email : emails) {
      result=result+email+" false"+" ";
    }
    return result;
  }
}
