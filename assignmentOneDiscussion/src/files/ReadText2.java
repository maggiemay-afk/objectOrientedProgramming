package files;

/**
 * ReadText2 - read a text file using a java.io.BufferedReader object this time
 * we use try-catch blocks to try to handle errors like not being able to find a
 * file or not being able to read from a file
 * 
 * @author tony
 *
 */
public class ReadText2 {

	private static String input1 = "inputfile.txt";

	public static void main(String[] args) {
		System.out.println("Opening the file '" + input1 + "'.");

		try {
			java.io.File file = new java.io.File(input1);
			java.io.BufferedReader buffread = new java.io.BufferedReader(new java.io.FileReader(file));

			String linein = "";
			while ((linein = buffread.readLine()) != null) {
				System.out.println(linein);
			}

			buffread.close();

		} catch (java.io.FileNotFoundException fnfex) {
			System.err.println(fnfex.getMessage());
		} catch (java.io.IOException ioex) {
			System.out.println(ioex.getMessage());
		}
	}
}
