package com.zensar.dao;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zensar.api.Book;

public class BookDAOImpl implements BookDAO{
	//private JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Book book) {
		String sql="INSERT INTO BOOK VALUES(?,?,?)";
		Object[] arg= {book.getBookNo(),book.getBookName(),book.getBookCost()};
		int noOfRowInserted=jdbcTemplate.update(sql,arg);
		System.out.println("No of row inserted"+noOfRowInserted);
	}
	/*
	 * public DataSource getDataSource() { String
	 * url="jdbc:mysql://localhost:3306/School?useSSL=false"; String
	 * username="root"; String password="root123";
	 * 
	 * DataSource dataSource = new DriverManagerDataSource(url,username,passward);
	 * return dataSource; }
	 */

}
