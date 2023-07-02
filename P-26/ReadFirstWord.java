/*
 * Write a program that reads the first word of each line of input and prints them out at the end.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadFirstWord{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			FileWriter fileWrite = new FileWriter("example-first-word.txt");
			while(scan.hasNext()){
				String[] eachLine = scan.nextLine().split(" ");
				fileWrite.write(eachLine[0]+"\n");
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