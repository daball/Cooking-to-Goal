package com.customfit.ctg.data;

import java.util.*;

/**
 * The DataManager is a utility class with static methods that can be used
 * to access data drivers.
 * @author David
 */
public class DataManager extends ClassLoader {
	
	/**
	 * Returns a new FlatFileDriver object. 
	 * @return A new FlatFileDriver object.
	 */
	public static FlatFileDriver acquireFlatFileDriver()
	{
		return new FlatFileDriver();
	}
	
	/**
	 * You specify a Java class name and this function will return the class 
	 * if it extends DataDriver.
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static DataDriver acquireDriver(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		ClassLoader ldr = Thread.currentThread().getContextClassLoader();
		Class<?> unknown = ldr.loadClass(className);
		Class<? extends DataDriver> known = unknown.asSubclass(DataDriver.class);
		Object curious = known.newInstance();
		return (DataDriver)curious;
	}
	
	/**
	 * 
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 */
	public static List<String> listLoadedDataDrivers() throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException
	{
		ArrayList<String> driverList = new ArrayList<String>();
		driverList.add("com.customfit.ctg.data.FlatFileDriver");
		return driverList;
	}

}
