package br.com.model;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class UserBean {

	private int id;
	private String login;
	private String password;
	private String name;
	private String date;
	private Gender gender;
	private Hashtable<String, String> mistakes;

	public UserBean() {
		id = -1;
		login = "";
		password = "";
		name = "";
		date = "";
		mistakes = new Hashtable<String, String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMistakes(String key) {

		String message = mistakes.get(key);

		return (message == null) ? "" : message;
	}

	public void setMistakes(String key, String message) {
		mistakes.put(key, message);
	}

	public boolean isValid() {
		boolean flag = false;
		 Field[] fields = UserBean.this.getClass().getDeclaredFields();
		 for (Field field : fields) {
			System.out.println(fields.toString());
		}
		
		return flag;
	}
}
