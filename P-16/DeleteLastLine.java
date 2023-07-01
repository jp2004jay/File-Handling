/*
 * Write a program to delete last line of any file.
 */

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class DeleteLastLine{

    public static void main(String[] args){

        // Create an ArrayList to store each line of the file
        ArrayList<String> eachLine = new ArrayList<String>();

        try{
            // Create a Scanner object to read from the file
            Scanner scan = new Scanner(new File("example.txt"));
            
            // Read each line and add it to the ArrayList
            while(scan.hasNext()){
                eachLine.add(scan.nextLine());
            }

            eachLine.remove(eachLine.size()-1);
            
            // Close the Scanner
            scan.close();
        }

        catch(Exception e){
            // Print the exception trace if an error occurs
            e.printStackTrace();
        }

        try{
            // Create a FileWriter object to write to the file
            FileWriter fileWrite = new FileWriter("example.txt");
            
            // Write each line from the ArrayList to the file
            for(String temp : eachLine){
                fileWrite.write(temp+"\n");
            }

            // Close the FileWriter
            fileWrite.close();
        }

        catch(Exception e){
            // Print the exception trace if an error occurs
            e.printStackTrace();
        }
        
        System.out.println("Command Executed Successfully");
    }
}