package com.customfit.ctg.model;

public class RecipeIngredient extends Ingredient{

	private MeasurableUnit amount = new MeasurableUnit(0.0, "units");
	
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
	public RecipeIngredient(String name, MeasurableUnit amount) {
		super(name);
		this.amount = amount;
	}
	
	/**
	 * Creates a RecipeIngredient
	 * @param name
	 */
	public RecipeIngredient(String name, double quantity, String unit) {
		super(name);
		this.amount = new MeasurableUnit(quantity, unit);
	}
	
	public MeasurableUnit getAmount() {
		return this.amount;
	}
	
	public String getMeasurementUnit() {
		return this.amount.getUnit();
	}
	
	public double getMeasurementAmount() {
		return this.amount.getQuantity();
	}
	
	public String toString()
	{
		return this.getAmount() + " " + this.getName();
	}
}