package com.gms.user.service;

import java.util.Set;

import com.gms.user.beans.UserBean;

public interface UserService {

	public boolean createOrUpdateUser(UserBean userBean) throws Exception;
	public Set<UserBean> getAllUsers() throws Exception;
	public UserBean validateUser(UserBean userBean) throws Exception;
	public Set<String> getAllExistingLoginId() throws Exception;
	public Boolean checkForLoginId(String loginId) throws Exception;
}
