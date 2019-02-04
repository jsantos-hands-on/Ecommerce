package br.com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class Controller extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		String taskName = req.getParameter("taskName");

		if (taskName == null)
			throw new IllegalArgumentException("Task invalid!");

		Class<?> taskType;
		try {
			taskType = Class.forName("br.com.web."+taskName);
			Task taskInstance = (Task) taskType.newInstance();
			String page = taskInstance.execute(req, resp);

			RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

	}

}
