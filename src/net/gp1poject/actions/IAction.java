package net.gp1poject.actions;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction extends Serializable {
   void execute(HttpServletRequest req, HttpServletResponse res);
}
