<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
<jsp:include page="indexAdmin.jsp" flush="true" />

<article>
<h3  align="center"><span class="label label-default">${requestScope.dateBetween}</span></h3>
<br><br>
<div style="overflow-x:auto;">
<table class="table"  border="1" style="border-collapse:collapse" align="center" style="color:white">
	<tr style="background-color: grey">
		<th width="1%">Transaction Id</th>	
		<th width="3%">Transaction Date (YYYY-MM-DD)</th>
		<th width="3%">Unit per 100Kgs</th>
		<th width="5%">Total Amt</th>
	</tr>
<c:forEach var="tx" items="${requestScope.txs}">
	<tr>
		<td style="color:white">${tx.transactionId}</td>
		<td style="color:white">${tx.transactionDate }</td>
		<td style="color:white">${tx.units }</td>
		<td style="color:white">${tx.totalAmt }</td>
		
	</tr>
</c:forEach>
</table>
</div>
</article>


</section>
</body>
</html>
