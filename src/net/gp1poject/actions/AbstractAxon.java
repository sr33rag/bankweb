package net.gp1poject.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public abstract class AbstractAxon implements IAction {

	protected String url = null;
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	protected HttpSession session=null;
	protected Map<String,String> errors;

	public abstract void preExecute();

	@Override
	public void execute(HttpServletRequest _req, HttpServletResponse _res) {
		this.req = _req;
		this.res = _res;
		errors = new HashMap<String, String>();
		preExecute();
		processRequest();
		postExecute();
	}

	public abstract void processRequest();

	public abstract void postExecute();
	
	protected void redirect() {
		try {
			res.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void forward() {
		try {
			req.getRequestDispatcher(url).forward(req, res);
		} catch (ServletException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	

}
