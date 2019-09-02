package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;

public class CategoryDAOTest extends BaseDAOTest{
	
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDAO=new CategoryDAO(entityManager);
	}

	@Test
	public void testCreateCategory() {
		Category newCat=new Category("Java");
		Category category=categoryDAO.create(newCat);
		assertTrue( category!=null && category.getCategoryId() >0);
	}

	@Test
	public void testUpdateCategory() {
		Category cate=new Category("Java Core");
		cate.setCategoryId(1);
		Category category=categoryDAO.update(cate);
		
		assertEquals(cate.getName(),category.getName());
	}

	@Test
	public void testGet() {
		Integer cateId=2;
		Category cate=categoryDAO.get(cateId);
		assertNotNull(cate);
	}

	@Test
	public void testDeleteObject() {
		Integer cateId=3;
		categoryDAO.delete(cateId);
		
		Category cate=categoryDAO.get(cateId);
		assertNull(cate);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDAO.listAll();
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		long totalCategories=categoryDAO.count();
		assertEquals(totalCategories, 2);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}
}
