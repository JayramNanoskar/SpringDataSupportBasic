package com.jayram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.jayram.model.Circle;

@Component
public class JdbcDaoImpl {
		
		private DataSource dataSource;

		JdbcTemplate jdbcTemplate;

		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		public DataSource getDataSource() {
			return dataSource;
		}

		@Autowired
		public void setDataSource(DataSource dataSource) { //During initialization itself setting DataSource in JdbcTemplate because many DAO methods may need it.
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
	public Circle getCircle(int circleId){
		Connection conn = null;
		try{
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from Circle where id = ?");
		ps.setInt(1, circleId);
		Circle circle = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			circle = new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int getCircleCount(){
		String sql = "select count(*) from Circle";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
