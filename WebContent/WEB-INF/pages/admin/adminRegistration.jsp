<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:  #d9ff66"> 
<form:form method="post" action="addAdmin" modelAttribute="admin">
			<table>
			<tr>
				<td>Enter first Name</td>
				<td><form:input path="firstName" required="required"/></td>
			</tr>
			
			<tr>
				<td>Enter last Name</td>
				<td><form:input path="lastName" required="required"/></td>
			</tr>
			<tr>
				<td>Enter email</td>
				<td><form:input path="email" type="email" required="required"/></td>
			</tr>
			<tr>
				<td>Enter contact</td>
				<td><form:input path="contact" pattern="[789][0-9]{9}" required="required"/></td>
			</tr>
			<tr>
				<td>Enter address</td>
				<td><form:input path="address" required="required"/></td>
			</tr>
			<tr>
				<td>Enter password</td>
				<td><form:input path="password" type="password" required="required"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="cancel"></td>
				<td><input type="submit" value="Register admin" /></td>
			</tr>
		</table>
	
</form:form>
</body>
</html>