package net.gp1poject.dao;

import java.io.Serializable;
import java.util.List;

import net.gp1poject.pojo.Transfer;

public interface ITransferDao extends Serializable {
	public List<Transfer> selectByFrmAcc(int i);

	public List<Transfer> selectByToAcc(Transfer transfer);

	public Transfer saveTransfer(Transfer transfer);
}