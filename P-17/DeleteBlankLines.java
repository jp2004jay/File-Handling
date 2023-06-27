/*
 * Write a program to delete lines in a file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class DeleteBlankLines{
	public static void main(String[] args){

		ArrayList<String> eachLine = new ArrayList<String>();

		try{
			Scanner scan = new Scanner(new File("example.txt"));
			while(scan.hasNext()){
				String temp = scan.nextLine();
				eachLine.add(temp);
			}
			scan.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		try{
			FileWriter fileWrite = new FileWriter("example.txt");

			for(String temp : eachLine){
				if(temp.isEmpty()){
					continue;
				}
				else{
					fileWrite.write(temp+"\n");
				}
			}

			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}