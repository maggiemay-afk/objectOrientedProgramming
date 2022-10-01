package assignmentTwo;
import java.util.Arrays;

public class CastList {
	
	private Role[] tvShowRoles;
	int castListIndex = 0; //tracks the number of Roles in an instance of Cast List
	
	/** Constructor. Instantiates Cast List class with new array of 5 Roles
	 */
	public CastList () {
		this.tvShowRoles = new Role[5];
	}
	
	/**
	 * @param newRole Role
	 */
	public void addRole (Role newRole) {
		
		if (castListIndex >= tvShowRoles.length) { //checks if cast list is full. Error message if full
			System.err.println("Cast list is full. Role not added."); 
			return;
		} else {
			this.tvShowRoles[castListIndex] = newRole;
			castListIndex++;
		}
		
	}
	
	/**
	 * @param roleToDel Role
	 */
	public void deleteRole (Role roleToDel) {
		
		int delIndex = -1;
		
		for (int i = 0; i < castListIndex; i++) {
			if (tvShowRoles[i].equals(roleToDel)) {
				delIndex = i;
				break;
			}
		}
		
		if (delIndex != -1) {
			for (int i = delIndex; i < castListIndex -1; i++) {
				tvShowRoles[i] = tvShowRoles[i + 1];
			}
			tvShowRoles[castListIndex - 1] = null;
			castListIndex--;
		} else {
			
		}
	}
	
	public String toString () {
		
		String castDetails = ("Number of roles= " + castListIndex + " ");
		return castDetails += Arrays.deepToString(tvShowRoles);
		
	}

}
