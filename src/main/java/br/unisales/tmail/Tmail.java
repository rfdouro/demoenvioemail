package br.unisales.tmail;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class Tmail {

 private static Properties props;
 private static String emailDe = "EMAIL@DOMINIO";
 private static String senha = "SENHA";
 private static String emailPara = "OUTROEMAIL@OUTRODOMINIO";
 private static String assunto = "ASSUNTO DO EMAIL";
 private static String corpo = "CORPO DA MENSAGEM";

 private static Session sessionEmail() {
  props = new Properties();
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", "587");
  props.put("mail.smtp.host", "smtp.office365.com");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  Session session = Session.getInstance(props, new Authenticator() {
   @Override
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(Tmail.emailDe,
      Tmail.senha);
   }
  });
  return session;
 }

 public static void main(String... args) {
  if (args.length >= 5) {
   Tmail.emailDe = args[0];
   Tmail.senha = args[1];
   Tmail.emailPara = args[2];
   Tmail.assunto = args[3];
   Tmail.corpo = args[4];
   try {
    Session session = sessionEmail();
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(Tmail.emailDe));
    message.setRecipients(Message.RecipientType.TO,
      InternetAddress.parse(Tmail.emailPara));
    message.setSubject(Tmail.assunto);
    message.setText(Tmail.corpo);
    Transport.send(message);
    System.out.println("E-mail enviado");
   } catch (Exception ex) {
    System.err.println("ERRO " + ex.getMessage());
   }
  }
 }
}
