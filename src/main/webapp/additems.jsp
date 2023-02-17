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

<form action="additems" method="post">
<table>
<tr>
<td>MenuId:</td>
<td><input type="number" name="mid" value="<%= menu.getId() %>" readonly="readonly"></td>
</tr>

<tr>
<td>Name:</td>
<td><input type="text" name="name" value="<%= menu.getName() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Description:</td>
<td><input type="text" name="description" value="<%= menu.getDescription() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Price:</td>
<td><input type="text" name="price" value="<%= menu.getPrice() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Offer in %:</td>
<td><input type="text" name="offer" value="<%= menu.getOffer() %>" readonly="readonly"></td>
</tr>
<tr>
<td>Quantity:</td>
<td><input type="number" name="quantity" placeholder="Add quantity"></td>
</tr>

<tr>
<td><input type="submit" value="AddItem"></td>
</tr>

</table>
</form>
</body>
</html>