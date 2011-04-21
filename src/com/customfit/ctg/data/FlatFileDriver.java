package com.customfit.ctg.data;

import com.customfit.ctg.controller.Application;
import com.customfit.ctg.model.*;
import com.thoughtworks.xstream.XStream;
import java.util.*;
import java.io.*;

/**
 * The FlatFileDriver class represents one of the DataDriverInterfaces
 * aimed at providing basic data operations for the application
 * for the local filesystem, as a data store.
 * 
 * It uses the long-term object persistence provided in the JSR 57,
 * Long-Term Persistence for JavaBeans. Although it is the only
 * part of JavaBeans we'll be using here.
 *
 * @author David
 */
public class FlatFileDriver implements DataDriver {

	/**
	 * This is appended to file names when they are generated
	 * by the insert/update queries, when exact file names are
	 * not provided specified by the driver consumer. It provides
	 * a default naming convention for recipe files.
	 */
	public static final String RECIPE_FILE_SUFFIX = ".recipe.xml";

	/**
	 * This is appended to file names when they are generated
	 * by the insert/update queries, when exact file names are
	 * not provided specified by the driver consumer. It provides
	 * a default naming convention for user files.
	 */
	public static final String USER_FILE_SUFFIX = ".user.xml";
	
	/**
	 * This is File path where recipe data will go, by default, per
	 * the driver implementation.
	 */
	private File recipeDataDirectory;	

	/**
	 * This is File path where user data will go, by default, per
	 * the driver implementation.
	 */
	private File userDataDirectory;	

	/**
	 * This uses the external XStream library to do what neither
	 * Object serialization nor JAXB serialization can, that is
	 * serialize everything including generic collections, etc.
	 */
	private XStream xStream = new XStream();
	
	/**
	 * Creates a new FlatFileDriver object and automatically connects
	 * to the application's current working directory.
	 */
	public FlatFileDriver() {
		super();
		
		//connect driver to application current working directory
		this.connect();
		
		//map short names to objects for serialization
		xStream.alias("recipe", Recipe.class);
		xStream.alias("ingredient", RecipeIngredient.class);
		xStream.alias("nutritionPlan", NutritionPlan.class);
	}

	/**
	 * Connects the driver to the specific data directory.
	 * 
	 * Using this method call will ensure that all data will be written
	 * to your specified directory. 
	 * 
	 * The destination directory is optional. By using the other
	 * method overload, you guarantee the data directory will be
	 * chosen by the driver.
	 * 
	 * Once a driver has connected to directory, you must call connect(String)
	 * to use a different directory for default file storage, or connect()
	 * without any parameters for the application's current working directory.
	 * 
	 * @param dataDirectory The directory you want to save to/read from
	 * by default.
	 * 
	 * @return Boolean indicating that you have read and write
	 * permissions at the target directory you specified.
	 */
	@Override
	public boolean connect(String dataDirectory) {
		//this is a file system driver
		//but we'll do a little testing of the waters anyways
		this.recipeDataDirectory = new File(dataDirectory);
		this.userDataDirectory = new File(dataDirectory);
		
		//the required testing facility is in connect()
		return this.connect();
	}
	
	/**
	 * Connects the driver to the application's current working directory.
	 * 
	 * The destination directory is optional by using the other function
	 * overload. Once the object is created, the current working can be
	 * refreshed by calling connect() again without any parameters.
	 *  
	 * The default directory for recipes is within the scope of the\
	 * application's current working directory, at the path:
	 *  ./app_data/...
	 *  
	 * Recipes are stored at:
	 *  ./app_data/recipes/*
	 *  
	 * Once a driver is connected, the object will not adjust paths even
	 * if the application's current working directory is changed through
	 * another means. You must re-instantiate the driver or choose a data
	 * directory manually by calling the connect(String) overloaded method.
	 * 
	 * @return Boolean indicating that you have read and write permissions
	 * at the directory you specified.
	 */
	public boolean connect() {
		//this is a file system driver
		//but we'll do a little testing of the waters anyways
		this.recipeDataDirectory = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
		this.userDataDirectory = new File ("." + File.separator + "app_data" + File.separator + "users"); //users data directory
		
		//the required testing facility is in isConnected()
		return this.isConnected();
	}

	/**
	 * Checks the driver's connection state to the current data directory.
	 * 
	 * @return Boolean indicating that you have read and write permissions
	 * at the directory it is connected to.
	 */
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
	
