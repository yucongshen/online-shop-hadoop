package cn.ssh.shop.test;

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
	
	public static void sendMail(String to,String kafkaMessage){
		
		Properties props = new Properties();
		//props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
	    props.setProperty("mail.smtp.host", "smtp.163.com");   // 发件人的邮箱的 SMTP 服务器地址
	    props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("shen_yucong@163.com", "shen786436542");
			}
			
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("shen_yucong@163.com"));
		
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			
	
			message.setSubject("online-shopping 交易成功！");
			
			message.setContent(kafkaMessage, "text/html;charset=UTF-8");
		
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("490603883@qq.com","congcong");
	}
}
