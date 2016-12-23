package net.gp1poject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.gp1poject.dao.impl.ConnectionHelper;

public abstract class BaseDaoImpl {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	protected String query = null;

	protected void connect() {
     con = ConnectionHelper.getInstance().getConnection();
	}

	protected void close() {
		try {
			if (rs != null && !(rs.isClosed())) {
				rs.close();
			}
			if (ps != null && !(ps.isClosed())) {
				ps.close();
			}
			if (con != null && !(con.isClosed())) {
				con.close();
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

}
