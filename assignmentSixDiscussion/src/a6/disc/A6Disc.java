package a6.disc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ARow {
	private String name;
	private int zip;
	
	public ARow(String n, int z) {
		this.name = n;
		this.zip  = z;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getZip() {
		return this.zip;
	}
}

class BRow {
	private String name;
	private int    area;
	
	public BRow(String n, int a) {
		this.name = n;
		this.area = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getArea() {
		return this.area;
	}
}

class CRow {
	private String name;
	private int    zip;
	private int    area;
	
	public CRow(String n, int z, int a) {
		this.name = n;
		this.zip  = z;
		this.area = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getZip() {
		return this.zip;
	}
	
	public int getArea() {
		return this.area;
	}
	
	public String toString() {
		return "\n" + this.name + " " + this.zip + " " + this.area + " ";
	}
}

public class A6Disc {

	public static void main(String[] args) {
		// Set up Table a
		List<ARow> a = new ArrayList<>();
		/* Table a stores zip codes:
		 *   Adell	53001
		 *   Clyman	53016
		 *   Lomira	53048
		 */
		a.add( new ARow("Adell",  53001 ));
		a.add( new ARow("Clyman", 53016 ));
		a.add( new ARow("Lomira", 53048 ));
		
		// Set up Table b
		List<BRow> b = new ArrayList<>();
		/* Table b stores area codes:
		 *   Adell		920
		 *   Clyman		921
		 *   Waukesha	262
		 */
		b.add( new BRow("Adell",  920 ));
		b.add( new BRow("Clyman", 921 ));
		b.add( new BRow("Waukesha", 262 ));

		// Use a map to store elements of table b that need to be joined
		// - only add a row from b if the city name appears in a
		Map<String,BRow> bmap = new HashMap<>();
		List<CRow> c = new ArrayList<>();
		// TODO: 
		// loop through a
		// if a.name is within b array
		//   push b to map. key = b.name value = b
		
		for (BRow br : b) {
			for (ARow ar : a) {
				if (br.getName().compareTo(ar.getName()) == 0) {
					bmap.put(br.getName(), br);
					c.add(new CRow(br.getName(), br.getArea(), ar.getZip()));
				}
			}
		}
		
		System.out.println(bmap);
		
		
		// Do a join
		/*
		 * Output should be Table a JOIN Table b:
		 *   Adell	53001	920
		 *   Clyman	53016	921
		 */
		// Ready for the join
		
		
		// TODO:
		// loop through a
		// if a.name in bmap
		//   push new row to c with joined stuff (from both a & b)

		System.out.println( "Join is: " + c );
	}

}
