package br.com.model;

import java.lang.reflect.Field;
import java.util.Hashtable;

public class UserBean {

	private int id;
	private String login;
	private String password;
	private String name;
	private String dateBirth;
	private Gender gender;
	private Hashtable<String, String> mistakes;

	public UserBean() {
		id = -1;
		login = "";
		password = "";
		name = "";
		dateBirth = "";
		gender = Gender.EMPTY;
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

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String date) {
		this.dateBirth = date;
	}

	public String getGender() {
		return gender.getDescription();
	}

	public void setGender(String gender) {
		if (gender.equals("empty")) {
			this.gender = Gender.EMPTY;
		} else {
			if (gender.equals("male"))
				this.gender = Gender.MALE;
			else
				this.gender = Gender.FEMALE;
		}
	}

	public String getMistakes(String key) {

		String message = mistakes.get(key);

		return (message == null) ? "" : message;
	}

	public void setMistakes(String key, String message) {
		mistakes.put(key, message);
	}

	public boolean isValid() {
		boolean flag = true;

		Field[] fields = this.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.getType().getName().equals("java.lang.String")) {
				try {
					Object varInstance = field.get(this);
					String var = (String) varInstance;
					if (var == null || var.equals("")) {
						flag = false;
						mistakes.put(field.getName(), "Tip a " + field.getName());
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}

			} else if (field.getType().getName().equals("br.com.model.Gender")) {
				try {
					Object varInstance = field.get(this);
					Gender var = (Gender) varInstance;
					if (var.getDescription() == null || var.getDescription().equals("empty")) {
						flag = false;
						mistakes.put(field.getName(), "Tip a " + field.getName());
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public boolean passIsValid() {

		Validator validator = new Validator(this.password);

		if (this.password.length() >= 6) {
			if (validator.hasAlphabetic()) {
				if (validator.hasDigit()) {
					if (validator.hasUpperCase()) {
						if (validator.hasSpecialCharacters()) {
							return true;
						} else {
							this.mistakes.put("password", "The password must be at least one special character");
						}

					} else {
						this.mistakes.put("password", "The password must be at least one uppercase letter");
					}

				} else {
					this.mistakes.put("password", "The password must be at least one numeric character");
				}

			} else {
				this.mistakes.put("password", "The password must be at least one letter");
				return false;
			}

		} else {
			this.mistakes.put("password", "The password must be at least six characters");
			return false;
		}
		
		return true;
	}
}
