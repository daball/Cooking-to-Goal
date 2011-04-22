package com.customfit.ctg.model;

public class MeasurementUnit
{
	public static class USAUnits
	{
		//USA units
		public static String POUNDS			= "pounds";
		public static String GALLONS		= "gallons";
		public static String QUARTS			= "quarts";
		public static String PINTS			= "pints";
		public static String CUPS			= "cups";
		public static String LIQUID_OUNCES	= "fluid ounces"; 	// Volume
		public static String DRY_OUNCES		= "ounces (dry)"; 	// Weight
		public static String TABLESPOONS	= "tablespoons";
		public static String TEASPOONS		= "teaspoons";
	}
	
	public static class MetricUnits
	{
		//metric units
		public static String GRAMS			= "grams";
		public static String MILLIGRAMS		= "milligrams";
	}
	
	public static class FoodUnits
	{
		//food units
		public static String CALORIES		= "Calories"; //capitalize, because calories != Calories, sometimes also called kCals.
	}	
	
	public static double toOunces(MeasurableUnit foodUnit)
	{
		return toOunces(foodUnit.getQuantity(), foodUnit.getUnit());
	}
	
	public static double toOunces(double amount, String measurementUnit)
	{
		double ounces = amount;		
		if (measurementUnit == USAUnits.POUNDS || measurementUnit == USAUnits.PINTS)
			ounces *= 16.0;
		else if (measurementUnit == USAUnits.GALLONS)
			ounces *= 128.0;
		else if (measurementUnit == USAUnits.QUARTS)
			ounces *= 32.0;
		else if (measurementUnit == USAUnits.CUPS)
			ounces *= 8.0;
		else if (measurementUnit == USAUnits.TABLESPOONS)
			ounces *= .5;
		else if (measurementUnit == USAUnits.TEASPOONS)
			ounces *= .167;
		else if (measurementUnit == USAUnits.LIQUID_OUNCES || measurementUnit == USAUnits.DRY_OUNCES)
		{
			//ounces = ounces;
			//so do nothing			
		}
		else
		{
			ounces = 0.0;
			System.err.println("Error: Unknown measurement unit provided for conversion.");
		}
		return ounces;
	}
}
