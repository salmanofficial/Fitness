package com.gms.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gms.user.beans.UserBean;
import com.gms.user.dao.UserDao;
import com.gms.user.dao.UserDaoImpl;

public class TestMain {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDao userDao = new UserDaoImpl();
		
		UserBean u = new UserBean();
		
		u.setFirstName("salman");
		u.setLoginId("salman");
		u.setLoginPassword("Test");
		
		//userDao.createOrUpdateUser(u);
		
		
		

		
		

	}

}
