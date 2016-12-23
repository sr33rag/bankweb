package net.gp1poject.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Transfer implements Serializable {
	private int transferid=0;
	private Account tFromAcc=null,toAcc=null;
	private double tamount=0.00;
	private Date transferDate=null;
	
	public Transfer(int _transferId) {
		setTransferid(_transferId);
	}
	
	public Transfer(int _transferid, Account _tFromAcc, Account _toAcc, double _tamount, Date _transferDate) {
		setTransferid(_transferid);
		settFromAcc(_tFromAcc);
		setToAcc(_toAcc);
		setTamount(_tamount);
		setTransferDate(_transferDate);
	}

	public int getTransferid() {
		return this.transferid;
	}

	public void setTransferid(int _transferid) {
		this.transferid = _transferid;
	}

	public Account gettFromAcc() {
		return this.tFromAcc;
	}

	public void settFromAcc(Account _tFromAcc) {
		this.tFromAcc = _tFromAcc;
	}

	public Account getToAcc() {
		return this.toAcc;
	}

	public void setToAcc(Account _toAcc) {
		this.toAcc = _toAcc;
	}

	public double getTamount() {
		return this.tamount;
	}

	public void setTamount(double _tamount) {
		this.tamount = _tamount;
	}

	public Date getTransferDate() {
		return this.transferDate;
	}

	public void setTransferDate(Date _transferDate) {
		this.transferDate = _transferDate;
	}
	
	@Override
	public String toString() {
		return "["+getTransferid()+","+getToAcc()+","+gettFromAcc()+","+getTamount()+","+getTransferDate()+"]";
	}	
}
