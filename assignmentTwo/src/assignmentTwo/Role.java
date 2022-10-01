package assignmentTwo;

public class Role {
	
	private String roleName;
	private Actor  actorName;
	private int    startseason;
	
	/** Constructor. Instantiates Role class
	 * @param inputName String
	 * @param inputActor String
	 * @param startSeason int
	 */
	public Role( String inputName, String inputActor, int startSeason){
		this.roleName = inputName;
		this.actorName = new Actor(inputActor); //calls Actor class constructor
		this.startseason = startSeason;
	}
	
	@Override
	public String toString() {
		return "[Role name= " + roleName + ", Start Season= " + startseason + 
				", " + actorName +  "]";
	}

}
