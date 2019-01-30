<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Customer Page</title>
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
<h3  align="center"><span class="label label-default">Customer Deletion</span></h3>
<br><br>
<form method="post" action="removeCustomer" >
		<table class="table">
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
				<td><input type="submit" class="btn" value="Remove Customer"></td>
				<td><input type="reset" class="btn" value="cancel"></td>	
			<tr>
		</table>
	</form>
	</article>
</body>
</html>