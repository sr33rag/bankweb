<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/function" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/format" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer History</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="Links/style.css" />
</head>
<body>
	<div id="container">
		<div id="intro">
			<div id="pageHeader">
				<h1>
					<span>Sunrise Cooperative Bank</span>
				</h1>
				<h2>
					<span>Deposit and Forget</span>
				</h2>
			</div>
		</div>
	</div>
	<div id="formBox2">
		<h3 align="center">
			<span>Transfer History</span>
		</h3>
		<hr>
		<div id="errorNotification"></div>
		<div id="formContent">
			<table id="tblStmt">
				<tr id="tblStmt">
					<td width="10">Date</td>
					<td>Beneficiary Account</td>
					<td>Amount</td>
				</tr>
				<%-- <c:forEach items="transfers" var="transfer">
				  <tr id="tblStmt">
				    <td width="10"><% requestgetParametertransfer.transferDate%></td>
				    <td>${transfer.toAcc.accountId}</td>
				    <td>${transfer.tamount}</td>
				  </tr>
				</c:forEach> --%>
			</table>
		</div>
	</div>
	<div id="footer">
		<hr>
		Copyright &copy; 2013 Aryans Group
	</div>
</body>
</html>