/**
 * 
 */
package com.customfit.ctg.data;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import com.customfit.ctg.*;
import com.customfit.ctg.data.*;
import java.io.*;

/**
 * @author David
 *
 */
public class FlatFileDriverTestCase extends TestCase {

	//CONSTANTS
	private static final String TEST_RECIPE_NAME = "Test Recipe";
	private static final String TEST_RECIPE_DESCRIPTION = "This is a recipe description.";
	private static final String TEST_RECIPE_INSTRUCTIONS = "Sample instructions.";
	private static final int 	TEST_RECIPE_SERVING_SIZE = 1;
	private static final double TEST_RECIPE_RATING = 1.0;

	private Recipe testRecipe;
	private FlatFileDriver rfa;
	
	/**
	 * @throws java.lang.Exception
	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}

	/**
	 * @throws java.lang.Exception
	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//set up basic test object
		this.testRecipe = new Recipe(TEST_RECIPE_NAME, TEST_RECIPE_DESCRIPTION, TEST_RECIPE_INSTRUCTIONS, TEST_RECIPE_SERVING_SIZE, TEST_RECIPE_RATING, null, null);
		
		//set up file access
		this.rfa = new FlatFileDriver();
	}

	public void testConnect() throws IOException
	{
		System.out.println("testConnect(): Test beginning.");
		System.out.println("\ttestConnect(): Test empty connect().");
		assertTrue(this.rfa.connect());
		System.out.println("\ttestConnect(): Test connect(data dir).");
		assertTrue(this.rfa.connect(this.rfa.getRecipeDataDirectory().getCanonicalPath()));
		System.out.println("\ttestConnect(): Test isConnected().");
		assertTrue(this.rfa.isConnected());
		System.out.println("testConnect(): Test completed.");
	}
	
	/**
	 * Tests saving a serialized object.
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public void testInsertRecipe() throws FileNotFoundException, IOException
	{
		System.out.println("testInsertRecipe(): Test beginning.");
		
		//store the test object
		this.rfa.insertRecipe(this.testRecipe);
		
		//grab file info
	    File destDir = this.rfa.getRecipeDataDirectory(); //recipes data directory
		File file = new File(destDir.getCanonicalPath() + File.separator + this.testRecipe.getName() + FlatFileDriver.RECIPE_FILE_SUFFIX);
		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);
		
		//make sure file it was saved
		assertTrue(file.exists());
		
		//tell the user the contents in console
		System.out.println("\ttestInsertRecipe(): Saved test file with contents:");
		String line = "";
		while ( (line = bReader.readLine()) != null)
			System.out.println("\t" + line);

		//close readers
		bReader.close();
		fReader.close();
		
		//delete test file
		boolean deleted = false;
		if ((deleted = file.delete()) == false)
			System.err.println("\ttestInsertRecipe(): Could not delete test file.");
		else
			System.out.println("\ttestInsertRecipe(): Deleted test recipe file.");
		System.out.println("testInsertRecipe(): Test completed.");
		
		assertTrue(deleted);
		}
	
	/**
	 * Tests saving a serialized object.
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public void testSelectRecipe() throws FileNotFoundException, IOException
	{
		System.out.println("testSelectRecipe(): Test beginning.");
		
		//store the test object
		this.rfa.insertRecipe(this.testRecipe);
		
		//grab file info
	    File destDir = this.rfa.getRecipeDataDirectory(); //recipes data directory
		File file = new File(destDir.getCanonicalPath() + File.separator + this.testRecipe.getName() + FlatFileDriver.RECIPE_FILE_SUFFIX);
		
		//make sure file it was saved
		assertTrue(file.exists());
		
		//tell the tester the contents in console
		System.out.println("\ttestSelectRecipe(): Saved test recipe.");
		
		//now go get the newly created object
		Recipe recipe = this.rfa.selectRecipeByName(TEST_RECIPE_NAME);

		System.out.println("\ttestSelectRecipe(): Retrieved test recipe using the get(String) function.");

		//now make sure that everything matches after deserialization
		assertEquals(recipe.getName(), TEST_RECIPE_NAME);
		assertEquals(recipe.getDescription(), TEST_RECIPE_DESCRIPTION);
		assertEquals(recipe.getInstructions(), TEST_RECIPE_INSTRUCTIONS);
		assertEquals(recipe.getRating(), TEST_RECIPE_RATING);
		assertEquals(recipe.getServingSize(), TEST_RECIPE_SERVING_SIZE);
		//disabled tests:
		//assertEquals(recipe.getIngredients(), TEST_RECIPE_INGREDIENTS);
		//assertEquals(recipe.getNutrition(), TEST_RECIPE_NUTRITION_INFO);
		System.out.println("\ttestSelectRecipe(): Recipe " + "Name" + "=" + recipe.getName());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Description" + "=" + recipe.getDescription());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Instructions" + "=" + recipe.getInstructions());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Rating" + "=" + recipe.getRating());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Serving Size" + "=" + recipe.getServingSize());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Ingredients" + "=" + recipe.getIngredients());
		System.out.println("\ttestSelectRecipe(): Recipe " + "Nutrition Information" + "=" + recipe.getNutrition());
		
		//delete test file
		boolean deleted = false;
		if ((deleted = file.delete()) == false)
			System.err.println("\ttestSelectRecipe(): Could not delete test file.");
		else
			System.out.println("\ttestSelectRecipe(): Deleted test recipe file.");

		System.out.println("testSelectRecipe(): Test completed.");
		assertTrue(deleted);
	}

	/**
	 * @throws java.lang.Exception
	 */
//	@After
//	public void tearDown() throws Exception {
//	}

}