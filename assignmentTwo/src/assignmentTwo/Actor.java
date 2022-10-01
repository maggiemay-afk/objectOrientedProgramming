package assignmentTwo;

public class Actor {
	private String actorName;
	
	/** Constructor. Instantiates Actor class
	 * @param inputName String
	 */
	public Actor( String inputName){
		this.actorName = inputName;
	}
	
	@Override
	public String toString() {
			return "Actor name= " + actorName;
	}
		
}


