/*
 * Write a program to read a file and display contents with its line numbers.
*/

import java.io.File;
import java.util.Scanner;

public class ContentWithLineNumbers{

	public static void main(String[] args){
	
		try{
	
			Scanner scan = new Scanner(new File("example.txt"));
			
			int lineNumber = 1;
	
			// Read each line of the file until there are no more lines    
			while(scan.hasNext()){

				// Print the line number and the line content to the console
				System.out.println("Line : "+lineNumber+" "+scan.nextLine());
				
				lineNumber++;
			}
			
			// Close the Scanner object
			scan.close();
		}

		// If an exception occurs during file reading, print the stack trace
		catch(Exception e){
			e.printStackTrace();
		}
	}
}