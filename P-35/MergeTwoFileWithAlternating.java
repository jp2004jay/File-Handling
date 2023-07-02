/*
 * Write a program that merges lines alternately from two files and writes the results to new file. 
 * If one file has less number of lines than the other, 
 * The remaining lines from the larger file should be simply copied into the target file
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class MergeTwoFileWithAlternating{
	public static void main(String[] args){
		try{
			int terminate = 0;
			ArrayList<String> file1 = readData("example");
			ArrayList<String> file2 = readData("score");

			FileWriter fileWrite = new FileWriter("mearge.txt");

			if(file1.size() > file2.size()){
				terminate = file1.size();
			}
			else{
				terminate = file2.size();
			}

			for(int i=0; i<terminate; i++){
				if(file1.size() > i){
					fileWrite.write(file1.get(i)+"\n");
				}
				if(file2.size() > i){
					fileWrite.write(file2.get(i)+"\n");
				}
			}
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}	
	public static ArrayList<String> readData(String fileName) throws Exception{
		ArrayList<String> data = new ArrayList<String>();

		Scanner scan = new Scanner(new File(fileName+".txt"));

		while(scan.hasNext()){
			data.add(scan.nextLine());
		}

		scan.close();
		return data;
	}
}
