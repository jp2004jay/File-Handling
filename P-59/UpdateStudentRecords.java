/*
 * Assume that a Master file contains two fields, Roll no. And name of the student. 
 * At the end of the year, a set of students join the class and another set leaves. 
 * A Transaction file contains the roll numbers and an appropriate code to add or delete a student. 
 * Write a program to create another file that contains the updated list of names and roll numbers. 
 * Assume that the Master file and the Transaction file are arranged in ascending order by roll numbers. 
 * The updated file should also bein ascending order by roll numbers.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Student class represents a student with their roll number and name.
*/
class Student {

    private int rollNo;
    private String name;
    
    /*
     * Constructs a Student object with the specified roll number and name.
     *
     * @param rollNo the roll number of the student
     * @param name   the name of the student
    */
    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    /*
     * Returns the roll number of the student.
     *
     * @return the roll number
    */
    public int getRollNo() {
        return rollNo;
    }

    /*
     * Returns the name of the student.
     *
     * @return the name
    */
    public String getName() {
        return name;
    }

    /*
     * Returns a string representation of the Student object.
     *
     * @return a string representation of the Student
    */
    @Override
    public String toString() {
        return rollNo + ", " + name;
    }
}

public class UpdateStudentRecords {

    public static void main(String[] args) {

        try {

            // Read the master file
            File masterFile = new File("master.txt");

            Scanner masterScanner = new Scanner(masterFile);

            Student[] students = new Student[100];

            int studentCount = 0;
            
            // Process each line of student data from the master file
            while (masterScanner.hasNextLine()) {

                String line = masterScanner.nextLine();
                String[] parts = line.split("\t");

                int rollNo = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();

                Student student = new Student(rollNo, name);
                students[studentCount] = student;
                studentCount++;
            }

            masterScanner.close();

            // Read the transaction file
            File transactionFile = new File("transaction.txt");

            Scanner transactionScanner = new Scanner(transactionFile);
            
            // Process each line of transaction data
            while (transactionScanner.hasNextLine()) {

                String line = transactionScanner.nextLine();
                String[] parts = line.split(", ");

                int rollNo = Integer.parseInt(parts[0].trim());
                String code = parts[1].trim();
                
                // Insert or delete student based on the transaction code
                if (code.equals("A")) {

                    String name = parts[2].trim();
                    Student student = new Student(rollNo, name);
                    insertStudent(students, student, studentCount);
                    studentCount++;
                } 
                else if (code.equals("D")) {
                    deleteStudent(students, rollNo, studentCount);
                    studentCount--;
                }
            }

            transactionScanner.close();

            // Write the updated records to the output file
            FileWriter writer = new FileWriter("updated.txt");

            for (int i = 0; i < studentCount; i++) {
                writer.write(students[i].toString() + "\n");
            }

            writer.close();

            System.out.println("Student records updated successfully!");

        } 

        catch (IOException e) {
            System.out.println("An error occurred while updating student records.");
            e.printStackTrace();
        }
    }

    /*
     * Inserts a new student into the sorted array of students.
     *
     * @param students the array of students
     * @param student  the student to insert
     * @param count    the current count of students
    */
    private static void insertStudent(Student[] students, Student student, int count) {

        int i = count - 1;

        while (i >= 0 && students[i].getRollNo() > student.getRollNo()) {
            students[i + 1] = students[i];
            i--;
        }

        students[i + 1] = student;
    }

     /*
     * Deletes a student with the given roll number from the array of students.
     *
     * @param students the array of students
     * @param rollNo   the roll number of the student to delete
     * @param count    the current count of students
    */
    private static void deleteStudent(Student[] students, int rollNo, int count) {

        int i = 0;

        while (i < count && students[i].getRollNo() != rollNo) {
            i++;
        }

        if (i == count) {
            System.out.println("Student with roll number " + rollNo + " not found.");
        } 
        else {
            for (int j = i; j < count - 1; j++) {
                students[j] = students[j + 1];
            }
        }
    }
}