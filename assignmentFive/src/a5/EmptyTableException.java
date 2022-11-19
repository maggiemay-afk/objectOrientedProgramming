/**
 * Name: Maggie Herms, email: mkherms@uwm.edu
 */
package a5;

public class EmptyTableException extends Exception {
	
	public EmptyTableException() {
		super("Your table appears to be emtpy.\nIt wasn't saved to an output.\nAdd data before saving a table.");
	}

}
