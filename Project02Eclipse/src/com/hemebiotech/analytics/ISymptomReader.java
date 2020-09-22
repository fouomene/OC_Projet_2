package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a TreeMap,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty TreeMap
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */

	TreeMap<String, Integer> GetSymptoms () throws IOException;


}
