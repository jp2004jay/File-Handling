/*
 * Reads records from binary file and display them on screen.
*/

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class BinaryToDisplay{

	public static void main(String[] args){
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
		
			while(scan.hasNext()){
				
				String[] binary = scan.nextLine().split(" ");
				
				for(String temp : binary){
					int number = 0;
					for(int i=0; i<temp.length(); i++){
						number += ((int)temp.charAt(i)-48)*(int)Math.pow(2, temp.length()-1-i);
					}
					System.out.print((char)number);
				}
				System.out.print("\n");
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}