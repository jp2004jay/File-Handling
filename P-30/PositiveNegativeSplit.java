Write a program which stores 10 integers in a file and then reads them and stores all the positive
number in one file, while all negative numbers in another file.

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PositiveNegativeSplit{
	public static void main(String[] args){
		Scanner scanUserInput = new Scanner(System.in);
		FileWriter fileWrite = null;
		try{
			fileWrite = new FileWriter("numbers.txt");
			for(int i=0; i<10; i++){
				System.out.println("Enter number : "+(i+1));
				fileWrite.write(scanUserInput.nextInt()+"\n");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				fileWrite.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}


		try{
			Scanner scan = new Scanner(new File("numbers.txt"));
			FileWriter positiveWrite = new FileWriter("positive-numbers.txt");
			FileWriter negativeWrite = new FileWriter("negative-numbers.txt");
			while(scan.hasNext()){
				String record = scan.nextLine();
				int recordCheke = Integer.parseInt(record);
				if(recordCheke >= 0){
					positiveWrite.write(record+"\n");
				}
				else{
					negativeWrite.write(record+"\n");
				}
			}

			positiveWrite.close();
			negativeWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Command Executed Successfully");
	}
}