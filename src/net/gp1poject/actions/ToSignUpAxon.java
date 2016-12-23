package net.gp1poject.actions;

@SuppressWarnings("serial")
public class ToSignUpAxon extends AbstractAxon {

	@Override
	public void preExecute() {
	}

	@Override
	public void processRequest() {
		url="userprofile.jsp";
	}

	@Override
	public void postExecute() {
		forward();
	}

}
