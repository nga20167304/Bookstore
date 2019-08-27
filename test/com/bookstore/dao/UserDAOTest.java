package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setupClass() {
		entityManagerFactory=Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager=entityManagerFactory.createEntityManager();
		userDAO=new UserDAO(entityManager);
	}
	
	@Test
	public void testCreateUsers() {
		Users user1=new Users();
		user1.setEmail("Tommy@gmail.com");
		user1.setFullName("Tommy Timothy");
		user1.setPassword("1243567890");
		 
		user1=userDAO.create(user1);
		
		assertTrue(user1.getUserId()>0);
	}
	
	@Test(expected=PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1=new Users();
		
		user1=userDAO.create(user1);
		
	}
	
	@Test
	public void testUpdateUsers() {
		Users user=new Users();
		user.setUser_id(6);
		user.setEmail("nga.dt167304@gmail.com");
		user.setFullName("Do Thuy Nga");
		user.setPassword("999999999");
		
		user= userDAO.update(user);
		String expected ="999999999";
		String actual=user.getPassword();
		
		assertEquals(expected,actual);
		
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
