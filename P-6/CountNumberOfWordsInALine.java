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
			
			scan = new Scanner(new File("example.txt"));
			
			
			int lineCounter = 1;
			while(scan.hasNext()){
				String record = scan.nextLine();
				String[] wordsInLine = record.split(" ");
				System.out.println("Line : "+lineCounter+", In this line have "+ wordsInLine.length+" words.");
				lineCounter++;
			}
			
			//scan.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			scan.close();
		}
	}
}