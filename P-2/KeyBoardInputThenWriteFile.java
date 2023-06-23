/*
 * Receives records from keyboard and writes them to a file in Java.
*/

import java.io.FileWriter;
import java.util.Scanner;

public class KeyBoardInputThenWriteFile{
	
	public static void main(String []args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a record (or 'save' to save the file.): ");
		FileWriter fileWriter = null;
		
		try{
			//Initialised 'fileWriter' with capable to make a new file.
			fileWriter = new FileWriter("example.txt", true);
			
			/*As much data as the user enters through the keyboard,
			the data will be taken and written to the file.
			Until the user type 'Save'. */
			while(true){
				String record = scan.nextLine();
	
				if(record.equalsIgnoreCase("save")){
					break;
				}
				
				fileWriter.write(record+"\n");
			}
			//Closes the resource named 'fileWriter'.
			fileWriter.close();
		}
		
		catch(Exception e){
			/*If there is any problem in outputting the file, 
			that problem will be printed here.*/
			e.printStackTrace();
		}
	}
}