/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */

package a5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StadiumTable extends AbstractTable<AbstractRow> {

	
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
			setTableRows(new ArrayList<AbstractRow>());
			setTableIndex(0);
		}
		
		Scanner input = null;
		
		try {
			input = new Scanner(new FileReader(fileName));
			
			//checks to see if a text file is empty.
			if (input.hasNext()) {
				setTableHeader(input.nextLine());
			} else {
				throw new EmptyFileException(fileName);
			}
			
			while (input.hasNextLine() && input.hasNext()) { //If a file has extra blank lines, second conditional will return false
				
				String split[] = input.nextLine().split(","); //split the input array at comma delimiter
				
				if (split.length != 4) {
					throw new ColumnMismatchException(4, split.length);
				}
				
				String inputStadiumName = split[0].trim(); //trim each of the three Strings to account for whitespace
				String inputStadiumCityID = split[1].trim();
				String inputStadiumTeam = split[2].trim();
				String inputStadiumCapacity = split[3].trim();
				
				addRow(inputStadiumName, inputStadiumCityID, inputStadiumTeam, inputStadiumCapacity);
			}
		} catch (FileNotFoundException fnfx) {
			JOptionPane.showMessageDialog(null, fnfx.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
		} catch (ColumnMismatchException cme) {
			JOptionPane.showMessageDialog(null, cme.getMessage(), "Column Mismatch", JOptionPane.ERROR_MESSAGE);
		} catch (EmptyFileException efe) {
			JOptionPane.showMessageDialog(null, efe.getMessage(), "Empty File", JOptionPane.ERROR_MESSAGE);
		} catch (TableRowLimitException trl) {
			JOptionPane.showMessageDialog(null, trl.getMessage(), "Maximum Rows Reached", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	
	/** Save the current table to text file. Uses the stadium row toString method.
	 * Output with comma separated values so output can also be read by loadTable function.
	 * 
	 * @param fileName
	 */
	public void saveTable (String fileName) {
		
		PrintWriter output = null;
		
		try {
			output = new PrintWriter(fileName);
			
			if (getTableHeader() == null && getTableIndex() == 0) {
				throw new EmptyTableException();
			} else if (getTableHeader() == null){
				output.println("No Table Header");
			} else {
				output.println(getTableHeader());
			}
			
			for (int i = 0; i < getTableIndex(); i++) {
				output.println(this.getTableRows().get(i));
			}
			
		} catch (FileNotFoundException fnfx) {
			JOptionPane.showMessageDialog(null, fnfx.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
		} catch (EmptyTableException ete) {
			JOptionPane.showMessageDialog(null, ete.getMessage(), "Empty Table", JOptionPane.ERROR_MESSAGE);
		} finally{
			if (output != null) {
				output.close();	
			}
		}
	}
	
	
	/**Add a row to table based off user input values
	 * @param stadName
	 * @param stadCityID
	 * @param stadTeamName
	 * @param stadCapacity
	 * @throws TableRowLimitException 
	 */
	public void addRow (String stadName, String stadCityID, String stadTeamName, String stadCapacity) throws TableRowLimitException {
		
		try {
			int intCityID = Integer.parseInt(stadCityID);
			double doubleCapacity = Integer.parseInt(stadCapacity);
			
			int currentIndex = this.getTableIndex();
			
			if (currentIndex == 100) {
				throw new TableRowLimitException(); //Doesn't allow for a table larger than 100 rows.
			} else {
				StadiumRow sr = new StadiumRow(stadName, stadCityID, stadTeamName, stadCapacity);
				this.getTableRows().add(currentIndex, sr);	
				incrementTableIndex();
			}			
			
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, 
					"Invalid Input type.\nA stadium's city ID should be an integer.\n"
					+ "Stadium capacity should be a double.\nInvalid row not added.", 
					"Invalid Input", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
	/** Remove a row based off user input for stadium's city ID
	 * Return success or fail message
	 * @param stadCityID
	 * @return String
	 * @throws RowNotFoundException
	 */
	public String removeRow(String stadCityID) throws RowNotFoundException{
		
		boolean found = false;
		
		for (int i= 0; i < getTableIndex(); i++) {
			String[] currentRow = ((StadiumRow) getTableRows().get(i)).getSingleStadRow();
			
			if (currentRow[1].equals(stadCityID)) {
				found = true;
				getTableRows().remove(i);
				decrementTableIndex();
			}
		}
		
		if (found == false) {
			throw new RowNotFoundException(stadCityID);
		} else {
			return "Success. Row Removed";
		}
		
	}
	
	/** find a row based off user input for stadium's city ID. 
	 * Return entire row if found or error message if not found
	 * @param stadiumCityID
	 * @return String
	 * @throws RowNotFoundException
	 */
	public String findRow(String stadiumCityID) throws RowNotFoundException{
		
		for (int i= 0; i < getTableIndex(); i++) {
			String [] currentRow = ((StadiumRow) getTableRows().get(i)).getSingleStadRow();
			
			if (currentRow[1].equals(stadiumCityID)) {
				return getTableRows().get(i).toString();
			}	
		}
		throw new RowNotFoundException(stadiumCityID);
	}

}
