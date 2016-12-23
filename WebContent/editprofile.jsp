<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
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

		<div id="formBox2">
			<h3 align="center">
				<span>Edit Details</span>
			</h3>
			<hr>
			<div id="errorNotification">
				<c:if test="${hasherrors}==true">
					<ul>
						<c:forEach items="errors" var="error">
							<li><font color="red">${error.value}</font></li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
			<div id="formContent">
				<form name="frmSignup" method="POST" action="editprofile.do">
					<table border="0">
						<tr>
							<td><label id="lbl" for="txtFname">First Name</label></td>
							<td><input type="text" name="txtFname"
								value='${acc.user.ufname}' disabled="disabled" /></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtLname">Last Name </label></td>
							<td><input type="text" name="txtLname"
								value='${acc.user.ulname}' disabled="disabled" /></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtEmail">Email id</label></td>
							<td><input type="text" name="txtEmail"
								value='${acc.user.uemail}' disabled="disabled" /></td>
						</tr>
						<tr>
							<td><label id="lbl" for="radiosex">Gender</label></td>
							<td><input type="radio" name="ugender" value="Male"
								${acc.user.ugender == 'Male' ? 'checked' : ''}
								disabled="disabled" />Male<input type="radio" name="ugender"
								value="Female" ${acc.user.ugender == 'Female' ? 'checked' : ''}
								disabled="disabled" />Female</td>
						</tr>
						<tr>
							<td><label id="lbl" for="dtDob">Date Of Birth</label></td>
							<td><input type="text" name="dtDob" value='${acc.user.dob}'
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtPassword">Enter password</label></td>
							<td><input type="password" name="txtPassword"></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtRepassword">Re-enter
									password</label></td>
							<td><input type="password" name="txtRepassword"></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtContact">Contact</label></td>
							<td><input type="text" name="txtContact"
								value='${acc.user.uphone}' /></td>
						</tr>
						<tr>
							<td><label id="lbl" for="txtAddress">Address</label></td>
							<td><textarea name="txtAddress" rows="4" cols="15">${acc.user.uaddress1}</textarea></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" name="btnSubmit"
								value="Save">&nbsp; <input type="reset" name="btnReset"
								value="Reset">&nbsp;&nbsp; <input type="button"
								name="btnCancel" value="Cancel"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>