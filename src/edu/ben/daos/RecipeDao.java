package edu.ben.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.ben.models.Recipe;

public class RecipeDao {
	private static String TABLE_NAME = "cookbook.recipedatabase ";
	private static String TABLE_NAME2 = "cookbook.tag";
	private static String TABLE_NAME3 = "cookbook.recipetagrelation";
	private static String TABLE_NAME4 = "cookbook.picdatabase";
	
	public LinkedList<Recipe> list;

	DBConnector connector = new DBConnector();

	Connection conn = connector.getConnection();
	private LinkedList<Recipe> results;

	public void addRecipe(String title, String recipeFile, String ethnicity, String preference, String mealtype,
			int mealcooktime, String mealtemp) {
		String sql = "INSERT INTO " + TABLE_NAME + " (title, recipeFile) VALUES ('" + title.toLowerCase() + "', '" + recipeFile.toLowerCase()
				+ "')";
		String sql2 = "INSERT INTO " + TABLE_NAME2
				+ " (tagethnicity, tagpreference, tagmealtype, tagmealcooktime, tagmealtemp) VALUES " + "('"
				+ ethnicity.toLowerCase() + "', '" + preference.toLowerCase() + "', '" + mealtype.toLowerCase() + "', '" + mealcooktime + "', '" + mealtemp.toLowerCase() + "')";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addRelationshipTag();

	}
	
	private void addRelationshipTag() {
		String sql = "SELECT idrecipeDatabase FROM " + TABLE_NAME; 
		String sql2 = "SELECT idtag FROM " + TABLE_NAME2;
		
		PreparedStatement ps;
		ResultSet rs;
		int idrecipeDatabase = 0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.last();
			idrecipeDatabase = rs.getInt("idrecipeDatabase");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		PreparedStatement ps2;
		ResultSet rs2 = null;
		int idtag = 0;
		try {
			ps2 = conn.prepareStatement(sql2);
			rs2 = ps2.executeQuery();
			rs2.last();
			idtag = rs2.getInt("idtag");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sq3 = "INSERT INTO " + TABLE_NAME3 + " (idtag, idrecipeDatabase) VALUES ('" + idtag + "', '" + idrecipeDatabase + "')";
		
		PreparedStatement ps3;
		try {
			ps3 = conn.prepareStatement(sq3);
			ps3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public LinkedList<Recipe> searchForRecipe(String ethnicity, String cookTime) {
		list = new LinkedList<Recipe>();
		String sql;
		String sql2;
		
		sql = "SELECT idtag FROM " + TABLE_NAME2 + " WHERE tagmealcooktime<=" + " '" + Integer.parseInt(cookTime) + "' AND tagethnicity=" + " '" + ethnicity.toLowerCase() + "'";
		
			System.out.println(sql);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2;
			ResultSet rs2;
			while (rs.next()) {
				sql2 = "SELECT * FROM " + TABLE_NAME + " WHERE idrecipeDatabase= " + "'" +  rs.getInt("idtag") + "'";
				ps2 = conn.prepareStatement(sql2);
				rs2 = ps2.executeQuery();
				rs2.next();
				Recipe newRecipe = new Recipe(rs2.getString("title"), rs2.getString("recipeFile"),
						rs2.getInt("recipeRating"));
				list.add(newRecipe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public LinkedList<Recipe> getList() {
		return list;
	}
	public LinkedList<Recipe> displayRecipe() {
	 LinkedList<Recipe>	results = new LinkedList<Recipe>();
		String sql;
		String sql2;
		
		sql = "SELECT * FROM " + TABLE_NAME;
		
			System.out.println(sql);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Recipe newRecipe = new Recipe(rs.getString("title"), rs.getString("recipeFile"),
						rs.getInt("recipeRating"));
				results.add(newRecipe);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}
	
	
	public Recipe getRecipeByTitle(String title) {
		String sql = "SELECT * FROM " + TABLE_NAME + " WHERE title=" + "'" + title + "'";
		
		PreparedStatement ps;
		ResultSet rs;
		Recipe newRecipe = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			
			newRecipe = new Recipe(rs.getString("title"), rs.getString("recipeFile"), rs.getInt("recipeRating"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		
		return newRecipe;
		
	}
	
	
	public void addRatingAndComment(String comment, int rating, String title) {
		String sql = "UPDATE " + TABLE_NAME + " SET recipeRating=" + rating + " WHERE title=" + "'" + title + "'";
		String sql2 = "UPDATE " + TABLE_NAME + " SET recipeComment=" + "'"+ comment + "'" + " WHERE title=" + "'" + title + "'";
		
		PreparedStatement ps, ps2;
//		ResultSet rs, rs2;
		try {
			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
			
			ps2 = conn.prepareStatement(sql2);
//			rs2 = ps2.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	
	public void deleteRecipe(String title) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE title=" + "'" + title + "'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Delete Recipe");
		
	}
	
	
	
	
	
	
	
	
	
}
