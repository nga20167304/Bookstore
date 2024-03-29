package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest extends BaseDAOTest{
	private static UserDAO userDAO;

	@BeforeClass
	public static void setupClass() {
		BaseDAOTest.setUpBeforeClass();
		userDAO = new UserDAO(entityManager);
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("Tommy@gmail.com");
		user1.setFullName("Tommy Timothy");
		user1.setPassword("1243567890");

		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);

	}

	@Test
	public void testUpdateUsers() {
		Users user = new Users();
		user.setUser_id(6);
		user.setEmail("nga.dt167304@gmail.com");
		user.setFullName("Do Thuy Nga");
		user.setPassword("999999999");

		user = userDAO.update(user);
		String expected = "999999999";
		String actual = user.getPassword();

		assertEquals(expected, actual);

	}
	
	@Test
	public void testGetUsersFound() {
		Integer userId=6;
		Users user = userDAO.get(userId);
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId=2;
		Users user = userDAO.get(userId);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId=10;
		userDAO.delete(userId);
		
		Users user=userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId=99;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers=userDAO.listAll();
		for(Users user : listUsers) {
			System.out.println(user.getEmail()); 
		}
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testCount() {
		long totalUsers=userDAO.count();
		assertEquals(totalUsers,11);
	}
	
	@Test
	public void testFindByEmail() {
		String email="nga.dt167304@gmail.com";
		Users user=userDAO.findByEmail(email);
		assertNotNull(user);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
}
