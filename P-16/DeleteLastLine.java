/*
 * Write a program to delete last line of any file.
*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class DeleteLastLine{
    public static void main(String[] args){

        ArrayList<String> eachLine = new ArrayList<String>();

        try{
            Scanner scan = new Scanner(new File("example.txt"));
            
            while(scan.hasNext()){
                eachLine.add(scan.nextLine());
            }

            eachLine.remove(eachLine.size()-1);
            scan.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }

        try{

            FileWriter fileWrite = new FileWriter("example.txt");

            for(String temp : eachLine){
                fileWrite.write(temp+"\n");
            }
            fileWrite.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Command Executed Successfully");
    }
}