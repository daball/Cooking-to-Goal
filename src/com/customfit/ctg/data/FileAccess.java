/**
 * 
 */
package com.customfit.ctg.data;

import java.util.AbstractList;

/**
 * @author David
 *
 */
public interface FileAccess <E> {
	/**
	 * Returns a set of all objects of E type.
	 * @return A list of all E objects.
	 */
	public AbstractList<E> getAll();
	/**
	 * Saves an object of E type.
	 * @param object Any E object.
	 * @return Boolean indicating the success of the save operation.
	 */
	public boolean saveObject(E object);
}
