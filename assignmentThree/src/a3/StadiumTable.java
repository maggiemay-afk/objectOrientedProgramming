/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */

package a3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StadiumTable extends AbstractTable {

	
	/** Load text file from parameter file name location
	 * Only works with comma separated values. Assumes at least a header will be included. 
	 * Only works with 4 columns. No empty files.
	 * 
	 * @param fileName
	 */
	public void loadTableFromFile (String fileName) {
		
		//if the getTableHeader function does not return null, a table is already in use. Clears out old table before loading new one
		String tableHeader = getTableHeader();
		if (tableHeader != null) {
			setTableRows(new AbstractRow[100]);
			setTableIndex(0);
		}
		
		try {
			Scanner input = new Scanner(new FileReader(fileName));
			
			//checks to see if a text file is empty.
			if (input.hasNext()) {
				setTableHeader(input.nextLine());
			} else {
				System.err.println("Your file seems to be empty");
				return;
			}
			
			while (input.hasNextLine() && input.hasNext()) { //If a file has extra blank lines, second conditional will return false
				
				String split[] = input.nextLine().split(","); //split the input array at comma delimiter
				
				String inputStadiumName = split[0].trim(); //trim each of the three Strings to account for whitespace
				String inputStadiumCityID = split[1].trim();
				String inputStadiumTeam = split[2].trim();
				String inputStadiumCapacity = split[3].trim();
				
				addRow(inputStadiumName, inputStadiumCityID, inputStadiumTeam, inputStadiumCapacity);
			}
		} catch (FileNotFoundException fnfx) {
			System.err.println(fnfx.getMessage());
		} 
		
	}
	
	
	/** Save the current table to text file. Uses the stadium row toString method.
	 * Output with comma separated values so output can also be read by loadTable function.
	 * 
	 * @param fileName
	 */
	public void saveTable (String fileName) {
		
		try {
			PrintWriter output = new PrintWriter(fileName);
			
			if (getTableHeader() == null) {
				output.println("No Header");
			} else {
				output.println(getTableHeader());
			}
			
			for (int i = 0; i < getTableIndex(); i++) {
				output.println(this.getTableRows()[i]);
			}
			
			output.close();
			
		} catch (FileNotFoundException fnfx) {
			System.err.println(fnfx.getMessage());
		}
		
	}
	
	
	/**Add a row to table based off user input values
	 * @param stadName
	 * @param stadCityID
	 * @param stadTeamName
	 * @param stadCapacity
	 */
	public void addRow (String stadName, String stadCityID, String stadTeamName, String stadCapacity) {
		
		int currentIndex = this.getTableIndex();
		
		if (currentIndex == 100) {
			System.err.println("The table is full, row not added"); //Doesn't allow for a "table" larger than 100 rows.
			return;
		} else {
			
			StadiumRow sr = new StadiumRow(stadName, stadCityID, stadTeamName, stadCapacity);
			this.getTableRows()[currentIndex] = sr;	
			incrementTableIndex();
		}
		
	}
	
	
	/** Remove a row based off user input for stadium's city ID
	 * Return success or fail message
	 * @param stadCityID
	 * @return String
	 */
	public String removeRow(String stadCityID) {
		
		boolean found = false;
		
		for (int i= 0; i < getTableIndex(); i++) {
			String[] currentRow = ((StadiumRow) getTableRows()[i]).getSingleStadRow();
			
			if (currentRow[1].equals(stadCityID)) {
				found = true;
				for (int j= i; j < getTableIndex(); j++) {
					if (j == (getTableRows().length - 1)) { //prevents array index out of bounds error by setting last array index to null
						getTableRows()[j] = null;
						break;
					}
					getTableRows()[j] = getTableRows()[j + 1];
				}
				decrementTableIndex();
				break;
			}
		}
		
		if (found == false) {
			return "Sorry, we couldn't find that ID. Row not removed.";
		} else {
			return "Success. Row Removed";
		}
		
	}
	
	/** find a row based off user input for stadium's city ID. 
	 * Return entire row if found or error message if not found
	 * @param stadiumCityID
	 * @return String
	 */
	public String findRow(String stadiumCityID) {
		
		for (int i= 0; i < getTableIndex(); i++) {
			String [] currentRow = ((StadiumRow) getTableRows()[i]).getSingleStadRow();
			
			if (currentRow[1].equals(stadiumCityID)) {
				return getTableRows()[i].toString();
			}	
		}
		return "Sorry, we couldn't find that stadium city ID.";
	}

}
