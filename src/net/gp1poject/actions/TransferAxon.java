package net.gp1poject.actions;

import java.util.Date;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.IAccountDao;
import net.gp1poject.dao.ITransferDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.Transfer;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class TransferAxon extends AbstractAxon {

	private ITransferDao transferDao = null;
	private IAccountDao accountDao = null;
	private Account acc = null;
	private User user = null;
	private String toAcc = null, amt = null;

	private final String FIELD_TOACC = "txtBenficiaryAccNo";
	private final String FIELD_AMT = "txtAmount";

	@Override
	public void preExecute() {
		toAcc = (String) req.getParameter(FIELD_TOACC);
		amt = (String) req.getParameter(FIELD_AMT);
	}

	@Override
	public void processRequest() {
		double amount = 0.00, balance = 0.00;
		Account newAcc = null;
		session = req.getSession(false);
		try {
			acc = (Account) session.getAttribute("acc");
			user = acc.getUser();
			if (acc == null || user == null) {
				url = "home.do";
			} else {
				amount = Double.parseDouble(amt);
				balance = acc.getBalance() - amount;
				transferDao = DaoFactory.getInstance().getTransferDao();
				accountDao = DaoFactory.getInstance().getAccountDao();
				newAcc = accountDao.selectByid(Integer.parseInt(toAcc));
				if (newAcc == null) {
					url = "home.do";
				} else {
					transferDao.saveTransfer(new Transfer(0, acc, newAcc,
							amount, new Date()));
					acc.setBalance(acc.getBalance() - amount);
					newAcc.setBalance(newAcc.getBalance() + amount);
					accountDao.updateAccount(acc);
					accountDao.updateAccount(newAcc);
					session.setAttribute("acc", acc);
					url = "viewprofile.do";
				}
			}
		} catch (Exception e) {
			url = "home.do";
		}
	}

	@Override
	public void postExecute() {
		redirect();
	}

}
