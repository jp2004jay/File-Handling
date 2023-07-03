/*
 * Write a program to insert blank line after each line in a file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class InsertBlankLineAfterEachLine{

	public static void main(String[] args){

		// Create a new ArrayList of strings to store each line of the file
		ArrayList<String> eachLine = new ArrayList<String>();
		
		try{

			Scanner scan = new Scanner(new File("example.txt"));
			
			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				eachLine.add(scan.nextLine());
			}

			FileWriter fileWrite = new FileWriter("example.txt");
			
			// Iterate over each line in the ArrayList
			for(String temp : eachLine){
				fileWrite.write(temp+"\n\n");
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