/*
 * Write a program to accept a file of verifying length lines.
 * And changes it to a formatted file with 60 characters in each line.
*/

import java.io.File;
import java.util.Scanner;

public class AverageNumberOfCharacters{
	
	public static void main(String[] args){
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			int sumCount = 0;
			int totalLines = 0;
			while(scan.hasNext()){
				String[] record = scan.nextLine().split(" ");
			
				int charCount = 0;
				for(String temp : record){
					for(int i=0; i<temp.length(); i++){
						charCount++;
					}
				}
				sumCount += charCount;
				totalLines++;
			}
			
			System.out.println("Average number of characters per line is: "+(float) sumCount / totalLines);
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}