package com.mitrais.rms.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

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
@WebServlet("/users/edit")
public class EditUserServlet extends AbstractController {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
			Optional<User> optUser = userDao.find(Long.parseLong(req.getParameter("id").toString()));
			if(optUser.isPresent()) {
				//data found
				
				req.setAttribute("user", optUser.get());
				
				String path = getTemplatePath(req.getServletPath());
				RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
				requestDispatcher.forward(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath()+"/users/notfound");
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
		
		if(authenticationCheck(req.getSession())) {
			UserDao userDao = UserDaoImpl.getInstance();
			
			logger.info(req.getParameter("id"));
			logger.info(req.getParameter("username"));
			logger.info(req.getParameter("userpass"));
			
			Optional<User> optUser = userDao.find(Long.parseLong(req.getParameter("id")));
			if(optUser.isPresent()) {
				//continue with update
				User toUpdate = optUser.get();
				toUpdate.setUserName(req.getParameter("username"));
				toUpdate.setPassword(req.getParameter("userpass"));
				if(userDao.update(toUpdate)) {
					resp.sendRedirect(req.getContextPath()+"/users/list");
				}else {
					resp.sendRedirect(req.getContextPath()+"/users/failed");
				}
			}
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
    	
	}

}
