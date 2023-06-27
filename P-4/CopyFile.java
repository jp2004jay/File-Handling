/*
 * Write a program to copy one file to another file in Java.
 * The source and destination file name are taken from command line.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyFile{
	
	public static void main(String []args){
		
		Scanner readFile = null;
		FileWriter fileWriter = null;
		
		String sourceFile = args[0];
		String destinationFile = args[1];
		
		try{
			//Initialised 'readFile' with capable to read data.
			readFile = new Scanner(new File(sourceFile+".txt"));
			
			//Initialised 'fileWriter' with capable to make a new file.
			fileWriter = new FileWriter(destinationFile+".txt");
			
			//Data in file is read line by line with put in another file.
			while(readFile.hasNext()){
				String record = readFile.nextLine();
				fileWriter.write(record+"\n");
			}
			
			//Closes the all resource here.
			fileWriter.close();
			
			System.out.println("Command executed successfully");
		}
		
		catch(FileNotFoundException fnfe){
			//If "File not found", then this line is executed.
			System.out.println("File not found!");
		}
		
		catch(Exception e){
			/*If there is any problem in outputting the file, 
			that problem will be printed here.*/
			e.printStackTrace();
		}
		
		finally{
			readFile.close();
		}
	}
}