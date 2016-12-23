package net.gp1poject.dao;

import java.io.Serializable;

import net.gp1poject.pojo.User;

public interface IUserDao extends Serializable {
	public User selectByid(int _uid);

	public User saveUser(User _user);

	public void updateUser(User _user);
}
