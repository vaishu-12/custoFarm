<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All products Deatils</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<style>
.table
{
	
	margin: 0px 1000px 200px 300px;
	position:fixed;
	width:40%;
	
}
</style>

</head>
<body>

<jsp:include page="indexAdmin.jsp" flush="true" />


<article>
<h3  align="center"><span class="label label-default">Products Details</span></h3>
<br/><br/>
<div class="table-wrapper-scroll-y">
<table class="table " style="color:white">
<tr style="background-color: grey">
	<th>Product Details</th>
	<th>Product Cost</th>
</tr>
<c:forEach var="product" items="${requestScope.products}">
	<tr style="color:white">
		<td>${product.productName}</td>
		<td>${product.price }</td>
	</tr>
</c:forEach>

</table>

</div>

</article>


</section>
</body>
</html>