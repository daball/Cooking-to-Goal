/**
 * 
 */
package com.customfit.ctg.test;


import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import com.customfit.ctg.*;
import com.customfit.ctg.model.MeasurableUnit;
import com.customfit.ctg.model.MeasurementUnit;
import com.customfit.ctg.model.NutritionFacts;
import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.model.RecipeIngredient;

/**
 * Tests the 
 * @author David
 */
public class RecipeManagementTests extends TestCase {

	private static final String TEST_RECIPE_NAME			= "Test Recipe";
	private static final String TEST_RECIPE_DESCRIPTION 	= "This is a recipe description.";
	private static final String TEST_RECIPE_INSTRUCTIONS 	= "Sample instructions.";
	private static final MeasurableUnit
								TEST_RECIPE_SERVING_SIZE 	= new MeasurableUnit(1.0, "Serving");
	private static final double TEST_RECIPE_SERVINGS 		= 1.0;
	private static final double TEST_RECIPE_RATING 			= 1.0;
	private static List<RecipeIngredient>
								TEST_RECIPE_INGREDIENTS 	= new ArrayList<RecipeIngredient>();
	private static NutritionFacts TEST_RECIPE_NUTRITION_FACTS = null;

	private Recipe testRecipe = null;

	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//launch app normally
		Controller.main(new String[]{ });
		
		//stir up some ingredients
		TEST_RECIPE_INGREDIENTS.add(new RecipeIngredient("Sugar", 1.0, MeasurementUnit.USAUnits.CUPS));
		TEST_RECIPE_INGREDIENTS.add(new RecipeIngredient("Spice", 2.5, MeasurementUnit.USAUnits.TABLESPOONS));

		//add some nutrition info
		//since it is for a Recipe, we want an empty table
		TEST_RECIPE_NUTRITION_FACTS = NutritionFacts.EmptyNutritionFactsTable;
		TEST_RECIPE_NUTRITION_FACTS.setCalories(100.0);
				
		//set up basic test recipe from all the components
		this.testRecipe = new Recipe(TEST_RECIPE_NAME, TEST_RECIPE_DESCRIPTION, TEST_RECIPE_INSTRUCTIONS, TEST_RECIPE_SERVING_SIZE, TEST_RECIPE_SERVINGS, TEST_RECIPE_RATING, TEST_RECIPE_INGREDIENTS, TEST_RECIPE_NUTRITION_FACTS);
		
		//tell the database to store it
		Controller.getDataDriver().insertRecipe(this.testRecipe);
	}
	
	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//clear recipe ingredients for next run
		this.TEST_RECIPE_INGREDIENTS.clear();
		
		//go to sleep 0.5 second
		Thread.currentThread().sleep(500);
		
		//tell the database to delete test recipe
		Controller.getDataDriver().deleteRecipeByName(this.testRecipe.getName());
		
		//hide main frame
		Controller.getMainFrame().setVisible(false);
		
		//and close it
		Controller.getMainFrame().dispose();
	}
	
	public void testBrowseRecipes()
	{
		//call browse recipes
		RecipeManagement.browseRecipes();
		assertTrue(true);
	}
	
	public void testCreateRecipe()
	{
		//call create recipe
		RecipeManagement.createRecipe();
		assertTrue(true);
	}
	
	public void testCreateRecipe2()
	{
		String testName = TEST_RECIPE_NAME + " - testCreateRecipe2()";
		Recipe testRecipe = new Recipe(testName, TEST_RECIPE_DESCRIPTION, TEST_RECIPE_INSTRUCTIONS, TEST_RECIPE_SERVING_SIZE, TEST_RECIPE_SERVINGS, TEST_RECIPE_RATING, TEST_RECIPE_INGREDIENTS, TEST_RECIPE_NUTRITION_FACTS);
		
		//call create recipe
		assertTrue(RecipeManagement.createRecipe(testRecipe));

		boolean found = false;
		//find it		
		for (Recipe recipe : Controller.getDataDriver().selectAllRecipes())
		{
			System.out.println("!!!!!!!!!!!Found " + recipe.getName());
			if (recipe.getName().equals(testRecipe.getName()))
			{
				found = true;
				//now delete it
				Controller.getDataDriver().deleteRecipeByName(testName);
				break;
			}
		}
		
		assertTrue(found);
	}

	public void testViewRecipe()
	{
		RecipeManagement.viewRecipe(this.testRecipe);
		assertTrue(true);
	}
	
	public void testEditRecipe()
	{
		RecipeManagement.editRecipe(this.testRecipe);
		assertTrue(true);
	}
	
	public void testUpdateRecipe()
	{
		String testName = TEST_RECIPE_NAME + " - testUpdateRecipe()";
		Recipe testRecipe = new Recipe(testName, TEST_RECIPE_DESCRIPTION, TEST_RECIPE_INSTRUCTIONS, TEST_RECIPE_SERVING_SIZE, TEST_RECIPE_SERVINGS, TEST_RECIPE_RATING, TEST_RECIPE_INGREDIENTS, TEST_RECIPE_NUTRITION_FACTS);
		
		//tell data driver to create recipe
		Controller.getDataDriver().insertRecipe(testRecipe);

		//make it different
		testRecipe.setName(testRecipe.getName() +  " - UPDATED!");
		testRecipe.setDescription("THIS HAS BEEN UPDATED OK!");
		
		//now update it
		assertTrue(RecipeManagement.updateRecipe(testName, testRecipe));
		
		//now test it
		boolean found = false;
		//find it		
		for (Recipe recipe : Controller.getDataDriver().selectAllRecipes())
		{
			if (recipe.getName().equals(testRecipe.getName()))
			{
				found = true;
				//now delete it
				Controller.getDataDriver().deleteRecipeByName(testRecipe.getName());
				break;
			}
		}
		
		assertTrue(found);
	}

	public void testDeleteRecipe()
	{
		String testName = TEST_RECIPE_NAME + " - testDeleteRecipe()";
		Recipe testRecipe = new Recipe(testName, TEST_RECIPE_DESCRIPTION, TEST_RECIPE_INSTRUCTIONS, TEST_RECIPE_SERVING_SIZE, TEST_RECIPE_SERVINGS, TEST_RECIPE_RATING, TEST_RECIPE_INGREDIENTS, TEST_RECIPE_NUTRITION_FACTS);
		
		//tell data driver to create recipe
		Controller.getDataDriver().insertRecipe(testRecipe);

		for (Recipe recipe : Controller.getDataDriver().selectAllRecipes())
		{
			if (recipe.getName().equals(testRecipe.getName()))
			{
				//delete it
				assertTrue(RecipeManagement.deleteRecipe(recipe));
				break;
			}
		}
	}
}
