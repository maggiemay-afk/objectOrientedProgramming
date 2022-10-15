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
	
	public AbstractRow[] getTableRows () {
		return this.tableRows;
	}
	
	public void setTableRows(AbstractRow[] tableRows) {
		this.tableRows = tableRows;
	}
	
	public String getTableHeader () {
		return this.tableHeader;
	}
	
	public void setTableHeader(String inputTableHeader) {
		this.tableHeader = inputTableHeader;
	}
	
	public int getTableIndex() {
		return this.tableIndex;
	}
	
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
