<%@page import="com.ty.foodie_application_jsp.dao.MenuDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.foodie_application_jsp.dto.Menu"%>
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
<th>AddItems to Place Order</th>

</tr>

<% for(Menu menu:list){ %>
	<tr>
	<td><%= menu.getId() %> </td>
	<td><%= menu.getName() %> </td>
	<td><%= menu.getDescription() %> </td>
	<td><%= menu.getPrice() %> </td>
	<td><%= menu.getOffer() %> </td>
	<td><a href="add?id=<%= menu.getId() %>"><button>AddItems </button></a></td>
	
	</tr>



<%} %>
</table>

<br>
<a href="login.jsp" style="margin: 430px" ><button>logOut</button></a><br>
</body>
</html>