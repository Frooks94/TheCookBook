package edu.ben.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.daos.RecipeDao;

/**
 * Servlet implementation class ServDetailPage
 */
@WebServlet("/ServDetailPage")
public class ServDetailPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServDetailPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.getSession().setAttribute("title", request.getParameter("title"));
		request.getRequestDispatcher("/WEB-INF/jsp/DetailPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in servDetailPage");
		addRatingAndComment(request.getParameter("comment"), Integer.parseInt(request.getParameter("rating")), request.getParameter("recipeName"));
		doGet(request, response);
		
	}
	
	public void addRatingAndComment(String comment, int rating, String title) {
		RecipeDao rDao = new RecipeDao();
		rDao.addRatingAndComment(comment, rating, title);
		System.out.println("added rating and comment");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
