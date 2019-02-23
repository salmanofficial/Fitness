package com.gms.user.dao;

import java.util.Set;

import com.gms.user.beans.UserBean;

public interface UserDao {
	public boolean createOrUpdateUser(UserBean userBean) throws Exception;
	public Set<UserBean> getAllUsers();
	public UserBean validateUser(UserBean userBean);
	public Set<String> getAllExistingLoginId();
	public Boolean checkForLoginId(String loginId);
	public Integer getUserByLoginId(String loginId);
	public String getUserFullNameByUserSrNo(Integer userSrNO);
}
