package com.ty.foodie_application_jsp.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodie_application_jsp.dao.FoodOrderDao;
import com.ty.foodie_application_jsp.dto.FoodOrder;
import com.ty.foodie_application_jsp.dto.Items;
@WebServlet("/existingorderdetails")
public class ExistingOrderController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//int id=Integer.parseInt(req.getParameter("id"));
		
		String email=req.getParameter("email");
		
		FoodOrderDao foodOrderDao=new FoodOrderDao();
		try {
		FoodOrder foodOrder=foodOrderDao.getFoodOrderByEmail(email);
		//FoodOrder foodOrder=foodOrderDao.getFoodOrderById(id);
		
		if(foodOrder!=null) {
			List<Items> list=foodOrder.getItemsList();
			//AddCustomerController addCustomerController=new AddCustomerController();
			for(Items items:AddCustomerController.list2) {
				list.add(items);
			}

			req.setAttribute("orderlist", list);
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("displayexistingorderdetails.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		}catch(NoResultException e){
			req.setAttribute("message2", "Not Having any previous orders");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("orderdetails.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
