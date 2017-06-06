package cn.swu.fun.userInfo.controller;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.swu.fun.userInfo.entity.UserInfo;
import cn.swu.fun.userInfo.service.UserInfoService;

/**
 * 用户信息的控制器
 * @author zdb
 * 2017年3月29日16:37:19
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {
    
	 @Autowired
	 private UserInfoService userInfoService;
	 
	 @ResponseBody
	 @RequestMapping(value="saveOrUpdateUserInfo")
	 public String saveOrUpdateUserInfo(UserInfo userInfo){
		 if((userInfo.getId()==null)||(userInfo.getId().equals(""))){//说明是新的
		     userInfoService.saveOrUpdateUserInfo(userInfo);//保存新的用户资料
		 }
		return null;
	 }
	 
	 
	 
}
