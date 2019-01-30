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
<%-- <span>Showing Contents of: <h4>${requestScope.warehouse}</h4></span> --%>
<article>

<h3  align="center"><span class="label label-default">WareHouse Contents</span></h3>

<br><br>
	<form action="checkContents">
		<table class="table table-hover" border="1" >
			<tr style="background-color: grey">
				<th width="3%">product name</th>
				<th width="3%">product price</th>
				<th width="8%">quantity</th></tr>
						
				<c:forEach var="st" items="${requestScope.store}">
				<tr style="color:white">
					<td>${st.product.productName}</td>
					<td>${st.product.price}</td>
					<td>${st.quantity}</td>
				</tr>		
				</c:forEach>
				
			
				
			
		</table>
	</form>
	
</article>


</section>
</body>
</html>