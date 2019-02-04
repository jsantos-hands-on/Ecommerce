package br.com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {

	String execute(HttpServletRequest req, HttpServletResponse resp);
	

}
