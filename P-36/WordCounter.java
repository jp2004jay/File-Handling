import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        // Read the text file
        String filePath = "TRIAL.TXT";
        String fileContent = readFile(filePath);

        // Count and display the number of words
        int wordCount = countWords(fileContent);
        System.out.println("Number of words in the file: " + wordCount);

        // Count and display the total number of four-letter words
        int fourLetterWordCount = countFourLetterWords(fileContent);
        System.out.println("Number of four-letter words in the file: " + fourLetterWordCount);
    }

    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return content.toString();
    }

    private static int countWords(String text) {
        Scanner scanner = new Scanner(text);
        int wordCount = 0;

        while (scanner.hasNext()) {
            scanner.next();
            wordCount++;
        }

        scanner.close();

        return wordCount;
    }

    private static int countFourLetterWords(String text) {
        Scanner scanner = new Scanner(text);
        int fourLetterWordCount = 0;

        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() == 4) {
                fourLetterWordCount++;
            }
        }

        scanner.close();

        return fourLetterWordCount;
    }
}
