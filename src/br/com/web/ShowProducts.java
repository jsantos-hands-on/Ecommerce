package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ConnectionPool;
import br.com.dao.ProductDAO;
import br.com.model.ProductBean;

public class ShowProducts implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		try(Connection connection = new ConnectionPool().getConnection()){

			ProductDAO productDAO = new ProductDAO(connection);
			List<ProductBean> products = productDAO.selectAll();
			
			req.setAttribute("products", products);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return "/WEB-INF/pages/ShowProducts.jsp";
	}

}
