Write a program to find the size of a text file without traversing it character by character.

import java.io.File;

public class FindSize{
	public static void main(String[] args){
		File file = new File("example.txt");
		long fileSize = file.length();
		System.out.println("Size of this file is: "+fileSize+" bytes");
	}
}