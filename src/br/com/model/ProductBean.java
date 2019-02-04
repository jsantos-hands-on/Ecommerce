package br.com.model;

import java.util.Hashtable;

public class ProductBean {

	private int id;
	private String name;
	private String price;
	private Hashtable<String, String> mistakes;

	public ProductBean() {
		id = -1;
		name = "";
		price = "";
		mistakes = new Hashtable<String, String>();//Irá armazenar as mensagens de erro
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/*
	 * Será verificado cada parâmetro passado e caso seja encontrado 
	 * algum erro, uma mensagem será adicionada sinalizando o erro.
	 */
	public boolean isValid() {

		boolean flag = true;

		if (name == null || name.equals("")) {
			mistakes.put("name", "Tip a valid name for the product!");
			flag = false;
		}

		if (price == null || price.equals("")) {
			mistakes.put("price", "Tip a valid price for the product!");
			flag = false;
		}

		return flag;
	}

	public String getMistakes(String key) {

		String message = mistakes.get(key);

		return (message == null) ? "" : message;
	}

	public void setMistakes(String key, String message) {

		mistakes.put(key, message);
	}
}
