<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Manager</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

.table
{
	/* width:40%;
	height:60%;
	left-margin:50px; */
	margin: 0px 300px 200px 300px;
	position:fixed;
	width:40%;	
}

</style>

</head>
<body>
<jsp:include page="indexAdmin.jsp" flush="true" />

<article>

<h3  align="center"><span class="label label-default">Manager Registration</span></h3>
<br><br>
	<form:form method="post" modelAttribute="manager" action="addmanager">
		<table class="table">
			<tr>
				<td style="color:white">First Name</td>
				<td><form:input  path="firstName" required="required"/></td>	
			</tr>
			<tr>
				<td style="color:white">LastName</td>
				<td><form:input  path="lastName" required="required"/></td>	
			</tr>
			<tr>
				<td style="color:white">Email</td>
				<td><form:input  path="email" required="required"/></td>	
			</tr>
			<tr>
				<td style="color:white">Contact</td>
				<td><form:input  path="contact" pattern="[789][0-9]{9}" required="required"/></td>	
			</tr>
			<tr>
				<td style="color:white">Address</td>
				<td><form:input  path="address" required="required"/></td>	
			</tr>
			<tr>
				<td><input type="reset" value="cancel"></td>	
				<td><input type="submit" value="Register"></td>
			<tr>
		</table>
	</form:form>	

</article>


</section>
</body>
</html>