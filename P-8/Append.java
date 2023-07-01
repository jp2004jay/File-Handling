/*
 * Write a program to append one file at the end of other.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Append{
	
	public static void main(String[] args){
		
		Scanner scan = null;
		FileWriter fileWrite = null;
		
		try{
			// Create a Scanner object to read from the file
			scan = new Scanner(new File("example.txt"));

			// Create a FileWriter object to write to the file
			fileWrite = new FileWriter("exampleAppend.txt", true);
			
			// Read each line from the input file and write it to the output file
			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n");
			}
			
			// Close the FileWriter object
			fileWrite.close();
			
			System.out.println("Command Executed Successfully");
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}

		finally{
			// Close the Scanner object for reading from the file
			scan.close();
		}
	}
}