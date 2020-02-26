package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class AppendToFile {

	

	public static  void appendToFile(String data, Locale locale) throws Exception, Exception {
		System.out.println(locale);
		
		String FILENAME = "src/main/resources/messages_"+locale.toString() +".properties";
		if (locale.toString().equals("en")) {FILENAME = "src/main/resources/messages.properties";}
		
	
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
			System.out.println(data);
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