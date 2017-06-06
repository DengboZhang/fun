package cn.swu.fun.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制主页的页面链接跳转
 * @author zdb
 *
 */
@Controller
public class IndexController {
      
	
	/*
	 * 前台 进入主页页面
	 */
	@RequestMapping(value = "/index")
	private String index(){
		return "index";
	}
	
	
	/*
	 * 前台 进入登录页面
	 */
	@RequestMapping(value = "/loginPage")
	private String loginPage(){
		return "login";
	}
	
	/*
	 * 前台 出错处理页面
	 */
	@RequestMapping(value = "/error")
	private String error(){
		return "error";
	}
	
	/*
	 * 前台 进入注册页面
	 */
	@RequestMapping(value = "/registePage")
	private String registePage(){
		return "registe";
	}
}
