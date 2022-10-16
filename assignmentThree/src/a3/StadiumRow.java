/**
 * Name: Maggie Herms
 * Email: mkherms@uwm.edu
 * 
 */
package a3;

public class StadiumRow extends AbstractRow {
	
	private String[] singleStadiumRow = new String[4];
	
	
	/**
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
	
	/**
	 * Overrides super.equals
	 */
	public Boolean equals() {
		return true;
	}
	
	public String[] getSingleStadRow() {
		return this.singleStadiumRow;
	}
	
	public String toString() {
		return String.join(", ", singleStadiumRow); 
	}

}
