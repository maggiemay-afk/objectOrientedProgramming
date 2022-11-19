/**
 * Name: Maggie Herms, email: mkherms@uwm.edu
 */
package a5;

public class RowNotFoundException extends Exception {
	
	private final String rowId;
	
	public RowNotFoundException () {
		super();
		this.rowId = null;
	}
	
	public RowNotFoundException (String rowId) {
		super("We couldn't find the row: " + rowId);
		
		this.rowId = rowId;
	}
	
	public String getRowId () {
		return this.rowId;
	}
}
