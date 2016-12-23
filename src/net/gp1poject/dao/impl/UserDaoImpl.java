package net.gp1poject.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import net.gp1poject.dao.IUserDao;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	@Override
	public User selectByid(int uid) {
		User user = null;
		query = "SELECT `ufname`,`ulname`,`uemail`,`ugender`,`udob`,`uaddress1`,`uphone`,`upass`,`ucreatedOn` FROM tblusers WHERE userid=?;";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(uid, rs.getString("ufname"),
						rs.getString("ulname"), rs.getString("uemail"),
						rs.getString("ugender"), rs.getString("uaddress1"),
						rs.getString("uphone"), rs.getString("upass"),
						rs.getDate("udob"), rs.getTimestamp("ucreatedOn"));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		System.out.println(user);
		return user;
	}

	@Override
	public User saveUser(User user) {
		int genId=0;
		query = "INSERT INTO tblusers(`ufname`,`ulname`,`ugender`, `uemail`,`udob`,`uaddress1`,`uphone`,`upass`) VALUES (?,?,?,?,?,?,?,?);";
		try {
			connect();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUfname());
			ps.setString(2, user.getUlname());
			ps.setString(3, user.getUgender());
			ps.setString(4, user.getUemail());
			ps.setDate(5, new Date(user.getDob().getTime()));
			ps.setString(6, user.getUaddress1());
			ps.setString(7, user.getUphone());
			ps.setString(8, user.getUpass());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while (rs.next()) {
				genId=rs.getInt(1);
			}
			user.setUserId(genId);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		query = "UPDATE tblusers SET `upass`=?, `uaddress1`=? AND `uphone`=? WHERE `userid`=?";
		try {
			connect();
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUpass());
			ps.setString(2, user.getUaddress1());
			ps.setString(3, user.getUphone());
			ps.setInt(4, user.getUserId());
			ps.executeUpdate();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
	}

}
