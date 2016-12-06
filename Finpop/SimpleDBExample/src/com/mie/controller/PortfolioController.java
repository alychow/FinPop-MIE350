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
import com.mie.model.Portfolio;

public class PortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_PORTFOLIO = "/listPortfolio.jsp";
	private Query dao;

	public PortfolioController() {
		super();
		dao = new Query();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("listPortfolio")){
		//if action parameter is listPortfolio forward user to /listPortfolio.jsp
				String userId = (request.getParameter("userId"));
				forward = LIST_PORTFOLIO;
				request.setAttribute("portfolio", dao.selectUserPortfolio(userId));
			
		}else if(action.equalsIgnoreCase("deleteCompany")){
		//else if action parameter is deleteCompany delete the tuple that corresponds to compName and userID from the portfolio table
			//refresh the /listPortfolio.jsp page	
				String userId = request.getParameter("userId");
				String compName = request.getParameter("compName");
				dao.deleteCompFromPortfolio(compName,userId);
				forward = LIST_PORTFOLIO;
				request.setAttribute("portfolio", dao.selectUserPortfolio(userId));
		
		}else if(action.equalsIgnoreCase("updateCompany")){
		//else if action is equal to updateCompany update the tuple's number of shares corresponding to compName and userid
			//refresh the /listPortfolio.jsp page
				String userId = request.getParameter("userid");
				String compName = request.getParameter("compName");
				String value = request.getParameter("number");
				//convert the value string to an Integer
					//JS is used to check if the value is an Integer
				dao.updateCompFromPortfolio(compName,Integer.parseInt(value),userId);
				forward = LIST_PORTFOLIO;
				request.setAttribute("portfolio", dao.selectUserPortfolio(userId));
				
		}
		

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	//doPost inserts a company and the number of shares into the portfolio table with the userid
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		String userID = request.getParameter("userid");
		String info = request.getParameter("addinfo");
		Query dao = new Query();
		String[] i = info.split("-");
		Portfolio port = new Portfolio();
			port.setUsername(userID);
			port.setCompName(i[0]);
			port.setTicker(i[1]);
			port.setNumShares(Integer.parseInt(i[2]));
		if(dao.insertPortfolio(port)){
			out.printf("Company: %s | Ticker: %s | Number of Shares: %d | \n added to User: %s",port.getCompName(),port.getTicker(),port.getNumShares(),port.getUsername());
		}else{
			//error message if the company & number of shares cannot be added
			out.printf("There was an issue adding the company to the portfolio.\nPlease try again \nCompany: %s | Ticker: %s | Number of Shares: %d | \n added to User: %s",port.getCompName(),port.getTicker(),port.getNumShares(),port.getUsername());
		}
		
		
	}
}
