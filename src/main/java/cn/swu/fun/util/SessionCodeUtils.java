package cn.swu.fun.util;

import javax.servlet.http.HttpSession;



/**
 * 将生成的验证码存入session
 * 并且设置销毁时间
 * @author 张登博
 *
 */
public class SessionCodeUtils {
   
	public static void makeSessionCode(int code,HttpSession session){
		
		session.setAttribute("checkcode",code);
		session.setMaxInactiveInterval(300);//设置验证码失效时间，5分钟
	}	
	
}
