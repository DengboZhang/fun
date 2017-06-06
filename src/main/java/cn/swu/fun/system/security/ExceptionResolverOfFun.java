package cn.swu.fun.system.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * 系统的统一异常处理器
 * 2017年4月25日19:20:28
 */
public class ExceptionResolverOfFun implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		ex.printStackTrace();
		System.out.println("in class");
		
		try {
			System.out.println("in method");
			response.sendRedirect(request.getContextPath() + "/error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}
         
	
} 
