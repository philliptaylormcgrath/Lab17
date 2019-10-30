package co.grandcircus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {
//Contains two methods. One to allow you to write to file. One that allows you to read from file
	
	public static void createFile() {
		String fileName = "countries.txt";
		Path path = Paths.get("resources", fileName);
		
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File successfully created");
			} catch (IOException e) {
				System.out.println("Problem creating file. File not created");
			}
		} else {
			System.out.println("The file already exists");
		}
		
	}
	public static void readFromFile() {
		String fileName = "countries.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}			
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("404 File not found");
		} catch (IOException e) {
			System.out.println("IOException, something's fucked. File was not read");
		}
		
	}
	public static void writeToFile(Country inputCountry) {
		String fileName = "countries.txt";
		Path path = Paths.get("resources", fileName);
		File file = path.toFile();
		PrintWriter output; //These two lines could be one line declaring and initializing. Putting it outside of the trycatch allows us to close the output in the 'finally' logic
		output = null;
		try {
			
			output = new PrintWriter(new FileOutputStream(file, true));//set to false or delete the bool to overwrite the file, otherwise adds
			
			output.println(inputCountry);
			
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("404 File not found");
		} finally {
			output.close();
		}
			
	}
}
