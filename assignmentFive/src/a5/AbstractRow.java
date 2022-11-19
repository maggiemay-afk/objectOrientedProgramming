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


public abstract class AbstractRow {
	
	
	/**
	 * Overridden in CityRow and StadiumRow concrete classes
	 * @param row
	 * @return
	 */
	public abstract Boolean equals (AbstractRow row);
	
	

}
