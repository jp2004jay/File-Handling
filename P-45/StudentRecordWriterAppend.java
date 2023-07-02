/* 
 * Write a program to print all the records of file created in above program, 
   append a record and update the record.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentRecordWriterAppend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of student records to enter: ");
        int numRecords = scanner.nextInt();

        // Create a binary file to store the student records
        File file = new File("student_records.txt");

        try {
            FileWriter writer = new FileWriter(file, true);

            for (int i = 0; i < numRecords; i++) {
                System.out.println("Enter details for student " + (i + 1) + ":");
                System.out.print("Name: ");
                String name = scanner.next();

                char[] recordToChar = name.toCharArray();
                
                for(char temp : recordToChar){
                    int charASCII = (int)temp;
                    
                    int charBinary = 0;
                    int place = 1;
                    
                    while(charASCII != 0){
                        int digit = charASCII % 2;
                        charASCII = charASCII / 2;
                        charBinary = charBinary + (place*digit);
                        place = place * 10;
                    }
                    
                    writer.write(""+charBinary+" ");
                }
                writer.write("\n");

                System.out.print("Roll number: ");
                int rollNumber = scanner.nextInt();

                System.out.print("Marks: ");
                int marks = scanner.nextInt();

                // Write the student record to the binary file
                writer.write(toBinaryInt(rollNumber) + "\n");
                writer.write(toBinaryInt(marks) + "\n\n");
            }

            writer.close();
            System.out.println("Student records have been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the student records to the file.");
            e.printStackTrace();
        }
    }

    public static int toBinaryInt(int num){
        int binaryNum = 0;
        int place = 1;
        while(num != 0){
            int digit = num % 2;
            num = num/2;

            binaryNum = binaryNum + (place*digit);
            place = place * 10;
        }
        return binaryNum;
    }
}
