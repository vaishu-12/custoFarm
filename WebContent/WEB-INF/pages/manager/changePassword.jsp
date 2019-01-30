<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<style>
 .table{
	margin: 0px 1000px 200px 300px;
	position:fixed;
	width:40%;
}

</style>

</head>
<body>

<jsp:include page="indexManager.jsp" flush="true" />
<article>
<h3  align="center"><span class="label label-default">${requestScope.changePassword_status}</span></h3>
<h3  align="center"><span class="label label-default">Change Password</span></h3>
	<br><br>
	<form method="post" >
		<table class="table" align="center">
			<tr>
				<td style="color:white">User name</td>
				<td><input name="userName" required></td>	
			</tr>
			<tr>
				<td style="color:white">password</td>
				<td><input type="password" name="password" required></td>	
			</tr>
			<tr>
				<td style="color:white">Confirm password</td>
				<td><input type="password" name="cnfPassword" required></td>	
			</tr>
			<tr>
				<td><input type="submit" class="btn" value="Change Password"></td>
				<td><input type="reset" class="btn" value="cancel"></td>	
			<tr>
		</table>
	</form>
	
</body>
</html>