package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUser implements Task{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		req.setAttribute("user", session.getAttribute("user"));
		
		return "UserFormRetry.jsp?taskName=UpdateUser";
	}

}
