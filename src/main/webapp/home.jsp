<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String message=(String)request.getAttribute("message1"); %>
<% if(message!=null){ %>

<h3><%= message %></h3>

<%} %>
 
<a href="signup.jsp"><button>SignUP</button></a>
<a href="login.jsp"><button>Login</button></a>

</body>
</html>