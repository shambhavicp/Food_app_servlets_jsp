<%@page import="com.ty.foodie_application_jsp.dao.MenuDao"%>
<%@page import="com.ty.foodie_application_jsp.dto.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% List<Menu> list=new MenuDao().getAllMenu(); %>
<% request.setAttribute("list", list); %>
<% List<Menu> list1=(List)request.getAttribute("list"); %>


<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Price</th>
<th>Offer</th>
</tr>

<% for(Menu menu:list1){ %>
	<tr>
	<td><%= menu.getId() %> </td>
	<td><%= menu.getName() %> </td>
	<td><%= menu.getDescription() %> </td>
	<td><%= menu.getPrice() %> </td>
	<td><%= menu.getOffer() %> </td>
	</tr>



<%} %>

</table>
<br>
<a href="orderdetails.jsp" ><button>Back</button></a>
</body>
</html>