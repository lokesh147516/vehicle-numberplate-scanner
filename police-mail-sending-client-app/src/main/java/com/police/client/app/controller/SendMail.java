package com.police.client.app.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.police.client.app.model.MailSendingDTO;

public class SendMail {

	public static void sendMail(String recepient, MailSendingDTO mailSendingDTO) throws Exception {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		String myAccountEmail = "lokeshcg516@gmail.com";
		String pass = "oct@2020a";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myAccountEmail, pass);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient, mailSendingDTO);
		
		Transport.send(message);
		System.out.println("Sent Sucessfully");
	}

	private static Message prepareMessage(Session session, String from, String recepient, MailSendingDTO mailSendingDTO) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Vehicle Number: "+mailSendingDTO.getNumberPlate());
			message.setContent("<head>\r\n" + 
					"<style>\r\n" + 
					"table {\r\n" + 
					"  font-family: arial, sans-serif;\r\n" + 
					"  border-collapse: collapse;\r\n" + 
					"  width: 100%;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"td, th {\r\n" + 
					"  border: 1px solid #dddddd;\r\n" + 
					"  text-align: left;\r\n" + 
					"  padding: 8px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"tr:nth-child(even) {\r\n" + 
					"  background-color: #dddddd;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<h2>Violated Vehicle Details</h2>\r\n" + 
					"\r\n" + 
					"<table>\r\n" + 
					"  <tr>\r\n" + 
					"    <th>Vehicle Details</th>\r\n" + 
					"    <th>Vehicle Data</th>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Number Plate</td>\r\n" + 
					"    <td>"+mailSendingDTO.getNumberPlate()+"</td>\r\n" + 
					
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Vehicle Name</td>\r\n" + 
					"    <td>"+mailSendingDTO.getVehicleName()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Vehicle Manufacturer</td>\r\n" + 
					"    <td>"+mailSendingDTO.getVehicleManufacturer()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Vehicle Color</td>\r\n" + 
					"    <td>"+mailSendingDTO.getVehicleOrgnlColor()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Owner Name</td>\r\n" + 
					"    <td>"+mailSendingDTO.getOwnerName()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Violated Date</td>\r\n" + 
					"    <td>"+mailSendingDTO.getViolatedDate()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>ViolationName</td>\r\n" + 
					"    <td>"+mailSendingDTO.getViolationName()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					"  <tr>\r\n" + 
					"    <td>Total Fine Amount</td>\r\n" + 
					"    <td>"+mailSendingDTO.getFineAmt()+"</td>\r\n" + 
					"  </tr>\r\n" + 
					
					"</table>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"", "text/html");
			return message;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	}

