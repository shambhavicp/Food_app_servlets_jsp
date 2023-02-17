<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message2"); %>
<% if(message!=null){ %>
<h3><%=message %></h3>
<%} %>
<a href="displaymenutocustomer.jsp"><button>DisplayMenu</button></a>
<a href="existingorderdetails.jsp"><button>PreviousOrderdetails</button></a>
<br>
<br>
<a href="login.jsp"><button>logout</button></a>

</body>
</html>