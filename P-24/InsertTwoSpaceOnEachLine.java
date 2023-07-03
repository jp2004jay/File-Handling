/* 
 * Write a program to copy a file, insert two space characters at the beginning of each line.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InsertTwoSpaceOnEachLine{
	
	public static void main(String[] args){
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));

			// Create a FileWriter object to write the modified content to the file "example-copy.txt"
			FileWriter fileWrite = new FileWriter("example-copy.txt");

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				String temp = scan.nextLine();

				// Write the line with two leading spaces to the new file
				fileWrite.write("  "+temp+"\n");
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