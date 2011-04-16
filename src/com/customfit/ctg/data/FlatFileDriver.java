 /**
 * 
 */
package com.customfit.ctg.data;

import com.customfit.ctg.Recipe;
import java.util.*;
import java.io.*;

/**
 * @author David
 *
 */
public class FlatFileDriver implements DataDriverInterface {

	/**
	 * This is appended to file names when they are generated.
	 */
	private static final String RECIPE_FILE_SUFFIX = "-serialized.dat";
	/**
	 * 
	 */
	private File destDir = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
	
	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		if (destDir.exists()) for (File recipeFile : destDir.listFiles())
		{
		    Recipe recipe = null; //recipe storage
		    recipe = this.getRecipe(recipeFile);
		    if (recipe != null)
		    	recipes.add(recipe);
		}
		
		return recipes;
	}

	public Recipe getRecipe(String recipeName) {
	    Recipe recipe = null; //recipe storage
	    String recipeFileName = "";
	    try {
			recipeFileName = destDir.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX;
		} catch (IOException ex) {
			System.err.println("There was a problem opening target data directory for recipes. Message:");
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
		File recipeFile = new File(recipeFileName);
		if (recipeFile.exists())
			recipe = this.getRecipe(recipeFile);
		return recipe;
	}
	
	/**
	 * Returns 
	 * @param recipeFile
	 * @return
	 */
	public Recipe getRecipe(File recipeFile) {
	    ObjectInputStream iStream = null;
	    Recipe recipe = null; //recipe storage
	    
		try {
			iStream = new ObjectInputStream(new FileInputStream(recipeFile));
		}
		catch (FileNotFoundException ex) {
	    	try {
				System.err.println("There was a problem opening non-existant file at " + recipeFile.getCanonicalPath() + " for deserialization. Not sure where it could have went, but it's gone now. Message:");
			} catch (IOException e) {
				System.err.println("There was a problem opening a non-existant file for deserialization. Not sure where it could have went, but it's gone now. Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
		catch (IOException ex) {
	    	try {
				System.err.println("There was a problem opening deserialization stream for file at " + recipeFile.getCanonicalPath() + ". Message:");
			} catch (IOException e) {
				System.err.println("There was a problem opening deserialization stream for a file. Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
	    
	    //deserialize recipe from file
	    //from: http://www.exampledepot.com/egs/java.io/DeserializeObj.html
	    //be sure to go back here for specific instructions for
	    //deserializing from byte arrays, the  BLOB data type
	    //response from SQL query, probably by SQLite or Derby for now,
	    //perhaps campus-wide Oracle, MySQL, etc., later
	    
	    //NOTE to self: Ask Team Code Breakers if there would be any objection
	    //to forking the code later to a side-project for a campus-wide Java EE
	    //on the server/cloud--(if we even have a cloud, hopefully Ubuntu :~) and
	    //Java FX in the web browser for the GUI. we could set up a launcher from
	    //within radford.edu and/or the MyRU portal application, a future mobile app
	    //for within the 3G/4G campus community, and several other useful features.
	    //I could probably do it alone, but I admire community contributions. But
	    //if you aren't in our trusted zone, you'd have to use an experimental
	    //branch. Every one has a RU LDAP user name for campus-wide use. LDAP client
	    //integration for authentication and identification is super simple to implement
	    //so long as the server trusted it's application--I see no reason why it shouldn't
	    //if it ran it from home or from within the cloud of known trusted servers.
	    //I'd/We'd have to rewind all the way back to Analysis to implement this many
	    //changes, however the processes can be made to be more closely integrated.
	    //There must be a better way to view all of the combined-project phases than
	    //this manual method we are using. However irrelevant to the fact that the
	    //Rewind doesn't require a clean slate, but a complete overhaul to compensate
	    //the technology differences. There are many students that can benefit from
	    //our work(s). Since we've open-sourced the application, it can be componentized
	    //to include the differences of other universities, junior colleges, high schools,
	    //corporate communities, etc. Perhaps the easiest way to do that would be to program
	    //for multiple languages, from the beginning-out. English (College) may have it's own
	    //user interface grammar, so might English (
	    
	    try {
	    	if (iStream != null)
	    		recipe = (Recipe) iStream.readObject();
		}
	    catch (IOException ex) {
	    	try {
				System.err.println("There was a problem opening file at " + recipeFile.getCanonicalPath() + " for deserialization. Proceeding without interruption. Message:");
			} catch (IOException e) {
				System.err.println("There was a problem opening a file for deserialization. Proceeding without interruption. Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
	    catch (ClassNotFoundException ex) {
	    	try {
				System.err.println("There was a problem deserializing object from file at " + recipeFile.getCanonicalPath() + ". Proceeding without interruption. Message:");
			} catch (IOException e) {
				System.err.println("There was a problem deserializing object from a file. Proceeding without interruption. Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
	    try {
	    	//close input stream
			if (iStream != null)
				iStream.close();
		} catch (IOException ex) {
	    	try {
				System.err.println("There was a problem closing file at " + recipeFile.getCanonicalPath() + " after deserialization. Proceeding without interruption. Message:");
			} catch (IOException e) {
				System.err.println("There was a problem closing a file after deserialization. Proceeding without interruption. Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
		}
		
		return recipe;
	}
	
	@Override
	public boolean addRecipe(Recipe recipe) {
		FileOutputStream fOut;
	    
	    if (!destDir.exists()) destDir.mkdirs();
	    
		try	{
			//open file
			fOut = new FileOutputStream(destDir.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX, false);
		}
		catch (IOException ex) {
			try {
				System.err.println("There was a problem creating file at " + destDir.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ". Message:");
			} catch (IOException e) {
				System.err.println("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ". Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		ObjectOutputStream oStream;
		try {
			//open object stream at file
			oStream = new ObjectOutputStream(fOut);
		}
		catch (IOException ex) {
			System.err.println("There was creating a serializable recipe object stream named after " + recipe.getName() + ". Message:");
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		try	{
			//write object
			oStream.writeObject(recipe);
		}
		catch (IOException ex) {
			System.err.println("There was writing a serializable recipe object named " + recipe.getName() + " to a file stream. Message:");
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			try {
				System.err.println("There was a problem closing file at " + destDir.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ". Message:");
			} catch (IOException e) {
				System.err.println("There was a problem closing file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ". Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
				
		return true;
	}

	@Override
	public boolean connect(String requiredAndIgnoredConnectionString) {
		//this is a file system driver
		//this is generally a true statement,
		//but we'll do a little testing of the waters anyways
		
		//the required testing facility is in connect()
		return this.connect();
	}
	
	public boolean connect() {
		//this is a file system driver
		//this is generally a true statement,
		//but we'll do a little testing of the waters anyways
		
		//the required testing facility is in isConnected()
		return this.isConnected();
	}

	@Override
	public boolean isConnected() {
		//this is a file system driver
		//this is generally a true statement,
		//but we'll do a little testing of the waters anyways

		boolean canConnect = false;
		
		//if the data dir exists
		if (destDir.exists())
		{
			//if you can read & write to data directory
			if (destDir.canWrite() && destDir.canRead())
				//then you are "connected"
				canConnect = true;
		}
		//otherwise
		else
		{
			File cwd = new File ("."); //current working directory
			//if you can read & write to current working directory
			if (cwd.exists() && cwd.canWrite() && cwd.canRead())
				//then you are "connected"
				canConnect = true;
		}
		return canConnect;
	}

	@Override
	public boolean updateRecipe(String currentRecipeName, Recipe updatedRecipe) {
		// TODO Auto-generated method stub
		return false;
	}
}