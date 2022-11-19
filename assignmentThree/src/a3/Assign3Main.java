package a3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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
 * @version 2.0
 * Using abstraction, create Abstract Table and Abstract Row classes to define methods for subclasses: City Table, Stadium Table, City Row, Stadium Row
 * A user can have one active city table and one active stadium table at a time
 * The user can load or save a table from/to a text file, add rows, remove rows, or find rows.
 * 
 */

public class Assign3Main {
	static final int LOAD = 1, SAVE = 2, ADD_ROW = 3, REMOVE_ROW = 4, FIND_ROW = 5, QUIT = 6;

	static final String welcomeMessage = "This program implements an interactive table builder.\n"
			+ "You can have one active stadium table and one active city table at a time.\n"
			+ "You can add new rows or remove rows from tables.\n"
			+ "You can also load a table from a file or save a current table to a file.\n";
			
	static final String promptMessage = "What would you like to do?\n"
			+ "Please enter the number corresponding to the action you would like:\n"
			+ "   " + LOAD + ": Load a table from a file\n"
			+ "   " + SAVE + ": Save current table to a file\n"
			+ "   " + ADD_ROW + ": Add a row to the current table\n"
			+ "   " + REMOVE_ROW + ": Remove a row from the current table\n"
			+ "   " + FIND_ROW + ": Find a table row with an ID\n"
			+ "   " + QUIT + ": Quit\n";

	
	public static void main(String[] args) {
		System.out.println("Maggie Herms");
		JOptionPane.showMessageDialog(null, welcomeMessage);
		
		AbstractTable myCityTable = new CityTable();
		AbstractTable myStadTable = new StadiumTable();
		
		String[] options = {"City Table", "Stadium Table"}; //Creates button options for user to choose which table to work with 
		
		int userSelection = 0;
		int tableType = 0;
		
		while (userSelection != QUIT) {
			tableType = JOptionPane.showOptionDialog(null, "Which table would you like to work with?", "Table Selection", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); //ask user which table they want to work with
			
			if (tableType == -1) { //If user exits tableType GUI, break from loop and quit program
				break;
			}
			
			userSelection = Integer.parseInt(JOptionPane.showInputDialog(promptMessage)); 
			
			//Based on which button from tableType GUI the user selected, call processSelection with appropriate AbstractTable instance
			if (tableType == 0) {
				processSelection(myCityTable, userSelection);
			} else if (tableType == 1) {
				processSelection(myStadTable, userSelection);
			}
			
		}
	}

	private static void processSelection(AbstractTable myTable, int userSelection) {
		switch (userSelection) {
		case LOAD:
			// Remember that you can have text files in your Eclipse Project. If this file is in src/a1, you could read the input.txt file in your a1 package using the "fileName" src/a1/input.txt
			String fileName = JOptionPane.showInputDialog("Please enter the name of the text file to load");
			System.out.println("Opening the file '" + fileName + "'.");
			myTable.loadTableFromFile(fileName);
			break;
		case SAVE:
			fileName = JOptionPane.showInputDialog("Please enter the name of the text file to save the table");
			myTable.saveTable(fileName);
			break;
		case ADD_ROW:
			
			if(myTable instanceof CityTable) {
				String cityName = JOptionPane.showInputDialog("Please enter the name of the city you want to add");
				String cityID = JOptionPane.showInputDialog("Please enter the ID for: " + cityName);
				String cityPop = JOptionPane.showInputDialog("Please enter the population, in millions, for: " + cityName);
				((CityTable) myTable).addRow(cityName, cityID, cityPop); //if myTable is instance of CityTable, cast to CityTable, then call CityTable's add row function
				
			} else if (myTable instanceof StadiumTable) {
				String stadiumName = JOptionPane.showInputDialog("Please enter the name of the stadium you want to add");
				String stadiumCityID = JOptionPane.showInputDialog("Please enter the city ID for: " + stadiumName);
				String stadiumTeam = JOptionPane.showInputDialog("Please enter the team name for: " + stadiumName);
				String stadiumCapacity = JOptionPane.showInputDialog("Please enter the capacity for: " + stadiumName);
				((StadiumTable) myTable).addRow(stadiumName, stadiumCityID, stadiumTeam, stadiumCapacity); //if myTable is instance of StadTable, cast to StadTable and call it's add row function
				
			}
			break;
		case REMOVE_ROW:
			
			if(myTable instanceof CityTable) {
				String cityID = JOptionPane.showInputDialog("Please enter the city ID in the row you want to remove from the table");
				JOptionPane.showMessageDialog(null, ((CityTable) myTable).removeRow(cityID));//if myTable is instance of CityTable, cast to CityTable, then call CityTable's remove row function
			} else if (myTable instanceof StadiumTable) {
				String stadiumCityID = JOptionPane.showInputDialog("Please enter the city ID for the stadium in the row you want to remove from the table");
				JOptionPane.showMessageDialog(null, ((StadiumTable) myTable).removeRow(stadiumCityID));//if myTable is instance of StadTable, cast to StadTable and call it's remove row function
				
			}
			break;
		case FIND_ROW:
			
			if (myTable instanceof CityTable) {
				String cityID = JOptionPane.showInputDialog("Please enter the city ID in the row you want to find.");
				JOptionPane.showMessageDialog(null, ((CityTable) myTable).findRow(cityID));//if myTable is instance of CityTable, cast to CityTable, then call CityTable's find row function
				
			} else if (myTable instanceof StadiumTable) {
				String stadiumCityID = JOptionPane.showInputDialog("Please enter the stadium city ID in the row you want to find."); 
				JOptionPane.showMessageDialog(null, ((StadiumTable) myTable).findRow(stadiumCityID));//if myTable is instance of StadTable, cast to StadTable and call it's find row function
			}
			break;

		case QUIT:
			JOptionPane.showMessageDialog(null, "Have a nice day");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Invalid Input");
		}
	}
}
