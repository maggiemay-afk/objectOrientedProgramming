package files;

/**
 * ReadText3 - read a text file using a java.util.Scanner object
 * 				In this version we read in String objects one "word" at
 * 				 a time rather than a whole line at a time
 * 
 * @author tony
 *
 */
public class ReadText5 {

	private static String input1 = "inputfile.txt";

	public static void main(String[] args) {
		System.out.println("Opening the file '" + input1 + "'.");

		try {
			java.io.File file = new java.io.File(input1);
			java.util.Scanner scanner = new java.util.Scanner( file );

			while ( scanner.hasNext() ) {
				String strin = scanner.next();
				if ( strin != null)
					System.out.println(strin);
			}

			scanner.close();

		} catch (java.io.FileNotFoundException fnfex) {
			System.err.println(fnfex.getMessage());
		} 
	}
}
