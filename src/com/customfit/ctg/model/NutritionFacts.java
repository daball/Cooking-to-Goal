package com.customfit.ctg.model;

/**
 * A model of nutrition facts
 * @author Drew
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
		this.Calories = calories;
		this.TotalFat = totalFat;
		this.SaturatedFat = saturatedFat;
		this.TransFat = transFat;
		this.Cholesterol = cholesterol;
		this.Sodium = sodium;
		this.TotalCarbohydrate = totalCarbohydrate;
		this.DietaryFiber = dietaryFiber;
		this.Sugars = sugars;
		this.Protein = protein;
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
		
		sb.append("Calories:");
		sb.append(this.getCalories());
		sb.append("\n");
		
		sb.append("Total Fat:");
		sb.append(this.getTotalFat());
		sb.append("\n");
		
		sb.append("\tSaturated Fat:");
		sb.append(this.getSaturatedFat());
		sb.append("\n");

		sb.append("\tTrans Fat:");
		sb.append(this.getTransFat());
		sb.append("\n");
		
		sb.append("Cholesterol:");
		sb.append(this.getCholesterol());
		sb.append("\n");
		
		sb.append("Sodium:");
		sb.append(this.getSodium());
		sb.append("\n");
		
		sb.append("Total Carbohydrate:");
		sb.append(this.getTotalCarbohydrate());
		sb.append("\n");

		sb.append("\tDietary Fiber:");
		sb.append(this.getDietaryFiber());
		sb.append("\n");

		sb.append("\tSugars:");
		sb.append(this.getSugars());
		sb.append("\n");
		
		sb.append("Protein:");
		sb.append(this.getProtein());
		sb.append("\n");
		
		return sb.toString();
	}
}