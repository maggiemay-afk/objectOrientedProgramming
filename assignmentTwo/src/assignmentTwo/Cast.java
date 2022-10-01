package assignmentTwo;
import java.io.PrintStream;

public class Cast {
	static PrintStream syso = System.out;
	
	public static void main(String[] args) {
		System.out.println("Maggie Herms");
		
		int seasonf = 1;
		int season2 = 2;
		
		Role  r1 = new Role("Leslie Knope", "Amy Poehler",   seasonf);
		Role  r2 = new Role("Ron Swanson",  "Nick Offerman", seasonf);
		Role  r3 = new Role("Ben Wyatt",    "Adam Scott",    season2);
		
		CastList theOfficeCast = new CastList();
		theOfficeCast.addRole(r1);
		theOfficeCast.addRole(r2);
		theOfficeCast.addRole(r3);

		syso.println(r1);
		syso.println(r2);
		syso.println(r3);
		syso.println(theOfficeCast);
		
		Role cmR1 = new Role("Derek Morgan", "Shemar Moore", seasonf);
		Role cmR2 = new Role("Spencer Reid", "Matthew Gray Gubler", seasonf);
		Role cmR3 = new Role("Jennifer Jareau", "AJ Cook", seasonf);
		Role cmR4 = new Role("Penelope Garcia", "Kirsten Vangsness", seasonf);
		Role cmR5 = new Role("Jason Gideon", "Mandy Patinkin", seasonf);
		
		CastList criminalMinds = new CastList();
		criminalMinds.addRole(cmR1);
		criminalMinds.addRole(cmR2);
		criminalMinds.addRole(cmR3);
		criminalMinds.addRole(cmR4);
		criminalMinds.addRole(cmR5);
		
		/*syso.println(cmR1);
		syso.println(cmR2);
		syso.println(cmR3);
		syso.println(cmR4);
		syso.println(cmR5);*/
		syso.println(criminalMinds);
		
		criminalMinds.deleteRole(cmR1);
		syso.println(criminalMinds);
		
		syso.println(cmR1);
	}

}
