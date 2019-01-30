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
.table
{
	
	margin: 0px 300px 200px 200px;
	position:absolute;
	width:30%;
	
} 
</style>

</head>
<body>

<jsp:include page="indexAdmin.jsp" flush="true" />

<article>
<h3  align="center"><span class="label label-default">Manager Details</span></h3>
<br>
<table class="table "  border="1" style="border-collapse:collapse" align="center" >
<tr style="background-color: grey"><th>first name</th><th>last name</th><th>email</th><th>contact</th><th>address</th>
<th>city of warehouse</th><th>update warehouse</th><th>delete warehouse</th></tr>

<c:forEach var="mgr" items="${requestScope.listManagers}">
<tr>
	<td width="2%" style="color:white">${mgr.firstName}</td>
	<td width="2%" style="color:white">${mgr.lastName}</td>
	<td width="2%" style="color:white">${mgr.email}</td>
	<td width="2%" style="color:white">${mgr.contact}</td>
	<td width="3%" style="color:white">${mgr.address}</td>
	<td width="3%" style="color:white">${mgr.warehouse.address}</td>
	<td width="3%" style="color:white"><a href="updatemanagerform?mgrId=${mgr.empId}">update</a></td>
	<td width="12%" style="color:white"><a href="deletemanager?mgrId=${mgr.empId}">delete</a></td>
	
</tr>
</c:forEach>
</table>
</article>


</section>
</body>
