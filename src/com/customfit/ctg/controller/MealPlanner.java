package com.customfit.ctg.controller;

import com.customfit.ctg.model.Meal;
import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.model.User;
import com.customfit.ctg.view.meal.MealMenuPanel;
import java.util.List;


/**
 * The composite model of our data.
 * 
 * @author Drew, David
 */
public class MealPlanner { // implements Observable

    //needs restructuring
    //particularly, the model for Meal needs to be developed first

    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame from the list
     * of all known recipes in the Controller's default database.
     */
    public static void browseMenu()
    {
        //recipes not provided, so go get them
        List<Recipe> recipes = Application.getDataDriver().selectAllRecipes();
        List<Meal> meals = UserManagement.getCurrentUser().getMeals();

        //now pass them to the overloaded method
        browseMenu(recipes, meals);
    }

    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame with the recipes
     * you have provided.
     *
     * @param recipes The list of recipes to browse through.
     */
    public static void browseMenu(List<Recipe> recipes, List<Meal> meals)
    {
        //create panel
        MealMenuPanel mealMenuPanel = new MealMenuPanel(MealMenuPanel.ListMode.LIST_BROWSE);
        //tell panel about our recipes
        mealMenuPanel.setRecipeList(recipes);
        mealMenuPanel.setMenuList(meals);
        //display panel in main frame
        Application.getMainFrame().setPanel(mealMenuPanel);
    }

    /**
     * Add the recipe to the meal.
     *
     * @param recipe
     * @param meal
     */
    public static void addRecipeToMeal(Recipe recipe, String mealName) {
        User cUser = UserManagement.getCurrentUser();
        Meal meal = cUser.getMealByName(mealName);
        if (meal != null)
            meal.getRecipes().add(recipe);
    }

    /**
     * Remove the recipe from the meal.
     *
     * @param recipe
     * @param meal
     */
    public static void removeRecipeFromMeal(String recipeName, String mealName) {
        User cUser = UserManagement.getCurrentUser();
        Meal meal = cUser.getMealByName(mealName);
        if (meal != null) {
            int rindex = getRecipeIndexInMeal(meal, recipeName);
            if (rindex > 0)
                meal.getRecipes().remove(rindex);
        }
    }

    /**
     * Remove the recipe from the meal.
     *
     * @param mealIndex
     * @param recipeIndex
     */
    public static void removeRecipeFromMeal(int mealIndex, int recipeIndex) {
        User cUser = UserManagement.getCurrentUser();
        if (mealIndex >= 0 && recipeIndex >= 0) {
            if (mealIndex < cUser.getMeals().size()) {
                Meal meal =  cUser.getMeals().get(mealIndex);
                if (recipeIndex < meal.getRecipes().size()) {
                    Recipe r = meal.getRecipes().get(recipeIndex);
                    meal.getRecipes().remove(r);
                }
            }
        }
    }

    /**
     * Get the index for the recipe in a given meal.
     *
     * @param meal The meal to get the index from.
     * @param mealName The meal's name to search for
     * @return Returns the index.  -1 if no match is found.
     */
    public static int getRecipeIndexInMeal(Meal meal, String recipeName) {
        int index = 0;
        for (Recipe r : meal.getRecipes()) {
            if (r.getName().equals(recipeName))
                return index;
            index++;
        }
        return -1;
    }

    /**
     * Gets the list of meals from the current user.
     */
    public static List<Meal> getAllMeals()
    {
        return UserManagement.getCurrentUser().getMeals();
    }

    public static void createDefaultMeals() {
        User cUser = UserManagement.getCurrentUser();
        cUser.addMeal(new Meal("Monday"));
        cUser.addMeal(new Meal("Tuesday"));
        cUser.addMeal(new Meal("Wednesday"));
        cUser.addMeal(new Meal("Thursday"));
        cUser.addMeal(new Meal("Friday"));
        cUser.addMeal(new Meal("Saturday"));
        cUser.addMeal(new Meal("Sunday"));
    }
}
