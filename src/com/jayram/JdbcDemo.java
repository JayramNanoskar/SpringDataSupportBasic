package com.jayram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jayram.dao.JdbcDaoImpl;
import com.jayram.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
		System.out.println(dao.getCircleForId(1).getName());
		System.out.println(dao.getAllCircles().size());
	}

}
