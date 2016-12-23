package net.gp1poject.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;

import net.gp1poject.dao.IAccountDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class AccountDaoImpl extends BaseDaoImpl implements IAccountDao {

	@Override
	public Account saveAccount(Account acc) {
		int genid=0;
		query = "INSERT INTO tblaccounts(`auser`,`aType`,`balance`,`acreatedOn`,`active`) VALUES (?,?,?,?,?);";
		try {
			connect();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, acc.getUser().getUserId());
			ps.setString(2, acc.getAtype());
			ps.setDouble(3, acc.getBalance());
			ps.setTimestamp(4, (java.sql.Timestamp) acc.getAcreatedOn());
			ps.setBoolean(5, acc.isActive());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while (rs.next()) {
				genid=rs.getInt(1);				
			}
			acc.setAccountId(genid);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return acc;
	}

	@Override
	public void updateAccount(Account acc) {
		query = "UPDATE tblaccounts SET balance=? WHERE accountId=?;";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getAccountId());
			ps.executeUpdate();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void deleteAccount(Account acc) {
		query = "UPDATE tblaccounts SET active=? WHERE accountId=?;";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setBoolean(1, false);
			ps.setInt(2, acc.getAccountId());
			ps.executeUpdate();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public Account selectByid(int id) {
		Account acc = null;
		query = "SELECT `auser`, `atype`, `balance`, `acreatedOn`, `active` FROM `tblaccounts` WHERE `accountid`=?;";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				acc = new Account(id,
						rs.getString("aType"), new User(rs.getInt("auser")), rs.getDouble("balance"),
						rs.getDate("acreatedOn"), rs.getBoolean("active"));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return acc;
	}

	@Override
	public Account selectByUser(int userid) {
		Account acc = null;
		query = "SELECT accountid,atype,balance,acreatedon,active from tblaccounts WHERE auser=?;";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				acc = new Account(rs.getInt("accountid"),
						rs.getString("aType"), rs.getDouble("balance"),
						rs.getDate("acreatedOn"), rs.getBoolean("active"));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return acc;
	}

}
