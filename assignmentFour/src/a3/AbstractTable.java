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

public abstract class AbstractTable {
	
	private String tableHeader;
	private AbstractRow[] tableRows = new AbstractRow[100];
	private int tableIndex;
	
	
	public abstract void loadTableFromFile (String fileName);
	public abstract void saveTable (String fileName);

	
	/** @return AbstractRow Array
	 */
	public AbstractRow[] getTableRows () {
		return this.tableRows;
	}
	
	/** @param tableRows
	 */
	public void setTableRows(AbstractRow[] tableRows) {
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
