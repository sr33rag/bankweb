<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" media="screen"
	href="Links/style.css" />
<script src="Links/validation.js"></script>
<title>Create Account</title>
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
		<div id="formBox">
			<h3 align="center">
				<span>Sign Up</span>
			</h3>
			<hr>
			<div id="erroNotification"></div>
			<div id="formContent">
				<form name="frmSignup" action="createprofile.do"
					onSubmit="return validateReg();">
				<h3>
					<span>Personal Details</span>
				</h3>
				<table border="0">
					<tr>
						<td><label id="lbl" for="txtFname">First Name</label></td>
						<td><input type="text" name="txtFname"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtLname">Last Name </label></td>
						<td><input type="text" name="txtLname"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtEmail">Email id</label></td>
						<td><input type="text" name="txtEmail"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtPassword">Password</label></td>
						<td><input type="password" name="txtPassword"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtRepassword">Re-enter
								Password</label></td>
						<td><input type="password" name="txtRepassword"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="radioGender">Gender</label></td>
						<td><input type="radio" name="radioGender" value="Male"
							checked="checked">Male<input type="radio"
							name="radioGender" value="Female">Female</td>
					</tr>
					<tr>
						<td><label id="lbl" for="dtDob">Date Of Birth</label></td>
						<td><input type="text" name="dtDob"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtContact">Contact</label></td>
						<td><input type="text" name="txtContact"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtAddress">Address</label></td>
						<td><textarea name="txtAddress" rows="4"></textarea></td>
					</tr>
				</table>
				<h3>
					<span>Account Details</span>
				</h3>
				<table border="0">
					<tr>
						<td><label id="lbl" for="txtAmt">Initial Amount</label></td>
						<td><input type="text" name="txtAmt"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="selAtype">Account Type</label></td>
						<td><select name="selAtype">
								<option value="Saving">Saving Account</option>
								<option value="Current">Current Account</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="submit" name="btnSubmit"
							value="Create Account" /></td>
						<td><input type="reset" name="btnReset" value="Reset" /></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
		<div id="linkList">
			<ul>
				<li><a href="/bankweb/">Home</a></li>
				<li><a href="home.do">Login</a></li>
			</ul>
		</div>
	</div>
</body>
</html>