package br.com.model;

public class Validator {

	final String word;

	public Validator(String password) {
		this.word = password;
	}

	public boolean hasAlphabetic() {

		char[] characters = this.word.toCharArray();

		for (char character : characters) {
			if (Character.isAlphabetic(character)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasUpperCase() {

		char[] characters = this.word.toCharArray();

		for (char character : characters) {
			if (Character.isUpperCase(character)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasDigit() {

		char[] characters = this.word.toCharArray();

		for (char character : characters) {
			if (Character.isDigit(character)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasSpecialCharacters() {

		char[] characters = this.word.toCharArray();

		for (char character : characters) {
			if (!Character.isAlphabetic(character) && !Character.isDigit(character)) {
				return true;
			}
		}
		return false;
	}

}
