package net.gp1poject.actions;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.IAccountDao;
import net.gp1poject.pojo.Account;

@SuppressWarnings("serial")
public class DeactivateAxon extends AbstractAxon {

	private Account acc = null;
	private IAccountDao accountDao = null;

	@Override
	public void preExecute() {
	}

	@Override
	public void processRequest() {
		session = req.getSession(false);
		try {
			acc = (Account) session.getAttribute("acc");
			if (acc == null) {
				url = "home.do";
				redirect();
			} else {
				accountDao = DaoFactory.getInstance().getAccountDao();
				accountDao.deleteAccount(acc);
				session.removeAttribute("acc");
				session.invalidate();
				url = "home.do";
				redirect();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void postExecute() {
	}

}
