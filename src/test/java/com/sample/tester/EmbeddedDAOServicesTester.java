package com.sample.tester;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.dao.EmbeddedDao;
import com.sample.dao.EmbeddedDaoImpl;
import com.sample.dao.UserDao;
import com.sample.dao.UserDaoImpl;
import com.sample.entities.Environment;
import com.sample.entities.UserDetail;
import com.sample.services.EmbeddedDBServices;


public class EmbeddedDAOServicesTester extends TestCase {
    UserDao userDao;
    EmbeddedDao embeddedDao;
    
    private static final Logger logger = Logger.getLogger(EmbeddedDAOServicesTester.class);
        
    protected void setUp() throws Exception {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "applicationContext.xml");
    //setup the log
    Appender appender = new ConsoleAppender(new PatternLayout("%d{HH:mm:ss,SSS} \u2013 %m%n"));
    BasicConfigurator.configure(appender);
    logger.getRootLogger().setLevel(Level.ERROR);
    logger.setLevel(Level.DEBUG);
    
    userDao  = applicationContext.getAutowireCapableBeanFactory()
            .createBean(UserDaoImpl.class);
    embeddedDao  = applicationContext.getAutowireCapableBeanFactory()
            .createBean(EmbeddedDaoImpl.class);
    //userDao = (UserDao) applicationContext.getBean("userDao");
    //embeddedDao = (EmbeddedDao) applicationContext.getBean("embeddedDao");
    //embeddedDBServices = (EmbeddedDBServices)applicationContext.getBean("embeddedDBServices");
    }

    public void test_save() {
        UserDetail userDetail = new UserDetail();
    userDetail.setUserName("Freddy"+new Date());
    userDao.createUser(userDetail);
    logger.info("User names is: " + userDao.getAllUserNames()); 
    }
    
    public void test_saveEnvironment(){
        Environment environment = new Environment();
        environment.setEnvId(System.currentTimeMillis());
        environment.setEnvName("EnvOne");
        environment.setEnvDesc("DescForNewEnvironment\t"+new Date());
        environment.setEnvActive(true);
        
    //    embeddedDBServices.saveEnvironment(environment);
        embeddedDao.saveEnvironment(environment);
        List<Environment> envs = embeddedDao.getAllEnvironments();
        for (Environment environment2 : envs) {
            logger.info(environment2);
	}
        
    }
}
