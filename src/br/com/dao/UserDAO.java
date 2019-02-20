package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public boolean insert(UserBean user) throws SQLException, ParseException {

		boolean flag = false;
		String query = "INSERT INTO user(login, password, name, dateBirth, gender) values(?, ?, ?, ?, ?)";
		
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(user.getDateBirth());
			java.sql.Date dateSql = new java.sql.Date(date.getTime());
			statement.setDate(4, dateSql);
			
			statement.setString(5, user.getGender());
			
			flag = !statement.execute();
		}
		
		return flag;
	}
	
	

}
