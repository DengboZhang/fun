package cn.swu.fun.system.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.swu.fun.user.entity.User;
import cn.swu.fun.user.service.UserService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

	
     @Autowired
     private UserService userService;
	

	@RequestMapping(value = "/login")
	public String login(HttpSession session, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		if (username != null && password != null) {
			User stu = userService.login(username, password);
			
			if (stu != null) {
				session.setAttribute("user", stu);
				return "redirect:/";
			}
		}
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		// 清除session
		@SuppressWarnings("unchecked")
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
	
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		return "redirect:/login";
	}

	@ResponseBody
	@RequestMapping(value = "/getSessionUser")
	public User getSessionUser(HttpSession session) {

		User user = (User) session.getAttribute("user");
		System.out.println("getSessionUser()--->session_userinfo="+user.toString());
		return user;
	}
	
	

}
