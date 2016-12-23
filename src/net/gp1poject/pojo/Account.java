package net.gp1poject.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Account implements Serializable {

	private int accountId=0;
	private User user=null;
	private String atype=null;
	private double balance=0.00;
	private Date acreatedOn=null;
	private boolean active=false;
	
	public Account(int _accountId) {
		setAccountId(_accountId);
	}
	
	public Account(int _accountId,String _atype, double _balance, Date _acreatedOn, boolean _active) {
		setAccountId(_accountId);
		setAtype(_atype);
		setBalance(_balance);
		setAcreatedOn(_acreatedOn);
		setActive(_active);
	}
	
	public Account(int _accountId,String _atype, User _user, double _balance, Date _acreatedOn, boolean _active) {
		this(_accountId,_atype,_balance,_acreatedOn,_active);
		setUser(_user);
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int _accountId) {
		this.accountId = _accountId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User _user) {
		this.user = _user;
	}

	public String getAtype() {
		return this.atype;
	}

	public void setAtype(String _atype) {
		this.atype = _atype;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double _balance) {
		this.balance = _balance;
	}

	public Date getAcreatedOn() {
		return this.acreatedOn;
	}

	public void setAcreatedOn(Date _acreatedOn) {
		this.acreatedOn = _acreatedOn;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean _active) {
		this.active = _active;
	}
		
}
