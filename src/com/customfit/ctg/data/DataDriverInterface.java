/**
 * 
 */
package com.customfit.ctg.data;

import java.util.List;

/** 
 * @author David
 *
 */
public interface DataDriverInterface <ItemType> {
	/**
	 * Returns a set of all objects of ListType<ItemType> type.
	 * @return A list of all E objects.
	 */
	public List<ItemType> getAll();
	/**
	 * Returns a object of E type.
	 * @param String Some object identifier.
	 * @return A list of all E objects.
	 */
	public ItemType get(String s);
	/**
	 * Saves an object of ItemType type.
	 * @param object Any ItemType object.
	 * @return Boolean indicating the success of the save operation.
	 */
	public boolean saveObject(ItemType object);
}
