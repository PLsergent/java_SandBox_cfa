package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class FileReaderMain{

    public static void main(String[] args) throws FileNotFoundException, Exception {

        // Pass the file that you want to read as an argument
        if (args.length == 0 || args.length > 1)
            throw new Exception("Invalid number of arguments.");

        // Create File object
        File file1 = new File(args[0]);

        // Create File reader
        FileReader file_reader1 = new PlainText(file1);

        // Read file (change delimiter) and display content
        file_reader1.readFile();
        System.out.println("File content : \n--");
        file_reader1.displayContent();

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

        // Close scanner
        file_reader1.fileScanner.close();
    }
}