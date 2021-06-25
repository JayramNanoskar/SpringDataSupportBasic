package com.jayram;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.jayram.dao.HibernateDaoImpl;
import com.jayram.dao.JdbcDaoImpl;
import com.jayram.dao.JdbcDaoSupportImpl;
import com.jayram.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		System.out.println(dao.getCircleForId(1).getName());
		dao.insert(new Circle(3, "Third Circle"));
		System.out.println(dao.getAllCircles().size());
//		dao.createTriangleTable();
		JdbcDaoSupportImpl daObj = context.getBean("jdbcDaoSupportImpl", JdbcDaoSupportImpl.class);
		System.out.println(daObj.getCircleCount());
		HibernateDaoImpl daObject = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(daObject.getCircleCount());
	}

}
