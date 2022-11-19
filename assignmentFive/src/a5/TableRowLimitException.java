/**
 * Name: Maggie Herms, email: mkherms@uwm.edu
 */
package a5;

public class TableRowLimitException extends Exception {
	
	public TableRowLimitException() {
		super("A table can have a maximum of 100 rows.\nRows over 100 have not been added to the table.");
	}

}
