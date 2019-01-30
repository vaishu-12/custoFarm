<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

body
  {
  	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("${pageContext.request.contextPath}/images/bg.jpg");
	background-position: 0 0; 
 	background-repeat:no-repeat; 
 	background-size: cover;
  }
</style>
</head>
<body style="background-color:  #d9ff66"> 


<div class="alert alert-info">
	  <h3>${requestScope.status}</h3>
	</div>

		<div class="container">
		  <h2 style="color:white">Admin Login Form</h2>
		  <form action="validateAdmin">
		    <div class="form-group">
		      <label for="email" style="color:white">Email:</label>
		      <input type="email" class="form-control" id="userName" placeholder="Enter email" name="userName" required>
		    </div>
		    <div class="form-group">
		      <label for="pwd" style="color:white">Password:</label>
		      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
		    </div>
		    <button type="submit" class="btn btn-default">Login</button>
		    <button type="reset" class="btn btn-default">Reset</button>
		  </form>
		</div>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/CustoFarm" class="btn " style="background-color:black">Back To Home</a>


</body>
</html>