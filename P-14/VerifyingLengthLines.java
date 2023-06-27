/*
 * Write a program to accept a file of verifying length lines.
 * And changes it to a formatted file with 60 characters in each line.
*/

import java.io.File;
import java.util.Scanner;

public class VerifyingLengthLines{
	
	public static void main(String[] args){
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			
			int lineNumber = 1;
			boolean isValid = true;
			while(scan.hasNext()){
				String[] record = scan.nextLine().split(" ");
				
				int charCounter = 0;
				for(String temp : record){
					for(int i=0; i<temp.length(); i++){
						charCounter++;
					}
				}
				
				if(charCounter > 60){
					System.out.println("Invalid Line: "+lineNumber);
					isValid = false;
				}
				lineNumber++;
			}
			if(isValid){
				System.out.println("The file is completely valid.");
			}
			
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}