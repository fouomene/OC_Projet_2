package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeMap;


public class AnalyticsCounter{

	public static void main(String[] args) throws Exception{

		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		//HashMap<String,Integer> symptoms_dictionary = new HashMap<>(); TODO: QUE CHOISIR??? car hashmap est thread safe!
		TreeMap<String,Integer> symptoms_dictionary = new TreeMap<>();

		// tant que le fichier contient une clé
		while (line != null) {
			//System.out.println(line);
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

		// création d'un fichier de sortie
		FileWriter writer = new FileWriter ("results.out");

		// écriture des résultats dans le fichier de sortie
		writer.write(String.valueOf((symptoms_dictionary)));

		// fermeture du reader et du writer
		writer.close();
		reader.close();

		// TODO trier les clés (en cours QUE CHOISIR???)
		// TODO faire un retour à la ligne dans le fichier de sortie

		// TODO faire la javadoc
		// TODO faire une présentation du travail

	}
}

