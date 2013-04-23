package com.sample.tester;

import com.sample.dao.UserDao;
import com.sample.entities.UserDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
    public static void main(String[] args) {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
	UserDao userDao = (UserDao) applicationContext.getBean("userDao");

	UserDetail userDetail = new UserDetail();
	userDetail.setUserId(1);
	userDetail.setUserName("Freddy");
	userDao.createUser(userDetail);
	System.out.println("User is successfully created");
	System.out.println("User names is: " + userDao.getAllUserNames());
    }
}
