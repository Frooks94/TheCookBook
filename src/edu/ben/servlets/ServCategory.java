package edu.ben.servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ben.daos.RecipeDao;
import edu.ben.models.Recipe;

/**
 * Servlet implementation class ServCategory
 */
@WebServlet("/ServCategory")
public class ServCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 	RecipeDao rDao = new RecipeDao(); 
			LinkedList<Recipe> recipeList = new LinkedList<Recipe>();
			recipeList = rDao.displayRecipe(); 
			

			
			request.getSession().setAttribute("recipes", recipeList);
			
		request.getRequestDispatcher("/WEB-INF/jsp/Category.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
