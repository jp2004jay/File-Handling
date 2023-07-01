/*
 * Count number of words in a line.
 * Words are separated by whitespace characters.
*/

import java.io.File;
import java.util.Scanner;

public class CountNumberOfWordsInALine{
	
	public static void main(String[] args){
		
		Scanner scan = null;
		
		try{
			// Open the file "example.txt" for reading
			scan = new Scanner(new File("example.txt"));
			
			int lineCounter = 1;
			
			while(scan.hasNext()){
				String record = scan.nextLine();
				String[] wordsInLine = record.split(" ");

				// Print the line number and the number of words in the line
				System.out.println("Line : "+lineCounter+", In this line have "+ wordsInLine.length+" words.");
				lineCounter++;
			}
			
			scan.close();
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}
	}
}