/* 
 * Write a program which writes whole ASCII set in the file "ASC_SET". 
 * After that program reads and prints only digits and uppercase alphabets from the file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ASCIISet{
	
	public static void main(String[] args){

		try{

			FileWriter fileWrite = new FileWriter("ASC_SET.txt");
			
			// Write the ASCII character set to the file
			for(int i=0; i<=127; i++){
				fileWrite.write(i+"\t"+(char)i+"\n");
			}

			fileWrite.close();

			Scanner scan = new Scanner(new File("ASC_SET.txt"));
			
			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				// Read the current line as a string
				String recordString = scan.nextLine();
				
				// Skip empty lines
				if(recordString.isEmpty()){
					continue;
				}

				String[] record = recordString.split("\t");

				// Parse the ASCII value from the string to an integer
				int ascII = Integer.parseInt(record[0]);
				
				// Filter records based on ASCII values
				if(ascII >= 48 && ascII <= 57 || ascII >= 65 && ascII <=90){

					// Print the filtered record to the console
					for(String temp : record){
						System.out.print(temp+"\t");
					}

					System.out.println();
				}

			}

			 // Close the Scanner object
			scan.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
	}
}