package edu.ben.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.daos.UserDao;

/**
 * Servlet implementation class ServLogin
 */
@WebServlet("/ServLogin")
public class ServLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add a session variable for when the user logins in
		if (loginToAccount(request.getParameter("userName"), request.getParameter("pWord"))) {
			System.out.println("Logged In");
			if (checkRole(request.getParameter("userName"))) {
				response.sendRedirect("ServAdmin");
			} else {
				response.sendRedirect("ServHome");
			}
			
			request.getSession().setAttribute("userName", request.getParameter("userName"));
//			createSession(request, response, request.getParameter("userName"));
		} else {
			System.out.println("Did not login");
			request.setAttribute("message", "User name or login is incorrect");
			response.sendRedirect("ServHome");
		}

	}


	private boolean loginToAccount(String userName, String password) {
		UserDao uDao = new UserDao();
		if (userName.equals(null) || password.equals(null)) {
			return false;
		} else if (uDao.userLogin(userName, password)) {
			return true;
		} else {
			return false;
		}

	}
	
	private boolean checkRole(String userName) {
		UserDao uDao = new UserDao();
		return uDao.checkRole(userName);
	}
	
	private void createSession(HttpServletRequest request, HttpServletResponse response, String userName) {
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		System.out.println("Created user name session variable");
		
	}

	
	
	
	
	
	
	
}
