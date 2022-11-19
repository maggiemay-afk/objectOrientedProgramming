/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */

package a5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

public abstract class AbstractTable <T extends AbstractRow>{ 
	
	private String tableHeader;
	List <T> tableRows = new ArrayList<>();
	private int tableIndex;
	
	
	public abstract void loadTableFromFile (String fileName);
	public abstract void saveTable (String fileName);

	
	/** @return AbstractRow Array
	 */
	public List<T> getTableRows () {
		return this.tableRows;
	}
	
	/** @param tableRows
	 */
	public void setTableRows(List<T> tableRows) {
		this.tableRows = tableRows;
	}
	
	/** @return String
	 */
	public String getTableHeader () {
		return this.tableHeader;
	}
	
	/** @param inputTableHeader
	 */
	public void setTableHeader(String inputTableHeader) {
		this.tableHeader = inputTableHeader;
	}
	
	/** @return int, Table Index
	 */
	public int getTableIndex() {
		return this.tableIndex;
	}
	
	/** @param newTableIndex
	 */
	public void setTableIndex (int newTableIndex) {
		this.tableIndex = newTableIndex;
	}
	

	public void incrementTableIndex() {
		this.tableIndex++;
	}
	
	
	public void decrementTableIndex() {
		this.tableIndex--;
	}
	
	

}
