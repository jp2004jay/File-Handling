/*
 * Write a program to insert a blank line after the seventh line in a file
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class InsertBlankLine{

	public static void main(String[] args){

		// Create a new ArrayList of strings to store each line of the file
		ArrayList<String> eachLine = new ArrayList<String>();

		try{
			Scanner scan = new Scanner(new File("example.txt"));

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				eachLine.add(scan.nextLine());
			}

			// Add a space at index 7 in the ArrayList
			eachLine.add(7, " ");

			FileWriter fileWrite = new FileWriter("example.txt");
			
			// Iterate over each line in the ArrayList
			for(String temp : eachLine){
				fileWrite.write(temp+"\n");
			}

			// Close the FileWriter and Scanner objects
			fileWrite.close();
			scan.close();
		}

		catch(Exception e){
			 // If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}