/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */
package a3;

public class StadiumRow extends AbstractRow {
	
	private String[] singleStadiumRow = new String[4];
	
	
	/** Instantiate singleStadiumRow with 4 parameter values
	 * @param stadiumName
	 * @param stadCityID
	 * @param stadiumTeam
	 * @param stadiumCapacity
	 */
	public StadiumRow (String stadiumName, String stadCityID, String stadiumTeam, String stadiumCapacity) {
		this.singleStadiumRow[0] = stadiumName;
		this.singleStadiumRow[1] = stadCityID;
		this.singleStadiumRow[2] = stadiumTeam;
		this.singleStadiumRow[3] = stadiumCapacity;
	}
	
	/** Check if a parameter Row equals the instances singleStadiumRow
	 * @param row
	 */
	public Boolean equals(AbstractRow row) {
		
		if (row instanceof StadiumRow) { //if the parameter row is not an instance of stadium row, return false 
			for (int i=0; i < singleStadiumRow.length; i++) {
				if (!this.singleStadiumRow[i].equalsIgnoreCase(((StadiumRow)row).getSingleStadRow()[i])) { //cast to stadium row
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * @return String array
	 */
	public String[] getSingleStadRow() {
		return this.singleStadiumRow;
	}
	

	public String toString() {
		return String.join(", ", singleStadiumRow); 
	}

}
