package com.jayram.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoSupportImpl extends JdbcDaoSupport{

	public int getCircleCount(){
		String sql = "select count(*) from Circle";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}
