package com.customfit.ctg.model;

import com.customfit.ctg.controller.*;
import java.util.*;
        
/**
 * The Meal has a name, could be Breakfast, Lunch, Dinner,
 * Evening Date with Jenny, etc., and one or more recipes for
 * the meal.
 * 
 * @author David
 */
public class Meal
{

    /**
     * The name of the meal, e.g. breakfast.
     */
    private String name = "";

    /**
     * The date/time the meal.
     */
    private Date date = null;
    
    /**
     * The list of recipes that constitutes a meal.
     */
    private List<Recipe> recipes = new ArrayList<Recipe>();
    
    /**
     * The list of members that constitutes a meal.
     */
    private List<Member> members = new ArrayList<Member>();

    public Meal()
    {
    }

    public Meal(String name)
    {
        this.name = name;
    }

    public Meal(String name, Date date)
    {
        this.name = name;
        this.date = date;
    }
    
    public Meal(String name, Date date, List<Recipe> recipes, List<Member> members)
    {
        this.name = name;
        this.date = date;
        this.recipes = recipes;
        this.members = members;
    }
    
    public Meal(Meal meal)
    {
        this.name = meal.name;
        this.date = meal.date;
        this.recipes = meal.recipes;
        this.members = meal.members;
    }

    /**
     * Gets the date/time the meal.
     * 
     * @return The date/time the meal.
     */
    public Date getDate()
    {
        return this.date;
    }

    /**
     * Sets the date/time the meal.
     * 
     * @param date The date/time the meal.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Gets the name of the meal, e.g. breakfast.
     * 
     * @return The name of the meal.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name of the meal, e.g. breakfast.
     * 
     * @param name The name of the meal.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * The list of recipes that constitutes a meal.
     * 
     * @return The list of recipes that constitutes a meal.
     */
    public List<Recipe> getRecipes()
    {
        return recipes;
    }

    /**
     * Sets the list of recipes that constitutes a meal. Since
     * we are assigning it for the meal, a few things will take
     * place other than just setting the recipes in there.
//     * 
//     * 1. The first thing it does is scale each of your recipes to
//     * the number of members dining at the meal.
     * 
     * @param recipes The list of recipes that constitutes a meal.
     */
    public void setRecipes(List<Recipe> recipes)
    {
        this.recipes = recipes;   
    }
    
    /**
     * Gets the list of members that constitutes a meal.
     * 
     * @return The list of members that constitutes a meal.
     */
    public List<Member> getMembers()
    {
        return members;
    }
    
    /**
     * Scales any Recipe for any Member's daily nutritional target.
     * 
     * Use Recipe.scale(double scaleFactor) to scale it smaller than that.
     * 
     * @param recipe A Recipe to scale.
     * @param member A Member with nutritional targets.
     * 
     * @return A new Recipe, scaled to fit the Member's daily nutritional target.
     */
    public static Recipe scaleRecipeToMemberNutritionalTarget(Recipe recipe, Member member)
    {
        return recipe.scaleToNutritionalTarget(member.getTrackedNutrient(), member.getGoal());
    }
    
    /**
     * Returns a List of Recipes scaled to the size for the Member's daily nutritional
     * target.
     * 
     * @param member The Member with a nutritional target to scale all the
     * Recipes in this Meal to.
     * 
     * @return A List of Recipes scaled to the right size.
     */
    public static List<Recipe> scaleAllRecipesToMemberNutritionalTarget(List<Recipe> recipes, Member member)
    {
        //each member has a nutritional target
        //this includes the goal (Measurement)
        //and the direction (even though the app uses
        //the same direction for all members)
        
        //so because each member has a nutritional target
        //we simple scale the Recipe to the ideal
        //portion size to cook it up.
        
        //store list of recipes
        ArrayList<Recipe> idealRecipes = new ArrayList<Recipe>();
        for (Recipe recipe: recipes)
        {
            //scale the recipe to the member's target
            idealRecipes.add(Meal.scaleRecipeToMemberNutritionalTarget(recipe, member));
        }
        
        //return list
        return idealRecipes;
    }
    
    /**
     * Creates a new Meal object with every Recipe scaled to the
     * sum of every Member's daily nutritional targets.
     *
     * At this function, it still assumes that every user will be
     * dining only this one meal for a day.
     * 
     * //TODO Improve this logic, probably by using the User object instead.
     * //TODO Get some sleep.
     * 
     * @param meal
     * 
     * @return A new Meal object with scaled Recipes.
     */
    public static Meal scaleMealToMemberNutritionalTargets(Meal meal)
    {
        List<Recipe> newRecipes = new ArrayList<Recipe>();
        //for each member in the meal
        for (Member member: meal.members)
        {
            //get list of recipes ideal for member
            List<Recipe> memberRecipes = Meal.scaleAllRecipesToMemberNutritionalTarget(newRecipes, member);
            for (Recipe memberRecipe: memberRecipes)
            {
                boolean foundNewRecipe = false;
                for (int n = 0; n < newRecipes.size(); n++)
                {
                    Recipe newRecipe = newRecipes.get(n);
                    if (newRecipe.getName().equals(memberRecipe.getName()))
                    {
                        newRecipes.set(n, newRecipe.add(memberRecipe));
                    }
                }
                if (!foundNewRecipe)
                    newRecipes.add(memberRecipe);
            }
        }
        Meal newMeal = new Meal(meal);
        //replace recipes with scaled recipes
        newMeal.recipes = newRecipes;
        return newMeal;
    }
    
    /**
     * Creates a new Meal object with every Recipe scaled to the
     * sum of every Member's daily nutritional targets.
     *
     * At this function, it still assumes that every user will be
     * dining only this one meal for a day.
     * 
     * //TODO Improve this logic, probably by using the User object instead.
     * //TODO Get some sleep.
     * 
     * @return A new Meal object based on this one with scaled Recipes.
     */
    public Meal scaleToMemberTargets()
    {
        return Meal.scaleMealToMemberNutritionalTargets(this);
    }
    
    @Override
    public boolean equals(Object object)
    {
       Meal meal = (Meal)object;
       if (Application.isEquals(this.name,meal.name)
           && Application.isEquals(this.date,meal.date)
           && this.recipes.size() == meal.recipes.size()
           && this.members.size() == meal.members.size())
       {
           for (int recipe = 0; recipe < this.recipes.size(); recipe++)
           {
               if (!this.recipes.get(recipe).equals(meal.recipes.get(recipe)))
                   return false;
           }
           for (int member = 0; member < this.members.size(); member++)
           {
               if (!this.members.get(member).equals(meal.members.get(member)))
                   return false;
           }
           return true;
       }
       return false;
    }   
}