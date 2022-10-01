package files;

/**
 * ReadText1 - read a text file using a java.io.BufferedReader object
 *  
 * @author tony
 *
 */
public class ReadText1 {

	private static String input1 = "inputfile.txt";

	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		System.out.println("Opening the file '" + input1 + "'.");
		java.io.File file = new java.io.File(input1);
		java.io.BufferedReader buffread = new java.io.BufferedReader( 
				new java.io.FileReader( file ));
		
		String linein = "";
		while ( (linein = buffread.readLine()) != null ) {
			System.out.println( linein );
		}
		
		buffread.close();
	}
}
