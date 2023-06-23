/*
 * Write a program to display the contents of a given file in Java. 
*/

import java.io.File;
import java.util.Scanner;

public class DisplayContentOfFile{
	
	public static void main(String []args){
		
		Scanner scan = null;
		
		try{
			//Initialised 'scan' with capable to read a file. 
			scan = new Scanner(new File("example.txt"));
			
			/*Data in file is read line by line 
			using while loop til the end of file.*/
			while(scan.hasNext()){
				System.out.println(scan.nextLine());
			}
		}
		
		catch(Exception e){
			/*If there is any problem in outputting the file, 
			that problem will be printed here.*/
			e.printStackTrace();
		}
		
		finally{
			//Closes the resource named 'scan'.
			scan.close();
		}
	}
}