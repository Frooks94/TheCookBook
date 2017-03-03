package edu.ben.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.mailDispatcher.Send;

/**
 * Servlet implementation class ServContact
 */
@WebServlet("/ServContact")
public class ServContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/Contact.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String fName = request.getParameter("firstname");
		String lName = request.getParameter("lastname");
		String fromEmail = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = "The following email was sent by " + fName + " " + lName + ". Their email address is " + fromEmail + ".\n\n";
		message += request.getParameter("message");
		
		String toEmail = "thecookbookhelp@gmail.com";
	    final String username = "thecookbookhelp";
	    final String password = "cookBook1";
	    Send.email(fromEmail, username, password, toEmail, subject, message);
	    
	    response.sendRedirect("ServContact");
		
	}

}
