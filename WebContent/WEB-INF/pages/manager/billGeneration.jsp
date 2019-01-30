<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bill</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
<script>
var billGen=function (addr) {
	var pdf = new jsPDF();
	pdf.setFontSize(20);
	pdf.setFont("times");
	pdf.setFontType("bold");
	pdf.setTextColor(20, 186, 75);
    pdf.text(80, 20,'Custo Farm!!!');
    pdf.setFontSize(12);
    pdf.setTextColor(53, 59, 94);
    var today = new Date();
    var newdat = "Date : "+ today.getDate()+" - "+today.getMonth()+" - "+today.getYear()+" (DD-MM-YYYY)";
    var time="Time : "+today.getHours()+" : "+today.getMinutes();
  
    pdf.setTextColor(56, 117, 112);
    pdf.setFontType("italic");
    pdf.text(140,40,newdat);
    pdf.text(140,45,time);
    
    pdf.setTextColor(250,0,0);
    
    pdf.setFont("times");
   	pdf.setFontType("bold");
   	
   	
 	pdf.text(40,60,'Transaction Id');
   	pdf.text(100,60,''+${requestScope.txid});
   	
   	pdf.setFontType("normal");
   	pdf.setTextColor(0,0,0);
   	pdf.text(40,70,'-------------------------------------------------------');
   	pdf.text(40,75,'Customer Id');
   	pdf.text(100,75,''+${requestScope.billContents.customer.customerId});
   	
   	
   	pdf.text(40,80,'Name');
   	pdf.text(100,80,document.getElementById('name').innerText);
   
   	pdf.text(40,85,'Address');
   	pdf.text(100,85,document.getElementById('address').innerText);
   	
   	pdf.text(40,90,'Contact');
   	pdf.text(100,90,''+${requestScope.billContents.customer.contact});
   	
	pdf.text(40,95,'Total Units');
	pdf.text(100,95,${requestScope.billContents.units}+'units');

	pdf.setTextColor(198, 100, 13);
	pdf.setFontType("bold");
   	pdf.text(40,100,'Total Amount');
   	pdf.text(100,100,${requestScope.billContents.totalAmt}+' Rs');
   	pdf.setTextColor(0,0,0);
	pdf.text(40,105,'-------------------------------------------------------');
   	pdf.setFontType("normal");
   	pdf.setFontSize(15);
   	pdf.text(80,140,'Thank you for Selling!!');
   	
   	pdf.setFillColor(204, 204,204,0);
    pdf.save('bill - '+${requestScope.billContents.customer.customerId}+'.pdf');
};

</script>
<style>
.table
{
	width:60%;
}
body
  {
  	background-image:linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url("https://drive.google.com/uc?id=1ArBvArzmzBrXplYtAsKxKjyCNvCabN5d");
	background-position: 0 0; 
 	background-repeat:no-repeat; 
 	background-size: cover;
 	font-family: Arial, Helvetica, sans-serif;
  }

</style>
</head>
<body style="background-color:  #d9ff66"> 


<header>
 <div class="navbar navbar-inverse nav navBar" style="background-color:	#404040" id="content">
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
<div id="bill">
<div class="col-xs-12" style="color:white">
					<strong>Transaction Id:${requestScope.txid}</strong>
					<br><br>
    				Billed To : ${requestScope.billContents.customer.customerId} <br>
    				${requestScope.billContents.customer.firstName}&nbsp;${requestScope.billContents.customer.lastName}
    					<hr>
  </div>
<table border="1" style="border-collapse:collapse;color:white" align="center" class="table">
	<tr>
		<td>Customer Contact </td>
		<td id="contact">${requestScope.billContents.customer.contact}</td>
	</tr>
	<tr>
		<td>Customer address </td>
		<td id="address">${requestScope.billContents.customer.address}</td>
	</tr>
	<tr>
		<td>product Name </td>
		<td>${requestScope.product}</td>
	</tr>
		<tr>
		<td>product Quantity</td>
		<td>${requestScope.billContents.units}</td>
	</tr>
</table>
<span id="name"  style="display:none">${requestScope.billContents.customer.firstName}&nbsp;${requestScope.billContents.customer.lastName}</span>
<span id="txid"  style="display:none">${requestScope.txid}</span>
<h3  align="center"><span class="label label-default">Total Amount : Rs.  ${requestScope.billContents.totalAmt}</span></h3>
<br>
 <p align="center"><button class="btn" align="center"  id="cmd" onclick="billGen()">Download Bill</button></p>


</body>
</html>