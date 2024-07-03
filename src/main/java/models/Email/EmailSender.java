package models.Email;



import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
  String user;
  String password;
  String host;
  String port;

  public EmailSender(String user, String password)
  {
    this.user = user;
    this.password = password;
    this.host = "poczta.o2.pl";
    this.port = "465";
  }
  public void sendEmail(String to, String subject, String body) {
    // Konfiguracja właściwości serwera SMTP
    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", port);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.user", user);
    properties.put("mail.password", password);
    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    Session session = Session.getInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password);
      }
    });
    try {
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(user));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
      message.setSubject(subject);
      message.setText(body);
      Transport.send(message);
      System.out.println("E-mail został wysłany pomyślnie.");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

}
