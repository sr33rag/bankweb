package net.gp1poject.actions;

@SuppressWarnings("serial")
public class ToEditProfileAxon extends AbstractAxon {

	@Override
	public void preExecute() {

	}

	@Override
	public void processRequest() {
		url = "editprofile.jsp";
	}

	@Override
	public void postExecute() {
		forward();
	}

}
