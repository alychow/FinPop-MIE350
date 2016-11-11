package com.mie.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.Query;
import com.mie.model.Company;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String SEARCH_COMPANY = "/result.jsp";
	
	public SearchController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
PrintWriter out = res.getWriter();
		
		String word = req.getParameter("keyword");
		
		Query dao = new Query();
		
		ArrayList<String> searchResults = dao.selectSuggestedResults(word);
		
		int i = 0;
		for( ; i < searchResults.size()-1; i++){
			out.write(searchResults.get(i)+ "|");
		}
		out.write(searchResults.get(i));
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			//User user = new User();
			//user.setFirstName(request.getParameter("firstName"));
			//user.setLastName(request.getParameter("lastName"));
			
			String keyword = req.getParameter("keyword");
			Query dao = new Query();
			
			Company resultCompany = dao.selectCompany(keyword);
			
			RequestDispatcher view = req.getRequestDispatcher(SEARCH_COMPANY);
			req.setAttribute("keyword", keyword);
			req.setAttribute("company", resultCompany);			
			view.forward(req, res);
	}
	
	protected void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	}
}