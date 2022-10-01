package a1;

public class TableRow {

	private String [] inputRow = new String [3];
	
	/** Constructor. Instantiates inputRow array equal to the 3 arguments passed in
	 * @param valueOne
	 * @param valueTwo
	 * @param valueThree
	 */
	public TableRow (String valueOne, String valueTwo, String valueThree) {
		
		inputRow[0] = valueOne;
		inputRow[1] = valueTwo;
		inputRow[2] = valueThree;
	}
	
	/** Getter function to return the private String array data member - inputRow
	 * @return
	 */
	public String[] getTableRow () {
		return this.inputRow;
	}
	
	//Formats output file with a comma and single space delimiter. Output is readable by TextTable.loadTable function.
	public String toString () {
		return String.join(", ", inputRow);
	}

}

