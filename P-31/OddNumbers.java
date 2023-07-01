Write a program that reads the odd number between 300 to 500 to a text file

import java.io.File;
import java.util.Scanner;

public class OddNumbers{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("numbers.txt"));
			while(scan.hasNext()){
				int record = Integer.parseInt(scan.nextLine());
				if(record >= 300 && record <= 500 && (record % 2 != 0)){
					System.out.println(record);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}