/**
 * Name: Maggie Herms, email: mkherms@uwm.edu
 */
package a5;

public class ColumnMismatchException extends Exception{
	
	private final int expectedColumns;
	private final int actualColumns;
	
	public ColumnMismatchException() {
		super();
		
		this.expectedColumns = 0;
		this.actualColumns = 0;
	}
	
	public ColumnMismatchException(int expectedColumns, int actualColumns) {
		
		super("Your file has a row with the wrong number of columns.\nExpected Columns: " 
				+ expectedColumns + "  Actual Columns: " + actualColumns 
				+ "\nRemember to separate columns by commas: `,`\n" + 
				"Rows after Column mismatch have not been added");
		
		this.expectedColumns = expectedColumns;
		this.actualColumns = actualColumns;
		
	}
	
	public int getExpectedColumns() {
		return this.expectedColumns;
	}
	
	public int getActualColumns() {
		return this.actualColumns;
	}


}
