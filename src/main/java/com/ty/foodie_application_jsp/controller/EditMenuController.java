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

@WebServlet("/edit")
public class EditMenuController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		double price=Double.parseDouble(req.getParameter("price"));
		double offer=Double.parseDouble(req.getParameter("offer"));
	
		Menu menu=new Menu();
		menu.setId(id);
		menu.setName(name);
		menu.setDescription(description);
		menu.setPrice(price);
		menu.setOffer(offer);
		
		MenuDao menuDao=new MenuDao();
		Menu updatedMenu= menuDao.updateMenu(menu);
		
		if(updatedMenu!=null) {
//			List<Menu> list=menuDao.getAllMenu();
//			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displaymenu.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		
	}

	
}
