package com.customfit.ctg;

import com.customfit.ctg.model.*;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * The composite model of our data.
 * 
 * @author Drew
 */
public class MealPlanner { // implements Observable
	
	private ArrayList<User> userList = new ArrayList<User>();			// Stores all the User objects
	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();		// Stores all the Recipe objects
	private ArrayList<Recipe> menuList = new ArrayList<Recipe>();		// Stores Recipe objects for weekly menu

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Initializes the model with data
	 */
	public MealPlanner(){
		generateTestData();	// Delete me when data IO is ready
		notifyObservers();
	}
	
	/**
	 * Creates a new user and adds them to the list
	 */
	// FIXME
	public void createUser(){
		User newUser = new User("");
		userList.add(newUser);
	}
	
	/**
	 * Adds a user to the list
	 * @param u A User object
	 */
	public void addUser(User u){
		userList.add(u);
	}
	
	/**
	 * Removes a User from the list
	 * @param u A user object
	 */
	public void removeUser(User u){
		userList.remove(u);
	}
	
	/**
	 * Retrieves the entire list of users.
	 * @return Array List of User objects
	 */
	public ArrayList<User> getAllUsers(){
		return this.userList;
	}
	
	/**
	 * Add an observer to this model
	 * @param o
	 */
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	/**
	 * Notify observers when this model changes.
	 */
	public void notifyObservers(){
		Iterator<Observer> it = observers.iterator();
		
		while(it.hasNext()){
			Observer o = (Observer) it.next();
			o.update();
		}
	}


	//---------------- Delete me at some point --------------------------//
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
