<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update Customer details</title>

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

<h3  align="center"><span class="label label-default">Customer Updation</span></h3>
<br><br>
<form method="post" action="updateCustomer" >
<table class="table" align="center">
	<tr>
				<td style="color:white">customer Id</td>
				<td>
				<select name="customerId">
					<option>--Select Customer id--</option>
					<c:forEach var="custId" items="${requestScope.custIds}">
						<option>${custId}</option>
					</c:forEach>
				</select>
				</td>	
			</tr>
			<tr>
				<td style="color:white">Address</td>
				<td><input type="text" name="address" required></td>	
			</tr>
			<tr>
				<td style="color:white">Contact number</td>
				<td><input type="text" pattern="[789][0-9]{9}" name="contact" required></td>	
			</tr>
			<tr>
				<td><input type="submit" class="btn" value="Update Customer"></td>
				<td><input type="reset" class="btn" value="cancel"></td>	
			<tr>
</table>

</form>
<%-- <form  method="post" action="updateCustomer" >
		<table  class="table table-hover  table1" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="black">customer Id</td>
				<td>
				<select name="customerId">
					<option>--Select Customer id--</option>
					<c:forEach var="custId" items="${requestScope.custIds}">
						<option>${custId}</option>
					</c:forEach>
				</select>
				</td>	
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>	
			</tr>
			<tr>
				<td>Contact number</td>
				<td><input type="text" name="contact"></td>	
			</tr>
			<tr>
				<td><input type="submit" value="Update Customer"></td>
				<td><input type="reset" value="cancel"></td>	
			<tr>
		</table> --%>
	</form>
</article>
</body>
</html>