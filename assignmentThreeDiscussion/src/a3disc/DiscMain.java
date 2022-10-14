package a3disc;

public class DiscMain {

	public static void main(String[] args) {
		AbstractItem a;
		AbstractItem b = new ConcreteItem( 1, 7 );
		ConcreteItem c = new ConcreteItem( 1, 23 );
		a = new ConcreteItem( c );
		
		System.out.println( " a is " + a );
		System.out.println( " b is " + b );
		System.out.println( " c is " + c );

		// The == operator, when used with references, checks whether the two references refer to the same object.
		
		if ( a == b )
			System.out.println( "  a == b"); // a and b refer to the same object
		else
			System.out.println( "  a != b"); // a and b refer to different objects
		if ( a == c )
			System.out.println( "  a == c");
		else
			System.out.println( "  a != c");
		if ( b == c )
			System.out.println( "  b == c");
		else
			System.out.println( "  b != c");
		if ( c == c ) // Such a comparison is not useful since it is always true!
			System.out.println( "  c == c");
		else
			System.out.println( "  c != c");
		// Although the == and != operators are simple to use, they are usually not
		//  what we want if we are trying to check if values in objects are the same. 
		
		
		// To check if two different objects contain the same values, use the .equals() method.
		// The default Object.equals() method a class inherits from the class Object just uses
		//  the == operator! Therefore if we want to compare the values contained in two objects,
		//  we have to override .equals(). We need a *good* implementation of the .equals method!
		if ( a.equals(b) )
			System.out.println( "  a  equals b");
		else
			System.out.println( "  a !equals b");

		if ( a.equals(c) )
			System.out.println( "  a  equals c");
		else
			System.out.println( "  a !equals c");
		
		if ( b.equals(c) )
			System.out.println( "  b  equals c");
		else
			System.out.println( "  b !equals c");
	}
}
