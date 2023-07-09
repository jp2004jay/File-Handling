/* 
 * Write a program to change all uppercase character in a file to lowercase, and vice-versa.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class UpperLowerViceVersa{

	public static void main(String[] args){
	
		try{

			Scanner scan = new Scanner(new File("example.txt"));
			
			String output = "";

			// Read each line of the file until there are no more lines        
			while(scan.hasNext()){

				// Read the current line as a character array
				char[] record = scan.nextLine().toCharArray();

				// Convert each character to opposite case and append it to the output
				for (char temp : record) {
					
					if((int)temp >= 97 && (int)temp <=122){

						// Convert lower case to upper case
						output += (char)((int)temp-32);
					}
					else if((int)temp >= 65 && (int)temp <= 90){
					
						// Convert upper case to lower case
						output += (char)((int)temp+32);
					}
					else{
						
						// Keep non-alphabetic characters as they are
						output += temp;
					}

				}

				output += '\n';
			}

			// Close the Scanner object
			scan.close();

			FileWriter fileWrite = new FileWriter("example.txt");
			
			// Write the modified content to the file
			fileWrite.write(output);

			// Close the FileWriter object
			fileWrite.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}