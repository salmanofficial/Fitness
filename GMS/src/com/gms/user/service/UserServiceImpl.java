package com.gms.user.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.user.beans.UserBean;
import com.gms.user.dao.UserDao;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean createOrUpdateUser(UserBean userBean) throws Exception {
		return userDao.createOrUpdateUser(userBean);
	}

	@Override
	public Set<UserBean> getAllUsers() throws Exception {
		return userDao.getAllUsers();
	}

	@Override
	public UserBean validateUser(UserBean userBean) throws Exception {
		return userDao.validateUser(userBean);
	}

	@Override
	public Set<String> getAllExistingLoginId() throws Exception {
		return userDao.getAllExistingLoginId();
	}

	@Override
	public Boolean checkForLoginId(String loginId) throws Exception {
		return userDao.checkForLoginId(loginId);
	}

}
