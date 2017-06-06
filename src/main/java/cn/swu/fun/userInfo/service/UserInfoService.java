package cn.swu.fun.userInfo.service;

import cn.swu.fun.userInfo.entity.UserInfo;
/*
 * 用户信息service层
 */
public interface UserInfoService {
 
 /*
  * 保存用户信息
  */
 public	void saveOrUpdateUserInfo(UserInfo userInfo);

}
