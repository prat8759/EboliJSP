package expt;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 //WORKING for gmail
//http://qna.rediff.com/questions-and-answers/what-is-rediffmail-smtp-port-no/11333473/answers
public class SendMailTLS {
 
	public static void main(String[] args) {
 
		final String username = "prat8759@yahoo.co.in";//prat8759@gmail.com prat8789@rediffmail.com
		final String password = "stupid8759";
		
		final String FROM="prat8759@yahoo.co.in";//"prat8759@gmail.com";
		final String TO="prat8789@rediffmail.com";
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mail.yahoo.com");//gmail  smtp.gmail.com
		props.put("mail.smtp.port", "587");//587 for gmail
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		/*
		 * to send via SSL
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		 */
		
		
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));//prat8759@gmail.com
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(TO));//nayan1952
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

/*
Properties props = new Properties();
props.put("mail.smtp.host", "smtp.rediffmail.com");
props.put("mail.smtp.socketFactory.port", "25");
//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.port", "25");

Session sess= Session.getDefaultInstance(props, new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication("username","password"); //valid unm-pwd
}
}); 
*/