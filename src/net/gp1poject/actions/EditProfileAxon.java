package net.gp1poject.actions;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.IUserDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class EditProfileAxon extends AbstractAxon {

	private IUserDao userDao = null;
	private Account acc = null;
	private User user = null, newUser = null;
	private String upass = null, uphone = null, uaddress = null;

	private final String FIELD_PASS = "txtPassword";
	private final String FIELD_PHONE = "txtContact";
	private final String FIELD_ADD = "txtAddress";

	@Override
	public void preExecute() {
		upass = (String) req.getParameter(FIELD_PASS);
		uphone = (String) req.getParameter(FIELD_PHONE);
		uaddress = (String) req.getParameter(FIELD_ADD);
	}

	@Override
	public void processRequest() {
		session = req.getSession(false);
		try {
			acc = (Account) session.getAttribute("acc");
			user = acc.getUser();
			if (acc == null || user == null) {
				url = "home.do";
			} else {
				newUser = new User(user.getUserId(), user.getUfname(),
						user.getUlname(), user.getUemail(), user.getUgender(),
						uaddress, uphone, upass, user.getDob(),
						user.getUcreatedOn());
				userDao = DaoFactory.getInstance().getUserDao();
				userDao.updateUser(newUser);
				acc.setUser(newUser);
				session.setAttribute("acc", acc);
				url = "viewprofile.do";
			}
		} catch (Exception e) {
			url = "home.do";
		}
	}

	@Override
	public void postExecute() {
		forward();
	}

}
