package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SmsSender {

  private int number;
  private SmsSender(int number)
  {
    this.number = number;
  }

  public static class Builder{
    private int number;
    public Builder(int number){
      this.number = number;
    }
    public SmsSender build(){
      return new SmsSender(number);
    }
  }

  public int getNumber() {
    return number;
  }
  public Boolean sendSms(Integer phoneNumber, String message){
    Boolean result = true;

    var secretP = "0d717e5235479761180b7dc93af12461";

    var authorizationToken = "Bearer SXRuosMqGeQBvjWLKbI4vbRenxbZLsH3WNAIZsOu";
    String requestBody = "from=Test&to="+"48730432932"+"&message=" + message+"&format=json";
    String tokenUrl = "https://api.smsapi.pl/sms.do";
    try {
      URL url = new URL(tokenUrl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Authorization", authorizationToken);
      connection.setDoOutput(true);
      try (OutputStream os = connection.getOutputStream()) {
        byte[] input = requestBody.getBytes("utf-8");
        os.write(input, 0, input.length);
      }
      int responseCode = connection.getResponseCode();
      System.out.println("Response Code: " + responseCode);
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String inputLine;
      StringBuffer responseBody = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        responseBody.append(inputLine);
      }
      in.close();

    } catch (IOException e) {
      e.printStackTrace();
      ;
      result = false;
    }

    return result;
  }
}
