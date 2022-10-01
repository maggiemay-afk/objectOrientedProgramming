package assignmentOneDiscussion;

import java.io.*;
import java.util.Scanner;

public class Songs {

	public static void main(String[] args) throws java.io.FileNotFoundException, java.io.IOException {
		
		String input = "C:/Users/Maggie Herms/Documents/objectOrientedProgramming/songs.txt";
		String output = "C:/Users/Maggie Herms/Documents/objectOrientedProgramming/practice.txt";
		
		Scanner scanner = new Scanner(new FileReader(input));
		PrintWriter outFile = new PrintWriter(output);
		
		String songTitle;
		String songArtist;
		String songLength;
		int playlistLength = 0;
		
		outFile.format("%-45s%-20s%s%n", "Song title:", "Artist name:", "Song length:");
		
		while (scanner.hasNextLine()) {
			
			String split[] = scanner.nextLine().split(",");
			songTitle = split[0];
			songArtist = split[1];
			songLength = split[2];
			
			/*outFile.println("--------------------------------");
			outFile.format("%-15s%s%n", "Song Title: ", songTitle);
			outFile.format("%-15s%s%n", "Song Artist: ", songArtist);
			outFile.format("%-15s%s%n", "Song Length: ", songLength);*/
			
			outFile.println("-----------------------------------------------------------------------------");
			outFile.format("%-45s", songTitle);
			outFile.format("%-20s", songArtist);
			outFile.format("%s%n", songLength);
		
			playlistLength++;
		}
		
		outFile.println("-----------------------------------------------------------------------------");
		outFile.println("Total songs in playlist: " + playlistLength);
		outFile.close();

	}

}
