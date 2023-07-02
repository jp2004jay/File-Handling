/*
 * Write a program that inserts 21st character of each line in a file to a new line. 
 * All extracted character are to on the same file. 
 * If a line in input file has fewer than 21 characters, write the last character. 
 * If line is blank then copy nothing. 
 * At the end of file write a new line to the new file and close it.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Character21OfEachLine{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			FileWriter fileWrite = new FileWriter("example-copy.txt");
			while(scan.hasNext()){
				char[] eachLine = scan.nextLine().toCharArray();

				int charCount = 1;
				char char21 = ' ';

				for(char temp : eachLine){
					if(temp == ' '){
						continue;
					}
					
					char21 = temp;

					if(charCount == 21){
						break;
					}
					charCount++;
				}
				fileWrite.write(char21+"\n");
			}
			scan.close();
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}