import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class CopyFileWithUserSpecified{
	public static void main(String[] args){
		Scanner scanUserChar = new Scanner(System.in);
		System.out.println("Enter the beginning character of line");
		String userChar = ""+scanUserChar.next().charAt(0);
		
		try{
			Scanner scan = new Scanner(new File("example.txt"));
			FileWriter fileWrite = new FileWriter("example-copy.txt");

			while(scan.hasNext()){
				String temp = scan.nextLine();

				if((""+temp.charAt(0)).equalsIgnoreCase(userChar)){
					fileWrite.write(temp+"\n");
				}
				else{
					continue;
				}
			}
			scan.close();
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}