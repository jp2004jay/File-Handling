/*
 * Write a program to read a score from a file, 
 * count the score over 90, 
 * copy the score over 90 to a new file 
 * Print the number of score over 90 to the monitor.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Over90{

	public static void main(String[] args){

		try{

			Scanner scan = new Scanner(new File("score.txt"));
			FileWriter fileWrite = new FileWriter("score-over-90.txt");
			
			int count = 0;

			// Read each line of the file until there are no more lines
			while(scan.hasNext()){

				int record = Integer.parseInt(scan.nextLine());
				
				// Check if the score is greater than 90 and write it to the file if it is
				if(record > 90){
					fileWrite.write(record+"\n");
					count++;
				}
			}

			// Close the FileWriter object
			fileWrite.close();

			System.out.println("Count is : "+count);
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}

		try{

			Scanner scanOver90 = new Scanner(new File("score-over-90.txt"));
			
			// Read each line of the file until there are no more lines and print them to the console
			while(scanOver90.hasNext()){
				System.out.println(scanOver90.nextLine());
			}

		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
	}
}

