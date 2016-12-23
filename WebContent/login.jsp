<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
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
					<span>Deposite and Forget</span>
				</h2>
			</div>
		</div>
		<div id="formBox">
			<h3 align="center">
				<span>Login</span>
			</h3>
			<hr>
			<div id="errorNotification">${form.errors}</div>
			<div id="formContent">
				<form name='fmlogin' action='login.do' method='post'>
					<table border="0">
						<tr>
							<td><label>Login-id:</label></td>
							<td><input type='text' name='txtloginid' value='${form.txtloginid}'/></td>
						</tr>
						<tr>
							<td><label>Password:</label></td>
							<td><input type='password' name='txtpass' /></td>
						</tr>
						<tr>
							<td><input type='submit' name='btnSubmit' value='Login' /></td>
							<td><input type='reset' name='btnReset' value='Reset'></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div id="linkList">
			<ul>
				<li><a href="/bankweb/">Home</a></li>
				<li><a href="tosignup.do">Open Account</a></li>
			</ul>
		</div>
	</div>
</body>
</html>