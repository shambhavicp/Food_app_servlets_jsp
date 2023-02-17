package com.ty.foodie_application_jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodie_application_jsp.dao.UserDao;
import com.ty.foodie_application_jsp.dto.User;

@WebServlet("/signup")
public class UserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAddress(address);
		user.setRole(role);
		
		UserDao userDao=new UserDao();
		User savedUser= userDao.saveUser(user);
		
		if(savedUser!=null) {
			req.setAttribute("message", "Signed Up Successfully");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		
		
	}
	
	

}
