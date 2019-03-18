package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.ConnectionPool;
import br.com.dao.UserDAO;
import br.com.model.UserBean;
import br.com.model.Validator;

public class Acess implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String password = req.getParameter("password");
		String login = req.getParameter("login");

		Validator validator = new Validator(password);

		if ((password.length() >= 6) && validator.hasAlphabetic() && validator.hasDigit()
				&& validator.hasSpecialCharacters() && validator.hasUpperCase()) {

			try {
				Connection connection = new ConnectionPool().getConnection();
				UserDAO userDAO = new UserDAO(connection);
				UserBean user = userDAO.select(login);

				if (user != null) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(10);
					return "user.jsp";
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return "user.jsp";
	}

}
