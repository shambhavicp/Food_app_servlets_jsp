<%@page import="com.ty.foodie_application_jsp.dto.Items"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.foodie_application_jsp.dao.ItemsDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Items> list=(List) request.getAttribute("itemlist"); %>

<form action="bill" method="post">

<h3>Thank u visit again!!!</h3>
<h3>your bill details</h3>


<table border="2px">
		<tr>
			<th>Item</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total price</th>
			<th>Offer</th>
			<th>Discounted price</th>
		</tr>
		<%  double discounted_price=0.0; %>
		<% double total=0.0; %>
		<% for(Items items:list){ %>
		<tr>
		<td><%= items.getName() %></td>
		<td><%= items.getPrice() %></td>
		<td><%= items.getQuantity() %></td>
		<td><%= items.getPrice()*items.getQuantity() %> </td>
		<td><%= items.getOffer() %></td>
		<%  discounted_price= items.getPrice()*items.getQuantity()-((items.getOffer()/100)*items.getPrice()*items.getQuantity()); %>
		<td><%= discounted_price %></td>
		</tr>
		
		<% total=total+ discounted_price; %>
		<%} %>
		
		<tr height="30px">
		
		</tr>
		<tr>
			<th colspan="5"> Total Item Price</th>
			<td><%= total %></td>
		</tr>
			
</table>

<br>
<a href="displaymenulist.jsp" style="margin: 430px" ><button>ShowMenulist</button></a><br>

</form>

</body>
</html>