/*
 * Write a program to copy only lines beginning with user specified character
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CopyFileWithUserSpecified{

	public static void main(String[] args){
		
		Scanner scanUserChar = new Scanner(System.in);
		
		// Prompt the user to enter the beginning character of a line
		System.out.println("Enter the beginning character of line");
		String userChar = ""+scanUserChar.next().charAt(0);
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			
			// Create a FileWriter object to write the selected lines to the new file "example-copy.txt"
			FileWriter fileWrite = new FileWriter("example-copy.txt");

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				String temp = scan.nextLine();

				// Check if the beginning character of the line matches the user-specified character
				if((""+temp.charAt(0)).equalsIgnoreCase(userChar)){
					fileWrite.write(temp+"\n");
				}
				else{
					continue;
				}

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