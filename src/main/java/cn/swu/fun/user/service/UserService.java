package cn.swu.fun.user.service;

import cn.swu.fun.user.entity.User;

public interface UserService {
    

   
	/*
	 * service 层给用户登录的业务
	 */
	public User login(String username, String password);
     
	/*
	 * service 层 异步校验 用户名是否存在的功能
	 */
	public String checkUserExist(String username);
    
	/*
	 * service层注册用户
	 */
	public void register(User user);
    
	/*
	 * service 层获取邮箱验证码
	 */
	public String getEmailCode(String email);
	
	

}
