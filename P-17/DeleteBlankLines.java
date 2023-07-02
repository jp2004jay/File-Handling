/*
 * Write a program to delete blank lines in a file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class DeleteBlankLines{

	public static void main(String[] args){

		// Create a new ArrayList of strings to store each line of the file
		ArrayList<String> eachLine = new ArrayList<String>();

		try{
			Scanner scan = new Scanner(new File("example.txt"));

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){
				String temp = scan.nextLine();

				// Add the line to the ArrayList
				eachLine.add(temp);
			}

			// Close the Scanner object
			scan.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading, print the stack trace
			e.printStackTrace();
		}

		try{
			FileWriter fileWrite = new FileWriter("example.txt");

			// Iterate over each line in the ArrayList
			for(String temp : eachLine){

				if(temp.isEmpty()){
					continue;
				}
				else{
					// If it is not empty, write the line followed by a newline character to the file
					fileWrite.write(temp+"\n");
				}

			}

			// Close the FileWriter object
			fileWrite.close();
		}

		catch(Exception e){
			// If an exception occurs during file writing, print the stack trace
			e.printStackTrace();
		}

		System.out.println("Command Executed Successfully");
	}
}