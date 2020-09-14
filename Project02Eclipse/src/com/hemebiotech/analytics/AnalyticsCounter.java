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

		FileWriter writer = new FileWriter ("result.txt");
		writer.write(String.valueOf(symptoms_dictionary));
		writer.close();

		// TODO fermer le reader
		// TODO trier les clés
		// TODO créer un fichier de sortie

		// test
		// test
		// test
		reader.close();





	}

}



//
//		FileWriter writer = new FileWriter ("result.out");
//		writer.write("headache: " + headacheCount + "\n");
//		writer.write("rash: " + rashCount + "\n");
//		writer.write("dialated pupils: " + pupilCount + "\n");
//		writer.close();
//	}
//}
