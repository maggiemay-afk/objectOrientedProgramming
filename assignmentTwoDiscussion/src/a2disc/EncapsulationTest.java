package a2disc;

import java.util.Arrays;

public class EncapsulationTest {

	public static void main(String[] args) {
		// Set up catalogs
		Item i1 = new Item("maggie");
		Item i2 = new Item( "Brandon" );
		Item i3 = new Item( "Emma" );
		Item i4 = new Item( "Watson" );
		
		System.out.println( "Initializing Catalogs ...\n");
		Catalog1 cat1 = new Catalog1();
		cat1.add( i1, 0 ); 	cat1.add( i2, 1 );
		cat1.add( i3, 2 ); 	cat1.add( i4, 3 );
		System.out.println( "  Here are the initial values:");
		System.out.println( "  Catalog 1: " + cat1 );
		
		Catalog2 cat2 = new Catalog2();
		Item[] iarr = {i1, i2, i3, i4}; 
		cat2.add( iarr );
		System.out.println( "  Catalog 2: " + cat2 );
		// done setting up data
		
		System.out.println( "At this point the two 'catalogs' have been initialized to contain the same data."
						+ "\n  Any code that does not change the two catalog objects directly should not cause them to change."
						+ "\n  Let's see what happens ... \n");
		System.out.println( "  Changing 'Item' i1 ...");
		i1.data = "Junk"; // this should not change cat1 or cat2!!
		System.out.println( "  Catalog 1 is now: " + cat1 );
		System.out.println( "  Catalog 2 is now: " + cat2 );
		System.out.println("Any changes in these last two lines compared to initial values?\n\n");
		
		System.out.println( "  Changing 'Item' array iarr ...");
		iarr[0] = new Item( "Foo" );  // this should not change cat1 or cat2!!
		iarr[1] = new Item( "change" );
		System.out.println( "  Catalog 1 is now: " + cat1 );
		System.out.println( "  Catalog 2 is now: " + cat2 );
		System.out.println("How about now?");
		
		
	
		System.out.println(cat1.getItem(9));
		
	
	}

}
