package com.ty.foodie_application_jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.foodie_application_jsp.dao.ItemsDao;
import com.ty.foodie_application_jsp.dao.MenuDao;
import com.ty.foodie_application_jsp.dto.Items;
import com.ty.foodie_application_jsp.dto.Menu;

@WebServlet("/updateitem")
public class UpdateItemController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		ItemsDao itemsDao=new ItemsDao();
		Items items=itemsDao.getItemsById(id);
		
		if(items!=null) {
			HttpSession httpSession=req.getSession();
			String value=(String)httpSession.getAttribute("name");
			if(value!=null) {
				req.setAttribute("items", items);
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("edititems.jsp");
				requestDispatcher.forward(req, resp);
				
			}else {
				req.setAttribute("message", "Login first to update");
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			
		}
		
	}

}
