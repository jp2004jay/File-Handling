Suppose a file contains student’s records with each record containing name and age of a student.
Write a program to read these records and display them in sorted order by name.


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class StudentRecordSorter {
    public static void main(String[] args) {
        File file = new File("student_records.txt");

        ArrayList<Student> studentList = new ArrayList<Student>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] record = line.split(",");

                String name = record[0].trim();
                int age = Integer.parseInt(record[1].trim());

                Student student = new Student(name, age);
                studentList.add(student);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file 'student_records.txt' could not be found.");
            e.printStackTrace();
        }

        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.name.compareToIgnoreCase(s2.name);
            }
        });

        System.out.println("Student records sorted by name:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
