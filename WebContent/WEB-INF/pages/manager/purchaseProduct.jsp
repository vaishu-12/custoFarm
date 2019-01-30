<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>purchaseProduct Form</title>

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

<h3  align="center"><span class="label label-default">Purchasing Products</span></h3>
<br><br>
<form method="post" >
<table class="table">
			<tr>
				<td style="color:white">Enter Customer Id</td>
				<td>
				<select name="customerId">
				<option style="color:black">---select Customer---</option>
				<c:forEach var="cid" items="${requestScope.custs}">
					<option style="color:black">${cid}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			
			<tr>
				<td style="color:white">Select Product</td>
				<td>
				<select name="product">
				<option style="color:black">---select Product---</option>
				<c:forEach var="product" items="${requestScope.products}">
					<option style="color:black">${product.productName}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td style="color:white">Enter Quantity</td>
				<td><input type="number" name="quantity" min="1" style="color:black"/></td>
			</tr>
			<tr>
				<td><input type="submit" class="btn" value="Purchase product" style="color:black"/></td>
				<td><input type="reset"class="btn"  value="cancel" style="color:black"></td>
			</tr>
		</table>
</form>
</article>

</body>
</html>