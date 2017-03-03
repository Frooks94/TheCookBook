package edu.ben.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ben.daos.RecipeDao;
import edu.ben.models.Recipe;

/**
 * Servlet implementation class ServSearchRecipe
 */
@WebServlet("/ServSearchRecipe")
public class ServSearchRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServSearchRecipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecipeDao rDao = new RecipeDao(); 
		LinkedList<Recipe> recipeList2 = rDao.searchForRecipe(request.getParameter("ethnicity"), request.getParameter("cooktime"));
		recipeList2 = rDao.displayRecipe();
		
		request.getSession().setAttribute("recipes", recipeList2);
		System.out.println("NUM RESULTS ARE HERE: " + recipeList2.size());
//		
		
		request.getRequestDispatcher("/WEB-INF/jsp/SearchRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		session.setAttribute("ethnicity", request.getParameter("ethnicity"));
		session.setAttribute("cooktime", request.getParameter("cooktime"));
		System.out.println("cook time param" + String.valueOf(session.getAttribute("cooktime")));
		System.out.println("ethnicty param" + String.valueOf(session.getAttribute("ethnicity")));
		RecipeDao rDao = new RecipeDao();
		rDao.searchForRecipe(request.getParameter("ethnicity"), request.getParameter("cooktime"));
		request.getRequestDispatcher("/WEB-INF/jsp/SearchRecipe.jsp").forward(request, response);
//		doGet(request, response);
	}

}
