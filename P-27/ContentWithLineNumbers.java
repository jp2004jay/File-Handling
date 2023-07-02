/*
 * Write a program to read a file and display contents with its line numbers.
*/

import java.io.File;
import java.util.Scanner;

public class ContentWithLineNumbers{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			int lineNumber = 1;
			while(scan.hasNext()){
				System.out.println("Line : "+lineNumber+" "+scan.nextLine());
				lineNumber++;
			}
			scan.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}