/*
 * Write a program to accept a file of verifying length lines.
 * And changes it to a formatted file with 60 characters in each line.
*/

import java.io.File;
import java.util.Scanner;

public class VerifyingLengthLines{
	
	public static void main(String[] args){
		
		try{
			// Create a Scanner object to read from the file
			Scanner scan = new Scanner(new File("example.txt"));
			
			int lineNumber = 1;
			boolean isValid = true;

			while(scan.hasNext()){

				// Read the next line and split it into individual records
				String[] record = scan.nextLine().split(" ");
				
				int charCounter = 0;
				
				// Count the characters in each record
				for(String temp : record){
					for(int i=0; i<temp.length(); i++){
						// Count the characters in each record
						charCounter++;
					}
				}
				
				// Print the line number if the character count exceeds the limit
				if(charCounter > 60){
					System.out.println("Invalid Line: "+lineNumber);
					isValid = false;
				}

				lineNumber++;
			}

			// Print the message if the file is valid
			if(isValid){
				System.out.println("The file is completely valid.");
			}
			
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}
	}
}