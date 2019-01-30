<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update manager</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

.table
{
	margin: 0px 300px 200px 200px;
	position:fixed;
	width:40%;	
}

</style>

</head>
<body>

<jsp:include page="indexAdmin.jsp" flush="true" />

<article>

<h3  align="center"><span class="label label-default">Update Manager Details</span></h3>
<br><br>
	<form action="updateManager">
	<input type="hidden" name="mgrId" value="${requestScope.mgrId}">
		<table class="table">
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required></td>	
			</tr>
			<tr>
				<td>contact</td>
				<td><input type="text" pattern="[789][0-9]{9}" name="contact" required></td>	
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address" required></td>	
			</tr>
			<tr>
				<td><input type="reset" value="cancel"></td>
				<td><input type="submit" value="update"></td>	
			<tr>
		</table>
	</form>
	
</article>

</section>
</body>
</html>