/**
 * 
 */
package com.customfit.ctg.data;

import com.customfit.ctg.data.*;
import junit.framework.TestCase;

/**
 * @author david
 *
 */
public class DataManagerTestCase extends TestCase {

	public void testAcquireFlatFileDriver()
	{
		FlatFileDriver dvr = DataManager.acquireFlatFileDriver();
		assertTrue(dvr.isConnected());
		if (dvr.isConnected()) System.out.println("Acquired driver. Will use " + dvr.getRecipeDataDirectory().getAbsolutePath() + " for recipe data storage.");
	}
}
