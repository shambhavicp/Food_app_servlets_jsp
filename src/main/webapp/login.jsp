<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<% String message=(String)request.getAttribute("message"); %>
<% if(message!=null){ %>

<h3><%= message %></h3>

<%} %>
<h3>=====Login Page=====</h3>
<form action="login" method="post">
<table>
<tr>
<td>Email:</td>
<td><input type="email" name="email" placeholder="Enter your email"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" placeholder="Enter your password"></td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
<tr>
<td><a href="signup.jsp" ><button>Signup</button></a></td>
</tr>

</table>
</form>
</body>
</html>