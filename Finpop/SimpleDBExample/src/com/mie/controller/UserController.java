package com.mie.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.Query;
import com.mie.model.*;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String SEARCH_FNAME_USER = "/searchFNUser.jsp";

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setPassword(password);
		user.setUsername(username);
		
		Query dao = new Query();
		String feedback = new String();
		feedback = dao.insertUser(user);
		request.setAttribute("feedback", feedback);
		out.write(feedback);
		out.close();
		RequestDispatcher view = request.getRequestDispatcher("/TEST.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}