	/**
	 * Doesn't do anything. It would close a connection normally, but
	 * there isn't really a connection in this implementation.
	 */
	@Override
	public void close() {
		// Do nothing, although it is needed for other drivers to work
		// properly.
	}
	
	/**
	 * Returns the current recipe data directory.
	 * 
	 * It makes no assertions about the validity of this path. Use
	 * the resulting object to check for existing paths and/or usability.
	 * 
	 * @return The recipe data directory.
	 */
	public File getRecipeDataDirectory() {
		return this.recipeDataDirectory;
	}

	/**
	 * Returns the current user data directory.
	 * 
	 * It makes no assertions about the validity of this path. Use
	 * the resulting object to check for existing paths and/or usability.
	 * 
	 * @return The user data directory.
	 */
	public File getUserDataDirectory() {
		return this.userDataDirectory;
	}

	/**
	 * Selects all recipes from the recipe data directory.
	 * 
	 * @return A List of Recipe objects.
	 */
	@Override
	public List<Recipe> selectAllRecipes() {
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		if (recipeDataDirectory.exists()) for (File recipeFile : recipeDataDirectory.listFiles())
		{
		    Recipe recipe = null; //recipe storage
		    recipe = this.selectRecipeByFile(recipeFile);
		    if (recipe != null)
		    	recipes.add(recipe);
		}
		
		return recipes;
	}

	/**
	 * Selects all recipes from the recipe data directory when
	 * given a recipe name.
	 * 
	 * @param recipeName Name of the recipe. File must be located in the
	 * recipe data directory. The file must be suffixed with RECIPE_FILE_SUFFIX.
	 * The recipe file associated with the name must exist, if it does not, the
	 * method will return an empty list. 
	 * 
	 * @return List of Recipe objects as required by the interface, but
	 * the list will only have one item in it, per the implementation.
	 */
	@Override
	public List<Recipe> selectRecipesByName(String recipeName) {
	    //in this driver implementation, there will only be one in item in the list
		//but in SQL queries, there may be more entries
		
		//create list
		List<Recipe> recipes = new ArrayList<Recipe>();
		
		//build recipe from file
		Recipe recipe = null; //recipe storage
	    String recipeFileName = "";
	    try {
			recipeFileName = recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX;
		} catch (IOException ex) {
			Application.dumpException("There was a problem opening target data directory for recipes.", ex);
		}
		File recipeFile = new File(recipeFileName);
		if (recipeFile.exists())
			recipe = this.selectRecipeByFile(recipeFile);
		
		//add recipe to list
		recipes.add(recipe);
		
		//return
		return recipes;
	}
	
