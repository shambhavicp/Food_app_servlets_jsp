<%@page import="com.ty.foodie_application_jsp.dto.Items"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Items items=(Items)request.getAttribute("items"); %>

<form action="edititems" method="post">
<table>
<tr>
<td>Id:</td>
<td><input type="number" name="id" value="<%= items.getId() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Name:</td>
<td><input type="text" name="name" readonly="readonly" value="<%= items.getName() %>"></td>
</tr>
<tr>
<td>Description:</td>
<td><input type="text" name="description" readonly="readonly" value="<%= items.getDescription() %>" ></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="text" name="price" readonly="readonly" value="<%= items.getPrice() %>" ></td>
</tr>
<tr>
<td>Offer:</td>
<td><input type="text" name="offer" readonly="readonly" value="<%= items.getOffer() %>" ></td>
</tr>
<tr>
<td>Quantity:</td>
<td><input type="number" name="quantity" placeholder="Add quantity" value="<%= items.getQuantity() %>"></td>
</tr>

<tr>
<td><input type="submit" value="Update"></td>
</tr>
</table>
</form>


</body>
</html>