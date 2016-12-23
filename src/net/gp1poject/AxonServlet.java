package net.gp1poject;

import java.io.IOException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gp1poject.actions.IAction;

/**
 * Gp1Poject implementation class AxonServlet
 */
@SuppressWarnings("serial")
public class AxonServlet extends HttpServlet {

	private Map<String, IAction> actionMap = null;
	String ending = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap = new HashMap<String, IAction>();
		actionMap.put("home", new net.gp1poject.actions.HomeAxon());
		actionMap.put("login", new net.gp1poject.actions.LoginAxon());
		actionMap.put("logout", new net.gp1poject.actions.LogoutAxon());
		actionMap.put("tosignup", new net.gp1poject.actions.ToSignUpAxon());
		actionMap.put("toeditprofile", new net.gp1poject.actions.ToEditProfileAxon());
		actionMap.put("editprofile", new net.gp1poject.actions.EditProfileAxon());
		actionMap.put("createprofile", new net.gp1poject.actions.CreateProfileAxon());
		actionMap.put("viewprofile", new net.gp1poject.actions.ViewProfileAxon());
		actionMap.put("viewtransfers", new net.gp1poject.actions.ViewTransfersAxon());
		actionMap.put("totransfer", new net.gp1poject.actions.ToTransferAxon());
		actionMap.put("transfer", new net.gp1poject.actions.TransferAxon());
		actionMap.put("deactivate", new net.gp1poject.actions.DeactivateAxon());
		ending = config.getInitParameter("ending");
	}

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String reqPath = null;
		reqPath = req.getPathInfo();
		if (reqPath == null) {
			reqPath = (String) req
					.getAttribute("javax.servlet.include.request_uri");
		} else {
			reqPath = (String) req
					.getAttribute("javax.servlet.include.request_pathinfo");
		}
		if (reqPath == null) {
			reqPath = req.getRequestURI().substring(
					req.getContextPath().length());
			reqPath = reqPath.substring(1, reqPath.length() - ending.length());
		}
		System.out.println(reqPath + " was accessed on " + new Date());
		if (null != reqPath)
			getAction(reqPath).execute(req, res);
		else
			res.sendRedirect("/index.jsp");
	}

	private IAction getAction(String _reqPath) {
		IAction action = null;
		if (_reqPath != null)
			action = actionMap.get(_reqPath.toLowerCase());
		return action;
	}

}
