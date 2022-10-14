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
		
		CastList parksAndRec = new CastList();
		parksAndRec.addRole(r1);
		parksAndRec.addRole(r2);
		parksAndRec.addRole(r3);
		
		syso.println(r1);
		syso.println(r2);
		syso.println(r3);
		syso.println(parksAndRec);
		
		

	}

}
