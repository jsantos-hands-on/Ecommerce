package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.model.ProductBean;

public class ProductDAO {

	private Connection connection;

	public ProductDAO(Connection connection) {

		this.connection = connection;
	}

	public boolean insert(ProductBean product) throws SQLException {

		boolean flag = false;
		String query = "INSERT INTO product(name, price) values(?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, product.getName());
			statement.setDouble(2, Double.parseDouble(product.getPrice()));
			flag = !statement.execute();
		}

		return flag;
	}

	public List<ProductBean> selectAll() throws SQLException {

		List<ProductBean> products = new ArrayList<>();
		String query = "SELECT * FROM product";

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			if (statement.execute()) {

				ResultSet resultSet = statement.getResultSet();

				while (resultSet.next()) {

					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					Double price = resultSet.getDouble("price");

					ProductBean product = new ProductBean();

					product.setId(id);
					product.setName(name);
					product.setPrice(String.valueOf(price));

					products.add(product);
				}
			}
		}

		return products;
	}

	public boolean Update(ProductBean product) throws SQLException {

		boolean flag = false;
		String query = "UPDATE product SET name=?, price=? WHERE id=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, product.getName());
			statement.setString(2, product.getPrice());
			statement.setInt(3, product.getId());
			flag = !statement.execute();
		}

		return flag;
	}

	public boolean delete(String id) throws SQLException {

		boolean flag = false;
		String query = "DELETE FROM product where id=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, id);
			flag = !statement.execute();
		}

		return flag;
	}

	public List<ProductBean> selectByprice(String price) throws SQLException {

		String sql = "SELECT * FROM product WHERE price > ?";
		List<ProductBean> products = new ArrayList<>();
		double priceAsDouble = Double.parseDouble(price);

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setDouble(1, priceAsDouble);

			if (statement.execute()) {
				try (ResultSet rs = statement.getResultSet()) {
					while (rs.next()) {
						int productId = rs.getInt("id");
						String productName = rs.getString("name");
						Double productPrice = rs.getDouble("price");

						ProductBean product = new ProductBean();
						product.setId(productId);
						product.setName(productName);
						product.setPrice(String.valueOf(productPrice));
						products.add(product);
					}
				}
			}
		}

		return products;
	}

}
