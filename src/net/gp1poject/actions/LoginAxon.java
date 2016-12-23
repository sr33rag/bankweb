package net.gp1poject.actions;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.IAccountDao;
import net.gp1poject.dao.IUserDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class LoginAxon extends AbstractAxon {

	private String txtloginid = null, txtpass = null;
	private IUserDao userDao = null;
	private IAccountDao accountDao=null;
	private final String FIELD_LOGIN = "txtloginid",
			FIELD_PASSWORD = "txtpass";
	private final String ERROR_FIELD = "errorNotification";

	@Override
	public void preExecute() {
		txtloginid = (String) req.getParameter(FIELD_LOGIN);
		txtpass = (String) req.getParameter(FIELD_PASSWORD);
	}

	@Override
	public void processRequest() {
		Account acc = null;
		userDao = DaoFactory.getInstance().getUserDao();
		User user = userDao.selectByid(Integer.parseInt(txtloginid));
		if (user != null) {
			accountDao = DaoFactory.getInstance().getAccountDao();
			acc = accountDao.selectByUser(user.getUserId());
			acc.setUser(user);
			if (txtpass.equals(user.getUpass()) && acc.isActive()) {
				session = req.getSession(true);				
				session.setAttribute("acc", acc);
				url = "home.do";
			} else {
				session.setAttribute("haserrors",true);
				errors.put(ERROR_FIELD, "Please recheck userid/password or your account may be deactivated.");
				req.setAttribute("errors", errors);
				url = "home.do";
			}
		}
	}

	@Override
	public void postExecute() {
		forward();
	}

}
