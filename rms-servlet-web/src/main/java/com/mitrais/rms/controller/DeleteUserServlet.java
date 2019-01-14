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
@WebServlet("/users/delete")
public class DeleteUserServlet extends AbstractController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(authenticationCheck(req.getSession())) {
			
			UserDao userDao = UserDaoImpl.getInstance();
			Optional<User> optUser = userDao.find(Long.parseLong(req.getParameter("id")));
			if(!optUser.isPresent()) {
				resp.sendRedirect(req.getContextPath()+"/users/notfound");
			}else {
				req.setAttribute("user", optUser.get());
				doPost(req, resp);
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao userDao = UserDaoImpl.getInstance();
		User toDelete = (User) req.getAttribute("user");
		if(userDao.delete(toDelete)) {
			resp.sendRedirect(req.getContextPath()+"/users/list");
		}else {
			resp.sendRedirect(req.getContextPath()+"/users/failed");
		}
	}

}
