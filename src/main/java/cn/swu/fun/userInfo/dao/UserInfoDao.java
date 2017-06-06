package cn.swu.fun.userInfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.swu.fun.userInfo.entity.UserInfo;

public  interface  UserInfoDao extends JpaRepository<UserInfo,String> {
        
	    
}
