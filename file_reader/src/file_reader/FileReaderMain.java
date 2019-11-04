package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class FileReaderMain{

    public static void main(String[] args) throws FileNotFoundException, Exception {

        // Pass the file that you want to read as an argument
        if (args.length == 0 || args.length > 2)
            throw new Exception("Invalid number of arguments.");

        // Create File objects
        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        // Create File reader
        PlainText file_reader1 = new PlainText(file1);
        PlainText file_reader2 = new PlainText(file2);

        // Read file (change delimiter) and display content
        file_reader2.readFile();
        System.out.println("File 2 content : \n--");
        file_reader2.displayContent();

        file_reader1.resetScanner();
        System.out.println("============================");

        // Display content with reversed lines
        System.out.println("Reversed lines content : \n--");
        file_reader1.reverseLinesContent();

        file_reader1.resetScanner();
        System.out.println("============================");

        // Display content with reversed lines and characters
        System.out.println("Reversed lines and characters content : \n--");
        file_reader1.reverseContent();

        // Compare content from two files
        file_reader1.resetScanner();
        file_reader2.resetScanner();
        PlainText.comparePlainTextFiles(file_reader1, file_reader2);

        // Close scanner
        file_reader1.closeScanner();
        file_reader2.closeScanner();
    }
}