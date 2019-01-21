package com.pkg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		JDBCTemplateDAO jdbcTemplateDao = applicationContext.getBean(JDBCTemplateDAO.class);
		jdbcTemplateDao.display();
	}

}
