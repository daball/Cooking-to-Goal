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
	public static final String RECIPE_FILE_SUFFIX = "-serialized.dat";
	
	/**
	 * This is where recipe data goes.
	 */
	private File recipeDataDirectory = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
	
	/**
	 * @return The recipe data directory.
	 */
	public File getRecipeDataDirectory() {
		return this.recipeDataDirectory;
	}

	@Override
	public boolean connect(String destinationDirectory) {
		//this is a file system driver
		//but we'll do a little testing of the waters anyways
		this.recipeDataDirectory = new File(destinationDirectory);
		
		//the required testing facility is in connect()
		return this.connect();
	}
	
	public boolean connect() {
		//this is a file system driver
		//but we'll do a little testing of the waters anyways
		
		//the required testing facility is in isConnected()
		return this.isConnected();
	}

	@Override
	public boolean isConnected() {
		//this is a file system driver
		//but we'll do a little testing of the waters anyways

		boolean canConnect = false;
		
		//if the data directory exists
		if (recipeDataDirectory.exists())
		{
			//and if you can read & write to data directory
			if (recipeDataDirectory.canWrite() && recipeDataDirectory.canRead())
				//then you are "connected"
				canConnect = true;
		}
		//otherwise
		else
		{
			File cwd = new File ("."); //get current working directory
			//if you can read & write to current working directory
			if (cwd.exists() && cwd.canWrite() && cwd.canRead())
				//then you are "connected"
				canConnect = true;
		}
		return canConnect;
	}
	
	@Override
	public List<Recipe> selectAllRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		if (recipeDataDirectory.exists()) for (File recipeFile : recipeDataDirectory.listFiles())
		{
		    Recipe recipe = null; //recipe storage
		    recipe = this.selectRecipe(recipeFile);
		    if (recipe != null)
		    	recipes.add(recipe);
		}
		
		return recipes;
	}

	public Recipe selectRecipeByName(String recipeName) {
	    Recipe recipe = null; //recipe storage
	    String recipeFileName = "";
	    try {
			recipeFileName = recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX;
		} catch (IOException ex) {
			this.dumpDataError("There was a problem opening target data directory for recipes.", ex);
		}
		File recipeFile = new File(recipeFileName);
		if (recipeFile.exists())
			recipe = this.selectRecipe(recipeFile);
		return recipe;
	}
	
	/**
	 * Returns a recipe by using recipeFile.  
	 * @param recipeFile
	 * @return
	 */
	public Recipe selectRecipe(File recipeFile) {
	    ObjectInputStream iStream = null;
	    Recipe recipe = null; //recipe storage
	    
		try {
			iStream = new ObjectInputStream(new FileInputStream(recipeFile));
		}
		catch (FileNotFoundException ex) {
	    	try {
	    		this.dumpDataError("There was a problem opening non-existant file at " + recipeFile.getCanonicalPath() + " for deserialization. Not sure where it could have went, but it's gone now.", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem opening a non-existant file for deserialization. Not sure where it could have went, but it's gone now.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
		}
		catch (IOException ex) {
	    	try {
	    		this.dumpDataError("There was a problem opening deserialization stream for file at " + recipeFile.getCanonicalPath() + ".", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem opening deserialization stream for a file.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
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
	    		this.dumpDataError("There was a problem opening file at " + recipeFile.getCanonicalPath() + " for deserialization. Proceeding without interruption.", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem opening a file for deserialization. Proceeding without interruption.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
		}
	    catch (ClassNotFoundException ex) {
	    	try {
				this.dumpDataError("There was a problem deserializing object from file at " + recipeFile.getCanonicalPath() + ". Proceeding without interruption.", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem deserializing object from a file. Proceeding without interruption.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
		}
	    try {
	    	//close input stream
			if (iStream != null)
				iStream.close();
		} catch (IOException ex) {
	    	try {
				this.dumpDataError("There was a problem closing file at " + recipeFile.getCanonicalPath() + " after deserialization. Proceeding without interruption.", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem closing a file after deserialization. Proceeding without interruption.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
		}
		
		return recipe;
	}
	
	@Override
	public boolean insertRecipe(Recipe recipe) {
		//when using this routine, we'll auto-generate data directory
	    if (!recipeDataDirectory.exists()) recipeDataDirectory.mkdirs();

	    //prepare a file
	    File newFile;
	    try
	    {
	    	String newFileName = recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX;
	    	newFile = new File(newFileName);
	    }
		catch (IOException ex) {
			try {
				this.dumpDataError("There was a problem creating file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	    
	    //now call the overload to export
	    return this.insertRecipe(recipe, newFile);
	}
	
	public boolean insertRecipe(Recipe recipe, File toFile) {
		//this is very reusable, especially for recipe file exporting
		FileOutputStream fOut;
		try
		{
			fOut = new FileOutputStream(toFile, false);
		}
		catch (FileNotFoundException ex) {
			try {
				this.dumpDataError("There was a problem creating file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
			return false;
		}
		
		ObjectOutputStream oStream;
		try {
			//open object stream at file
			oStream = new ObjectOutputStream(fOut);
		}
		catch (IOException ex) {
			this.dumpDataError("There was a problem creating a serializable recipe object stream named after " + recipe.getName() + ".", ex);
			return false;
		}
		
		try	{
			//write object
			oStream.writeObject(recipe);
		}
		catch (IOException ex) {
			this.dumpDataError("There was writing a serializable recipe object named " + recipe.getName() + " to a file stream.", ex);
			return false;
		}
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			try {
				this.dumpDataError("There was a problem closing file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				this.dumpDataError("There was a problem closing file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
			return false;
		}
				
		return true;
	}
	
	@Override
	public boolean updateRecipeByName(String currentRecipeName, Recipe updatedRecipe) {
		//for the filesystem driver, this couldn't be simpler
		//we're going to delete, then insert
		if (this.isConnected())
		{
			if (this.deleteRecipe(currentRecipeName))
			{
				//delete succeeded
				//now save it
				return this.insertRecipe(updatedRecipe);
			}
		}
		//otherwise:
		return false;
	}

	@Override
	public boolean deleteRecipe(String recipeName) {
		File file;
		try
		{
			file = new File(recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX);
			return file.delete();
		}
		catch (IOException ex)
		{
			try {
				this.dumpDataError("There was an error deleting the file " + recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX, ex);
			} catch (IOException e) {
				this.dumpDataError("There was an error deleting a file for the " + recipeName + "recipe.", ex);
				this.dumpDataError("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	}
	
	/**
	 * This is consumed internally by the object in order
	 * to dump as much info about the error as possible, while
	 * shortening implementation code by 5 lines per exception.
	 * There are lots of exceptions, so this was needed to shorten
	 * the code.
	 * @param message Message to dump.
	 * @param exception Exception.
	 */
	private void dumpDataError(String message, Exception exception)
	{
		System.err.println(message + " Exception Message:");
		System.err.print(exception.getMessage());
		System.err.println("Stack trace:");
		System.err.print(exception.getStackTrace());	
	}
}