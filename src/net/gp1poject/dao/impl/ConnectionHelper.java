package net.gp1poject.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

	private final String dbUrl = "jdbc:mysql://localhost:3306/bankwebdb?zeroDateTimeBehavior=convertToNull",
			dbUser = "root", dbPass = "",
			dbDriver = "com.mysql.jdbc.Driver";

	private static ConnectionHelper instance = null;

	private ConnectionHelper() {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException cnfex) {
			System.out.println(cnfex.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ConnectionHelper getInstance() {
		if (instance == null)
			instance = new ConnectionHelper();
		return instance;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (SQLException sqlex) {
			System.out.println(sqlex.getMessage());
		}
		return con;
	}

}
