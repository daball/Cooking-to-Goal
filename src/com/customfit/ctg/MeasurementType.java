package com.customfit.ctg;

public enum MeasurementType {
	
	POUNDS,
	GALLONS,
	QUARTS,
	PINTS,
	CUPS,
	LIQUID_OUNCES, 	// Volume
	DRY_OUNCES, 	// Weight
	TABLESPOONS,
	TEASPOONS;
	
	public static double convertToOunces(MeasurementType x, int value){
		double ounces = value;
		
		switch(x){
			case POUNDS:
				ounces *= 16;
				break;
				
			case GALLONS:
				ounces *= 128;
				break;
				
			case QUARTS:
				ounces *= 32;
				break;
				
			case PINTS:
				ounces *= 16;
				break;
				
			case CUPS:
				ounces *= 8;
				break;
				
			case LIQUID_OUNCES:
				break;
				
			case DRY_OUNCES:
				break;
				
			case TABLESPOONS:
				ounces *= .5;
				break;
				
			case TEASPOONS:
				ounces *= .167;
				break;
				
			default:
				System.err.println("Error: no MeasurementType provided.");
				break;
		}
		
		return ounces;
	}
}
