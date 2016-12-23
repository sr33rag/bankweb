package net.gp1poject.dao;

import java.io.Serializable;

import net.gp1poject.pojo.Account;

public interface IAccountDao extends Serializable {
	public Account selectByid(int _id);
	public Account selectByUser(int userid);
  public Account saveAccount(Account _acc);
  public void updateAccount(Account _acc);
  public void deleteAccount(Account _acc);
}
