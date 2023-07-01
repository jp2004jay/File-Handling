Write a program to that copies one text file to another and insert blank lines between paragraphs
in the new file. Paragraphs are identified by a newline character.

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InsertBlankLineInParagraph{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			FileWriter fileWrite = new FileWriter("example-copy.txt");

			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n\n");
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