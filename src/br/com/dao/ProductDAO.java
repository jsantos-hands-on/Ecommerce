package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.model.Product;

public class ProductDAO {

	private Connection connection;
	
	public ProductDAO(Connection connection) {

		this.connection = connection;
	}

	public boolean insert(Product product) throws SQLException {

		boolean flag = false;
		
		try(PreparedStatement statement = connection.prepareStatement("INSERT INTO product(name, price) values(?, ?)")){
			statement.setString(1, product.getName());
			statement.setDouble(2, product.getPrice());
			flag = !statement.execute();
		}
		
		return flag;
	}

}
