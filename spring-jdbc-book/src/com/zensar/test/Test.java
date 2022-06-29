package com.zensar.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.api.Book;
import com.zensar.dao.BookDAO;
import com.zensar.dao.BookDAOImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("applicationcontext loaded.....");
	BookDAOImpl bookDaoImpl=	context.getBean("BookDAOImpl",BookDAOImpl.class);
	
	
		Book book1=new Book();
		book1.setBookNo(01);
		book1.setBookName("mahabaratam");
		book1.setBookCost(3000);
		bookDaoImpl.insert(book1);
		
		
		//BookDAO bookDAO=new BookDAOImpl();
		//bookDAO.insert(book1);
		
	}

}
