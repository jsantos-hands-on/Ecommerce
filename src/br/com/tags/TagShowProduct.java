package br.com.tags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import br.com.dao.ConnectionPool;
import br.com.dao.ProductDAO;
import br.com.model.ProductBean;

public class TagShowProduct extends SimpleTagSupport {

	private String whatType;

	public void setWhatType(String whatType) {
		
		this.whatType = whatType;
	}

	@Override
	public void doTag() throws JspException, IOException {

		try (Connection connection = new ConnectionPool().getConnection()) {

			ProductDAO productDAO = new ProductDAO(connection);
			List<ProductBean> products = productDAO.selectByprice(whatType);
			getJspContext().setAttribute("products", products);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
