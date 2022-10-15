package a3;

import javax.swing.JOptionPane;

import a3.TableRow;
import a3.TextTable;

/**
 * <p> Title: APC 390 Assignment #1 </p>
 * <p> Description: Interactive Table builder. Assign1Main
 *     - read a text file containing a table of data </p>
 * <p> Copyright: Copyright (c) 2021 </p>
 * <p> Company: UWRF </p>
 * 
 * @author Anthony Varghese, Maggie Herms mkherms@uwm.edu
 * @version 1.0
 * 
 * Summary of Changes: Added TextTable and TableRow classes with functionality for loading in a txt file to a 
 * "table" array, saving our "table" array to another txt file as output, adding a row to our "table" array, 
 * finding a row in our "table" array, and removing a row in the "table" array.
 * 
 */

public class Assign3Main {
	static final int LOADCITY = 1, SAVECITY = 2, ADDCITY_ROW = 3, REMOVECITY_ROW = 4, FINDCITY_ROW = 5,
			LOADSTAD = 6, SAVESTAD = 7, ADDSTAD_ROW = 8, REMOVESTAD_ROW = 9, FINDSTAD_ROW = 10, QUIT = 11;

	static final String welcomeMessage = "This program implements an interactive table builder.\n"
			+ "You can have one active stadium table and one active city table at a time.\n"
			+ "You can add new rows or remove rows from tables.\n"
			+ "You can also load a table from a file or save a current\n"
			+ "table to a file.\n";
	static final String promptMessage = "What would you like to do?\n"
			+ "Please enter the number corresponding to the action you would like:\n"
			+ "   " + LOADCITY + ": Load a city table from a file\n"
			+ "   " + SAVECITY + ": Save current city table to a file\n"
			+ "   " + ADDCITY_ROW + ": Add a row to the current city table\n"
			+ "   " + REMOVECITY_ROW + ": Remove a row from the current city table\n"
			+ "   " + FINDCITY_ROW + ": Find a city table row\n"
			+ "   " + LOADSTAD + ": Load a stadium table from a file\n"
			+ "   " + SAVESTAD + ": Save current stadium table to a file\n"
			+ "   " + ADDSTAD_ROW + ": Add a row to the current stadium table\n"
			+ "   " + REMOVESTAD_ROW + ": Remove a row from the current stadium table\n"
			+ "   " + FINDSTAD_ROW + ": Find a stadium table row\n"
			+ "   " + QUIT + ": Quit\n";

	
	public static void main(String[] args) {
		System.out.println("Maggie Herms");
		JOptionPane.showMessageDialog(null, welcomeMessage);
		
		CityTable myCityTable = new CityTable();
		StadiumTable myStadTable = new StadiumTable();

		int userSelection = 0;
		while (userSelection != QUIT) {
			userSelection = Integer.parseInt(JOptionPane.showInputDialog(promptMessage));
			processSelection(myCityTable, myStadTable, userSelection);
		}
	}

	private static void processSelection(CityTable myCityTable, StadiumTable myStadiumTable, int userSelection) {
		switch (userSelection) {
		case LOADCITY:
			// Remember that you can have text files in your Eclipse Project
			// If this file is in src/a1, you could read the input.txt file in your a1
			// package
			// using the "fileName" src/a1/input.txt
			String cityFileName = JOptionPane.showInputDialog("Please enter the name of the city text file to load");
			System.out.println("Opening the file '" + cityFileName + "'.");
			myCityTable.loadTableFromFile(cityFileName);
			break;
		case SAVECITY:
			cityFileName = JOptionPane.showInputDialog("Please enter the name of the text file to save the city table");
			myCityTable.saveTable(cityFileName);
			break;
		case ADDCITY_ROW:
			String cityName = JOptionPane.showInputDialog("Please enter the name of the city you want to add");
			String cityID = JOptionPane.showInputDialog("Please enter the ID for: " + cityName);
			String cityPop = JOptionPane.showInputDialog("Please enter the population, in millions, for: " + cityName);
			myCityTable.addRow(cityName, cityID, cityPop);
			break;
		case REMOVECITY_ROW:
			cityID = JOptionPane
					.showInputDialog("Please enter the city ID in the row you want to remove from the table");
			myCityTable.removeRow(cityID);
			break;
		case FINDCITY_ROW:
			cityName = JOptionPane.showInputDialog("Please enter the city name in the row you want to find.");
			JOptionPane.showMessageDialog(null, myCityTable.findRow(cityName));
			break;
		case LOADSTAD:
			String stadFileName = JOptionPane.showInputDialog("Please enter the name of the stadium text file to load");
			System.out.println("Opening the file '" + stadFileName + "'.");
			myStadiumTable.loadTableFromFile(stadFileName);
			break;
		case SAVESTAD:
			stadFileName = JOptionPane.showInputDialog("Please enter the name of the text file to save the stadium table");
			myStadiumTable.saveTable(stadFileName);
			break;
		case ADDSTAD_ROW:
			String stadName = JOptionPane.showInputDialog("Please enter the name of the stadium");
			String stadCityID = JOptionPane.showInputDialog("Please enter the City ID for: " + stadName);
			String stadTeamName = JOptionPane.showInputDialog("Please enter the team name for: " + stadName);
			String stadCapacity = JOptionPane.showInputDialog("Please enter the capacity for: " + stadName);
			myStadiumTable.addRow(stadName, stadCityID, stadTeamName, stadCapacity);
			break;
		case REMOVESTAD_ROW:
			stadName = JOptionPane
					.showInputDialog("Please enter the name of the stadium in the row you want to remove from the table");
			myStadiumTable.removeRow(stadName);
			break;
		case FINDSTAD_ROW:
			stadName = JOptionPane.showInputDialog("Please enter the name of the stadium in the row you want to find.");
			JOptionPane.showMessageDialog(null, myStadiumTable.findRow(stadName));
			break;
		case QUIT:
			JOptionPane.showMessageDialog(null, "Have a nice day");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid Input");
		}
	}
}
