package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProduct implements Task{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		
		
		return "WEB-INF/pages/ProductFormRetry.jsp";
	}
	
	

}
