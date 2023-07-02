/* 
 * Write a program which writes whole ASCII set in the file “ASC_SET”. 
 * After that program reads and prints only digits and uppercase alphabets from the file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ASCIISet{
	public static void main(String[] args){
		try{
			FileWriter fileWrite = new FileWriter("ASC_SET.txt");
			
			for(int i=0; i<=127; i++){
				fileWrite.write(i+"\t"+(char)i+"\n");
			}
			fileWrite.close();

			Scanner scan = new Scanner(new File("ASC_SET.txt"));
			while(scan.hasNext()){
				String recordString = scan.nextLine();
				if(recordString.isEmpty()){
					continue;
				}
				
				String[] record = recordString.split("\t");

				int ascII = Integer.parseInt(record[0]);
				
				if(ascII >= 48 && ascII <= 57 || ascII >= 65 && ascII <=90){
					for(String temp : record){
						System.out.print(temp+"\t");
					}
					System.out.println();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}