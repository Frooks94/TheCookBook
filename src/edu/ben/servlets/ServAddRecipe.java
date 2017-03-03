package edu.ben.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.daos.RecipeDao;

/**
 * Servlet implementation class ServAddRecipe
 */
@WebServlet("/ServAddRecipe")
public class ServAddRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServAddRecipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/AddRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeDao rDao = new RecipeDao();
		rDao.addRecipe(request.getParameter("title"), request.getParameter("recipeFile"), request.getParameter("tagethnicity"), request.getParameter("tagpreference"), request.getParameter("tagmealtype"), Integer.parseInt(request.getParameter("tagmealcooktime")), request.getParameter("tagmealtemp"));
		request.getRequestDispatcher("/WEB-INF/jsp/AddRecipe.jsp").forward(request, response);
	}

}
