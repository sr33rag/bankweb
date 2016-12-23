package net.gp1poject.dao.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.gp1poject.dao.ITransferDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.Transfer;

@SuppressWarnings("serial")
public class TransferDaoImpl extends BaseDaoImpl implements ITransferDao {

	@Override
	public Transfer saveTransfer(Transfer transfer) {
		int genid = 0;
		query = "INSERT INTO tbltransfers (`tFromAcc`,`toAcc`,`tamount`) VALUES (?,?,?);";
		try {
			connect();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, transfer.gettFromAcc().getAccountId());
			ps.setInt(2, transfer.getToAcc().getAccountId());
			ps.setDouble(3, transfer.getTamount());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while (rs.next()) {
				genid = rs.getInt(1);
			}
			transfer.setTransferid(genid);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return transfer;
	}

	@Override
	public List<Transfer> selectByFrmAcc(int fromid) {
		List<Transfer> fromTransfers = null;
		query = "SELECT `toAcc`,`tamount`,`transferDate` FROM `tbltransfers` WHERE `tFromAcc`=?;";
		try {
			fromTransfers = new ArrayList<Transfer>();
			connect();
			ps = con.prepareStatement(query);
			ps.setInt(1, fromid);
			rs = ps.executeQuery();
			while (rs.next()) {
				fromTransfers.add(new Transfer(0, new Account(fromid),
						new Account(rs.getInt("toAcc")), rs
								.getDouble("tamount"), rs
								.getTimestamp("transferDate")));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return fromTransfers;
	}

	@Override
	public List<Transfer> selectByToAcc(Transfer transfer) {
		List<Transfer> toTransfers = null;
		query = "SELECT `tFromAcc`,`tamount`,`transferDate` FROM `tbltransfers` WHERE `toAcc`=?;";
		try {
			toTransfers = new ArrayList<Transfer>();
			connect();
			ps = con.prepareStatement(query);
			ps.setInt(1, transfer.getToAcc().getAccountId());
			rs = ps.executeQuery();
			while (rs.next()) {
				toTransfers.add(new Transfer(transfer.getTransferid(),
						new Account(rs.getInt("tFromAcc")), new Account(rs
								.getInt("toAcc")), rs.getDouble("tamount"), rs
								.getDate("transferDate")));
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			close();
		}
		return toTransfers;
	}

}
