package com.rule.violation.zuul.server.controller;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void sendMail(String recepient) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "lokeshcg516@gmail.com";
		String pass = "";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myAccountEmail, pass);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient);
		
		Transport.send(message);
		System.out.println("Sent Sucessfully");
	}

	private static Message prepareMessage(Session session, String from, String recepient) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Demo");
			message.setText("First Mail");
			return message;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	}
