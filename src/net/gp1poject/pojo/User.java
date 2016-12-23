package net.gp1poject.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {

	private int userId=0;
	private String ufname=null,ulname=null,uemail=null,ugender=null,uaddress1=null,uphone=null,upass=null;
	private Date dob=null,ucreatedOn=null;
	
	public User(int _userid) {
		setUserId(_userid);
	}
	
	public User(int _userId, String _fname, String _lname, String _email,String _gender, String _address1,String _uphone, String _upass, Date _dob,Date _createdOn) {
		setUserId(_userId);
		setUfname(_fname);
		setUlname(_lname);
		setUemail(_email);
		setUgender(_gender);
		setUaddress1(_address1);
		setUpass(_upass);
		setDob(_dob);
		setUphone(_uphone);
		setUcreatedOn(_createdOn);
	}
	
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int _userId) {
		this.userId = _userId;
	}
	public String getUfname() {
		return this.ufname;
	}
	public void setUfname(String _ufname) {
		this.ufname = _ufname;
	}
	public String getUlname() {
		return this.ulname;
	}
	public void setUlname(String _ulname) {
		this.ulname = _ulname;
	}
	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUgender() {
		return this.ugender;
	}
	public void setUgender(String _ugender) {
		this.ugender = _ugender;
	}
	public String getUaddress1() {
		return this.uaddress1;
	}
	public void setUaddress1(String _uaddress1) {
		this.uaddress1 = _uaddress1;
	}
	public String getUphone() {
		return this.uphone;
	}
	public void setUphone(String _uphone) {
		this.uphone = _uphone;
	}
	public String getUpass() {
		return this.upass;
	}
	public void setUpass(String _upass) {
		this.upass = _upass;
	}
	public Date getDob() {
		return this.dob;
	}
	public void setDob(Date _dob) {
		this.dob = _dob;
	}
	public Date getUcreatedOn() {
		return this.ucreatedOn;
	}
	public void setUcreatedOn(Date _ucreatedOn) {
		this.ucreatedOn = _ucreatedOn;
	}

	@Override
	public String toString() {
		return "User["+getUserId()+","+getUfname()+","+getUlname()+","+getUgender()+","+getUaddress1()+","+getUphone()+","+getUpass()+","+getDob()+","+getUcreatedOn()+"]";
	}
}
