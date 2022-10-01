package files;

public class OpenFile {

	private static String input1 = "inputfile.txt";

	public static void main(String[] args) throws java.io.FileNotFoundException{
		System.out.println("Let's try to open the file " + input1 + "!");
		java.io.File file = new java.io.File( input1 );
		if ( file.exists() ) {
			if (file.canRead()) {
				String path = file.getPath();
				System.out.println("File " + path + " is readable");
			} else {
				System.out.println("File could not be read");
			}
		} else {
		}
	}

}
