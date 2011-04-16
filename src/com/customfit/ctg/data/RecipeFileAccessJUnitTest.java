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
public class RecipeFileAccessJUnitTest extends TestCase {

	//CONSTANTS
	private static final String TEST_RECIPE_NAME = "Test Recipe";
	private static final String TEST_RECIPE_DESCRIPTION = "This is a recipe description.";
	private static final String TEST_RECIPE_INSTRUCTIONS = "Sample instructions.";
	private static final int 	TEST_RECIPE_SERVING_SIZE = 1;
	private static final double TEST_RECIPE_RATING = 1.0;

	private Recipe testRecipe;
	private RecipeFileAccess rfa;
	
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
		this.rfa = new RecipeFileAccess();
	}
	
	/**
	 * Tests saving a serialized object.
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public void testSave() throws FileNotFoundException, IOException
	{
		//store the test object
		this.rfa.saveObject(this.testRecipe);
		
		//grab file info
	    File destDir = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
		File file = new File(destDir.getCanonicalPath() + File.separator + this.testRecipe.getName() + "-serialized.dat");
		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);
		
		//make sure file it was saved
		assertTrue(file.exists());
		
		//tell the user the contents in console
		System.out.println("testSave(): Saved test file with contents:");
		String line = "";
		while ( (line = bReader.readLine()) != null)
			System.out.println(line);

		//close readers
		bReader.close();
		fReader.close();
		
		//delete test file
		if (file.delete() == false)
			System.err.println("testSave(): Could not delete test file.");
		else
			System.out.println("testSave(): Deleted test recipe file.");
		System.out.println("testSave(): Test completed.");
	}
	
	/**
	 * Tests saving a serialized object.
	 * @throws FileNotFoundException 
	 * @throws IOException
	 */
	public void testGet() throws FileNotFoundException, IOException
	{
		//store the test object
		this.rfa.saveObject(this.testRecipe);
		
		//grab file info
	    File destDir = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
		File file = new File(destDir.getCanonicalPath() + File.separator + this.testRecipe.getName() + "-serialized.dat");
		FileReader fReader = new FileReader(file);
		BufferedReader bReader = new BufferedReader(fReader);
		
		//make sure file it was saved
		assertTrue(file.exists());
		
		//tell the tester the contents in console
		System.out.println("testGet(): Saved test file.");
		String line = "";
		while ( (line = bReader.readLine()) != null)
			System.out.println(line);

		//close readers
		bReader.close();
		fReader.close();
		
		//now go get the newly created object
		Recipe recipe = this.rfa.get(TEST_RECIPE_NAME);

		System.out.println("testGet(): Retrieved test recipe using the get(String) function.");

		//now make sure that everything matches after deserialization
		assertEquals(recipe.getName(), TEST_RECIPE_NAME);
		assertEquals(recipe.getDescription(), TEST_RECIPE_DESCRIPTION);
		assertEquals(recipe.getInstructions(), TEST_RECIPE_INSTRUCTIONS);
		assertEquals(recipe.getRating(), TEST_RECIPE_RATING);
		assertEquals(recipe.getServingSize(), TEST_RECIPE_SERVING_SIZE);
		//disabled tests:
		//assertEquals(recipe.getIngredients(), TEST_RECIPE_INGREDIENTS);
		//assertEquals(recipe.getNutrition(), TEST_RECIPE_NUTRITION_INFO);
		System.out.println("testGet(): Recipe " + "Name" + "=" + recipe.getName());
		System.out.println("testGet(): Recipe " + "Description" + "=" + recipe.getDescription());
		System.out.println("testGet(): Recipe " + "Instructions" + "=" + recipe.getInstructions());
		System.out.println("testGet(): Recipe " + "Rating" + "=" + recipe.getRating());
		System.out.println("testGet(): Recipe " + "Serving Size" + "=" + recipe.getServingSize());
		
		//delete test file
		if (file.delete() == false)
			System.err.println("testGet(): Could not delete test file.");
		else
			System.out.println("testGet(): Deleted test recipe file.");

		System.out.println("testGet(): Test completed.");
	}

	/**
	 * @throws java.lang.Exception
	 */
//	@After
//	public void tearDown() throws Exception {
//	}

}
