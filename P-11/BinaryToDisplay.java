/*
 * Reads records from binary file and display them on screen.
*/

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class BinaryToDisplay{

	public static void main(String[] args){
		
		try{
			// Create a Scanner object to read from the file
			Scanner scan = new Scanner(new File("example.txt"));
		
			while(scan.hasNext()){

				// Read the binary representation of each character
				String[] binary = scan.nextLine().split(" ");
				
				for(String temp : binary){
					// Initialize the variable to hold the decimal representation of the binary number
					int number = 0;

					for(int i=0; i<temp.length(); i++){
						number += ((int)temp.charAt(i)-48)*(int)Math.pow(2, temp.length()-1-i);
					}
					
					// Convert the decimal representation to its corresponding character and print it
					System.out.print((char)number);
				}

				System.out.print("\n");
			}
		}

		// Print the exception trace if an error occurs
		catch(Exception e){
			e.printStackTrace();
		}
	}
}