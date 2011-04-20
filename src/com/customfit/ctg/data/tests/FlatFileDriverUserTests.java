package com.customfit.ctg.data.tests;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.customfit.ctg.data.DataManager;
import com.customfit.ctg.model.NutritionFacts;
import com.customfit.ctg.model.User;

import junit.framework.TestCase;

/**
 * Tests the Recipe functions in FlatFileDriver.
 * @author David
 */
public class FlatFileDriverUserTests extends TestCase {

	private static ArrayList<User> userList = new ArrayList<User>();			// Stores all the User objects

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
		User steven = new User("Steven");				// Create a User
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setCalories(2200);						// Use "setters" to set goals .. here, 2000 calories
		nf.setTotalCarbohydrate(1250);
		steven.getActiveNutritionPlan().setMinimumGoals(nf);						// if user wants 2000 calorie max, use setMaxGoals and pass it the NF object we just created
		nf = new NutritionFacts();	// Create a NutritionFacts to store nutritional info
		nf.setTotalCarbohydrate(100);
		nf.setCalories(1800);
		steven.getActiveNutritionPlan().setMaximumGoals(nf);
		userList.add(steven);							// add this user to the List
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	public void testInsert()
	{
		for (User user : this.userList)
			assertTrue(DataManager.acquireFlatFileDriver().insertUser(user));
	}
	
	public void testSelectAll()
	{
		List<User> users = DataManager.acquireFlatFileDriver().selectAllUsers();
		for (User user : users)
		{
			System.out.println("selectAll() found user " + user.getName());
		}
		assertTrue (users.size() >= 3);
	}
	
	public void testSelectOne()
	{
		List<User> users = DataManager.acquireFlatFileDriver().selectUsersByName("Ryan");
		for (User user : users)
		{
			System.out.println("selectOne() found user " + user.getName());
		}
		assertTrue (users.size() == 1);
	}
	
	public void testModify()
	{
		for (User user : this.userList)
		{
			String prevName = user.getName();
			user.setName("MODIFIED " + user.getName());
			assertTrue(DataManager.acquireFlatFileDriver().updateUserByName(prevName, user));
		}
		List<User> users = DataManager.acquireFlatFileDriver().selectAllUsers();
		for (User user : users)
		{
			System.out.println("selectAll() found user " + user.getName());
			assertTrue(user.getName().startsWith("MODIFIED "));
		}
		assertTrue (users.size() >= 3);
	}
	
	public void testDelete()
	{
		List<User> users = DataManager.acquireFlatFileDriver().selectAllUsers();
		for (User user : users)
		{
			assertTrue(DataManager.acquireFlatFileDriver().deleteUserByName(user.getName()));
		}
	}
}
