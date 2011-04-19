/**
 * 
 */
package com.customfit.ctg.data;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author David
 *
 */
public class DataManager {
	
	/**
	 * 
	 * @return
	 */
	public static FlatFileDriver createFlatFileDriver()
	{
		return new FlatFileDriver();
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<String> listKnownDataDrivers()
	{
		ArrayList<String> driverList = new ArrayList<String>();
		

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		//classLoader.
		
		return driverList;
	}
}
