package com.vk.Helper;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Helper {
	public static void sendMail(String subject, String message , String to) {

		String from = "sirteavinash@gmail.com";

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("sirteavinash@gmail.com", "hfiwaklaqgizgfqk");
			}
		});

		session.setDebug(true);

		try {

			MimeMessage mailmessage = new MimeMessage(session);

			InternetAddress ia = new InternetAddress(from);
			InternetAddress ia1 = new InternetAddress(to);

			mailmessage.setFrom(ia);

			mailmessage.addRecipient(Message.RecipientType.TO, ia1);

			mailmessage.setSubject(subject);

			mailmessage.setContent(message, "text/html");

			Transport.send(mailmessage);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}