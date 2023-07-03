/*
 * Write a program to delete sixth line in a file. 
 * Do not change sixth line as a blank line. 
 * Delete it completely.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class DeleteSixthLine{

	public static void main(String[] args){

		// Create a new ArrayList of strings to store each line of the file
		ArrayList<String> eachLine = new ArrayList<String>();

		try{
			Scanner scan = new Scanner(new File("example.txt"));

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				eachLine.add(scan.nextLine());
			}

			// Remove the line at index 5 from the ArrayList
			eachLine.remove(5);

			FileWriter fileWrite = new FileWriter("example.txt");
			
			// Iterate over each line in the ArrayList
			for(String temp : eachLine){
				fileWrite.write(temp+"\n");
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