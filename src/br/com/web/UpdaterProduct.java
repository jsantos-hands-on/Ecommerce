package br.com.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ConnectionPool;
import br.com.dao.ProductDAO;
import br.com.model.ProductBean;

public class UpdaterProduct implements Task{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		boolean flag = false;
		
		try(Connection connection = new ConnectionPool().getConnection()){

			ProductDAO productDAO = new ProductDAO(connection);
			ProductBean product = (ProductBean) req.getAttribute("product");
			flag = productDAO.Update(product);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(flag)
			return "controller?taskName=ShowProducts";
		
		return "/WEB-INF/pages/productFail.html";
	}

}
