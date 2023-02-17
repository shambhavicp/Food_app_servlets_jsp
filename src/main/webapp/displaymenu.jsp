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
<th>Delete</th>
<th>Update</th>
</tr>

<% for(Menu menu:list1){ %>
	<tr>
	<td><%= menu.getId() %>  </td>
	<td><%= menu.getName() %> </td>
	<td><%= menu.getDescription() %> </td>
	<td><%= menu.getPrice() %> </td>
	<td><%= menu.getOffer() %> </td>
	<td><a href="delete?id=<%= menu.getId() %>"><button>delete</button></a></td>
	<td><a href="update?id=<%= menu.getId() %>"><button>update</button></a></td>
	</tr>



<%} %>

</table>
<br>
<a href="addmenu.jsp" style="margin: 430px" ><button>Add More</button></a><br>
<br>
<a href="menu.jsp" style="margin: 430px" ><button>Back</button></a>
</body>
</html>