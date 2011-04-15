/**
 * 
 */
package com.customfit.ctg.data;

import java.util.List;

/** 
 * @author David
 *
 */
public interface FileAccessDriverInterface <ItemType> {
	/**
	 * Returns a set of all objects of ListType<ItemType> type.
	 * @return A list of all E objects.
	 */
	public List<ItemType> getAll();
	/**
	 * Saves an object of ItemType type.
	 * @param object Any ItemType object.
	 * @return Boolean indicating the success of the save operation.
	 */
	public boolean saveObject(ItemType object);
}
