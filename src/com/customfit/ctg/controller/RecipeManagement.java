package com.customfit.ctg.controller;

import com.customfit.ctg.view.print.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import com.customfit.ctg.view.print.*;
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
        }
        //return status
        return status;
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
        boolean status = false;
        //be sure to ask for a confirmation first, if they click OK
        if (JOptionPane.showConfirmDialog(Application.getMainFrame(), "Are you sure you want to delete the recipe, " + recipeName + "? This cannot be reversed.", "Delete Recipe Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            //then do the delete
            status = Application.getDataDriver().deleteRecipeByName(recipeName);
            //check for errors
            if (!status)
                //if failed, tell user about the failure
                JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem deleting your recipe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return status;
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
     * Prints a shopping list of ingredients for a list of meals for this week
     * starting whenever Monday was.
     */
    public static void printShoppingList()
    {
        //get a Calendar
        Calendar calendarToday = Calendar.getInstance();
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        
        //go to the first day of the week
        if (calendarStart.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
        {
            switch (calendarStart.get(Calendar.DAY_OF_WEEK))
            {
                case Calendar.SUNDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.SATURDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.FRIDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.THURSDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.WEDNESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.TUESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
            }
        }
        //then add 6 days to end date
        calendarEnd.add(Calendar.DATE, 6);

        //then print the report
        RecipeManagement.printShoppingList(calendarStart.getTime(), calendarEnd.getTime());
    }
    
    /**
     * Prints a shopping list of ingredients for a list of meals.
     * 
     * @param meals List of meals.
     */
    public static void printShoppingList(Date startDate, Date endDate)
    {
        //get meal data from current user
        List<Meal> meals = UserManagement.getCurrentUser().getMealsByDateRange(startDate, endDate);
        ArrayList<RecipeIngredient> allMealIngredients = new ArrayList<RecipeIngredient> ();
        
        //now process every meal in the range for shared ingredients
        for (Meal meal: meals)
        {
            for (Recipe recipe: meal.getRecipes())
            {
                for (RecipeIngredient mealIngredient: recipe.getIngredients())
                {
                    boolean found = false;
                    int index = -1;
                    for (RecipeIngredient allMealIngredientsIngredient: allMealIngredients)
                    {
                        if (allMealIngredientsIngredient.getName() == mealIngredient.getName())
                        {
                            found = true;
                            index = allMealIngredients.indexOf(allMealIngredientsIngredient);
                        }
                    }
                    
                    if (found)
                        allMealIngredients.set(index, allMealIngredients.get(index).add(mealIngredient));
                    else
                        allMealIngredients.add(mealIngredient);
                }
            }
        }
                
        //get a Calendar
        Calendar calendarToday = Calendar.getInstance();
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        
        //go to the first day of the week
        if (calendarStart.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
        {
            switch (calendarStart.get(Calendar.DAY_OF_WEEK))
            {
                case Calendar.SUNDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.SATURDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.FRIDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.THURSDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.WEDNESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.TUESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
            }
        }
        //then add 6 days to end date
        calendarEnd.add(Calendar.DATE, 6);
        
        //then print the report
        RecipeManagement.printShoppingList(allMealIngredients, startDate, endDate);
    }
    
    /**
     * Prints a shopping list of ingredients for the dates you provide with
     * a list of ingredients that you provide.
     * 
     * @param ingredients List of ingredients.
     * @param startDate Starting date for report.
     * @param endDate Ending date for report.
     */
    public static void printShoppingList(List<RecipeIngredient> ingredients, Date startDate, Date endDate)
    {
        //create print panel
        ShoppingListPrintPanel printPanel = new ShoppingListPrintPanel();
        //tell print panel about our data
        printPanel.setIngredientsAndDates(ingredients, startDate, endDate);
        //create print preview panel
    	PrintPreviewPanel printPriviewPanel = new PrintPreviewPanel(printPanel);
    	//tell main frame to display preview
    	Application.getMainFrame().setPanel(printPriviewPanel);
    }
}
