/*
 * Write a program that reads student data (roll no, name, age).
 * From keyboard for 5 students and write them into file. 
 * The program then reads the data from the same file and displays on screen.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Student{
	
	int rollNo;
	String name;
	int age;
	
	Student(int rollNo, String name, int age){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return (rollNo+"\t"+name+"\t\t"+age);
	}
}

public class ReadWriteStudentData{
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		
		Student[] students = new Student[5];
		
		Scanner readStudentData = null;
		FileWriter fileWrite = null;
		
		String fileName = "Student Data.txt";
		
		for(int i=0; i<students.length; i++){
			
			System.out.println("Enter Roll number of Student "+(i+1)+": ");
			int rollNo = scan.nextInt();
			
			System.out.println("Enter Name of Student "+(i+1)+": ");
			String name = scanString.nextLine();
			
			System.out.println("Enter Age of Student "+(i+1)+": ");
			int age = scan.nextInt();
			
			students[i] = new Student(rollNo, name, age);
		}
		
		try{
			
			fileWrite = new FileWriter(fileName);
			fileWrite.write("Rollno\tName\t\tAge\n");
			
			for(Student temp : students){
				fileWrite.write(temp.toString()+"\n");
			}
			
			fileWrite.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("\nStudent Data From File\n");
		try{
			readStudentData = new Scanner(new File(fileName));
			while(readStudentData.hasNext()){
				System.out.println(readStudentData.nextLine());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			readStudentData.close();
		}
	}
}

