<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
* {
  box-sizing: border-box;"WebContent/WEB-INF/pages/manager/indexManager.jsp"
}
body
  {
  	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("${pageContext.request.contextPath}/images/bg.jpg");
	background-position: 0 0; 
 	background-repeat:no-repeat; 
 	background-size: cover;
 	font-family: Arial, Helvetica, sans-serif;
  }


/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 20%;
  height: 100%; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

.list1
{
	 width: 20%;
}

nav ul {
  list-style-type: none;
  padding: 0;
}

article {

	padding:0px 10px 10px 100px;

}


section:after {
  content: "";
  display: table;
  clear: both;
}

@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
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
      <li class="active"><a href="getIndexAdmin">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;${sessionScope.admin.firstName}</a></li>
      <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Logout</a></li>      
    </ul>
  </div>
</div>	
  
</header>


<section>
<nav>
	<div class="list-group container">
		<div class="panel-group  list1" id="accordion">
	        <div class="panel panel-default">
		          <div class="panel-heading">
		            <h4 class="panel-title">
		              <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Ware House</a>
		            </h4>
		          </div>
				 <div id="collapseOne" class="panel-collapse collapse in ">
	 				<ul class="list-group">
	              		<li class="list-group-item"><a class="dropdown-item" href="addwarehouse">Add WareHouse</a></li>
	              		<li class="list-group-item"><a class="dropdown-item" href="getWareHouses">Show WareHouse</a></li>
				    	<li class="list-group-item"><a class="dropdown-item" href="getWhContentsForm">Warehouse Details</a></li></ul>
				  </div>
				  <a href="GetAllProduct" class="list-group-item ">Show Products</a>
			 	  <a href="AddProduct" class="list-group-item ">Add Product</a>
				  <a href="DeleteProduct" class="list-group-item ">Delete Product</a> 
				  <a href="updateProduct" class="list-group-item ">Update Product</a>
				  <a href="transactionDetails" class="list-group-item ">Transaction Details</a>
				  <a href="getManagers" class="list-group-item ">show managers</a> 
			</div>
		</div> 
	</div>
  </nav>
<br>


<h3  align="center"><span class="label label-default">${requestScope.Status}</span></h3>






