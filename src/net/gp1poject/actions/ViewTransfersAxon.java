package net.gp1poject.actions;

import java.util.List;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.ITransferDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.Transfer;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class ViewTransfersAxon extends AbstractAxon {

	private ITransferDao transferDao = null;
	private Account acc = null;
	private User user = null;

	@Override
	public void preExecute() {
	}

	@Override
	public void processRequest() {
		session = req.getSession(false);
		try {
			acc = (Account) session.getAttribute("acc");
			if (acc == null) {
				url="home.do";
			} else {
				user = acc.getUser();
				transferDao = DaoFactory.getInstance().getTransferDao();
				List<Transfer> transfers = transferDao.selectByFrmAcc(user.getUserId());
				System.out.println("Transfers:"+transfers.size());
				session.setAttribute("transfers", transfers);
				url = "transferhistory.jsp";
			}
		} catch (Exception e) {
			url = "home.do";
		}		
	}

	@Override
	public void postExecute() {
		forward();
	}

}
