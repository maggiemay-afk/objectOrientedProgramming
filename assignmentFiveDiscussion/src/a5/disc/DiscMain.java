package a5.disc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class DiscMain {
	public static void main(String[] args) {
		
		
		System.out.println("A5 Discussion ...");
		Integer i1 = 2000;
		Integer i2 = 3005;
		String  s1 = "This is not a number";
		String  s2 = "4003";
		
		List <String> mylist1 = new ArrayList<>();
		List <Integer> mylist2 = new ArrayList<>();
		
		mylist2.add( i1 );
		mylist2.add( i2 );
		
		mylist1.add( s1 );
		mylist1.add( s2 );
		
		mylist2.add( i1 );
		mylist2.add( i2 );
		
		mylist1.add( s1 );
		mylist1.add( s2 );
		
		System.out.println(" List contains:");
		for (Object o : mylist1)
			System.out.println( "  " + o );
		System.out.println();
		
		
		Set<Object> myset = new HashSet<>( mylist1 );
		System.out.println(" Set contains:");
		for (Object o : myset)
			System.out.println( "  " + o );
		System.out.println();
		
		Map<Integer, String> mymap = new HashMap<>();
		mymap.put(i1, s1);
		mymap.put(i2, s1);
		mymap.put(1, s2);
		mymap.put(2, s2);
		
		System.out.println(mymap.toString());
		
		
		Set<Integer> keys = mymap.keySet();
		System.out.println(" Map keys are:");
		for ( Object k : keys)
			System.out.println( "  " + k );
		System.out.println();
		
		System.out.println("... done!");
	}
}
