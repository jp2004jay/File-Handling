/*
 * Write a program to read a list of words, sort the words in alphabetical order.
 * Display them one word per line. 
 * Also give the total number of words in the list. 
 * Output format should be:
 * Total Number of words in the list is _______
 * Alphabetical listing of words is:
    ------
    ------
 * Assume the end of the list is indicated by ZZZZZZ. 
 * There are maximum in 25 words in the Text file.
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordSorter {
    public static void main(String[] args) {
        // Read the input file
        String inputFilePath = "words.txt";
        ArrayList<String> wordList = readFile(inputFilePath);

        // Sort the words in alphabetical order
        Collections.sort(wordList);

        // Display the total number of words
        int totalWords = wordList.size();
        System.out.println("Total Number of words in the list is " + totalWords);

        // Display the alphabetical listing of words
        System.out.println("Alphabetical listing of words is:");
        for (String word : wordList) {
            System.out.println(word);
        }
    }

    private static ArrayList<String> readFile(String filePath) {
        ArrayList<String> wordList = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.equals("ZZZZZZ")) {
                    break;
                }
                wordList.add(word);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return wordList;
    }
}
