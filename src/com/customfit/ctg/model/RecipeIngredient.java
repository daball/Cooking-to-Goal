package com.customfit.ctg.model;

public class RecipeIngredient extends Ingredient{

	private MeasurableUnit measurement = new MeasurableUnit(0.0, "units");
	
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
	public RecipeIngredient(String name, MeasurableUnit measuableUnit) {
		super(name);
		this.measurement = measuableUnit;
	}
	
	/**
	 * Creates a RecipeIngredient
	 * @param name
	 */
	public RecipeIngredient(String name, double quantity, String unit) {
		super(name);
		this.measurement = new MeasurableUnit(quantity, unit);
	}
	
	public MeasurableUnit getMeasurement() {
		return measurement;
	}
	
	public String getMeasurementUnit() {
		return measurement.getUnit();
	}
	
	public double getMeasurementQuantity() {
		return measurement.getQuantity();
	}
	
	public String toString()
	{
		return this.getMeasurement() + " " + this.getName();
	}
}