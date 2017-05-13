package cn.ssh.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	
	public static void sendMail(String to,String code){
		
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "111");
			}
			
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
		
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			
	
			message.setSubject("happy购~用户激活邮件");
		
			message.setContent("<h1>点击此链接激活用户</h1><h3><a href='http://localhost:8080/happy-shop/user_active.action?code="+code+"'>http://localhost:8080/happy-shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("aaa@shop.com","11111111111111");
	}
}
