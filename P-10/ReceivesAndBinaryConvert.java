/*
 * Receives records from keyboards.
 * And writes them to a file in binary mode.
*/

import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class ReceivesAndBinaryConvert{
	
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
				
				char[] recordToChar = record.toCharArray();
				
				for(char temp : recordToChar){
					int charASCII = (int)temp;
					
					int charBinary = 0;
					int place = 1;
					
					while(charASCII != 0){
						int digit = charASCII % 2;
						charASCII = charASCII / 2;
						charBinary = charBinary + (place*digit);
						place = place * 10;
					}
					
					fileWriter.write(""+charBinary+" ");
				}
				fileWriter.write("\n");
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