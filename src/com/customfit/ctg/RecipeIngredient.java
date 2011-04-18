package com.customfit.ctg;

public class RecipeIngredient extends Ingredient{

	private MeasurementType measurement;
	private double amount;

	/**
	 * Creates a default RecipeIngredient
	 * @param name
	 */
	public RecipeIngredient(String name) {
		super(name);
	}
	
	/**
	 * @return the measurement
	 */
	public MeasurementType getMeasurement() {
		return measurement;
	}
	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(MeasurementType measurement) {
		this.measurement = measurement;
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
