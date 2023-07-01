/*
 * Write a program to demonstrate fseek() function.
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSeekExample {

    public static void main(String[] args) {

        try {
            RandomAccessFile file = new RandomAccessFile("example.txt", "rw");

            // Writing data to the file
            file.writeBytes("Hello, World!");

            // Moving the file pointer to a specific position
            file.seek(7);

            // Reading data from the file from the current position
            byte[] buffer = new byte[5];
            file.read(buffer);

            System.out.println("Data read: " + new String(buffer));

            file.close();
        } 

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}