package com.customfit.ctg.model;

import com.customfit.ctg.controller.*;

/**
 * A NutritionFacts model for nutrition facts table.
 * 
 * Go to this web site for more information about nutrition facts tables.
 * http://www.fda.gov/food/labelingnutrition/consumerinformation/ucm078889.htm
 * 
 * @author Drew, David
 */
public class NutritionFacts{

	private Measurement Calories = null;
	private Measurement TotalFat = null;
	private Measurement SaturatedFat = null;
	private Measurement TransFat = null;
	private Measurement Cholesterol = null;
	private Measurement Sodium = null;
	private Measurement TotalCarbohydrate = null;
	private Measurement DietaryFiber = null;
	private Measurement Sugars = null;
	private Measurement Protein = null;

	public static NutritionFacts EmptyNutritionFactsTable = new NutritionFacts();
	
	public static NutritionFacts CompleteNutritionFactsTable = new NutritionFacts(
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
	 * @param calories
	 * @param totalFat
	 * @param saturatedFat
	 * @param transFat
	 * @param cholesterol
	 * @param sodium
	 * @param totalCarbohydrate
	 * @param dietaryFiber
	 * @param sugars
	 * @param protein
	 */
	public NutritionFacts(Measurement calories, Measurement totalFat,
			Measurement saturatedFat, Measurement transFat,
			Measurement cholesterol, Measurement sodium,
			Measurement totalCarbohydrate, Measurement dietaryFiber,
			Measurement sugars, Measurement protein) {
		super();
		this.setCalories(calories);
                this.setTotalFat(totalFat);
		this.setSaturatedFat(saturatedFat);
		this.setTransFat(transFat);
		this.setCholesterol(cholesterol);
		this.setSodium(sodium);
		this.setTotalCarbohydrate(totalCarbohydrate);
		this.setDietaryFiber(dietaryFiber);
		this.setSugars(sugars);
		this.setProtein(protein);
	}

	/**
	 * 
	 */
	public NutritionFacts() {
		super();
	}

	

	/**
	 * @return the calories
	 */
	public Measurement getCalories() {
		return Calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(Measurement calories) {
		Calories = calories;
	}
	
	/**
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		Calories = new Measurement(calories, Measurement.FoodUnits.CALORIES);
	}

	/**
	 * @return the totalFat
	 */
	public Measurement getTotalFat() {
		return TotalFat;
	}

	/**
	 * @param totalFat the totalFat to set
	 */
	public void setTotalFat(Measurement totalFat) {
		TotalFat = totalFat;
	}
	
	/**
	 * @param totalFatGrams the totalFat (in grams) to set
	 */
	public void setTotalFat(double totalFatGrams) {
		TotalFat = new Measurement(totalFatGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the saturatedFat
	 */
	public Measurement getSaturatedFat() {
		return SaturatedFat;
	}

	/**
	 * @param saturatedFat the saturatedFat to set
	 */
	public void setSaturatedFat(Measurement saturatedFat) {
		SaturatedFat = saturatedFat;
	}
	
	/**
	 * @param saturatedFat the saturatedFat (in grams) to set
	 */
	public void setSaturatedFat(double saturatedFatInGrams) {
		SaturatedFat = new Measurement(saturatedFatInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the transFat
	 */
	public Measurement getTransFat() {
		return TransFat;
	}

	/**
	 * @param transFat the transFat to set
	 */
	public void setTransFat(Measurement transFat) {
		TransFat = transFat;
	}
	
	/**
	 * @param transFat the transFat (in grams) to set
	 */
	public void setTransFat(double transFatInGrams) {
		TransFat = new Measurement(transFatInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the cholesterol
	 */
	public Measurement getCholesterol() {
		return Cholesterol;
	}

	/**
	 * @param cholesterol the cholesterol to set
	 */
	public void setCholesterol(Measurement cholesterol) {
		Cholesterol = cholesterol;
	}
	
	/**
	 * @param cholesterol the cholesterol (in milligrams) to set
	 */
	public void setCholesterol(double cholesterolInMilligrams) {
		Cholesterol = new Measurement(cholesterolInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
	}

	/**
	 * @return the sodium
	 */
	public Measurement getSodium() {
		return Sodium;
	}

	/**
	 * @param sodium the sodium to set
	 */
	public void setSodium(Measurement sodium) {
		Sodium = sodium;
	}
	
	/**
	 * @param sodium the sodium (in milligrams) to set
	 */
	public void setSodium(double sodiumInMilligrams) {
		Sodium = new Measurement(sodiumInMilligrams, Measurement.MetricUnits.MILLIGRAMS);
	}

	/**
	 * @return the totalCarbohydrate
	 */
	public Measurement getTotalCarbohydrate() {
		return TotalCarbohydrate;
	}

	/**
	 * @param totalCarbohydrate the totalCarbohydrate to set
	 */
	public void setTotalCarbohydrate(Measurement totalCarbohydrate) {
		TotalCarbohydrate = totalCarbohydrate;
	}
	
	/**
	 * @param totalCarbohydrate the totalCarbohydrate (in grams) to set
	 */
	public void setTotalCarbohydrate(double totalCarbohydrateInGrams) {
		TotalCarbohydrate = new Measurement(totalCarbohydrateInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the dietaryFiber
	 */
	public Measurement getDietaryFiber() {
		return DietaryFiber;
	}

	/**
	 * @param dietaryFiber the dietaryFiber to set
	 */
	public void setDietaryFiber(Measurement dietaryFiber) {
		DietaryFiber = dietaryFiber;
	}
	
	/**
	 * @param dietaryFiber the dietaryFiber (in grams) to set
	 */
	public void setDietaryFiber(double dietaryFiberInGrams) {
		DietaryFiber = new Measurement(dietaryFiberInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the sugars
	 */
	public Measurement getSugars() {
		return Sugars;
	}

	/**
	 * @param sugars the sugars to set
	 */
	public void setSugars(Measurement sugars) {
		Sugars = sugars;
	}
	
	/**
	 * @param sugars the sugars (in grams) to set
	 */
	public void setSugars(double sugarsInGrams) {
		Sugars = new Measurement(sugarsInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the protein
	 */
	public Measurement getProtein() {
		return Protein;
	}

	/**
	 * @param protein the protein to set
	 */
	public void setProtein(Measurement protein) {
		Protein = protein;
	}
	
	/**
	 * @param protein the protein (in grams) to set
	 */
	public void setProtein(double proteinInGrams) {
		Protein = new Measurement(proteinInGrams, Measurement.MetricUnits.GRAMS);
	}

	/**
	 * @return the emptyNutritionFactsTable
	 */
	public static NutritionFacts getEmptyNutritionFactsTable() {
		return EmptyNutritionFactsTable;
	}

	/**
	 * @param emptyNutritionFactsTable the emptyNutritionFactsTable to set
	 */
	public static void setEmptyNutritionFactsTable(
			NutritionFacts emptyNutritionFactsTable) {
		EmptyNutritionFactsTable = emptyNutritionFactsTable;
	}

	/**
	 * @return the completeNutritionFactsTable
	 */
	public static NutritionFacts getCompleteNutritionFactsTable() {
		return CompleteNutritionFactsTable;
	}

	/**
	 * @param completeNutritionFactsTable the completeNutritionFactsTable to set
	 */
	public static void setCompleteNutritionFactsTable(
			NutritionFacts completeNutritionFactsTable) {
		CompleteNutritionFactsTable = completeNutritionFactsTable;
	}

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
         * @param nutritionFacts A NutritionFact instance
         * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
         * @return The new NutritionFact with the scaled field.
         */
        public static NutritionFacts scaleNutritionFacts(NutritionFacts nutritionFacts, double scaleFactor)
        {
            NutritionFacts newNutritionFacts = null;
            try {
                newNutritionFacts = (NutritionFacts)nutritionFacts.clone();
                newNutritionFacts.setCalories(nutritionFacts.getCalories().scale(scaleFactor));
                newNutritionFacts.setTotalFat(nutritionFacts.getTotalFat().scale(scaleFactor));
                newNutritionFacts.setSaturatedFat(nutritionFacts.getSaturatedFat().scale(scaleFactor));
                newNutritionFacts.setTransFat(nutritionFacts.getTransFat().scale(scaleFactor));
                newNutritionFacts.setCholesterol(nutritionFacts.getCholesterol().scale(scaleFactor));
                newNutritionFacts.setSodium(nutritionFacts.getSodium().scale(scaleFactor));
                newNutritionFacts.setTotalCarbohydrate(nutritionFacts.getTotalCarbohydrate().scale(scaleFactor));
                newNutritionFacts.setDietaryFiber(nutritionFacts.getDietaryFiber().scale(scaleFactor));
                newNutritionFacts.setSugars(nutritionFacts.getSugars().scale(scaleFactor));
                newNutritionFacts.setProtein(nutritionFacts.getProtein().scale(scaleFactor));
            } catch (CloneNotSupportedException ex) {
                Application.dumpException("The was a problem cloning the Nutrition Facts object. Clone is not supported.", ex);
            }
            return newNutritionFacts;
        }
        
        /**
         * Scales quantity fields of each nutrient field into a new NutritionFacts.
         * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
         * @return The new NutritionFact with the scaled field.
         */
        public NutritionFacts scale(double scaleFactor)
        {
            return NutritionFacts.scaleNutritionFacts(this, scaleFactor);
        }
}