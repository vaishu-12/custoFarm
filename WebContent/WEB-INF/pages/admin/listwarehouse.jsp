<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List WareHouses</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

.table1
{
	/* width:40%;
	height:60%;
	left-margin:50px; */
	margin: 0px 0px 200px 300px ;
	position:fixed;
	width:60%;
	
}



</style>



</head>
<body>

<jsp:include page="indexAdmin.jsp" flush="true" />

<h3  align="center"><span class="label label-default">WareHouse Details</span></h3>
<div class="table-wrapper-scroll-y">
<table class="table1  table"  style="border-collapse:collapse;color:white" >
<thead class="thead-light" style="background-color: grey">
	<th width="4%">Address of WH</th>
	<th width="5%">Name Of WH</th>
	<th width="5%">Contact Of WH</th>
	<th width="5%">update warehouse</th>
	<th width="10%">delete warehouse</th>
</thead>

<c:forEach var="wh" items="${requestScope.listWrhouse}">
<tr style="color:white">
	<td>${wh.address}</td>
	<td>${wh.warehouseName}</td>
	<td>${wh.contact}</td>
	<td ><a class="btn" href="updatewarehouseform?warehouseId=${wh.warehouseId}">update</a></td>
	<td ><a class="btn" href="deletewarehouse?warehouseId=${wh.warehouseId}">delete</a></td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>