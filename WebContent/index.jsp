<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Custo Farm Home</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <style>
	

  .container
  {
  	width:100%;
  	height:100px;
  	padding:50px;
  }
  
  #contactUsbody
  {
  	font:10;
  }
  
  #aboutUsDiv
  {
  	height:100%;
  	align:center;
  	position:fixed;
  	margin:80px 100px 100px 100px;
  	color:#000000;
  }
  body
  {
  	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("${pageContext.request.contextPath}/images/bg.jpg");
	background-position: 0 0; 
 	background-repeat:no-repeat; 
 	background-size: cover;
  }
 
  
  </style>

</head>

<body> 
<nav class=" navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#CustoFarmModal" role="button"  data-toggle="modal"><span class="glyphicon glyphicon-leaf" style="color:#a6ff4d"></span>&nbsp;Custo Farm</a>
      
      <div id="CustoFarmModal" class="modal" data-easein="swoopIn"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" >
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" style="color: black">Custo Farm</h4>
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

      <li class="active" id="aboutUsId"><a >Home</a></li>
      <li><a href="#contactModal"  role="button"  data-toggle="modal">Contact Us</a></li>
      
      <div id="contactModal" class="modal" data-easein="swoopIn"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" >
          <div class="modal-content">
            <div class="modal-header">
              <h4 class="modal-title" style="color: #009900">Contact Us</h4>
            </div>
            <div class="modal-body" id="contactUsbody">
           	<h3> <span class="glyphicon glyphicon-phone" /> <b>91-9865321542</b></h3><br>
           	
             <h3> 
             	<a href="mailto:sam5sggs@gmail.com" ><span class="glyphicon glyphicon-envelope "/>  sam5sggs@gmail.com
             </h3><br></a>
             	
             	
             	
             <h3><span class="glyphicon glyphicon-home"/> plotno.1,sopanbaug,pashan-411008.</h3>
              
            </div>
            <div class="modal-footer">
              <button class="btn success" data-dismiss="modal" aria-hidden="true" style="color: #009900">Close</button>
          </div>
        </div>
        </div>
      </div>
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="manager/getManager"><span class="glyphicon glyphicon-log-in"></span> Manager Login</a></li>      
      <li><a href="admin/loginform"><span class="glyphicon glyphicon-log-in"></span> Admin Login</a></li>
    </ul>
  </div>
</nav>	


<div   id="aboutUsDiv">
<b><h3  align="center">
<span class="glyphicon glyphicon-leaf"/>&nbsp;&nbsp;
Custo Farm
&nbsp;&nbsp;<span class="glyphicon glyphicon-leaf"/>
</h3></b>
<br>

<p id="info" align="center">
			We are here to providing services to the Farmers<br>
			and maximum profit too..
	      What we eat and where our foods come from have changed a lot over the last two decades. 
	      Today small and medium scale farms have given way to "big" factory farms due to their enormous success. 
	      By adopting factory farms practices, some farmers have gained a greater financial success and the largest
	      of these business are practically monopolies.
	      </p>

</div>


</body>
</html>


