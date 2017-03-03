package edu.ben.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.daos.UserDao;
import edu.ben.mailDispatcher.Send;
import edu.ben.models.User;

/**
 * Servlet implementation class ServRegister
 */
@WebServlet("/ServRegister")
public class ServRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServRegister() {
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
		request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		if (checkParameters(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("pWord"), request.getParameter("pWord2"), request.getParameter("userName"), request.getParameter("email"))) {
			if (registerNewUser(request.getParameter("firstName"), request.getParameter("lastName"),
					request.getParameter("pWord"), request.getParameter("userName"), request.getParameter("email"),
					request, response)) {
				sendRegistrationEmail(request.getParameter("firstName"), request.getParameter("lastName"),
				request.getParameter("pWord"), request.getParameter("pWord2"), request.getParameter("userName"), request.getParameter("email"));
				response.sendRedirect("ServHome");
			}
		} else {
			response.sendRedirect("ServRegister");
		}
	}

	private boolean checkParameters(String fName, String lName, String p, String p2, String uName, String email) {

		if (fName.equals(null) || lName.equals(null) || p.equals(null) || p2.equals(null) || uName.equals(null) || email.equals(null)) {
			return false;
		}

		char fArray[] = fName.toCharArray();
		char lArray[] = lName.toCharArray();

		for (int i = 0; i < fArray.length; i++) {
			if (!Character.isLetter(fArray[i])) {
				return false;
			}
		}

		for (int i = 0; i < lArray.length; i++) {
			if (!Character.isLetter(lArray[i])) {
				return false;
			}
		}

		if (!email.contains("@")) {
			return false;
		}
		
		if (!p.equals(p2)) {
			return false;
		}

		return true;
	}

	private boolean registerNewUser(String fName, String lName, String p, String uName, String email,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User(fName, lName, p, uName, email);
		UserDao uDao = new UserDao();

		if (uDao.userExists(u)) {
			request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
			request.setAttribute("message", "User Name is already used");
			System.out.println("User Name already exists");
			return false;
		} else {
			uDao.addUser(u);
			return true;
		}

	}
	private void sendRegistrationEmail(String fName, String lName, String p, String p2, String uName, String toEmail){
		String fromEmail = "thecookbookhelp@gmail.com";
	    final String username = "thecookbookhelp";
	    final String password = "cookBook1";
	    
	    String subject = "Congratulations on Registering! Welcome!";
	    String message = "Hello " + fName + ", \n\n\n\n Thank you for Registering!\n\n Make sure you rate and comment all "
	    		+ "over the place! Thats why we built this website!\n\n Oh and your username is: " + uName + " in case you forget." 
	    		+ "\n\nRegards, \n The CookBook Web Team";
	    Send.email(fromEmail, username, password, toEmail, subject, message);

	    
	}
}
