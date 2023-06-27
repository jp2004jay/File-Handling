/*
 * Write a program to append one file at the end of other.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Append{
	
	public static void main(String[] args){
		
		Scanner scan = null;
		FileWriter fileWrite = null;
		
		try{
			scan = new Scanner(new File("example.txt"));
			fileWrite = new FileWriter("exampleAppend.txt", true);
			
			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n");
			}
			
			fileWrite.close();
			
			System.out.println("Command Executed Successfully");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			scan.close();
		}
	}
}