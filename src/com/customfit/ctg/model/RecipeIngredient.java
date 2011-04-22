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
	 * Creates a RecipeIngredient with name and amount.
	 * @param name Ingredient name. 
         * @param amount A MeasurableUnit instance.
	 */
	public RecipeIngredient(String name, MeasurableUnit amount) {
		super(name);
		this.amount = amount;
	}
	
	/**
	 * Creates a RecipeIngredient with name and amount. The amount
         * will be converted to a MeasurableUnit out of the quantity and unit.
	 * @param name Ingredient name.
         * @param quantity Quantity.
         * @param unit Measurement unit.
	 */
	public RecipeIngredient(String name, double quantity, String unit) {
		super(name);
		this.amount = new MeasurableUnit(quantity, unit);
	}
        
	/**
	 * Creates a RecipeIngredient with name and amount. The amount
         * will be converted to a MeasurableUnit out of the String.
	 * @param name Ingredient name.
         * @param measureableUnitString MeasurableUnit string.
	 */
        public RecipeIngredient(String name, String measureableUnitString) {
                super(name);
                this.amount = new MeasurableUnit(measureableUnitString);
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