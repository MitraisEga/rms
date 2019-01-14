package com.mitrais.rms.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.dao.impl.UserDaoImpl;
import com.mitrais.rms.model.User;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/users/create")
public class CreateUserServlet extends AbstractController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (authenticationCheck(req.getSession())) {
			String path = getTemplatePath(req.getServletPath());
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (authenticationCheck(req.getSession())) {
			User user = new User((long) 0, req.getParameter("username").toString(),
					req.getParameter("userpass").toString());

			UserDao userDao = UserDaoImpl.getInstance();
			if (userDao.save(user)) {
				resp.sendRedirect(req.getContextPath() + "/users/list");
			} else {
				doGet(req, resp); // return to page
			}
		}else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

}
