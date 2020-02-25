package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class AppendToFile {

	

	public static  void appendToFile(String data, Locale locale) {
		System.out.println(locale);
		String FILENAME = "src/main/resources/messages_"+locale.toString() +".properties";
		//(value.equals(locale.toString()))
		
		/* if (locale.toString().equals("es")) {
			System.out.println("Spansk");
			FILENAME = "src/main/resources/messages_es.properties";
		}
		if (locale.toString().equals("se")) {
			System.out.println("Svensk");
			FILENAME = "src/main/resources/messages_se.properties";
		} */
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File(FILENAME);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}