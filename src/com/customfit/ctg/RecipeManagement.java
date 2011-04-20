package com.customfit.ctg;

import com.customfit.ctg.data.*;
import com.customfit.ctg.model.*;
import java.util.*;

/**
 * The RecipeManagement facility, used as a section of the total
 * application Controller logic, represents the actions that
 * directly involve recipe management.
 * 
 * @author David
 */
public class RecipeManagement {

	/**
	 * Activates Browse Recipes application feature, which displays
	 * a Browse Recipes JPanel in the main JFrame from the list
	 * of all known recipes in the Controller's default database.
	 */
	public static void browseRecipes()
	{
		//recipes not provided, so go get them
		List<Recipe> recipes = Controller.getDataDriver().selectAllRecipes();

		//now pass them to the overloaded method
		browseRecipes(recipes);
	}
	
	/**
	 * Activates Browse Recipes application feature, which displays
	 * a Browse Recipes JPanel in the main JFrame with the recipes
	 * you have provided.
	 * 
	 * @param recipes The list of recipes to browse through. 
	 */
	public static void browseRecipes(List<Recipe> recipes)
	{
		//method stub:
		//	TODO: replace this CLI-code with GUI-initiation code
		System.out.println("browseRecipes() recipe listing (by name):");
		for (Recipe recipe : recipes)
			System.out.println("\t" + recipe.getName());
		/* 
		 * example pseudocode:
		 * 		instantiate JPanel for listing recipes (browse/search/etc.)
		 * 		pass recipes to a special function in JPanel for processing List<Recipe>
		 * 		Controller.getMainFrame().openPanel( list panel )
		 */
	}
	
	/**
	 * Activates Create Recipe application feature, which in this case
	 * displays a Create Recipe JPanel to prepare a new Recipe object
	 * for storage. If you already have a Recipe object, use the
	 * overloaded method.
	 */
	public static void createRecipe()
	{
		//method stub:
		//	TODO: insert GUI-initiation code and remove this CLI error message
		System.err.println("createRecipe() hit. Not currently implemented.");
		/* 
		 * example pseudocode:
		 * 		instantiate JPanel for creating new Recipe
		 * 		Controller.getMainFrame().openPanel( list panel )
		 */
	}
	
	/**
	 * Activates Create Recipe application feature, which in this case
	 * sends the Recipe object over to the Controller's default data driver.
	 * 
	 * This method is also used as a callback from the Create Recipe JPanel
	 * upon saving the newly created Recipe.
	 * 
	 * @param recipe The completed Recipe object ready to store.
	 * 
	 * @return Boolean indicating the success of the operation. 
	 */
	public static boolean createRecipe(Recipe recipe)
	{
		//send it over to the database
		return Controller.getDataDriver().insertRecipe(recipe);
	}

	/**
	 * Activates View Recipe application feature, which displays
	 * a View Recipe JPanel to display the contents of the provided
	 * Recipe object.
	 * 
	 * @param recipe The recipe to show in view.
	 */
	public static void viewRecipe(Recipe recipe)
	{
		//method stub:
		//	replace this CLI-code with GUI-initiation code
		System.out.println("viewRecipe(): Recipe " + "Name" + ": " + recipe.getName());
		System.out.println("\tviewRecipe(): Recipe " + "Description" + ":\n" + recipe.getDescription());
		System.out.println("\tviewRecipe(): Recipe " + "Instructions" + ":\n" + recipe.getInstructions());
		System.out.println("\tviewRecipe(): Recipe " + "Rating" + ": " + recipe.getRating());
		System.out.println("\tviewRecipe(): Recipe " + "Serving Size" + ": " + recipe.getServingSize());
		System.out.println("\tviewRecipe(): Recipe " + "Ingredients" + ":\n" + recipe.getIngredients());
		System.out.println("\tviewRecipe(): Recipe " + "Nutrition Information" + ":\n" + recipe.getNutritionInformation());
		/* 
		 * example pseudocode:
		 * 		instantiate JPanel for viewing Recipe
		 * 		pass recipe to a special function in JPanel for processing List<Recipe>
		 * 		Controller.getMainFrame().openPanel( list panel )
		 * TODO: replace this with GUI initialization code for Create Recipes
		 */
	}
	
	/**
	 * Activates Edit Recipe application feature, which displays
	 * a Edit Recipe JPanel to permit end user to edit the contents of the
	 * provided Recipe object.
	 * 
	 * @param recipe The recipe to edit in view.
	 */
	public static void editRecipe(Recipe recipe)
	{
		//method stub:
		//	replace this CLI-code with GUI-initiation code
		System.err.println("editRecipe() hit: Recipe " + "Name" + ": " + recipe.getName() + ". Feature not currently implemented.");
		/* 
		 * example pseudocode:
		 * 		instantiate JPanel for viewing Recipe
		 * 		pass recipe to a special function in JPanel for processing List<Recipe>
		 * 		Controller.getMainFrame().openPanel( list panel )
		 * TODO: replace this with GUI initialization code for Create Recipes
		 */
	}
	
	/**
	 * Activates Update Recipe application feature, which updates the Recipe
	 * record in the database.
	 * 
	 * @param originalRecipeName The recipe's original name, used to locate the recipe in the database.
	 * @param newRecipe The new recipe data.
	 * 
	 * @return Boolean indicating the success of the operation. 
	 */
	public static boolean updateRecipe(String originalRecipeName, Recipe newRecipe)
	{
		return Controller.getDataDriver().updateRecipeByName(originalRecipeName, newRecipe);
	}
	
	/**
	 * Activates Delete Recipe application feature, which deletes the Recipe
	 * record in the database.
	 * 
	 * @param recipeName The recipe's name, used to locate the recipe in the database.
	 * 
	 * @return Boolean indicating the success of the operation. 
	 */
	public static boolean deleteRecipe(String recipeName)
	{
		return Controller.getDataDriver().deleteRecipeByName(recipeName);
	}
	
	/**
	 * Activates Delete Recipe application feature, which deletes the Recipe
	 * record in the database.
	 * 
	 * @param recipe The recipe name to delete.
	 * 
	 * @return Boolean indicating the success of the operation. 
	 */
	public static boolean deleteRecipe(Recipe recipe)
	{
		return deleteRecipe(recipe.getName());
	}
}
