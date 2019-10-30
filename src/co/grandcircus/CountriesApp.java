package co.grandcircus;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//ArrayList<Country> userList = new ArrayList<Country>();
		String countryName;
		Long population;
		int userInput;
		String userInput2 = "y";
		CountriesBinaryFile.createFile(); //Created the .txt file we are storing our information in. No longer of use. Comment remains for posterity. 
		do {
			userInput = Validator.getInt(scan, "Welcome to survey of nations! Please enter an input: " + "\n" + "1. Display a list of countries. " + "\n" + "2. Enter a country. " + "\n" + "3. Quit. ");
			
			if (userInput == 1) {
				CountriesBinaryFile.readFromFile();
				
			} else if (userInput == 2) {
				
				countryName = Validator.getString(scan, "Please input the name of the country you're adding: ");
					
					population = Validator.getLong(scan, "Please input the country population: ");
					
					Country newCountry = new Country();
					
					newCountry.setName(countryName);
					
					newCountry.setPopulation(population);
					
					CountriesBinaryFile.writeToFile(newCountry);
					
			}  else if (userInput == 3 ) {
					System.out.println("Are you sure you want to quit? y/n: ");
					userInput2 = scan.next();
						if (userInput2.equalsIgnoreCase("y")){
							userInput = 3;
							System.out.println("GOODBYE FOREVER");//program ends
						} else if (userInput2.equalsIgnoreCase("n")) {
							userInput = 0;
						}
					
			} else {
				System.out.println("Sorry I didn't understand, let's try again."); // if above conditions aren't met
																					// (userInput == anything but 5), nothing
																					// increments and message is
																					// displayed
			}
		} while (userInput != 3); 
		scan.close();
				}

	}
	

