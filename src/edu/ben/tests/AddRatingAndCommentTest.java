package edu.ben.tests;

import org.junit.Test;

import edu.ben.daos.RecipeDao;

public class AddRatingAndCommentTest {

	@Test
	public void test() {
		RecipeDao rDao = new RecipeDao();
		rDao.addRatingAndComment("This works great", 5, "Stuffed Chicken Valentino");
	
	
	}

}
