<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Warehouse Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.table
{
	width:60%;
}
body
  {
  	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("${pageContext.request.contextPath}/images/bg.jpg");
	background-position: 0 0; 
 	background-repeat:no-repeat; 
 	background-size: cover;
 	font-family: Arial, Helvetica, sans-serif;
  }

</style>

</head>
<body style="background-color:  #d9ff66"> 


<header>
 <div class="navbar navbar-inverse nav navBar" style="background-color:	#404040">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#CustoFarmModal" role="button"  data-toggle="modal"><span class="glyphicon glyphicon-leaf" style="color:#a6ff4d"></span>&nbsp;Custo Farm</a>
      
      <div id="CustoFarmModal" class="modal" data-easein="swoopIn"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" >
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" style="color: #009900">Custo Farm</h4>
            </div>
            <div class="modal-body">
              <p>here is a custo farm to serve you!!</p>
            </div>
            <div class="modal-footer">
              <button class="btn success" data-dismiss="modal" aria-hidden="true" style="color: #009900">Close</button>
          </div>
        </div>
        </div>
      </div>
      
      
      
      
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="getIndexManager">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.manager_dtls.firstName}</a></li>
      <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>      
    </ul>
  </div>
</div>	
  
</header>
<br><br>
<h3  align="center"><span class="label label-default">Storage Deatils in ${requestScope.warehouseDetails.warehouseName}</span></h3>
<br><br>
<table border="1" style="border-collapse:collapse;color:white" class="table" align="center">
	<tr>
		<th>Product Name</th>
		<th>Quantity</th>
	</tr>
	<c:forEach var="storage" items="${requestScope.StorageDetails}">
		<tr>
		<td>${storage.product.productName}</td>
		<td>${storage.quantity}</td>
		</tr>
	</c:forEach>
</table>
<br>

</body>
</html>