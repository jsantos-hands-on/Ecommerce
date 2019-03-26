package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUser implements Task{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		
		
		return "UserFormRetry.jsp";
	}

}
