Write a program to change all uppercase character in a file to lowercase, and vice-versa.


import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Arrays;

public class UpperLowerViceVersa{
	public static void main(String[] args){
		try{


			Scanner scan = new Scanner(new File("example.txt"));
			
			String output = "";
			while(scan.hasNext()){
				char[] record = scan.nextLine().toCharArray();
				
				for (char temp : record) {
					
					if((int)temp >= 97 && (int)temp <=122){
						output += (char)((int)temp-32);
					}
					else if((int)temp >= 65 && (int)temp <= 90){
						output += (char)((int)temp+32);
					}
					else{
						output += temp;
					}
				}
				output += '\n';
			}
			scan.close();

			FileWriter fileWrite = new FileWriter("example.txt");

			fileWrite.write(output);
			
			fileWrite.close();
		


		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}