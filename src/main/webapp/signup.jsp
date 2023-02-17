<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="signup" method="post">
<table>
<tr>
<td>Name:</td>
<td><input type="text" name="name" placeholder="enter your name"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email" placeholder="Enter your email"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" placeholder="Enter your password"></td>
</tr>
<tr>
<td>Phone:</td>
<td><input type="tel" name="phone" placeholder="Enter your Phone"></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address" placeholder="enter your address"></td>
</tr>
<tr>
<td>Role:</td>
<td>Manager<input type="radio" name="role" value="Manager">
Customer<input type="radio" name="role" value="Customer">
Staff<input type="radio" name="role" value="Staff"></td>
</tr>
<tr>
<td><input type="submit" value="Signup"></td>
</tr>

</table>
</form>

</body>
</html>