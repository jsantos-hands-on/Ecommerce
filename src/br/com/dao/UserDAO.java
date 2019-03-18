package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.model.UserBean;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {

		this.connection = connection;
	}

	public boolean insert(UserBean newUser) throws SQLException, ParseException {

		boolean flag = false;

		if (this.select(newUser.getLogin()) == null) {

			System.out.println("executing statement!");

			String query = "INSERT INTO user(login, password, name, dateBirth, gender) values(?, ?, ?, ?, ?)";

			try (PreparedStatement statement = connection.prepareStatement(query)) {

				statement.setString(1, newUser.getLogin());
				statement.setString(2, newUser.getPassword());
				statement.setString(3, newUser.getName());

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = format.parse(newUser.getDateBirth());
				java.sql.Date dateSql = new java.sql.Date(date.getTime());
				statement.setDate(4, dateSql);

				statement.setString(5, newUser.getGender());

				flag = !statement.execute();
			}
		}
		return flag;
	}

	public UserBean select(String login) throws SQLException {

		String query = "SELECT * FROM user WHERE login=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, login);
			boolean flag = statement.execute();

			if (flag) {
				try (ResultSet rs = statement.getResultSet()) {
					while (rs.next()) {
						int userId = rs.getInt("id");
						String userLogin = rs.getString("login");
						String userPassword = rs.getString("password");
						String userName = rs.getString("name");
						String userDateBirth = rs.getDate("dateBirth").toString();
						String userGender = rs.getString("gender");
						UserBean user = new UserBean();

						user.setId(userId);
						user.setLogin(userLogin);
						user.setPassword(userPassword);
						user.setName(userName);
						user.setDateBirth(userDateBirth);
						user.setGender(userGender);
						System.out.println("return user!");
						return user;
					}
				}
			}
		}
		System.out.println("return null!");
		return null;
	}
}
