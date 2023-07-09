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

	/*
 	* Reads the data from a file and returns it as a list of strings.
 	*
 	* @param fileName The name of the file to read.
 	* @return The data read from the file as a list of strings.
 	* @throws Exception If an error occurs during file reading.
 	*/
	public static ArrayList<String> readData(String fileName) throws Exception{

		ArrayList<String> data = new ArrayList<String>();
		Scanner scan = new Scanner(new File(fileName+".txt"));

		while(scan.hasNext()){
			data.add(scan.nextLine());
		}

		scan.close();

		return data;
	}

	public static void main(String[] args){

		try{

			int terminate = 0;
			
			// Read the data from the file "example"
			ArrayList<String> file1 = readData("example");
			
			// Read the data from the file "score"
			ArrayList<String> file2 = readData("score");

			FileWriter fileWrite = new FileWriter("mearge.txt");

			// Determine the termination condition based on the size of the files
			if(file1.size() > file2.size()){
				terminate = file1.size();
			}
			else{
				terminate = file2.size();
			}

			// Merge the data from both files and write it to the "merge.txt" file
			for(int i=0; i<terminate; i++){

				if(file1.size() > i){
					fileWrite.write(file1.get(i)+"\n");
				}

				if(file2.size() > i){
					fileWrite.write(file2.get(i)+"\n");
				}
			}

			// Close the FileWriter object
			fileWrite.close();
		}

		catch(Exception e){
			// If an exception occurs during file reading or writing, print the stack trace
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}