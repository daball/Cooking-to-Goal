package com.customfit.ctg;

import java.io.Serializable;

/**
 * The model of an ingredient
 * @author Drew
 */
public class Ingredient implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private MeasurementType measurement;
	
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
	 * Constructs an Ingredient
	 * @param name
	 */
	public Ingredient(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
