package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * get interface from ISymptomReader.java
	 * create the TreeMap and sort the keys
	 * and add a counter which is the value of keys
	 *
	 *
	 * @return symptoms dictionnary (who is a treemap)
	 * @throws IOException
	 */

	@Override
	public TreeMap<String, Integer> GetSymptoms() throws IOException {
		TreeMap<String, Integer> symptoms_dictionary = new TreeMap<>();


		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line = reader.readLine();
		// while the text file contain a line
		while (line != null) {
			//System.out.println(line); // print the line for verification
			if (symptoms_dictionary.containsKey(line)) {
				// if key exist in the dictionnary
				// we keep the existant value
				Integer count = symptoms_dictionary.get(line);
				// value's incrementation
				count++;
				// switch de value
				symptoms_dictionary.replace(line, count);

			} else {
				// if key doesn't exist in the dictionnary
				// the default value equal one
				symptoms_dictionary.put(line, 1);
			}
			// read the next line
			line = reader.readLine();
		}
		// reader's close
		reader.close();

		return symptoms_dictionary;
	}
}
