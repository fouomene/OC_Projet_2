package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * read a text file "symptoms.txt", create a TreeMap, with lines
 * considerring as keys and new occurences from existing lines
 * are considerring as a +1 (value's incrementation) and finally
 * write this dictionnary in another text file "results.out".
 */

public class AnalyticsCounter{

	public static void main(String[] args) throws Exception{
		TreeMap<String,Integer> symptoms_dictionary = new TreeMap<>();
		readSymptoms(symptoms_dictionary, "symptoms.txt");
		writeResult(symptoms_dictionary, "results.out");
	}

	/**
	 *
	 * @param symptoms_dictionary
	 * @param fileName
	 * @throws IOException
	 *
	 *
	 *this function read the symtoms in the text file
	 *and create (and close) the reader by the way
	 * Also, create the counter of each symptoms
	 */

	private static void readSymptoms(TreeMap<String, Integer> symptoms_dictionary, String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();

		// while the text file contains a line
		while (line != null) {
			//System.out.println(line); // print the line for verification
			if(symptoms_dictionary.containsKey(line)){
				// if key exist in the dictionnary
				// we keep the existant value
				Integer count = symptoms_dictionary.get(line);
				// value's incrementation
				count++;
				// switch de value
				symptoms_dictionary.replace(line,count);

			}else {
				// if key doesn't exist in the dictionnary
				// the default value equal one
				symptoms_dictionary.put(line,1);
			}
			// read the next line
			line = reader.readLine();
		}
		// reader's close
		reader.close();
	}

	/**
	 *
	 * @param symptoms_dictionary
	 * @param fileName
	 * @throws IOException
	 *
	 * This function create (and close) the writer
	 * and present the dictionnary in separated line.
	 *
	 */


	private static void writeResult(TreeMap<String, Integer> symptoms_dictionary, String fileName) throws IOException {
		// create an output file
		FileWriter writer = new FileWriter (fileName);

		// write the result in the output file
		for (String key : symptoms_dictionary.keySet() ) {
			writer.write("symptom from file : "+key +" = "+
					symptoms_dictionary.get(key)+System.lineSeparator());
		}

		//redactor's close
		writer.close();
	}
}

