package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ConnectionPool;
import br.com.dao.UserDAO;
import br.com.model.UserBean;


public class CreatUser implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		UserBean user = (UserBean) req.getAttribute("user");
		boolean flag = false;

		try (Connection connection = new ConnectionPool().getConnection()) {

			UserDAO userDAO = new UserDAO(connection);

			flag = userDAO.insert(user);
      
		} catch (SQLException | ParseException e) {

			e.printStackTrace();
		}

		if (flag) {
			user.setMistakes("result", "The user creat with sucess!");
			return "formUser.jsp";
		} else {
			user.setMistakes("result", "The user" + user.getLogin() + "already exist!");
			return "UserFormRetry.jsp";
		}
	}
}