	/**
	 * Returns a deserialized Recipe object from a XML File.
	 * 
	 * @param recipeFile File containing Recipe object.
	 * 
	 * @return Recipe object from state-file.
	 */
	public Recipe selectRecipeByFile(File recipeFile) {
	    FileInputStream iStream = null;
	    Recipe recipe = null; //recipe storage
	    
		try {
			iStream = new FileInputStream(recipeFile);
		}
		catch (FileNotFoundException ex) {
	    	try {
	    		Application.dumpException("There was a problem opening non-existant file at " + recipeFile.getCanonicalPath() + " for deserialization. Not sure where it could have went, but it's gone now.", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem opening a non-existant file for deserialization. Not sure where it could have went, but it's gone now.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
		}
	    
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
	    		
		//use XStream now instead of JAXB
		recipe = (Recipe) this.xStream.fromXML(iStream); 
		
	    try {
	    	//close input stream
			if (iStream != null)
				iStream.close();
		}
	    catch (IOException ex) {
	    	try {
	    		Application.dumpException("There was a problem closing file at " + recipeFile.getCanonicalPath() + " after deserialization. Proceeding without interruption.", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem closing a file after deserialization. Proceeding without interruption.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
		}
	    
	    return recipe;
	}
	
	/**
	 * Inserts a new recipe XML file into the recipe data directory by
	 * serializing the Recipe object.
	 * 
	 * @param recipe Recipe to save.
	 */
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
				Application.dumpException("There was a problem creating file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	    
	    //now call the overload to export
	    return this.insertRecipeToFile(recipe, newFile);
	}
	
	/**
	 * Serializes Recipe to XML file you specify.
	 * 
	 * @param recipe Recipe object to store.
	 * @param toFile File to put it in.
	 * 
	 * @return Boolean indicating success of the operation.
	 */	
	public boolean insertRecipeToFile(Recipe recipe, File toFile) {
		//this is very reusable, especially for recipe file exporting
		FileOutputStream fOut;
		try
		{
			fOut = new FileOutputStream(toFile, false);
		}
		catch (FileNotFoundException ex) {
			try {
				Application.dumpException("There was a problem creating file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
		
		//use XStream now instead of JAXB
		this.xStream.toXML(recipe, fOut);
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			try {
				Application.dumpException("There was a problem closing file at " + recipeDataDirectory.getCanonicalPath() + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem closing file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + RECIPE_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
		
		return true;
	}
	
	/**
	 * Updates the recipe with the currentRecipeName with the new Recipe object.
	 * 
	 * This may mean the file can be renamed, if the recipe name changes.
	 * 
	 * @param currentRecipeName The current name of the recipe. (Before changing)
	 * 
	 * @param updatedRecipe The Recipe object to save. (May have a new recipe name.)
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	@Override
	public boolean updateRecipeByName(String currentRecipeName, Recipe updatedRecipe) {
		//for the filesystem driver, this couldn't be simpler
		//we're going to delete, then insert
		if (this.isConnected())
		{
			if (this.deleteRecipeByName(currentRecipeName))
			{
				//delete succeeded
				//now save it
				return this.insertRecipe(updatedRecipe);
			}
		}
		//otherwise:
		return false;
	}
	
	/**
	 * Deletes the recipe using the object's default naming convention.
	 * 
	 * Read about inserting for more information about naming conventions.
	 * 
	 * @param recipeName Recipe name.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	@Override
	public boolean deleteRecipeByName(String recipeName) {
		File file;
		try
		{
			file = new File(recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX);
			return this.deleteRecipeFile(file);
		}
		catch (IOException ex)
		{
			try {
				Application.dumpException("There was an error deleting the file " + recipeDataDirectory.getCanonicalPath() + File.separator + recipeName + RECIPE_FILE_SUFFIX, ex);
			} catch (IOException e) {
				Application.dumpException("There was an error deleting a file for the " + recipeName + "recipe.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	}
	
	/**
	 * Deletes whatever file you specify.
	 * 
	 * @param file Any valid File object.
	 *  
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean deleteRecipeFile(File file)
	{
		return file.delete();
	}
	
	/**
	 * Selects all recipes from the user data directory.
	 * 
	 * @return A List of User objects.
	 */
	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<User>();
		
		if (userDataDirectory.exists()) for (File userFile : userDataDirectory.listFiles())
		{
		    User user = null; //user storage
		    user = this.selectUserByFile(userFile);
		    if (user != null)
		    	users.add(user);
		}
		
		return users;
	}

	/**
	 * Selects all users from the user data directory when
	 * given a user name.
	 * 
	 * @param userName Name of the user. File must be located in the
	 * user data directory. The file must be suffixed with USER_FILE_SUFFIX.
	 * The user file associated with the name must exist, if it does not, the
	 * method will return an empty list. 
	 * 
	 * @return List of User objects as required by the interface, but
	 * the list will only have one item in it, per the implementation.
	 */
	@Override
	public List<User> selectUsersByName(String userName) {
	    //in this driver implementation, there will only be one in item in the list
		//but in SQL queries, there may be more entries
		
		//create list
		List<User> users = new ArrayList<User>();
		
		//build user from file
		User user = null; //user storage
	    String userFileName = "";
	    try {
			userFileName = userDataDirectory.getCanonicalPath() + File.separator + userName + USER_FILE_SUFFIX;
		} catch (IOException ex) {
			Application.dumpException("There was a problem opening target data directory for users.", ex);
		}
		File userFile = new File(userFileName);
		if (userFile.exists())
			user = this.selectUserByFile(userFile);
		
		//add user to list
		users.add(user);
		
		//return
		return users;
	}
	
	/**
	 * Returns a deserialized User object from a XML File.
	 * 
	 * @param userFile File containing User object.
	 * 
	 * @return User object from state-file.
	 */
	public User selectUserByFile(File userFile) {
	    FileInputStream iStream = null;
	    User user = null; //recipe storage
	    
		try {
			iStream = new FileInputStream(userFile);
		}
		catch (FileNotFoundException ex) {
	    	try {
	    		Application.dumpException("There was a problem opening non-existant file at " + userFile.getCanonicalPath() + " for deserialization. Not sure where it could have went, but it's gone now.", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem opening a non-existant file for deserialization. Not sure where it could have went, but it's gone now.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
		}
	    
		//use XStream now instead of JAXB
		user = (User) this.xStream.fromXML(iStream); 
		
	    try {
	    	//close input stream
			if (iStream != null)
				iStream.close();
		}
	    catch (IOException ex) {
	    	try {
	    		Application.dumpException("There was a problem closing file at " + userFile.getCanonicalPath() + " after deserialization. Proceeding without interruption.", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem closing a file after deserialization. Proceeding without interruption.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
		}
	    
	    return user;
	}
	
	/**
	 * Inserts a new user XML file into the user data directory by
	 * serializing the User object.
	 * 
	 * @param user User to save.
	 */
	@Override
	public boolean insertUser(User user) {
		//when using this routine, we'll auto-generate data directory
	    if (!userDataDirectory.exists()) userDataDirectory.mkdirs();

	    //prepare a file
	    File newFile;
	    try
	    {
	    	String newFileName = userDataDirectory.getCanonicalPath() + File.separator + user.getName() + USER_FILE_SUFFIX;
	    	newFile = new File(newFileName);
	    }
		catch (IOException ex) {
			try {
				Application.dumpException("There was a problem creating file at " + userDataDirectory.getCanonicalPath() + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "users" + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	    
	    //now call the overload to export
	    return this.insertUserToFile(user, newFile);
	}
	
	/**
	 * Serializes User to XML file you specify.
	 * 
	 * @param user User object to store.
	 * @param toFile File to put it in.
	 * 
	 * @return Boolean indicating success of the operation.
	 */	
	public boolean insertUserToFile(User user, File toFile) {
		//this is very reusable, especially for recipe file exporting
		FileOutputStream fOut;
		try
		{
			fOut = new FileOutputStream(toFile, false);
		}
		catch (FileNotFoundException ex) {
			try {
				Application.dumpException("There was a problem creating file at " + userDataDirectory.getCanonicalPath() + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "users" + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
		
		//use XStream now instead of JAXB
		this.xStream.toXML(user, fOut);
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			try {
				Application.dumpException("There was a problem closing file at " + userDataDirectory.getCanonicalPath() + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
			} catch (IOException e) {
				Application.dumpException("There was a problem closing file at " + "." + File.separator + "app_data" + File.separator + "users" + File.separator + user.getName() + USER_FILE_SUFFIX + ".", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
		
		return true;
	}
	
	/**
	 * Updates the user with the currentUserName with the new User object.
	 * 
	 * This may mean the file can be renamed, if the user name changes.
	 * 
	 * @param currentUserName The current name of the user. (Before changing)
	 * @param updatedUser The User object to save. (May have a new user name.)
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	@Override
	public boolean updateUserByName(String currentUserName, User updatedUser) {
		//for the filesystem driver, this couldn't be simpler
		//we're going to delete, then insert
		if (this.isConnected())
		{
			if (this.deleteUserByName(currentUserName))
			{
				//delete succeeded
				//now save it
				return this.insertUser(updatedUser);
			}
		}
		//otherwise:
		return false;
	}
	
	/**
	 * Deletes the user using the object's default naming convention.
	 * 
	 * Read about inserting for more information about naming conventions.
	 * 
	 * @param userName User name.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	@Override
	public boolean deleteUserByName(String userName) {
		File file;
		try
		{
			file = new File(userDataDirectory.getCanonicalPath() + File.separator + userName + USER_FILE_SUFFIX);
			return this.deleteUserFile(file);
		}
		catch (IOException ex)
		{
			try {
				Application.dumpException("There was an error deleting the file " + userDataDirectory.getCanonicalPath() + File.separator + userName + USER_FILE_SUFFIX, ex);
			} catch (IOException e) {
				Application.dumpException("There was an error deleting a file for the " + userName + "recipe.", ex);
				Application.dumpException("Then an error was generated while generating the error.", e);
			}
			return false;
		}
	}
	
	/**
	 * Deletes whatever file you specify.
	 * 
	 * @param file Any valid File object.
	 *  
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean deleteUserFile(File file)
	{
		return file.delete();
	}

}