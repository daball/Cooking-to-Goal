package com.customfit.ctg.model;

/**
 * Data model for nutrition facts table.
 * 
 * Go to this web site for more information about nutrition facts tables.
 * http://www.fda.gov/food/labelingnutrition/consumerinformation/ucm078889.htm
 * 
 * @author Drew, David
 */
public class NutritionFacts{

	private MeasurableUnit Calories = null;
	private MeasurableUnit TotalFat = null;
	private MeasurableUnit SaturatedFat = null;
	private MeasurableUnit TransFat = null;
	private MeasurableUnit Cholesterol = null;
	private MeasurableUnit Sodium = null;
	private MeasurableUnit TotalCarbohydrate = null;
	private MeasurableUnit DietaryFiber = null;
	private MeasurableUnit Sugars = null;
	private MeasurableUnit Protein = null;

	public static NutritionFacts EmptyNutritionFactsTable = new NutritionFacts();
	
	public static NutritionFacts CompleteNutritionFactsTable = new NutritionFacts(
			new MeasurableUnit(0.0, MeasurementUnit.FoodUnits.CALORIES),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.MILLIGRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.MILLIGRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS),
			new MeasurableUnit(0.0, MeasurementUnit.MetricUnits.GRAMS)
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
	public NutritionFacts(MeasurableUnit calories, MeasurableUnit totalFat,
			MeasurableUnit saturatedFat, MeasurableUnit transFat,
			MeasurableUnit cholesterol, MeasurableUnit sodium,
			MeasurableUnit totalCarbohydrate, MeasurableUnit dietaryFiber,
			MeasurableUnit sugars, MeasurableUnit protein) {
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
	public MeasurableUnit getCalories() {
		return Calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(MeasurableUnit calories) {
		Calories = calories;
	}
	
	/**
	 * @param calories the calories to set
	 */
	public void setCalories(double calories) {
		Calories = new MeasurableUnit(calories, MeasurementUnit.FoodUnits.CALORIES);
	}

	/**
	 * @return the totalFat
	 */
	public MeasurableUnit getTotalFat() {
		return TotalFat;
	}

	/**
	 * @param totalFat the totalFat to set
	 */
	public void setTotalFat(MeasurableUnit totalFat) {
		TotalFat = totalFat;
	}
	
	/**
	 * @param totalFatGrams the totalFat (in grams) to set
	 */
	public void setTotalFat(double totalFatGrams) {
		TotalFat = new MeasurableUnit(totalFatGrams, MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the saturatedFat
	 */
	public MeasurableUnit getSaturatedFat() {
		return SaturatedFat;
	}

	/**
	 * @param saturatedFat the saturatedFat to set
	 */
	public void setSaturatedFat(MeasurableUnit saturatedFat) {
		SaturatedFat = saturatedFat;
	}
	
	/**
	 * @param saturatedFat the saturatedFat (in grams) to set
	 */
	public void setSaturatedFat(double saturatedFatInGrams) {
		SaturatedFat = new MeasurableUnit(saturatedFatInGrams, MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the transFat
	 */
	public MeasurableUnit getTransFat() {
		return TransFat;
	}

	/**
	 * @param transFat the transFat to set
	 */
	public void setTransFat(MeasurableUnit transFat) {
		TransFat = transFat;
	}
	
	/**
	 * @param transFat the transFat (in grams) to set
	 */
	public void setTransFat(double transFatInGrams) {
		TransFat = new MeasurableUnit(transFatInGrams, MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the cholesterol
	 */
	public MeasurableUnit getCholesterol() {
		return Cholesterol;
	}

	/**
	 * @param cholesterol the cholesterol to set
	 */
	public void setCholesterol(MeasurableUnit cholesterol) {
		Cholesterol = cholesterol;
	}
	
	/**
	 * @param cholesterol the cholesterol (in milligrams) to set
	 */
	public void setCholesterol(double cholesterolInMilligrams) {
		Cholesterol = new MeasurableUnit(cholesterolInMilligrams, MeasurementUnit.MetricUnits.MILLIGRAMS);
	}

	/**
	 * @return the sodium
	 */
	public MeasurableUnit getSodium() {
		return Sodium;
	}

	/**
	 * @param sodium the sodium to set
	 */
	public void setSodium(MeasurableUnit sodium) {
		Sodium = sodium;
	}
	
	/**
	 * @param sodium the sodium (in milligrams) to set
	 */
	public void setSodium(double sodiumInMilligrams) {
		Sodium = new MeasurableUnit(sodiumInMilligrams, MeasurementUnit.MetricUnits.MILLIGRAMS);
	}

	/**
	 * @return the totalCarbohydrate
	 */
	public MeasurableUnit getTotalCarbohydrate() {
		return TotalCarbohydrate;
	}

	/**
	 * @param totalCarbohydrate the totalCarbohydrate to set
	 */
	public void setTotalCarbohydrate(MeasurableUnit totalCarbohydrate) {
		TotalCarbohydrate = totalCarbohydrate;
	}
	
	/**
	 * @param totalCarbohydrate the totalCarbohydrate (in grams) to set
	 */
	public void setTotalCarbohydrate(double totalCarbohydrateInGrams) {
		TotalCarbohydrate = new MeasurableUnit(totalCarbohydrateInGrams, MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the dietaryFiber
	 */
	public MeasurableUnit getDietaryFiber() {
		return DietaryFiber;
	}

	/**
	 * @param dietaryFiber the dietaryFiber to set
	 */
	public void setDietaryFiber(MeasurableUnit dietaryFiber) {
		DietaryFiber = dietaryFiber;
	}
	
	/**
	 * @param dietaryFiber the dietaryFiber (in grams) to set
	 */
	public void setDietaryFiber(double dietaryFiberInGrams) {
		DietaryFiber = new MeasurableUnit(dietaryFiberInGrams,  MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the sugars
	 */
	public MeasurableUnit getSugars() {
		return Sugars;
	}

	/**
	 * @param sugars the sugars to set
	 */
	public void setSugars(MeasurableUnit sugars) {
		Sugars = sugars;
	}
	
	/**
	 * @param sugars the sugars (in grams) to set
	 */
	public void setSugars(double sugarsInGrams) {
		Sugars = new MeasurableUnit(sugarsInGrams, MeasurementUnit.MetricUnits.GRAMS);
	}

	/**
	 * @return the protein
	 */
	public MeasurableUnit getProtein() {
		return Protein;
	}

	/**
	 * @param protein the protein to set
	 */
	public void setProtein(MeasurableUnit protein) {
		Protein = protein;
	}
	
	/**
	 * @param protein the protein (in grams) to set
	 */
	public void setProtein(double proteinInGrams) {
		Protein = new MeasurableUnit(proteinInGrams, MeasurementUnit.MetricUnits.GRAMS);
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
}