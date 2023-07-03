/*
 * Write a program that inserts 21st character of each line in a file to a new line. 
 * All extracted character are to on the same file. 
 * If a line in input file has fewer than 21 characters, write the last character. 
 * If line is blank then copy nothing. 
 * At the end of file write a new line to the new file and close it.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Character21OfEachLine{

	public static void main(String[] args){

		try{
			Scanner scan = new Scanner(new File("example.txt"));

			// Create a FileWriter object to write the extracted characters to the file "example-copy.txt"
			FileWriter fileWrite = new FileWriter("example-copy.txt");
			
			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				char[] eachLine = scan.nextLine().toCharArray();

				int charCount = 1;
				char char21 = ' ';
				
				// Iterate over each character in the line
				for(char temp : eachLine){

					if(temp == ' '){
						continue;
					}
					
					// Assign the non-space character to the variable
					char21 = temp;

					// Break the loop if the 21st non-space character is found
					if(charCount == 21){
						break;
					}

					charCount++;
				}

				// Write the extracted character followed by a newline character to the new file
				fileWrite.write(char21+"\n");

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