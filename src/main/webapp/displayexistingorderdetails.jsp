<%@page import="com.ty.foodie_application_jsp.dto.Items"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.foodie_application_jsp.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% List<Items> list=(List)request.getAttribute("orderlist");%>


<table border="2px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Price</th>
<th>Offer</th>
</tr>

<% for(Items items:list){ %>
	<tr>
	<td><%= items.getId() %>  </td>
	<td><%= items.getName() %> </td>
	<td><%= items.getDescription() %> </td>
	<td><%= items.getPrice() %> </td>
	<td><%= items.getOffer() %> </td>
	</tr>

<%} %>

</table>


<br>
<br>
<a href="orderdetails.jsp"><button>Back</button></a>


</body>
</html>