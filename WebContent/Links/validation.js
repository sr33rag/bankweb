function validateEdit() {
	var fname = document.frmSignup.txtFname.value;
	var lname = document.frmSignup.txtLname.value;
	var contact = document.frmSignup.txtContact.value;
	var address = document.frmSignup.txtAddress.value;

	if (fname == "") {
		alert("First Name field is Empty");
		document.frmSignup.txtFname.borderColor = "#00FF00";
		return false;
	} else if (lname == "") {
		alert("Last Name field is Empty");
		document.frmSignup.txtLname.borderColor = "#00FF00";
		return false;
	} else if (email == "") {
		alert("Email field is Empty");
		document.frmSignup.txtLname.borderColor = "#00FF00";
		return false;
	} else if (!emailregex.test(email)) {
		alert("Invalid email id");
		document.frmSignup.txtEmail.borderColor = "#FF00FF";
		return false;
	} else if (contact == "") {
		alert("Contact field is Empty");
		document.frmSignup.txtContact.borderColor = "#00FF00";
		return false;
	} else if (address == "") {
		alert("Address field is Empty");
		document.frmSignup.txtAddress.borderColor = "#00FF00";
		return false;
	} else {
		alert("validation successfull");
		return true;
	}

}
function validateReg() {
	var fname = document.frmSignup.txtFname.value;
	var lname = document.frmSignup.txtLname.value;
	var email = document.frmSignup.txtEmail.value;
	var passwd = document.frmSignup.txtPassword.value;
	var repasswd = document.frmSignup.txtRepassword.value;
	var contact = document.frmSignup.txtContact.value;
	var address = document.frmSignup.txtAddress.value;
	var emailregex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/;
	if (fname == "") {
		alert("First Name field is Empty");
		document.frmSignup.txtFname.borderColor = "#00FF00";
		return false;
	} else if (lname == "") {
		alert("Last Name field is Empty");
		document.frmSignup.txtLname.borderColor = "#00FF00";
		return false;
	} else if (email == "") {
		alert("Email field is Empty");
		document.frmSignup.txtLname.borderColor = "#00FF00";
		return false;
	} else if (!emailregex.test(email)) {
		alert("Invalid email id");
		document.frmSignup.txtEmail.borderColor = "#FF0000";
		return false;
	} else if (passwd == "") {
		alert("Password field is Empty");
		document.frmSignup.txtPassword.borderColor = "#00FF00";
		return false;
	} else if (repasswd != passwd) {
		alert("Password does not match");
		document.frmSignup.txtRepassword.borderColor = "#00FF00";
		return false;
	} else if (contact == "") {
		alert("Contact field is Empty");
		document.frmSignup.txtContact.borderColor = "#00FF00";
		return false;
	} else if (address == "") {
		alert("Address field is Empty");
		document.frmSignup.txtAddress.borderColor = "#00FF00";
		return false;
	} else {
		alert("validation successfull");
		return true;
	}
}
function validateLogin() {
	var eid = document.frnLogin.txtLoginid.value;
	var passwd = document.frmSignup.txtPass.value;

	if (eid == "") {
		alert("User id field is Empty");
		document.frmSignup.txtLoginid.borderColor = "#00FF00";
		return false;
	} else if (passwd == "") {
		alert("Password field is Empty");
		document.frmSignup.txtPass.borderColor = "#00FF00";
		return false;
	} else {
		alert("validation successfull");
		return true;
	}

}
function validateTranfer() {
	var baccno = document.frnLogin.txtBenficiaryAccNo.value;
	var passwd = document.frmSignup.txtAmount.value;

	if (baccno == "") {
		alert("Beneficiary account number field is Empty");
		document.frmSignup.txtBenficiaryAccNo.borderColor = "#00FF00";
		return false;
	} else if (passwd == "") {
		alert("Enter amount");
		document.frmSignup.txtAmount.borderColor = "#00FF00";
		return false;
	} else {
		alert("validation successfull");
		return true;
	}

}