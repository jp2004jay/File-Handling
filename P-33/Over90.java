import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Over90{
	public static void main(String[] args){
		try{
			Scanner scan = new Scanner(new File("score.txt"));
			FileWriter fileWrite = new FileWriter("score-over-90.txt");
			int count = 0;

			while(scan.hasNext()){
				int record = Integer.parseInt(scan.nextLine());
				if(record > 90){
					fileWrite.write(record+"\n");
					count++;
				}
			}
			fileWrite.close();
			System.out.println("Count is : "+count);
		}
		catch(Exception e){
			e.printStackTrace();
		}

		try{
			Scanner scanOver90 = new Scanner(new File("score-over-90.txt"));

			while(scanOver90.hasNext()){
				System.out.println(scanOver90.nextLine());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

