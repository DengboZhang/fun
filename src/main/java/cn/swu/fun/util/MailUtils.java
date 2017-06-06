package cn.swu.fun.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


/**
 * 发送邮件的工具类
 * @author 张登博
 *
 */
public class MailUtils {
  public static void sendMail(String to,int code) throws Exception, MessagingException{
	 
	  Properties props=new Properties();
	  //左边填写的邮件协议
	  props.setProperty("mail.smtp","localhost");//右边填写发送邮件 的服务器的主机名称
	  //1 Session对象的获取，连接（与邮箱服务器连接）
	  Session session=Session.getDefaultInstance(props,new Authenticator() {
	    
		@Override  
		protected  PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("service@fun.com","123456");
			
		}
	  
	  });
	  
	  //2 构建邮件信息
	  
	  Message message=new MimeMessage(session);
	  //发件人
	  message.setFrom(new InternetAddress("service@fun.com"));
	  //收件人
	  message.setRecipient(RecipientType.TO, new InternetAddress(to));
	/*  //设置标题
	  message.setSubject("来自'乐易取'官网的激活邮件");
	  //设置正文
	  message.setContent("<h1>来自'乐易取'官网的激活邮件</h1><h3><a href='http://10.78.43.148:8080/j2eeproject/user_active.html?code="+code+"'>http://www.swulyq.cn/j2eeproject/user_active.html?code="+code+"</a></h3>", "text/html;charset=UTF-8");*/
	  //设置标题
	  message.setSubject("来自'友乐取'官网的验证码邮件,请您查收！");
	  //设置正文
	  message.setContent("<h1>您本次服务的验证码为： </h1><h3>"+code+"  ！ 验证码将在五分钟后失效！请尽快使用！ </h3>", "text/html;charset=UTF-8");
	  
	  
	  //设置验证码session对象
	 
	  
	  
	// 3.发送对象
	  
	  Transport.send(message);
	  
	 
	  
	  
	  
  }
	
}
