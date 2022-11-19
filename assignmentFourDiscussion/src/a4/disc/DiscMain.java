package a4.disc;

import java.io.*;
import java.util.*;
import java.lang.*;

public class DiscMain {
	private static String filename1 = "src/a4/disc/xyz.txt";
	private static String filename2 = "src/a4/disc/data.txt";
	private static final int MAXELEMENT = 10;
	private static final int SCALE = 10;
	
	public DiscMain() {
	}

	public int findsum(int[] array) {
		int result = 0;
		
		try {
			for (int i : array) {
			result += i;
			}
		} catch (NegativeArraySizeException n) {
			System.err.println("Negative Array index");
		} catch (NullPointerException e) {
			System.err.println("Null Pointer Exception");
		}
		
		return result;
	}

	public int findnegatives(int[] array) {
		int result = 0;
		
		try{
			for (int i : array) {
				int j = 1 - 1 / i;
				if (j < 0)
				result++;	
			}
			
		} catch (ArithmeticException ae){
			System.err.println("Find Negatives AE exception");
		} catch (NegativeArraySizeException n) {
			System.err.println("Negative Array index");
		} catch (NullPointerException e) {
			System.err.println("Null Pointer Exception");
		}
		return result;
	}
	
	public static void main(String[] args)  {

		DiscMain d = new DiscMain();
		
		
		//open a file for reading
		FileReader f1 = null;
		
		try {
			f1 = new FileReader( new File( filename1 ));
		} catch (FileNotFoundException e) {
			System.err.println("f1 FNF exception");
		} finally {
			try {
				f1.close();
			} catch (NullPointerException | IOException e) {
				System.err.println("f1 Null Pointer exception");
				
			}
		}
				
		Scanner f2 = null;
		
		
		
		try {
			//open another file for reading
			f2 = new Scanner( new File( filename2 ));
			System.out.println("File " + filename2 + " opened.");

		} catch (FileNotFoundException f) {
			System.err.println("File " + filename2 + " not found");
		} finally {
			try {
				f2.close();
				System.out.println("File " + filename2 + " is closed");
			} catch (NullPointerException npe) {
				
			}
		}
		
		int i1 = f2.nextInt();
		String s1 = f2.next();
		String s2 = f2.next();
		
		int[] a1 = new int[ MAXELEMENT ];
		
		for (int i = 0; i < MAXELEMENT; i++) {
			try {
				a1[i] = i1 + f2.nextInt();
			} catch (InputMismatchException e ) {
				System.err.println("Next token doesn't match integer");
				break;
			}
				
		}
		
		// Add up numbers
		int sum = d.findsum(a1);
		System.out.println("Result for " + s1 + " is " + sum );

		
		// Check if the string s2 is actually a number
		try {
			int i2 = Integer.parseInt(s2);
			System.out.println(" " + s2 + " is actually " + i2 );
		} catch (NumberFormatException e) {
			System.err.println("i2 Number Format Exception");
		}
		
		
		try {
			String s3 = "";
			
			if (i1 != 0) {
				s3 = null;
				System.out.println("Hashcode for " + s3 + " is " + s3.hashCode() );
			}
		} catch (NullPointerException e) {
			System.err.println("i1 Null Pointer exception");
		}
		
				
		int[] array = new int[MAXELEMENT];
		for (int i = 0; i < MAXELEMENT; i++)
			array[i] = (int) ((Math.random() - 0.5) * SCALE);
		System.out.println("Result is " + d.findnegatives( array ) );
		

	}
}
