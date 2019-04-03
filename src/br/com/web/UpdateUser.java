package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.ConnectionPool;
import br.com.dao.UserDAO;
import br.com.model.UserBean;

public class UpdateUser implements Task{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		

		UserBean user = (UserBean) req.getAttribute("user");
		boolean flag = false;
		
		System.out.println(user.getId());
		
		try(Connection connection = new ConnectionPool().getConnection()){
			
			UserDAO userDAO = new UserDAO(connection);
			flag = userDAO.update(user);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
				
		if(flag) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			return "index.jsp";
		}
			
		
		return "/WEB-INF/pages/ErrorPage.jsp";
	}

}
