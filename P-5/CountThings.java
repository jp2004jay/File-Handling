/*
 * Count chars, space, tabs and new lines in a file.
 * At the end of the file program should display appropriate message.
 */
 
 import java.io.File;
 import java.util.Arrays;
 import java.util.Scanner;
 
 public class CountThings{
	
	public static void main(String []args){
		
		int charsCount = 0;
		int spaceCount = 0;
		int tabsCount = 0;
		int lineCount = 0;
		
		try{
			//Initialised 'scan' with capable to read a file. 
			Scanner scan = new Scanner(new File("example.txt"));
			
			while(scan.hasNext()){
				String temp = scan.nextLine();
				
				//Here the whole 'temp' is separated by tab.
				String[] tempTabs = temp.split("\t");
				
				//Here the whole 'temp' is separated by space.
				String[] tempSpace = temp.split(" ");
				
				//All characters are counted here.
				for(String tempString : tempSpace){
					
					for(char c : tempString.toCharArray()){
						
						if(c == '\t'){
							continue;
						}
						
						else if((int)c >= 65 && (int)c <=97 || (int)c >= 97 && (int)c <=122){
							charsCount++;
						}
					}
				}
				
				tabsCount = tempTabs.length-1;
				spaceCount = tempSpace.length-1;
				lineCount++;
			}
			
			scan.close();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("\"In Whole File\"");
		System.out.println("Total Charactors: "+charsCount);
		System.out.println("Total Spaces: "+spaceCount);
		System.out.println("Total Tabs: "+tabsCount);
		System.out.println("Total Lines: "+lineCount);
	}
}