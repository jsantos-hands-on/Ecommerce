package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowProducts implements Task {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

			return "/WEB-INF/pages/ShowProducts.html";
	}

}
