package splittingstrings;

/**
 * This class has a number of ways to use the String.split() method
 * 
 * @author tony
 *
 */
public class StringSplits {

	public static void main(String[] args) {
		String str = "Hello 1 2 3 Jello 34.6 4\ta"; // '\t' is the "TAB" character
		
		split1(str);
		split2(str);
		split3(str);
		split34(str);
		
		str = "Hello,1,2,3,Jello,34.6,4,a";
		split5(str);
		
		str = "Hello 1\t2  3 Jello   34.6\t\t4     a";
		split6(str);
	}
	
	private static void split1(String string) {
		
		String split[] = string.split(" "); // space
		System.out.println("---split1----------------");
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

	private static void split2(String string) {
		
		String split[] = string.split("e"); // the letter 'e'
		System.out.println("---split2----------------");		
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

	private static void split3(String string) {
		
		String split[] = string.split("3"); // the number '3'
		System.out.println("---split3----------------");		
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

	private static void split34(String string) {
		
		String split[] = string.split("34");  // the string '34'
		System.out.println("---split34----------------");		
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

	private static void split5(String string) {
		
		String split[] = string.split(",");  // separate at the commas
		System.out.println("---split5----------------");		
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

	private static void split6(String string) {
		
		String split[] = string.split("\\s+");  // separate at the whitespaces
		System.out.println("---split6----------------");		
		for (String s : split)
			System.out.println( s ); 
		System.out.println("-------------------\n");
	}

}
