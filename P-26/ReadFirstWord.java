/*
 * Write a program that reads the first word of each line of input and prints them out at the end.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadFirstWord{

	public static void main(String[] args){
	
		try{
	
			Scanner scan = new Scanner(new File("example.txt"));
	
			// Create a FileWriter object to write the extracted first words to the file "example-first-word.txt"    
			FileWriter fileWrite = new FileWriter("example-first-word.txt");

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				String[] eachLine = scan.nextLine().split(" ");

				// Write the first word of the line to the new file
				fileWrite.write(eachLine[0]+"\n");
			}

			// Close the Scanner and FileWriter objects
			scan.close();
			fileWrite.close();
		}

		// If an exception occurs during file reading or writing, print the stack trace
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}