<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addcustomer" method="post">

<table>
<tr>
<td>Customer Name:</td>
<td><input type="text" name="name" placeholder="Enter customer name"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" placeholder="Enter customer email"></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" placeholder="Enter customer address"></td>
</tr>
<tr>
<td>Phone:</td>
<td><input type="tel" name="phone" placeholder="Enter customer phone"></td>
</tr>


<tr>
<td><input type="submit" value="AddCustomer"></td>
</tr>
</table>


</form>

</body>
</html>