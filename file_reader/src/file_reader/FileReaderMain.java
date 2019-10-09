package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 

public class FileReaderMain{

    public static void main(String[] args) throws FileNotFoundException, Exception {
        File file1 = new File("/home/pl/everysaint/java_SandBox_cfa/file_reader/plain_text_file.txt");

        if (FileReader.getFileExtension(file1).equals("txt")){
            FileReader file_reader1 = new PlainText(file1);
            
            file_reader1.readFile();
            file_reader1.displayContent();

            file_reader1.resetScanner();
            
            file_reader1.reverseLinesContent();
        }
        
    }
}