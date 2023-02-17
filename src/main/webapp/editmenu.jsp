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

<% Menu menu=(Menu)request.getAttribute("menu"); %>

<form action="edit" method="post">
<table>
<tr>
<td>Id:</td>
<td><input type="number" name="id" value="<%= menu.getId() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" placeholder="Enter food name" value="<%= menu.getName() %>"></td>
</tr>
<tr>
<td>Description:</td>
<td><input type="text" name="description" placeholder="Enter the Description" value="<%= menu.getDescription() %>" ></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="text" name="price" placeholder="Enter the food Price" value="<%= menu.getPrice() %>" ></td>
</tr>
<tr>
<td>Offer:</td>
<td><input type="text" name="offer" placeholder="Enter the offer" value="<%= menu.getOffer() %>" ></td>
</tr>

<tr>
<td><input type="submit" value="Update"></td>
</tr>
</table>
</form>

</body>
</html>