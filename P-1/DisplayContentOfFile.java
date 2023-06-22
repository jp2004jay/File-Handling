/*
 * Write a program to display the contents of a given file in Java. 
*/

import java.io.File;
import java.util.Scanner;

public class DisplayContentOfFile{
	
	public static void main(String []args){
		
		Scanner sc = null;
		
		try{
			//Initialised 'sc' with capable to read a file. 
			sc = new Scanner(new File("example.txt"));
			
			/*Data in file is read line by line 
			using while loop til the end of file.*/
			while(sc.hasNext()){
				System.out.println(sc.nextLine());
			}
		}
		
		catch(Exception e){
			/*If there is any problem in outputting the file, 
			that problem will be printed here.*/
			e.printStackTrace();
		}
		
		finally{
			//Closes the resource named 'sc'.
			sc.close();
		}
	}
}