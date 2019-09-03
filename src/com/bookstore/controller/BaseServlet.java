package com.bookstore.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/")
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected EntityManagerFactory entityManagerFatory;
	protected EntityManager entityManager;

	@Override
	public void init() throws ServletException{
		entityManagerFatory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFatory.createEntityManager();
	}
	
	@Override
	public void destroy() {
		entityManager.close();
		entityManagerFatory.close();
	}
	
}
