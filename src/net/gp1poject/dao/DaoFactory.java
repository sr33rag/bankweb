package net.gp1poject.dao;

import net.gp1poject.dao.impl.AccountDaoImpl;
import net.gp1poject.dao.impl.TransferDaoImpl;
import net.gp1poject.dao.impl.UserDaoImpl;

public class DaoFactory {

	private static DaoFactory daoFactory=null;
	private DaoFactory() {
	}
	
	public static DaoFactory getInstance() {
		if(daoFactory == null)
			daoFactory = new DaoFactory();
		return daoFactory;
	}
	
	public IUserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	public ITransferDao getTransferDao() {
		return new TransferDaoImpl();
	}
	
	public IAccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
}
