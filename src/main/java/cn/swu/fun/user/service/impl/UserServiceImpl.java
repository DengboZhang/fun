package cn.swu.fun.user.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.swu.fun.user.dao.UserDao;
import cn.swu.fun.user.entity.User;
import cn.swu.fun.user.service.UserService;
import cn.swu.fun.util.MailUtils;
import cn.swu.fun.util.UUIDUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDao userDao;
	@Autowired
	private EntityManager entityManager;
	
	//用户登录方法
	@Override
	public User login(String username, String password) {
		User user = userDao.findUserByUsernameAndPassword(username, password);
		entityManager.clear();// EJB的东西。。。。使对象变成游离状态，不再自动更新
		if (user != null)
			user.setPassword("");
		
		return user;
	}
   
	//异步校验用户名是否存在
	@Override
	public String checkUserExist(String username) {
		String checkResult = "-1";
		User user = userDao.findUserByUsername(username);
		if(user != null){//说明数据库里存在这个用户名
			checkResult="1";
		    return checkResult;
		}else{
			checkResult="0";
		   return checkResult;
		}
		
	}
   
	//保存注册用户
	@Override
	public void register(User user) {
		 //保存用户
		 userDao.save(user);		
	}
    
	//生成邮箱验证码
	@Override
	public String getEmailCode(String email) {
		 //生成验证码
	    int code=UUIDUtils.getUUID();
	    
	    try{
            MailUtils.sendMail(email, code);
        	System.out.println("验证码邮件发送成功！");
        } catch (Exception e) {
		   System.out.println("邮件发送失败！管理员请及时处理！");
		}			

		return Integer.toString(code);
	}



	
 
}
