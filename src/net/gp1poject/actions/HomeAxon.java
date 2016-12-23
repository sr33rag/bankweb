package net.gp1poject.actions;

import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class HomeAxon extends AbstractAxon {

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
			user = acc.getUser();
			if (acc == null || user == null) {
				url = "login.jsp";
			} else {
				url = "viewprofile.do";
			}
		} catch (Exception e) {
			url = "login.jsp";
		}

	}

	@Override
	public void postExecute() {
		redirect();
	}

}
