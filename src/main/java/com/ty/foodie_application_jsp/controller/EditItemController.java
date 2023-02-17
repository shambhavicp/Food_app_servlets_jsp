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

import com.ty.foodie_application_jsp.dao.ItemsDao;
import com.ty.foodie_application_jsp.dto.Items;


@WebServlet("/edititems")
public class EditItemController extends HttpServlet{
	static Items items1;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String description=req.getParameter("description");
		double price=Double.parseDouble(req.getParameter("price"));
		double offer=Double.parseDouble(req.getParameter("offer"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
	
		Items items=new Items(); 
		items.setId(id);
		items.setName(name);
		items.setDescription(description);
		items.setPrice(price);
		items.setOffer(offer);
		items.setQuantity(quantity);
		
		ItemsDao itemsDao=new ItemsDao();
		Items items2=itemsDao.getItemsById(id);
		
		for(Items items3: DisplayAddedItemsController.list) {
			if(id==items3.getId()) {
				items1=items3;
			}
		}
		DisplayAddedItemsController.list.remove(items1);
		
		Items updatedItem= itemsDao.updateItem(items);
		DisplayAddedItemsController.list.add(updatedItem);
	
//		list1.add(updatedItem);
//		
		if(updatedItem!=null) {
			//DisplayAddedItemsController displayAddedItemsController=new DisplayAddedItemsController();
			
			req.setAttribute("list", DisplayAddedItemsController.list);
			//req.setAttribute("list", list1);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayaddeditems.jsp");
			requestDispatcher.forward(req, resp);
			
		}
	}

}
