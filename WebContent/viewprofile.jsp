<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Profile</title>
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
		<div id="formBox">
			<h3 align="center">
				<span>User Details</span>
			</h3>
			<hr>
			<div id="formContent">

				<table border="0">
					<tr>
						<td><label id="lbl" for="txtFname">First Name</label></td>
						<td><input type="text" name="txtFname"
							value='${acc.user.ufname}' disabled="disabled"></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtLname">Last Name </label></td>
						<td><input type="text" name="txtLname"
							value='${acc.user.ulname}' disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtEmail">Email id</label></td>
						<td><input type="text" name="txtEmail"
							value='${acc.user.uemail}' disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtGender">Gender</label></td>
						<td><input type="text" name='txtGender'
							value='${acc.user.ugender}' disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="dtDob">Date Of Birth</label></td>
						<td><input type="text" name="dtDob" value='${acc.user.dob}'
							disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtContact">Contact</label></td>
						<td><input type="text" name="txtContact"
							value='${acc.user.uphone}' disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtAddress">Address</label></td>
						<td><textarea name="txtAddress" rows="4" disabled='disabled'>${acc.user.uaddress1}</textarea></td>
					</tr>
				</table>
				<a href="toeditprofile.do">Edit</a>

			</div>
		</div>
		<div id="formBox">
			<h3 align="center">
				<span>Account Details</span>
			</h3>
			<hr>
			<div id="formContent">
				<table border="0">
					<tr>
						<td><label id="lbl" for="txtAccName">Account No.</label></td>
						<td><input type="text" name="txtAccName"
							value='${acc.accountId}' disabled='disabled'></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtAccType">Account type</label></td>
						<td><input type="text" name="txtAccType" value='${acc.atype}'
							disabled='disabled'></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtBalance">Balance</label></td>
						<td><input type="text" name="txtEmail" value='${acc.balance}'
							disabled='disabled' /></td>
					</tr>
					<tr>
						<td><label id="lbl" for="txtactive">Status</label></td>
						<td><input type="text" name="txtactive" value='${acc.active}'
							disabled='disabled' /></td>
					</tr>
				</table>
				<a href="deactivate.do">Deactivate Account</a>
			</div>
		</div>
		<div id="linkList">
			<ul>
				<li><a href="totransfer.do">Transfer Fund</a></li>
				<li><a href="viewtransfers.do">View Transfer History</a></li>
				<li><a href="logout.do">Logout</a></li>
			</ul>
		</div>
	</div>
</body>
</html>