/**
 * 
 */
package com.customfit.ctg.data.tests;

import java.util.List;

import com.customfit.ctg.data.DataManager;
import com.customfit.ctg.data.FlatFileDriver;

import junit.framework.TestCase;

/**
 * @author david
 *
 */
public class DataManagerTests extends TestCase {

	public void testAcquireFlatFileDriver()
	{
		FlatFileDriver dvr = DataManager.acquireFlatFileDriver();
		assertTrue(dvr.isConnected());
		if (dvr.isConnected()) System.out.println("Acquired driver directly from code:\n\t" + ((Object)dvr).toString() + "\n\tWill use " + dvr.getRecipeDataDirectory().getAbsolutePath() + " for recipe data storage.");
	}
	
	public void testListLoadedDrivers() throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException
	{
		List<String> driverList = DataManager.listLoadedDataDrivers();
		System.out.println("List of loaded drivers (from DataManager):");
		for (String driver : driverList)
		{
			System.out.println("\t" + driver);
		}
		assertTrue(!driverList.isEmpty());
	}
	
	public void testAcquireDriverByUsingFlatFile() throws Exception
	{
		FlatFileDriver dvr = (FlatFileDriver)DataManager.acquireDriver("com.customfit.ctg.data.FlatFileDriver");
		assertTrue(dvr != null);
		if (dvr != null)
		{
			assertTrue(dvr.isConnected());
			if (dvr.isConnected()) System.out.println("Acquired driver using manager-loader:\n\t" + ((Object)dvr).toString() + "\n\tWill use " + dvr.getRecipeDataDirectory().getAbsolutePath() + " for recipe data storage.");
		}
	}
}
