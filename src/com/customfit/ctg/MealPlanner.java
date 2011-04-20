package com.customfit.ctg;

import com.customfit.ctg.model.*;
import java.util.ArrayList;



/**
 * The composite model of our data.
 * @author Drew
 */
public class MealPlanner {
	
	private static ArrayList<User> userList = new ArrayList<User>();			// Stores all the User objects
	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();		// Stores all the Recipe objects
//	private static ArrayList<Recipe> menuList = new ArrayList<Recipe>();		// Stores Recipe objects for weekly menu
	
	/**
	 * Initializes the model with data
	 */
	public MealPlanner(){
		generateTestData();		// Delete me when data IO is ready
	}
	/**
	 * Generates some test data to work with.
	 */
	private void generateTestData(){
		/*
		 * Ryan has 1 goal of 2000 calories MAX a day
		 */
		User ryan = new User("Ryan");				// Create a User
		NutritionFacts nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(2000.0);						// Use "setters" to set goals .. here, 2000 calories
		ryan.getActiveNutritionPlan().setMaximumGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		userList.add(ryan);							// add this user to the List
		
		/*
		 * Drew has 2 goals of 1800 calories MAX a day
		 *           and 100 mg? cholesterol MAX a day
		 */
		User drew = new User("Drew Salyer");				// Create a User
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(1800.0);						// Use "setters" to set goals .. here, 2000 calories
		nf.setCholesterol(100.0);
		drew.getActiveNutritionPlan().setMaximumGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		userList.add(drew);							// add this user to the List
		
		/*
		 * David has 2 goals of 3000 calories MIN a day
		 *                  and 100 g? carbs a day
		 */
		User david = new User("David A. Ball, Dr. Spaz!!");				// Create a User
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(3000.0);						// Use "setters" to set goals .. here, 2000 calories
		david.getActiveNutritionPlan().setMinimumGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(3000.0);						// Use "setters" to set goals .. here, 2000 calories
		nf.setTotalCarbohydrate(100.0);
		nf.setCalories(0);
		david.getActiveNutritionPlan().setMaximumGoals(nf);
		userList.add(david);							// add this user to the List
		
		
		/*
		 * Steven has 4 goals, 2 MIN, 2 MAX
		 */
		User steven = new User("S");				// Create a User
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(2200);						// Use "setters" to set goals .. here, 2000 calories
		nf.setTotalCarbohydrate(1250);
		steven.getActiveNutritionPlan().setMinimumGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setTotalCarbohydrate(100);
		nf.setCalories(1800);
		steven.getActiveNutritionPlan().setMaximumGoals(nf);
		userList.add(steven);							// add this user to the List
		
		
		/*=============================================*/
		// Recipes
		
		Recipe r = new Recipe("Chicken Soup");
		recipeList.add(r);
		r = new Recipe("Pudding");
		recipeList.add(r);
	}
}
