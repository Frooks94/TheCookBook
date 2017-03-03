package edu.ben.models;

import java.sql.Blob;

public class Recipe {
	private String title;
	private String recipeFile;
	private int recipeRating;
	private String recipePic;
	
	public Recipe(String title, String recipeFile, int recipeRating) {
		this.title = title;
		this.recipeFile = recipeFile;
		this.recipeRating = recipeRating;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRecipeFile() {
		return recipeFile;
	}

	public void setRecipeFile(String recipeFile) {
		this.recipeFile = recipeFile;
	}

	public int getRecipeRating() {
		return recipeRating;
	}

	public void setRecipeRating(int recipeRating) {
		this.recipeRating = recipeRating;
	}

	public String getRecipePic() {
		return recipePic;
	}

	public void setRecipePic(String recipePic) {
		this.recipePic = recipePic;
	}
	
	
	
	
	
}
