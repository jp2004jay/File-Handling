/*
 * Write a program which stores 10 integers in a file.
 * Then reads them and stores all the positive number in one file, 
 * While all negative numbers in another file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PositiveNegativeSplit{

	public static void main(String[] args){

		Scanner scanUserInput = new Scanner(System.in);
		FileWriter fileWrite = null;

		try{

			fileWrite = new FileWriter("numbers.txt");
			
			// Prompt the user to enter 10 numbers and write them to the file
			for(int i=0; i<10; i++){
				System.out.println("Enter number : "+(i+1));
				fileWrite.write(scanUserInput.nextInt()+"\n");
			}

		}

		catch(Exception e){
			 // If an exception occurs during file writing, print the stack trace
			e.printStackTrace();
		}

		finally{
		
			try{
				// Close the FileWriter object    
				fileWrite.close();
			}

			catch (Exception e) {
				// If an exception occurs while closing the FileWriter object, print the stack trace
				e.printStackTrace();
			}

		}


		try{

			Scanner scan = new Scanner(new File("numbers.txt"));
			
			 // Create FileWriter objects to write positive and negative numbers to separate files
			FileWriter positiveWrite = new FileWriter("positive-numbers.txt");
			FileWriter negativeWrite = new FileWriter("negative-numbers.txt");
			
			// Read each number from the file until there are no more numbers
			while(scan.hasNext()){
				String record = scan.nextLine();
		
				int recordCheke = Integer.parseInt(record);

				// Separate positive and negative numbers and write them to the respective files
				if(recordCheke >= 0){
					positiveWrite.write(record+"\n");
				}

				else{
					negativeWrite.write(record+"\n");
				}

			}

			// Close the FileWriter objects
			positiveWrite.close();
			negativeWrite.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}