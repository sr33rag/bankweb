package net.gp1poject.actions;

@SuppressWarnings("serial")
public class LogoutAxon extends AbstractAxon {

	@Override
	public void preExecute() {

	}

	@Override
	public void processRequest() {
		session = req.getSession(false);
		session.removeAttribute("acc");
		session.invalidate();
		url="home.do";
	}

	@Override
	public void postExecute() {
		redirect();
	}

}
