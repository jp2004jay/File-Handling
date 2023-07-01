. Write a program to insert blank line after each line in a file.

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class InsertBlankLineAfterEachLine{
	public static void main(String[] args){
		ArrayList<String> eachLine = new ArrayList<String>();
		try{
			Scanner scan = new Scanner(new File("example.txt"));

			while(scan.hasNext()){
				eachLine.add(scan.nextLine());
			}

			FileWriter fileWrite = new FileWriter("example.txt");

			for(String temp : eachLine){
				fileWrite.write(temp+"\n\n");
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