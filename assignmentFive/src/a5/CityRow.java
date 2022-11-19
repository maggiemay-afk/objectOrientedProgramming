/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */
package a5;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public class CityRow extends AbstractRow {
	
	private String[] singleCityRow = new String[3];
	

	/** Instantiate singleCityRow String array with the three parameters
	 * @param cityName
	 * @param cityID
	 * @param cityPop
	 */
	public CityRow(String cityName, String cityID, String cityPop) {
		
		this.singleCityRow[0] = cityName;
		this.singleCityRow[1] = cityID;
		this.singleCityRow[2] = cityPop;
	}
	
	
	/** Check if a parameter Row equals the instances singleCityRow
	 * @param row
	 */
	public Boolean equals(AbstractRow row) {
		
		if (row instanceof CityRow) { //if the parameter row is not an instance of city row, return false 
			for (int i=0; i < singleCityRow.length; i++) {
				if (!this.singleCityRow[i].equalsIgnoreCase(((CityRow)row).getSingleCityRow()[i])) { //cast to city row
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public String[] getSingleCityRow() {
		return this.singleCityRow;
	}
	
	public String toString () {
		return String.join(", ", singleCityRow);
	}

}
