/*
 * Write a program that calculates average number of character per line in a file.
*/

import java.io.File;
import java.util.Scanner;

public class AverageNumberOfCharacters{
	
	public static void main(String[] args){
		
		try{
			// Create a Scanner object to read from the file
			Scanner scan = new Scanner(new File("example.txt"));

			int sumCount = 0;
			int totalLines = 0;
			
			// Read the next line and split it into individual records
			while(scan.hasNext()){
				String[] record = scan.nextLine().split(" ");
			
				int charCount = 0;

				// Count the characters in each record
				for(String temp : record){
					for(int i=0; i<temp.length(); i++){
						charCount++;
					}
				}

				// Add the character count of the current line to the sum
				sumCount += charCount;
				totalLines++;
			}
			
			System.out.println("Average number of characters per line is: "+(float) sumCount / totalLines);
		}
		
		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}
	}
}