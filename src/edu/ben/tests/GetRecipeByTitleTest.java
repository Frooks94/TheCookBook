package edu.ben.tests;

import org.junit.Test;

import edu.ben.daos.RecipeDao;
import junit.framework.Assert;

public class GetRecipeByTitleTest {

	@Test
	public void test() {
		RecipeDao rDao = new RecipeDao();
		
		System.out.println(rDao.getRecipeByTitle("gyoza").getTitle());
	}

}
