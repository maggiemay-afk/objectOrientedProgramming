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

public class CityTable extends AbstractTable {
	
	
	/** Load text file from parameter file name location
	 * Only works with comma separated values. Assumes at least a header will be included. 
	 * Only works with 3 columns. No empty files.
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
		
		Scanner input = null;
		
		try {
			input = new Scanner(new FileReader(fileName));
			
			//checks to see if a text file is empty.
			if (input.hasNext()) {
				setTableHeader(input.nextLine());
			} else {
				throw new EmptyFileException(fileName);
			}
			
			while (input.hasNextLine() && input.hasNext()) { //If a file has extra blank lines, second conditional will return false, ending loop
				
				String split[] = input.nextLine().split(","); //split the input array at comma delimiter
				
				if (split.length != 3) {
					throw new ColumnMismatchException(3, split.length);
				}
				
				String inputCityName = split[0].trim(); //trim each of the three Strings to account for whitespace
				String inputCityID = split[1].trim();
				String inputCityPop = split[2].trim();
				
				addRow(inputCityName, inputCityID, inputCityPop);
			}
		} catch (FileNotFoundException fnfx) {
			JOptionPane.showMessageDialog(null, fnfx.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
		} catch (ColumnMismatchException cme) {
			JOptionPane.showMessageDialog(null, cme.getMessage(), "Column Number Mismatch", JOptionPane.ERROR_MESSAGE);
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
	
	/** Save the current table to text file. Uses the city row toString method.
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
			} else if (getTableHeader() == null) {
				output.println("No Table Header");
			} else {
				output.println(getTableHeader());
			}
			
			for (int i = 0; i < getTableIndex(); i++) {
				output.println(this.getTableRows()[i]);
			}
			
		} catch (FileNotFoundException fnfx) {
			JOptionPane.showMessageDialog(null, fnfx.getMessage(), "File Not Found", JOptionPane.ERROR_MESSAGE);
		} catch (EmptyTableException ete) {
			JOptionPane.showMessageDialog(null, ete.getMessage(), "Empty Table", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (output != null) {
				output.close();
			}
		}
	}
	
	
	/** Add a row to table based off user input values
	 * @param cityName
	 * @param cityID
	 * @param cityPop
	 * @throws TableRowLimitException 
	 */
	public void addRow (String cityName, String cityID, String cityPop) throws TableRowLimitException {
		
		int currentIndex = this.getTableIndex();
		
		if (currentIndex == 100) {
			throw new TableRowLimitException(); //Doesn't allow for a table larger than 100 rows.
		} else {
			
			CityRow cr = new CityRow(cityName, cityID, cityPop);
			this.getTableRows()[currentIndex] = cr;	
			incrementTableIndex();
		}
		
	}
	
	/** Remove a row based off user input for cityID
	 * Return success or fail message
	 * @param cityID
	 * @return String
	 * @throws RowNotFoundException
	 */
	public String removeRow(String cityID) throws RowNotFoundException{
		
		boolean found = false;
		
		for (int i= 0; i < getTableIndex(); i++) {
			String[] currentRow = ((CityRow) getTableRows()[i]).getSingleCityRow();
			
			if (currentRow[1].equals(cityID)) {
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
			throw new RowNotFoundException(cityID);
		} else {
			return "Success. Row Removed";
		}
	}
	
	/** find a row based off user input for city ID. 
	 * Return entire row if found or error message if not found
	 * @param cityID
	 * @return String
	 * @throws RowNotFoundException
	 */
	public String findRow(String cityID) throws RowNotFoundException{
		
		for (int i= 0; i < getTableIndex(); i++) {
			String [] currentRow = ((CityRow) getTableRows()[i]).getSingleCityRow();
			
			if (currentRow[1].equals(cityID)) {
				return getTableRows()[i].toString();
			}	
		}
		throw new RowNotFoundException(cityID);
	}

}
