package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;

@WebServlet("/admin/")
public class AdminHomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public AdminHomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminpage="index.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(adminpage);
		dispatcher.forward(request, response);
	}

}
