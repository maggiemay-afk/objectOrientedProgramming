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
				
				String split[] = input.nextLine().split(","); //split the  input array at comma delimiter
				
				String inputCityName = split[0].trim(); //trim each of the three Strings to account for whitespace
				String inputCityID = split[1].trim();
				String inputCityPop = split[2].trim();
				
				addRow(inputCityName, inputCityID, inputCityPop);
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
	 * @param cityName
	 * @param cityID
	 * @param cityPop
	 */
	public void addRow (String cityName, String cityID, String cityPop) {
		
		int currentIndex = this.getTableIndex();
		
		if (currentIndex == 100) {
			System.err.println("The table is full, row not added"); //Doesn't allow for a "table" larger than 100 rows.
			return;
		} else {
			
			CityRow cr = new CityRow(cityName, cityID, cityPop);
			this.getTableRows()[currentIndex] = cr;	
			
		}
		
	}
	
	/**
	 * @param cityName
	 */
	public void removeRow(String cityID) {
		
	}
	
	/**
	 * @param rowToFind
	 * @return
	 */
	public String findRow(String rowToFind) {
		return rowToFind;
	}

}
