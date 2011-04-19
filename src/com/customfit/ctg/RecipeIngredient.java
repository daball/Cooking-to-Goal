package com.customfit.ctg;

public class RecipeIngredient extends Ingredient{

	private MeasurementType measurementType;
	private double amount;
	
	/**
	 * Creates a default RecipeIngredient with name only.
	 * @param name
	 */
	public RecipeIngredient(String name) {
		super(name);
	}
	
	/**
	 * Creates a RecipeIngredient
	 * @param name
	 */
	public RecipeIngredient(String name, MeasurementType measurementType, double amount) {
		super(name);
		this.setMeasurementType(measurementType);
		this.setAmount(amount);
	}
	
	/**
	 * @return the measurement type
	 */
	public MeasurementType getMeasurementType() {
		return measurementType;
	}
	/**
	 * @param measurementType the measurement to set
	 */
	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
