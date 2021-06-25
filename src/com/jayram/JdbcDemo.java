package com.jayram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jayram.dao.JdbcDaoImpl;
import com.jayram.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		System.out.println(dao.getCircleForId(1).getName());
		dao.insert(new Circle(3, "Third Circle"));
		System.out.println(dao.getAllCircles().size());
		dao.createTriangleTable();
	}

}
