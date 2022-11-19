/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */
package a3;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import a3.TableRow;



public class TextTable {

	private String tableHeader;
	private TableRow[] userTable = new TableRow[100];
	private int tableIndex =0;
	
	
	/** Load in a txt file. Only works with comma separated values. Assumes at least a header 
	 * will be included. Only works with 3 columns. No empty files.
	 * @param fileName
	 */
	public void loadTableFromFile(String fileName) {
		
		//checks if a txt file has already been loaded by the tableHeader value. If a table has been loaded, update array to empty 
		if (tableHeader != null) {
			userTable = new TableRow[100];
			tableIndex = 0;
		}
		
		try {
			Scanner input = new Scanner(new FileReader(fileName));
			
			//checks to see if a txt file is empty.
			if (input.hasNext()) {
				tableHeader = input.nextLine();
			} else {
				System.err.println("Your file seems to be empty");
				return;
			}
			
			while (input.hasNextLine() && input.hasNext()) { //If a file has extra blank lines, second conditional will return false
				
				String split[] = input.nextLine().split(","); //split the  input array at comma delimiter
				
				String inputInt = split[0].trim(); //trim each of the three Strings to account for whitespace
				String inputName = split[1].trim();
				String inputDouble = split[2].trim();
				
				addRow(inputInt, inputName, inputDouble);
			}
		} catch (FileNotFoundException fnfx) {
			System.err.println(fnfx.getMessage());
		} 
	
	}
	
	/** Save the current "table" array to text file. Uses the tableRow toString method.
	 * Output with comma separated values so output can also be read by loadTable function.
	 * @param fileName
	 */
	public void saveTableToFile(String fileName) {
		
		try {
			PrintWriter output = new PrintWriter(fileName);
			output.println(this.tableHeader);
			
			for (int i = 0; i < tableIndex; i++) {
				output.println(userTable[i]);
			}
			
			output.close();
			
		} catch (FileNotFoundException fnfx) {
			System.err.println(fnfx.getMessage());
		}
	}
	
	/** Use addRow when loading in a txt file and if users want to add single rows at a time.
	 * Uses TableRow constructor to instantiate object with the three Strings. Increments tableRow counter tableIndex
	 * @param int1
	 * @param nameToAddToTable
	 * @param item3
	 */
	public void addRow(String int1, String nameToAddToTable, String item3) {
		
		if (tableIndex == 100) {
			System.err.println("The table is full, row not added"); //Doesn't allow for a "table" larger than 100 rows.
			return;
		}
		
		TableRow rowToAdd = new TableRow(int1, nameToAddToTable, item3);
		
		userTable[tableIndex] = rowToAdd;
		tableIndex++;
	}
	
	/** Search for a row by the name, which is the 1 array index or 2nd column. If a match is found, row is removed.
	 * if no match is found, print to the console that row wasn't removed.
	 * @param itemToRemoveFromTable
	 */
	public void removeRow(String itemToRemoveFromTable) {
		
		boolean found = false;
		
		for (int i= 0; i < tableIndex; i++) {
			String[] currentRow = userTable[i].getTableRow();
			
			if (currentRow[1].equalsIgnoreCase(itemToRemoveFromTable)) {
				found = true;
				for (int j= i; j < tableIndex; j++) {
					if (j == (userTable.length - 1)) { //prevents array index out of bounds error by setting last array index to null
						userTable[j] = null;
						break;
					}
					userTable[j] = userTable[j + 1];
				}
				tableIndex--;
				break;
			}
		}
		
		//ensures error message is only printed if no match was found.
		if (found == false) {
			System.err.println("Sorry, we couldn't find that name. Row not removed.");
		}	
	}
	
	/** Search for a row by the name, which is the 1 array index or 2nd column. If a match is found,
	 * return entire row as a String to user via GUI. If no match is found, return error message to 
	 * user via GUI.
	 * @param findWord
	 * @return String
	 */
	public String findRow(String findWord) {
		
		for (int i= 0; i < tableIndex; i++) {
			String [] currentRow = userTable[i].getTableRow();
			
			if (currentRow[1].equalsIgnoreCase(findWord)) {
				return userTable[i].toString();
			}	
		}
		return "Sorry, we couldn't find that name.";
		
	}
	
}
