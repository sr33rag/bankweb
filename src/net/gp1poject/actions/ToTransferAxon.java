package net.gp1poject.actions;

@SuppressWarnings("serial")
public class ToTransferAxon extends AbstractAxon {

	@Override
	public void preExecute() {
	}

	@Override
	public void processRequest() {
		url="transferForm.jsp";
	}

	@Override
	public void postExecute() {
		forward();
	}

}
