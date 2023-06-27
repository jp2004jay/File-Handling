import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class InsertBlankLine{
	public static void main(String[] args){
		ArrayList<String> eachLine = new ArrayList<String>();

		try{
			Scanner scan = new Scanner(new File("example.txt"));
			while(scan.hasNext()){
				eachLine.add(scan.nextLine());
			}

			eachLine.add(7, " ");

			FileWriter fileWrite = new FileWriter("example.txt");
			for(String temp : eachLine){
				fileWrite.write(temp+"\n");
			}

			fileWrite.close();
			scan.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}