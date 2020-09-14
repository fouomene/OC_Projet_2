package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class AnalyticsCounter{

	public static void main(String[] args) throws Exception{


		HashMap<String,Integer> symptoms_dictionary = new HashMap<>();
		File file = new File("symptoms.txt");
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();


		// tant que le fichier contient une clé
		while (line != null) {
			System.out.println(line);
			if(symptoms_dictionary.containsKey(line)){
				// si la clé existe dans le dictionnaire
				// on récupère la valeur existante
				Integer count = symptoms_dictionary.get(line);
				// on incrémente la valeur
				count++;
				// on remplace la valeur
				symptoms_dictionary.replace(line,count);
			}else {
				// si la clé n'existe pas dans le dictionnaire
				// la valeur est par défaut à 1
				symptoms_dictionary.put(line,1);
			}
			// on lit la ligne suivante
			line = reader.readLine();
		}
		// TODO fermer le reader
		// TODO trier les clés
		// TODO créer un fichier de sortie

		// test
		// test
		// test
		FileWriter writer = new FileWriter ("result.out");
		writer.close();

	}

}



////import java.io.BufferedReader;
////import java.io.FileReader;

//import java.io.FileWriter;
//
////public class AnalyticsCounter {
////	private static int headacheCount = 0;	// initialize to 0
////	private static int rashCount = 0;		// initialize to 0
////	private static int pupilCount = 0;		// initialize to 0
//
////	public static void main(String args[]) throws Exception {
//		// first get input
//
////		ArrayList<String > symptoms = new ArrayList<>();
////		File file = new File("symptoms.txt");
//
//		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
//		String line = reader.readLine();
//
//		int i = 0;	// set i to 0
//		int headCount = 0;	// counts headaches
//		while (line != null) {
//			i++;	// increment i
//			System.out.println("symptom from file: " + line);

//			if (line.equals("headache")) {
//				headCount++;
//				System.out.println("number of headaches: " + headCount);
//			}else if (line.equals("rush")) {
//				rashCount++;
//			}else if (line.contains("pupils")) {
//				pupilCount++;
//			}
//
//			line = reader.readLine();	// get another symptom
//		}

//
//		// next generate output
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
//	}
//}
