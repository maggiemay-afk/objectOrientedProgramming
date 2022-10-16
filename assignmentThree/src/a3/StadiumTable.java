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

	

	public void loadTableFromFile (String fileName) {
		
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
	
	

	public void saveTable (String fileName) {
		
		try {
			PrintWriter output = new PrintWriter(fileName);
			output.println(getTableHeader());
			
			for (int i = 0; i < getTableIndex(); i++) {
				output.println(this.getTableRows()[i]);
			}
			
			output.close();
			
		} catch (FileNotFoundException fnfx) {
			System.err.println(fnfx.getMessage());
		}
		
	}
	
	
	/**
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
	
	
	/**
	 * @param stadName
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
		
		//ensures error message is only printed if no match was found.
		if (found == false) {
			return "Sorry, we couldn't find that ID. Row not removed.";
		} else {
			return "Success. Row Removed";
		}
		
	}
	
	/**
	 * @param rowToFind
	 * @return
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
