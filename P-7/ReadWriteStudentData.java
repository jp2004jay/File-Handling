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
	
	/*
	 * Constructor to create a Student object with the specified roll number, name, and age.
	 * 
	 * @param rollNo The roll number of the student.
	 * @param name The name of the student.
	 * @param age The age of the student.
	 */
	Student(int rollNo, String name, int age){
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}
	
	/*
	 * Returns a string representation of the Student object.
	 * The string contains the roll number, name, and age of the student.
	 * 
	 * @return A formatted string representation of the student's information.
	 */
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
			
			// Read the roll number from the console
			System.out.println("Enter Roll number of Student "+(i+1)+": ");
			int rollNo = scan.nextInt();
			
			// Read the name from the console
			System.out.println("Enter Name of Student "+(i+1)+": ");
			String name = scanString.nextLine();
			
			// Read the age from the console
			System.out.println("Enter Age of Student "+(i+1)+": ");
			int age = scan.nextInt();
			
			// Create a new Student object with the provided data
			students[i] = new Student(rollNo, name, age);
		}
		
		try{
			fileWrite = new FileWriter(fileName);
			fileWrite.write("Rollno\tName\t\tAge\n");
			
			// Write each student's information to the file
			for(Student temp : students){
				fileWrite.write(temp.toString()+"\n");
			}
			// Close the FileWriter object
			fileWrite.close();
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}
		
		System.out.println("\nStudent Data From File\n");
		
		try{
			readStudentData = new Scanner(new File(fileName));
			
			// Read and print each line from the file
			while(readStudentData.hasNext()){
				System.out.println(readStudentData.nextLine());
			}
		}

		catch(Exception e){
			// Print the exception trace if an error occurs
			e.printStackTrace();
		}

		finally{
			// Close the Scanner object for reading data from the file
			readStudentData.close();
		}
	}
}