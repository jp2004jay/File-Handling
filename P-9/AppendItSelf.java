/*
 * Write a program to append a file itself.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AppendItSelf{
	
	public static void main(String[] args){
		
		Scanner scan = null;
		FileWriter fileWrite = null;
		
		try{

			// Create a Scanner object to read from the file
			scan = new Scanner(new File("append-it-self.txt"));
			
			// Create a FileWriter object to write to the file
			fileWrite =new FileWriter("append-it-self.txt", true);

			// Read each line from the input file and write it to the same file
			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n");
			}

			// Close the FileWriter object
			fileWrite.close();
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}
		
		finally{
			// Close the Scanner object for reading from the file
			scan.close();
		}

		System.out.println("Command Executed Successfully");
	}
}