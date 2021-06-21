package com.jayram;

import com.jayram.dao.JdbcDaoImpl;
import com.jayram.model.Circle;

public class JdbcDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
