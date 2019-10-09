package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class FileReaderMain{

    public static void main(String[] args) throws FileNotFoundException, Exception {
        if (args.length == 0 || args.length > 1)
            throw new Exception("Invalid number of arguments.");

        File file1 = new File(args[0]);

        FileReader file_reader1 = new PlainText(file1);

        file_reader1.readFile();
        file_reader1.displayContent();

        file_reader1.resetScanner();
        System.out.println("============================");

        file_reader1.reverseLinesContent();

        file_reader1.resetScanner();
        System.out.println("============================");

        file_reader1.reverseContent();
    }
}