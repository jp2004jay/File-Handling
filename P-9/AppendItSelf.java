/*
 * Write a program to append a file itself.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AppendItSelf{
	
	public static void main(String[] args){
		
		Scanner scan = null;
		FileWriter fileWrite = null;
		
		try{
			
			scan = new Scanner(new File("append-it-self.txt"));
			fileWrite =new FileWriter("append-it-self.txt", true);
			while(scan.hasNext()){
				fileWrite.write(scan.nextLine()+"\n");
			}
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			scan.close();
		}
	}
}