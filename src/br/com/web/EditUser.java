package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditUser implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		req.setAttribute("user", session.getAttribute("user"));
		String taskKey = req.getParameter("taskKey");

		if (taskKey != null) {
			if (req.getParameter("taskKey").equals("password")) {
				return "PasswordProcessor.jsp";
			}
		}

		return "UserFormRetry.jsp?taskName=EditUser";
	}

}
