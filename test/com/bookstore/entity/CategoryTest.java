package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {
	public static void main(String[] args) {
		Category category=new Category("Advanced Java");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(category);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

		System.out.println("A Category Object was persist ");

	}
}
