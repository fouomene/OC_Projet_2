package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * read a text file "symptoms.txt", create a TreeMap, with lines
 * considerring as keys and new occurences from existing lines
 * are considerring as a +1 (value's incrementation) and finally
 * write this dictionnary in an output text file "results.out".
 */

// Create objects :TreeMap and the input and output file
public class AnalyticsCounter{
	TreeMap<String,Integer> symptoms_dictionary = new TreeMap<>();
	String inputFile;
	String outputFile;

	//method constructor
	public AnalyticsCounter(String inputFile, String outputFile) {
		this.inputFile = inputFile;
		this.outputFile = outputFile;
	}

	public static void main(String[] args) throws Exception{

		AnalyticsCounter analyticsCounter = new AnalyticsCounter("symptoms.txt","results.out" );

		analyticsCounter.readSymptoms();
		analyticsCounter.writeResult();
	}

	private  void readSymptoms() throws IOException {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(this.inputFile);
		this.symptoms_dictionary = readSymptomDataFromFile.GetSymptoms();
	}

	/**
	 *
	 * @throws IOException
	 *
	 * This function create (and close) the writer
	 * and present the TreeMap dictionnary in separated line.
	 *
	 */
	private void writeResult() throws IOException {
		// create an output file
		FileWriter writer = new FileWriter (this.outputFile);

		// write the result in the output file
		for (String key : symptoms_dictionary.keySet() ) {
			writer.write("symptom from file : "+key +" = "+
					symptoms_dictionary.get(key)+System.lineSeparator());
		}

		//redactor's close
		writer.close();
	}
}

