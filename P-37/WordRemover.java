import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WordRemover {
    public static void main(String[] args) {
        // Read the input file
        String inputFilePath = "input.txt";
        String inputFileContent = readFile(inputFilePath);

        // Remove words and create the output file
        String outputFileContent = removeWords(inputFileContent);
        String outputFilePath = "output.txt";
        writeFile(outputFilePath, outputFileContent);

        System.out.println("Output file created successfully.");
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

    private static String removeWords(String text) {
        text = text.replaceAll("\\ba\\b", " ");
        text = text.replaceAll("\\bthe\\b", " ");
        text = text.replaceAll("\\ban\\b", " ");
        return text;
    }

    private static void writeFile(String filePath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
