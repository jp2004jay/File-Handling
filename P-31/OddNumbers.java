/*
 * Write a program that reads the odd number between 300 to 500 to a text file
*/

import java.io.File;
import java.util.Scanner;

public class OddNumbers{

	public static void main(String[] args){

		try{
			// Try reading the contents of the file "numbers.txt"
			Scanner scan = new Scanner(new File("numbers.txt"));

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				int record = Integer.parseInt(scan.nextLine());
				
				// Check if the number satisfies the conditions and print it if it does
				if(record >= 300 && record <= 500 && (record % 2 != 0)){

					System.out.println(record);
				}

			}

			// Close the Scanner object
        	scan.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading, print the stack trace
			e.printStackTrace();
		}
	}
}