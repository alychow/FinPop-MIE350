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
import com.mie.model.Hedgefund;
import com.mie.model.InvestsIn;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private static String SEARCH_COMPANY = "/result.jsp";
	private static String SEARCH_HEDGE = "/HedgeResult.jsp";

	
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

			String keyword = req.getParameter("keyword");
			Query dao = new Query();
			
			//if the keyword is a ticker or company return a company page
			if(dao.isCompany(keyword)||dao.isTicker(keyword)){
				Company resultCompany = dao.selectCompany(keyword);
				
				ArrayList<Hedgefund> hedgeList = dao.selectCompHedgeList(keyword);
				
				RequestDispatcher view = req.getRequestDispatcher(SEARCH_COMPANY);
				req.setAttribute("keyword", keyword);
				req.setAttribute("company", resultCompany);	
				req.setAttribute("hedgeList", hedgeList);
				view.forward(req, res);
			}
			//if the keyword is a hedgefund return a hedgefund page
			else if(dao.isHedgefund(keyword)){
				
				Hedgefund resultHedge = dao.selectHedgefund(keyword);
				
				ArrayList<InvestsIn> compList = dao.selectHedgeInvestIn(keyword);

				RequestDispatcher view = req.getRequestDispatcher(SEARCH_HEDGE);
				req.setAttribute("keyword", keyword);
				req.setAttribute("hedgefund", resultHedge);	
				req.setAttribute("compList", compList);
				view.forward(req, res);
			}
			else{
				req.setAttribute("keyword", keyword);
				RequestDispatcher view = req.getRequestDispatcher("/noResults.jsp");
				view.forward(req, res);

			}
			
			
	}
	
	protected void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
	}
}