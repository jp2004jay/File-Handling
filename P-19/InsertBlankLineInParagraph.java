/*
 * Write a program to that copies one text file to another 
 * Insert blank lines between paragraphs in the new file. 
 * Paragraphs are identified by a newline character.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InsertBlankLineInParagraph{

	public static void main(String[] args){

		try{
			Scanner scan = new Scanner(new File("example.txt"));
			
			// Create a FileWriter object to write the content to a new file "example-copy.txt"      
			FileWriter fileWrite = new FileWriter("example-copy.txt");
			
			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n\n");
			}

			// Close the Scanner and FileWriter objects
			scan.close();
			fileWrite.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}