package com.customfit.ctg.controller;

import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import com.customfit.ctg.view.recipes.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * The RecipeManagement Controller logic represents the actions that
 * directly involve recipe management, and are responsible for
 * establishing all the use cases for Recipe Management. This class
 * must set up a function for each use.
 * 
 * @author David
 */
public class RecipeManagement {

    /**
     * Gets the List of Recipes from the database.
     */
    public static List<Recipe> getAllRecipes()
    {
        //recipes not provided, so go get them
        return Application.getDataDriver().selectAllRecipes();
    }
    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame from the list
     * of all known recipes in the Controller's default database.
     */
    public static void browseRecipes()
    {
        //recipes not provided, so go get them
        List<Recipe> recipes = getAllRecipes();

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
        //create panel
        ListRecipesPanel recipeListPanel = new ListRecipesPanel(ListRecipesPanel.ListMode.LIST_BROWSE);
        //tell panel about our recipes
        recipeListPanel.setRecipeList(recipes);
        //display panel in main frame
        Application.getMainFrame().setPanel(recipeListPanel);
    }

    /**
     * Activates Create Recipe application feature, which in this case
     * displays a Create Recipe JPanel to prepare a new Recipe object
     * for storage. If you already have a Recipe object, use the
     * overloaded method.
     */
    public static void createRecipe()
    {
            Application.getMainFrame().setPanel(new EditRecipePanel(CreateEditMode.CREATE));
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
    public static boolean createRecipeAndGoBack(Recipe recipe)
    {
        //send it over to the database
        boolean status = Application.getDataDriver().insertRecipe(recipe);
        //check for errors
        if (!status)
            //if failed, tell user about the failure
            JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem creating your recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        else
        {
            //otherwise, assume success and go back
            Application.getMainFrame().goBack();
            //refresh data on previous panel
            Application.getMainFrame().getPanel().refresh();
        }
        //return status
        return status;
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
            //System.out.println("\tviewRecipe(): Recipe " + "Description" + ":\n" + recipe.getDescription());
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
             * TODO: replace this with GUI initialization code for Create Recipe
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
        EditRecipePanel editPanel = new EditRecipePanel(CreateEditMode.EDIT);
        editPanel.setRecipe(recipe);
        Application.getMainFrame().setPanel(editPanel);
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
    public static boolean updateRecipeAndGoBack(String originalRecipeName, Recipe newRecipe)
    {
        //send it over to the database
        boolean status = Application.getDataDriver().updateRecipeByName(originalRecipeName, newRecipe);
        //check for errors
        if (!status)
            //if failed, tell user about the failure
            JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem updating your recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        else
        {
            //otherwise, assume success and go back
            Application.getMainFrame().goBack();
            //refresh data on previous panel
            Application.getMainFrame().getPanel().refresh();
        }
        //return status
        return status;
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
        return Application.getDataDriver().deleteRecipeByName(recipeName);
    }

    /**
     * Activates Delete Recipe application feature, which deletes the Recipe
     * record in the database.
     * 
     * @param recipe The recipe to delete.
     * 
     * @return Boolean indicating the success of the operation. 
     */
    public static boolean deleteRecipe(Recipe recipe)
    {
        return deleteRecipe(recipe.getName());
    }
    
    /**
     * Displays the Print Preview dialog to print the Recipe that you feed it.
     */
    public static void printRecipe(Recipe recipe){
        //create print panel
        RecipePrintPanel recipePrintPanel = new RecipePrintPanel();
        //send the recipe to the print panel
        recipePrintPanel.setRecipe(recipe);
        //create print preview panel
    	PrintPreviewPanel printPreviewPanel = new PrintPreviewPanel(recipePrintPanel);
        //display panel in main frame
        Application.getMainFrame().setPanel(printPreviewPanel);
    }
    
    /**
     * Displays the Print Preview dialog to print the Recipe that you feed it.
     */
    public static void printRecipe(String recipeName){
        //lookup and send to override
        RecipeManagement.printRecipe(Application.getDataDriver().selectRecipesByName(recipeName).get(0));
    }
    
    /**
     * 
     */
    public static void printShoppingList(){
    	// TODO: Implement
    	// obtain the shopping list
    	
    	// create shopping list view JPanel (implements Printable)
    	    	
    	// pass JPanel to print preview panel and display
    	PrintPreviewPanel ppPanel = new PrintPreviewPanel(new RecipePrintPanel());
    	
    	Application.getMainFrame().setPanel(ppPanel);
    }
}
