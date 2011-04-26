package com.customfit.ctg.model;

import com.customfit.ctg.controller.*;
import java.lang.reflect.*;
import java.util.*;

/**
 * A NutritionFacts model for nutrition facts table.
 * 
 * Go to this web site for more information about nutrition facts tables.
 * http://www.fda.gov/food/labelingnutrition/consumerinformation/ucm078889.htm
 * 
 * @author Drew, David
 */
public class NutritionFacts{

    /**
     * Calories in NutritionFacts.
     */
    private Measurement Calories = null;
    
    /**
     * Total Fat in NutritionFacts.
     */
    private Measurement totalFat = null;
    
    /**
     * Saturated Fat in NutritionFacts.
     */
    private Measurement saturatedFat = null;
    
    /**
     * Trans Fat in NutritionFacts.
     */
    private Measurement transFat = null;

    /**
     * Cholesterol in NutritionFacts.
     */
    private Measurement cholesterol = null;
    
    /**
     * Sodium in NutritionFacts.
     */
    private Measurement sodium = null;

    /**
     * Total Carbohydrate in NutritionFacts.
     */
    private Measurement totalCarbohydrate = null;

    /**
     * Dietary Fiber in NutritionFacts.
     */
    private Measurement dietaryFiber = null;

    /**
     * Sugars in NutritionFacts.
     */
    private Measurement sugars = null;

    /**
     * Protein in NutritionFacts.
     */
    private Measurement protein = null;

    /**
     * Returns a new empty NutritionFacts.
     */
    public static NutritionFacts EmptyNutritionFacts = new NutritionFacts();

