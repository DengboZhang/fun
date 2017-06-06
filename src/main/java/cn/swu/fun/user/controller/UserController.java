package cn.swu.fun.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.swu.fun.user.entity.User;
import cn.swu.fun.user.service.UserService;

/**
 * order的controller
 * @author zdb
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
       
	@Autowired
	private UserService userService; 
	
	
	/*
	 * 前台用户登录
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,HttpSession session){
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    if (username != null && password != null) {//空值判断
			User user = userService.login(username, password);
			if (user != null) {
				session.setAttribute("user",user);
				return "redirect:/index";
			}
		}
		return "login";
	}
	
	/*
	 * 前台异步校验用户名是否存在
	 * 1 真 存这样的用户名
	 * 0假  不存在这样的用户名
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/checkUserExist")
	public String checkUserExist(String username,HttpSession session){
	    String checkResult = userService.checkUserExist(username);
		return checkResult;
	}
	
	
	/*
	 * 向前台发送验证码
	 */
	@ResponseBody
	@RequestMapping(value = "/getEmailCode")
	public String getEmailCode(String email){
		email="aaa@fun.com";
		String code=userService.getEmailCode(email);
		
		if(code!=null){
		   return code;
		}else{
			code="null_string";
		   return code;
		}
	}
	
	
	/*
	 * 前台用户注册
	 */
	@RequestMapping(value = "/registe")
	public String register(User user,HttpServletRequest request,HttpSession session){
		   if (user.getUsername()!= null && user.getPassword() != null && user.getEmail() != null && user.getPhone() != null) {//空值判断
				userService.register(user);
				return "login";
			}else{
				  System.out.println("前台注册时有用户提交空值到后台！");
			      return "registe";
			}
			     
		 
	}
	
	
	
	   
}
