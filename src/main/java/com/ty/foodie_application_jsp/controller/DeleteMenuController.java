package com.ty.foodie_application_jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodie_application_jsp.dao.MenuDao;
import com.ty.foodie_application_jsp.dto.Menu;

@WebServlet("/delete")
public class DeleteMenuController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		MenuDao menuDao=new MenuDao();
		boolean result= menuDao.deleteMenu(id);
		if(result) {

			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displaymenu.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		
	}

}