    /**
     * Returns a complete, zeroed NutritionFacts.
     */
    public static NutritionFacts CompleteNutritionFacts = new NutritionFacts(
        new Measurement(0.0, Measurement.FoodUnits.CALORIES),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.MILLIGRAMS),
        new Measurement(0.0, Measurement.MetricUnits.MILLIGRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS),
        new Measurement(0.0, Measurement.MetricUnits.GRAMS)
        );
        
    /**
     * Creates a new NutritionFacts with the information provided.
     * 
     * @param calories Calories in NutritionFacts.
     * @param totalFat Total Fat in NutritionFacts.
     * @param saturatedFat Saturated Fat in NutritionFacts.
     * @param transFat Trans Fat in NutritionFacts.
     * @param cholesterol Cholesterol in NutritionFacts.
     * @param sodium Sodium in NutritionFacts.
     * @param totalCarbohydrate Total Carbohydrate in NutritionFacts.
     * @param dietaryFiber Dietary Fiber in NutritionFacts.
     * @param sugars Sugars in NutritionFacts.
     * @param protein Protein in NutritionFacts.
     */
    public NutritionFacts(
                Measurement calories,
                Measurement totalFat,
                Measurement saturatedFat,
                Measurement transFat,
                Measurement cholesterol,
                Measurement sodium,
                Measurement totalCarbohydrate,
                Measurement dietaryFiber,
                Measurement sugars,
                Measurement protein)
    {
        this.Calories = calories;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.totalCarbohydrate = totalCarbohydrate;
        this.dietaryFiber = dietaryFiber;
        this.sugars = sugars;
        this.protein = protein;
    }
    
    /**
     * Creates a new NutritionFacts with the information provided.
     * 
     * @param calories Calories in NutritionFacts.
     * @param totalFatInGrams Total Fat in grams in NutritionFacts.
     * @param saturatedFatInGrams Saturated Fat in grams in NutritionFacts.
     * @param transFatInGrams Trans Fat in grams in NutritionFacts.
     * @param cholesterolInMilligrams Cholesterol in milligrams in NutritionFacts.
     * @param sodiumInMilligrams Sodium in milligrams in NutritionFacts.
     * @param totalCarbohydrateInGrams Total Carbohydrate in grams in NutritionFacts.
     * @param dietaryFiberInGrams Dietary Fiber in grams in NutritionFacts.
     * @param sugarsInGrams Sugars in grams in NutritionFacts.
     * @param proteinInGrams Protein in grams in NutritionFacts.
     */
    public NutritionFacts(
                double calories,
                double totalFatInGrams,
                double saturatedFatInGrams,
                double transFatInGrams,
                double cholesterolInMilligrams,
                double sodiumInMilligrams,
                double totalCarbohydrateInGrams,
                double dietaryFiberInGrams,
                double sugarsInGrams,
                double proteinInGrams)
    {
        this.Calories = new Measurement(calories, Measurement.FoodUnits.CALORIES);
        this.totalFat = new Measurement(totalFatInGrams, Measurement.MetricUnits.GRAMS);
        this.saturatedFat = new Measurement(saturatedFatInGrams, Measurement.MetricUnits.GRAMS);
        this.transFat = new Measurement(transFatInGrams, Measurement.MetricUnits.GRAMS);
        this.cholesterol = new Measurement(cholesterolInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
        this.sodium = new Measurement(sodiumInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
        this.totalCarbohydrate = new Measurement(totalCarbohydrateInGrams, Measurement.MetricUnits.GRAMS);
        this.dietaryFiber = new Measurement(dietaryFiberInGrams, Measurement.MetricUnits.GRAMS);
        this.sugars = new Measurement(sugarsInGrams, Measurement.MetricUnits.GRAMS);
        this.protein = new Measurement(proteinInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Creates an empty, NutritionFacts with nullified fields.
     */
    public NutritionFacts()
    {
    }

    /**
     * Gets Calories in NutritionFacts.
     * 
     * @return Calories in NutritionFacts.
     */
    public Measurement getCalories()
    {
        return this.Calories;
    }

    /**
     * Sets Calories in NutritionFacts.
     * 
     * @param Calories Calories in NutritionFacts.
     */
    public void setCalories(Measurement Calories)
    {
        this.Calories = Calories;
    }

    /**
     * Sets Calories in NutritionFacts.
     * 
     * @param Calories Calories in NutritionFacts.
     */
    public void setCalories(double Calories) {
        this.Calories = new Measurement(Calories, Measurement.FoodUnits.CALORIES);
    }

    /**
     * Gets Total Fat in NutritionFacts.
     * 
     * @return Total Fat in NutritionFacts.
     */
    public Measurement getTotalFat() {
        return this.totalFat;
    }

    /**
     * Sets Total Fat in NutritionFacts.
     * 
     * @param totalFat Total Fat in NutritionFacts.
     */
    public void setTotalFat(Measurement totalFat) {
        this.totalFat = totalFat;
    }

    /**
     * Sets Total Fat in NutritionFacts.
     * 
     * @param totalFatInGrams Total Fat in grams in NutritionFacts.
     */
    public void setTotalFat(double totalFatInGrams) {
        this.totalFat = new Measurement(totalFatInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Saturated Fat in NutritionFacts.
     * 
     * @return Saturated Fat in NutritionFacts.
     */
    public Measurement getSaturatedFat() {
        return this.saturatedFat;
    }

    /**
     * Sets Saturated Fat in NutritionFacts.
     * 
     * @param saturatedFat Total Fat in NutritionFacts.
     */
    public void setSaturatedFat(Measurement saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    /**
     * Sets Saturated Fat in NutritionFacts.
     * 
     * @param saturatedFatInGrams Total Fat in grams in NutritionFacts.
     */
    public void setSaturatedFat(double saturatedFatInGrams) {
        this.saturatedFat = new Measurement(saturatedFatInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Trans Fat in NutritionFacts.
     * 
     * @return Trans Fat in NutritionFacts.
     */
    public Measurement getTransFat() {
        return this.transFat;
    }

    /**
     * Sets Trans Fat in NutritionFacts.
     * 
     * @param transFat Trans Fat in NutritionFacts.
     */
    public void setTransFat(Measurement transFat) {
        this.transFat = transFat;
    }

    /**
     * Sets Trans Fat in NutritionFacts.
     * 
     * @param transFatInGrams Trans Fat in grams in NutritionFacts.
     */
    public void setTransFat(double transFatInGrams) {
        this.transFat = new Measurement(transFatInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Cholesterol in NutritionFacts.
     * 
     * @return Cholesterol in NutritionFacts.
     */
    public Measurement getCholesterol() {
        return this.cholesterol;
    }

    /**
     * Sets Cholesterol in NutritionFacts.
     * 
     * @param cholesterol Cholesterol in NutritionFacts.
     */
    public void setCholesterol(Measurement cholesterol) {
        this.cholesterol = cholesterol;
    }

    /**
     * Sets Cholesterol in NutritionFacts.
     * 
     * @param cholesterolInMilligrams Cholesterol in milligrams in NutritionFacts.
     */
    public void setCholesterol(double cholesterolInMilligrams) {
        this.cholesterol = new Measurement(cholesterolInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
    }

    /**
     * Gets Sodium in NutritionFacts.
     * 
     * @return Sodium in NutritionFacts.
     */
    public Measurement getSodium() {
        return this.sodium;
    }

    /**
     * Sets Sodium in NutritionFacts.
     * 
     * @param sodium Sodium in NutritionFacts.
     */
    public void setSodium(Measurement sodium) {
        this.sodium = sodium;
    }

    /**
     * Sets Sodium in NutritionFacts
     * 
     * @param sodium Sodium in milligrams in NutritionFacts.
     */
    public void setSodium(double sodiumInMilligrams) {
    sodium = new Measurement(sodiumInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
    }

    /**
     * Gets Total Carbohydrate in NutritionFacts.
     * 
     * @return Total Carbohydrate in NutritionFacts.
     */
    public Measurement getTotalCarbohydrate() {
        return this.totalCarbohydrate;
    }

    /**
     * Sets Total Carbohydrate in NutritionFacts.
     * 
     * @param totalCarbohydrate Total Carbohydrate in NutritionFacts.
     */
    public void setTotalCarbohydrate(Measurement totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    /**
     * Sets Total Carbohydrate in NutritionFacts.
     * 
     * @param totalCarbohydrateInGrams Total Carbohydrate in grams in NutritionFacts.
     */
    public void setTotalCarbohydrate(double totalCarbohydrateInGrams) {
        this.totalCarbohydrate = new Measurement(totalCarbohydrateInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Dietary Fiber in NutritionFacts.
     * 
     * @return Dietary Fiber in NutritionFacts.
     */
    public Measurement getDietaryFiber() {
        return this.dietaryFiber;
    }

    /**
     * Sets Dietary Fiber in NutritionFacts.
     * @param dietaryFiber Dietary Fiber in NutritionFacts.
     */
    public void setDietaryFiber(Measurement dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    /**
     * Sets Dietary Fiber in NutritionFacts.
     * 
     * @param dietaryFiberInGrams Dietary Fiber in grams in NutritionFacts.
     */
    public void setDietaryFiber(double dietaryFiberInGrams) {
        this.dietaryFiber = new Measurement(dietaryFiberInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Sugars in NutritionFacts.
     * 
     * @return Sugars in NutritionFacts.
     */
    public Measurement getSugars() {
        return this.sugars;
    }

    /**
     * Sets Sugars in NutritionFacts.
     * 
     * @param sugars Sugars in NutritionFacts.
     */
    public void setSugars(Measurement sugars) {
        this.sugars = sugars;
    }

    /**
     * Sugars in NutritionFacts.
     * 
     * @param sugarsInGrams Sugars in grams in NutritionFacts.
     */
    public void setSugars(double sugarsInGrams) {
        this.sugars = new Measurement(sugarsInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Gets Protein in NutritionFacts.
     * 
     * @return Protein in NutritionFacts.
     */
    public Measurement getProtein() {
        return this.protein;
    }

    /**
     * Sets Protein in NutritionFacts.
     * 
     * @param protein Protein in NutritionFacts.
     */
    public void setProtein(Measurement protein) {
        this.protein = protein;
    }

    /**
     * Protein in NutritionFacts.
     * 
     * @param proteinInGrams Protein in grams in NutritionFacts.
     */
    public void setProtein(double proteinInGrams) {
        this.protein = new Measurement(proteinInGrams, Measurement.MetricUnits.GRAMS);
    }

    /**
     * Returns a string with the entire NutritionFacts print out.
     * 
     * @return NutritionFacts table print out.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        if (this.getCalories() != null)
        {
            sb.append("Calories:");
            sb.append(this.getCalories());
            sb.append("\n");
        }

        if (this.getTotalFat() != null)
        {
            sb.append("Total Fat:");
            sb.append(this.getTotalFat());
            sb.append("\n");
        }

        if (this.getSaturatedFat() != null)
        {
            sb.append("\tSaturated Fat:");
            sb.append(this.getSaturatedFat());
            sb.append("\n");
        }

        if (this.getTransFat() != null)
        {
            sb.append("\tTrans Fat:");
            sb.append(this.getTransFat());
            sb.append("\n");
        }

        if (this.getCholesterol() != null)
        {
            sb.append("Cholesterol:");
            sb.append(this.getCholesterol());
            sb.append("\n");
        }

        if (this.getSodium() != null)
        {
            sb.append("Sodium:");
            sb.append(this.getSodium());
            sb.append("\n");
        }

        if (this.getTotalCarbohydrate() != null)
        {
            sb.append("Total Carbohydrate:");
            sb.append(this.getTotalCarbohydrate());
            sb.append("\n");
        }

        if (this.getDietaryFiber() != null)
        {
            sb.append("\tDietary Fiber:");
            sb.append(this.getDietaryFiber());
            sb.append("\n");
        }

        if (this.getSugars() != null)
        {
            sb.append("\tSugars:");
            sb.append(this.getSugars());
            sb.append("\n");
        }

        if (this.getProtein() != null)
        {
            sb.append("Protein:");
            sb.append(this.getProtein());
            sb.append("\n");
        }

        if (sb.length() == 0)
        {
            sb.append("There are no Nutrition Facts available for this item.");
        }

        return sb.toString().trim();
    }

    /**
     * Scales quantity fields of each nutrient field of a NutritionFacts into a new NutritionFacts.
     * 
     * @param nutritionFacts A NutritionFact instance
     * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
     * 
     * @return The new NutritionFact with the scaled field.
     */
    public static NutritionFacts scaleNutritionFacts(NutritionFacts nutritionFacts, double scaleFactor)
    {
        return new NutritionFacts(
            nutritionFacts.getCalories().scale(scaleFactor),
            nutritionFacts.getTotalFat().scale(scaleFactor),
            nutritionFacts.getSaturatedFat().scale(scaleFactor),
            nutritionFacts.getTransFat().scale(scaleFactor),
            nutritionFacts.getCholesterol().scale(scaleFactor),
            nutritionFacts.getSodium().scale(scaleFactor),
            nutritionFacts.getTotalCarbohydrate().scale(scaleFactor),
            nutritionFacts.getDietaryFiber().scale(scaleFactor),
            nutritionFacts.getSugars().scale(scaleFactor),
            nutritionFacts.getProtein().scale(scaleFactor)
            );
    }

    /**
     * Scales quantity fields of each nutrient field into a new NutritionFacts.
     * 
     * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
     * 
     * @return The new NutritionFact with the scaled field.
     */
    public NutritionFacts scale(double scaleFactor)
    {
        return NutritionFacts.scaleNutritionFacts(this, scaleFactor);
    }
    
    /**
     * Gets an array of valid nutrient strings for use with this object.
     * 
     * @return Array of strings.
     */
    public static String[] getAllValidNutrients()
    {
        String[] nutrients = new String[] {};
        ArrayList<String> nutrientList = new ArrayList<String>();
        //use an empty nutrition facts
        NutritionFacts sampleNutritionFacts = NutritionFacts.EmptyNutritionFacts;
        Measurement sampleMeasurement = new Measurement(0.0, "units");
        for (Field field : sampleNutritionFacts.getClass().getDeclaredFields())
        {
            if (field.getType().getName().equals(Measurement.class.getName()))
            {
                String nutrientName = field.getName();
                char[] nutrientNameLetters = nutrientName.toCharArray();
                nutrientName = "";
                for (char letter : nutrientNameLetters)
                {
                    //add spaces between the words
                    String letterString = new String(new char[] { letter });
                    if (letterString.matches("[A-Z]"))
                        nutrientName += " ";
                    nutrientName += letterString;
                }
                //trim white space around the edges
                nutrientName = nutrientName.trim();
                //capitalize first letter
                nutrientName = nutrientName.substring(0, 1).toUpperCase()
                        + nutrientName.substring(1, nutrientName.length());
                //add indents as needed
                if (nutrientName.equals("Saturated Fat") || nutrientName.equals("Trans Fat")
                        || nutrientName.equals("Dietary Fiber") || nutrientName.equals("Sugars"))
                    nutrientName = "    " + nutrientName;
                nutrientList.add(nutrientName);
            }
        }
        return nutrientList.toArray(nutrients);
    }
    
    /**
     * Returns the unit name used for an nutrient name.
     * 
     * @param nutrientName Nutrient name as returned by
     * the getAllValidNutrients() static method.
     * 
     * @return Measurement unit for the nutrient.
     */
    public static String getUnitForNutrient(String nutrientName)
    {
        if (nutrientName.trim().isEmpty())
            return "units";
            
        //remove spaces (makeItCamelCaseLikeThis)
        nutrientName = nutrientName.trim();
        String nutrientFieldName = nutrientName.substring(0, 1).toLowerCase() +
                nutrientName.substring(1, nutrientName.length()).replaceAll(" ", "");
        String nutrientFieldSetterName = "set" + nutrientName.replaceAll(" ", "");
        String nutrientFieldGetterName = "get" + nutrientName.replaceAll(" ", "");
        
        //use an empty nutrition facts
        NutritionFacts sampleNutritionFacts = NutritionFacts.EmptyNutritionFacts;
        for (Field field : sampleNutritionFacts.getClass().getDeclaredFields())
        {
            if (field.getType().getName().equals(Measurement.class.getName()) &&
                    field.getName().toLowerCase().equals(nutrientFieldName.toLowerCase()))
            {
                //call the setter
                for (Method method: sampleNutritionFacts.getClass().getDeclaredMethods())
                {
                    if (method.getName().equals(nutrientFieldSetterName) && (method.getParameterTypes()[0].isPrimitive() ||
                            method.getParameterTypes()[0].getClass().getName().equals(Double.class.getName())))
                    {
                        try {
                            method.invoke(sampleNutritionFacts, Double.valueOf(0.0).doubleValue());
                        } catch (IllegalAccessException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        } catch (IllegalArgumentException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        } catch (InvocationTargetException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        }
                    }
                }
                //call the getter
                Object measurementObject = null;
                for (Method method: sampleNutritionFacts.getClass().getDeclaredMethods())
                {                        
                    if (method.getName().equals(nutrientFieldGetterName) && !method.getReturnType().isPrimitive() &&
                            method.getReturnType().getName().equals(Measurement.class.getName()))
                    {
                        try {
                            measurementObject = method.invoke(sampleNutritionFacts, null);
                        } catch (IllegalAccessException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        } catch (IllegalArgumentException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        } catch (InvocationTargetException ex) {
                            Application.dumpException("Error getting unit for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        }
                    }
                }
                //cast back to a Measurement
                Measurement measurement = null;
                if (measurementObject != null)
                    measurement = (Measurement) measurementObject;
                //STEAL the measurement unit directly out of the getter function, which implements things perfectly
                if (measurement != null)
                    return measurement.getUnit();
            }
        }
        //otherwise tell a lie
        return "units";
    }

    /**
     * Get the Measurement for a nutrient.
     * 
     * @param nutrientName Nutrient name as returned by
     * the getAllValidNutrients() static method.
     * 
     * @return Measurement of the specified nutrient.
     */
    public Measurement getNutrient(String nutrientName)
    {
        if (nutrientName.trim().isEmpty())
            return null;
            
        //remove spaces (makeItCamelCaseLikeThis)
        nutrientName = nutrientName.trim();
        String nutrientFieldName = nutrientName.substring(0, 1).toLowerCase() +
                nutrientName.substring(1, nutrientName.length()).replaceAll(" ", "");
        String nutrientFieldGetterName = "get" + nutrientName.replaceAll(" ", "");
        
        Field[] fields = this.getClass().getDeclaredFields();
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Field field : fields)
        {
            if (field.getType().getName().equals(Measurement.class.getName()) &&
                    field.getName().toLowerCase().equals(nutrientFieldName.toLowerCase()))
            {
                //call the getter
                Object measurementObject = null;
                for (Method method : methods)
                {                        
                    if (method.getName().equals(nutrientFieldGetterName) && !method.getReturnType().isPrimitive() &&
                            method.getReturnType().getName().equals(Measurement.class.getName()))
                    {
                        try {
                            measurementObject = method.invoke(this, null);
                        } catch (IllegalAccessException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        } catch (IllegalArgumentException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        } catch (InvocationTargetException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the getter must be called " + nutrientFieldGetterName + " and that such fields existed. It was the invocation of the getter that failed.", ex);
                        }
                        //cast back to a Measurement
                        Measurement measurement = null;
                        if (measurementObject != null)
                            measurement = (Measurement) measurementObject;
                        //STEAL the measurement unit directly out of the getter function, which implements things perfectly
                        if (measurement != null)
                            return measurement;
                    }
                }
            }
        }
        //otherwise drop nothing
        return null;
    }
    
    /**
     * Sets the Measurement for a nutrient.
     * 
     * @param nutrientName Nutrient name as returned by
     * the getAllValidNutrients() static method.
     * @param measurementQuantity Measurement quantity of the specified nutrient.
     */
    public void setNutrient(String nutrientName, double measurementQuantity)
    {
        if (nutrientName.trim().isEmpty())
            return;
            
        //remove spaces (makeItCamelCaseLikeThis)
        nutrientName = nutrientName.trim();
        String nutrientFieldName = nutrientName.substring(0, 1).toLowerCase() +
                nutrientName.substring(1, nutrientName.length()).replaceAll(" ", "");
        String nutrientFieldSetterName = "set" + nutrientName.replaceAll(" ", "");
        
        //use an empty nutrition facts
        for (Field field : this.getClass().getDeclaredFields())
        {
            if (field.getType().getName().equals(Measurement.class.getName()) &&
                    field.getName().toLowerCase().equals(nutrientFieldName.toLowerCase()))
            {
                //call the setter
                for (Method method: this.getClass().getDeclaredMethods())
                {
                    if (method.getName().equals(nutrientFieldSetterName) && (method.getParameterTypes()[0].isPrimitive() ||
                            method.getParameterTypes()[0].getClass().getName().equals(Double.class.getName())))
                    {
                        try {
                            method.invoke(this, measurementQuantity);
                        } catch (IllegalAccessException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        } catch (IllegalArgumentException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        } catch (InvocationTargetException ex) {
                            Application.dumpException("Error getting measurement for nutrient. Requested unit for \"" + nutrientName + "\". Determined that the object field name must be " + nutrientFieldName + " and the setter must be called " + nutrientFieldSetterName + " and that such fields existed. It was the invocation of the setter that failed.", ex);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean equals(Object object)
    {
       NutritionFacts nutritionFacts = (NutritionFacts)object;
       for (String nutrientName: getAllValidNutrients())
       {
           Measurement nutrient = getNutrient(nutrientName);
           Measurement otherNutrient = nutritionFacts.getNutrient(nutrientName);
           if (nutrient != null && otherNutrient != null && !nutrient.equals(otherNutrient))
               return false;
       }
       return true;
    }
}