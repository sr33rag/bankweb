<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="Links/style.css" />
</head>
<body>
	<div id="container">
		<div id="intro">
			<div id="pageHeader">
				<h1>
					<span>Sunrise Co-operative Bank</span>
				</h1>
				<h2>
					<span>Deposit and Forget</span>
				</h2>
			</div>
		</div>

		<div id="formBox2">
			<h3 align="center">
				<span>Funds Tranfers</span>
			</h3>
			<hr>
			<div id="errorNotification">
				<c:if test="${haserrors == true}">
					<ul>
						<c:forEach items="errors" var="error">
							<li><font color="red">${error.value}</font></li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div id="formContent">
				<form name="frmTransfer" method="POST" action="transfer.do">
					<table border="0">
						<tr>
							<td><label id="lbl" for="txtBenficiaryAccNo">Beneficiary
									Account No</label></td>
							<td><input type="text" name="txtBenficiaryAccNo"></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtAmount">Amount </label></td>
							<td><input type="text" name="txtAmount"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="btnSubmit"
								value="Transfer" /> <input type="reset" name="btnReset"
								value="Reset" /> <input type="button" name="btnCancel"
								value="Cancel" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>