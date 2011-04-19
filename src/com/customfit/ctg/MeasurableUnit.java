/**
 * 
 */
package com.customfit.ctg;

/**
 * A MeasurableUnit represents what, in science, is typically
 * called a vector quantity. That is, it is two things: a value,
 * and a unit.
 * @author David
 */
public class MeasurableUnit implements Comparable<MeasurableUnit> {
	
	private double quantity = 0.0;	
	private String unit = null;
	
	/**
	 * Create a new MeasurableUnit with the quantity and unit specified.
	 * 
	 * @param quantity Amount. (e.g., 1.0, 99)
	 * @param unit Measurement. (e.g., grams, gallons, miles, millenia)
	 */
	public MeasurableUnit(double quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}
	
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString()
	{
		return this.getQuantity() + " " + this.getUnit();
	}
	
	public int compareTo(MeasurableUnit o)
	{
		if (this.getUnit() != o.getUnit())
		{
			System.err.println("compareTo() hit on MeasurableUnit with different units specified. You shouldn't compare apples and oranges if you expect a similar result. Will supply mathematical differenc, but fix your units.");
		}
		
		return Double.compare(this.getQuantity(), o.getQuantity());
	}
}