package net.gp1poject.actions;

import net.gp1poject.pojo.Account;

@SuppressWarnings("serial")
public class ViewProfileAxon extends AbstractAxon {

	private Account acc=null;
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
				redirect();
			} else {
				url="viewprofile.jsp";
				forward();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void postExecute() {
		
	}

}
