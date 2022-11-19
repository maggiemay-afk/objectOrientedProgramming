/**
 * Name: Maggie Herms, email: mkherms@uwm.edu
 */
package a5;

public class EmptyFileException extends Exception{
	
	private final String fileName;
	
	public EmptyFileException() {
		super("File is empty");
		this.fileName = null;
	}
	
	public EmptyFileException(String fileName) {
		super("Your file: " + fileName + " \nappears to be empty. File not loaded.");
		
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	

}
