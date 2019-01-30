<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>transaction Details Form</title>

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
<h3  align="center"><span class="label label-default">Transaction check Form</span></h3>
<br/><br/>

<form method="post" >
		<table class="table">
			<tr>
				<td style="color:white">Start Date</td>
				<td><input type="date" name="startDate" required></td>	
			</tr>
			<tr>
				<td style="color:white">End Date</td>
				<td><input type="date" name="endDate" required></td>
			</tr>
			<tr>
				<td><input type="reset" value="cancel"></td>	
				<td><input type="submit" value="Show Transactions"></td>
				
			<tr>
		</table>
	</form>
</article>


</section>
</body>
</html>