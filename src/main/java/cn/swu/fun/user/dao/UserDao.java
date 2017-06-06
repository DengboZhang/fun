package cn.swu.fun.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.swu.fun.user.entity.User;

/**
 * 用户dao层操作
 * @author zdb
 *
 */
public interface UserDao extends JpaRepository<User,String>{

          //根据用户名和密码查询用户
          public User findUserByUsernameAndPassword(String username, String password);
          
          
          
          //根据用户名查询用户是否存在
		  public User findUserByUsername(String username);
     
	
}
