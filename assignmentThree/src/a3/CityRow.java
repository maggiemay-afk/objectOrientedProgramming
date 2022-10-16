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

public class CityRow extends AbstractRow {
	
	private String[] singleCityRow = new String[3];
	
	/**
	 * City Row constructor
	 */
	public CityRow(String cityName, String cityID, String cityPop) {
		
		this.singleCityRow[0] = cityName;
		this.singleCityRow[1] = cityID;
		this.singleCityRow[2] = cityPop;
	}
	
	/**
	 * Overrides Super.equals
	 */
	public Boolean equals() {
		return true;
		
	}
	
	public String[] getSingleCityRow() {
		return this.singleCityRow;
	}
	
	public String toString () {
		return String.join(", ", singleCityRow);
	}

}
