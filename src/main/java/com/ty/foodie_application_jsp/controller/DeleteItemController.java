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


@WebServlet("/deleteitem")
public class DeleteItemController extends HttpServlet{
	static Items items;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		ItemsDao itemsDao=new ItemsDao();
		//Items items2=itemsDao.getItemsById(id);
		
////		List<Items> list1=new ArrayList<Items>();
//		for(Items items: DisplayAddedItemsController.list) {
//			list1.add(items);
//		}
//				
//		boolean result=itemsDao.deleteItems(id);
//		list1.remove(items2);
//		
//		
//		 if(result) {
//			
//			//req.setAttribute("list",DisplayAddedItemsController.list); 
//			req.setAttribute("list1",list1); 
//			 RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayaddeditems.jsp");
//			 requestDispatcher.forward(req, resp);
//		 }
		
		
		for(Items items1: DisplayAddedItemsController.list) {
			if(id==items1.getId()) {
				items=items1;
			}
			
		}
		
		DisplayAddedItemsController.list.remove(items);
		boolean result=itemsDao.deleteItems(id);
		if(result) {
		
			req.setAttribute("list",DisplayAddedItemsController.list); 
			//req.setAttribute("list1",list1); 
			 RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayaddeditems.jsp");
			 requestDispatcher.forward(req, resp);
	 }
		
		
	}

}
