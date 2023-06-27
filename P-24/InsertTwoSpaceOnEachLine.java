import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class InsertTwoSpaceOnEachLine{
	public static void main(String[] args){
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			FileWriter fileWrite = new FileWriter("example-copy.txt");

			while(scan.hasNext()){
				String temp = scan.nextLine();
				fileWrite.write("  "+temp+"\n");
			}
			scan.close();
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}