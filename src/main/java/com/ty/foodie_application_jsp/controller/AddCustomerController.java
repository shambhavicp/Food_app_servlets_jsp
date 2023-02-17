package com.ty.foodie_application_jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodie_application_jsp.dao.FoodOrderDao;
import com.ty.foodie_application_jsp.dao.ItemsDao;
import com.ty.foodie_application_jsp.dto.FoodOrder;
import com.ty.foodie_application_jsp.dto.Items;

@WebServlet("/addcustomer")
public class AddCustomerController extends HttpServlet{
	static List<Items> list2=DisplayAddedItemsController.list;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String c_name=req.getParameter("name");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		
		FoodOrder foodOrder=new FoodOrder();
		foodOrder.setC_name(c_name);
		foodOrder.setEmail(email);
		foodOrder.setPhone(phone); 
		foodOrder.setAddress(address);
		
		ItemsDao itemsDao=new ItemsDao();
		//DisplayAddedItemsController displayAddedItemsController=new DisplayAddedItemsController();
		List<Items> list=DisplayAddedItemsController.list;
		foodOrder.setItemsList(list);
		
		FoodOrderDao foodOrderDao=new FoodOrderDao();
		try {
			FoodOrder foodOrder2=foodOrderDao.getFoodOrderByEmail(email);
			if(foodOrder2!=null) {
				foodOrder.setId(foodOrder2.getId());
				FoodOrder updatedFoodOrder=foodOrderDao.updateFoodOrder(foodOrder);
								
					List<Items> list3=foodOrder.getItemsList();
					req.setAttribute("itemlist", list3);	
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("bill.jsp");
					requestDispatcher.forward(req, resp);
					DisplayAddedItemsController.list.clear();
					
					
				}
		}catch(NoResultException e)
		 {
				FoodOrder savedFoodOrder=foodOrderDao.saveFoodOrder(foodOrder);
				if(savedFoodOrder!=null) {
					
					List<Items> list3=foodOrder.getItemsList();
					req.setAttribute("itemlist", list3);	
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("bill.jsp");
					requestDispatcher.forward(req, resp);
					DisplayAddedItemsController.list.clear();
					
					
					}
				}
		
		
	}

}





