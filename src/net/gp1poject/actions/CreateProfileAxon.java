package net.gp1poject.actions;

import java.util.Date;

import net.gp1poject.dao.DaoFactory;
import net.gp1poject.dao.IAccountDao;
import net.gp1poject.dao.IUserDao;
import net.gp1poject.pojo.Account;
import net.gp1poject.pojo.User;

@SuppressWarnings("serial")
public class CreateProfileAxon extends AbstractAxon {

	private final String FIELD_FNAME = "txtFname";
	private final String FIELD_LNAME = "txtLname";
	private final String FIELD_EMAIL = "txtEmail";
	private final String FIELD_SEX = "radioGender";
	private final String FIELD_DOB = "dtDob";
	private final String FIELD_PHONE = "txtContact";
	private final String FIELD_ADD = "txtAddress";
	private final String FIELD_PASS = "txtPassword";
	private final String FIELD_AMT = "txtAmt";
	private final String FIELD_ATYPE="selAtype";

	private String fname = null, lname = null, email=null, atype=null, sex = null, phone = null,
			add = null, pass = null;
	private Date dob = null;
	private Double amt = 0.00;

	private IAccountDao accountDao = null;
	private IUserDao userDao = null;
	private Account acc=null;
	private User user = null;

	@Override
	public void preExecute() {
		fname = (String) req.getParameter(FIELD_FNAME);
		lname = (String) req.getParameter(FIELD_LNAME);
		sex = (String) req.getParameter(FIELD_SEX);
		email = (String) req.getParameter(FIELD_EMAIL);
		phone = (String) req.getParameter(FIELD_PHONE);
		dob = new Date(req.getParameter(FIELD_DOB));
		amt = Double.parseDouble(req.getParameter(FIELD_AMT));
		atype = (String) req.getParameter(FIELD_ATYPE);
		add = (String) req.getParameter(FIELD_ADD);
		pass = (String) req.getParameter(FIELD_PASS);
	}

	@Override
	public void processRequest() {
		userDao = DaoFactory.getInstance().getUserDao();
		accountDao = DaoFactory.getInstance().getAccountDao();
		user = new User(0, fname, lname, email, sex, add, phone, pass, dob, null);
		user = userDao.saveUser(user);
		acc = new Account(0, atype ,user, amt, null, true);
		acc = accountDao.saveAccount(acc);
		session = req.getSession(true);
		session.setAttribute("acc", acc);
		url = "viewprofile.do";
	}

	@Override
	public void postExecute() {
		redirect();
	}

}
