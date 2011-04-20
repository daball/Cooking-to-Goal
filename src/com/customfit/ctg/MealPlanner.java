package com.customfit.ctg;

import com.customfit.ctg.gui.*;
import com.customfit.ctg.gui.manageusers.GUIManageUsersPanel;
import com.customfit.ctg.model.*;
import java.util.*;

/**
 * Contains the controller logic for the CTG application.
 * @author Drew
 */
public class MealPlanner {

	//private GUIFrameMain parentFrame;
	
	private static ArrayList<User> userList = new ArrayList<User>();			// Stores all the User objects
	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();		// Stores all the Recipe objects
	private static ArrayList<Recipe> menuList = new ArrayList<Recipe>();		// Stores Recipe objects for weekly menu
	
	/**
	 * Initialize the program with a reference to the GUI (view).
	 * @param pf
	 */
	//public MealPlanner(GUIFrameMain pf){
	public MealPlanner(){
		//this.parentFrame = pf;
		
		generateTestData();		// Delete me when data IO is ready
		
		//pf.setVisible(true);
	}
	
	/**
	 * Generates some test data to work with.
	 */
	private static void generateTestData(){
		/*
		 * Ryan has 1 goal of 2000 calories MAX a day
		 */
		User ryan = new User("Ryan");				// Create a User
		NutritionFacts nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(2000.0);						// Use "setters" to set goals .. here, 2000 calories
		ryan.setMaxGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		userList.add(ryan);							// add this user to the List
		
		/*
		 * Drew has 2 goals of 1800 calories MAX a day
		 *           and 100 mg? cholesterol MAX a day
		 */
		User drew = new User("Drew Salyer");				// Create a User
//		NutritionFacts nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(1800.0);						// Use "setters" to set goals .. here, 2000 calories
		nf.setCholesterol(100.0);
		drew.setMaxGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		userList.add(drew);							// add this user to the List
		
		/*
		 * David has 2 goals of 3000 calories MIN a day
		 *                  and 100 g? carbs a day
		 */
		User david = new User("David A. Ball, Dr. Spaz!!");				// Create a User
//		NutritionFacts nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(3000.0);						// Use "setters" to set goals .. here, 2000 calories
		david.setMinGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		nf.setTotalCarbohydrate(100.0);
		nf.setCalories(0);
		david.setMaxGoals(nf);
		userList.add(david);							// add this user to the List
		
		
		/*
		 * Steven has 4 goals, 2 MIN, 2 MAX
		 */
		User steven = new User("S");				// Create a User
//		NutritionFacts nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(2200);						// Use "setters" to set goals .. here, 2000 calories
		nf.setTotalCarbohydrate(1250);
		steven.setMinGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		nf.setTotalCarbohydrate(100);
		nf.setCalories(1800);
		steven.setMaxGoals(nf);
		userList.add(steven);							// add this user to the List
		
		
		/*=============================================*/
		// Recipes
		
		Recipe r = new Recipe("Chicken Soup");
		recipeList.add(r);
		r = new Recipe("Pudding");
		recipeList.add(r);
	}
	
	public static ArrayList<User> getUserList() {
		GUIManageUsersPanel manageUsersPanel = new GUIManageUsersPanel();
		Controller.getMainFrame().openPanel(manageUsersPanel);
		return userList;
	}
	
	public static List<Recipe> getRecipeList() {
		List<Recipe> recipeList = Controller.getDataDriver().selectAllRecipes();
		return recipeList;
	}
}
