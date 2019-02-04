package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ConnectionPool;
import br.com.dao.ProductDAO;
import br.com.model.ProductBean;

public class RegisterProduct implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		ProductBean product = (ProductBean) req.getAttribute("product");

		boolean flag = false;

		try (Connection connection = new ConnectionPool().getConnection()) {

			ProductDAO productDAO = new ProductDAO(connection);
			flag = productDAO.insert(product);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (flag) {
			return "/WEB-INF/pages/productSucess.html";
		}
		return "/WEB-INF/pages/productFail.html";
	}

}
