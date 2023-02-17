package com.ty.foodie_application_jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.xml.IfTag;
import org.hibernate.internal.StaticFilterAliasGenerator;

import com.ty.foodie_application_jsp.dao.FoodOrderDao;
import com.ty.foodie_application_jsp.dao.ItemsDao;
import com.ty.foodie_application_jsp.dao.MenuDao;
import com.ty.foodie_application_jsp.dto.FoodOrder;
import com.ty.foodie_application_jsp.dto.Items;
import com.ty.foodie_application_jsp.dto.Menu;

@WebServlet("/additems")
public class DisplayAddedItemsController extends HttpServlet{
	static List<Items> list= new ArrayList<Items>();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		double price=Double.parseDouble(req.getParameter("price"));
		double offer=Double.parseDouble(req.getParameter("offer"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
	
		Items items=new Items();
		//items.setId(id);
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price);
		items.setOffer(offer);
		items.setQuantity(quantity);
		
		ItemsDao itemsDao=new ItemsDao();	
		Items saveItems= itemsDao.saveItems(items);
		//int id=saveItems.getId();
		list.add(saveItems);
	
		if(saveItems!=null) {			
			
			
			req.setAttribute("list", list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayaddeditems.jsp");
			requestDispatcher.forward(req, resp);			
		}
		
	
		
	}
	
}
