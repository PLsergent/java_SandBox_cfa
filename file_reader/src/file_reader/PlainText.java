package file_reader;
import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class PlainText extends FileReader {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    private File fileObj;
    private Scanner fileScanner;
    private String path;
    private String type;
    private String name;


    // Constructor
    PlainText(File fileObj) throws FileNotFoundException, Exception {
        super(fileObj);
        // Throw an exception if the file extension is not related to this contructor
        if (!FileReader.getFileExtension(super.fileObj).equals("txt"))
            throw new Exception("Invalid file extension.");
    }


    // Display content with reversed lines
    public void reverseLinesContent() {
        ArrayList<String> lines = new ArrayList<String>();

        super.fileScanner.useDelimiter("\n");

        // Add each lines to an array
        while (super.fileScanner.hasNext()) {
            lines.add(super.fileScanner.next());
        }

        for (int i=0; i < lines.size(); i++) {
            // Display each lines starting at the end of the array "lines"
            System.out.println(lines.get(lines.size()-1-i));
        }
    }


    // Display content with reversed characters and lines
    public void reverseContent() {
        ArrayList<String> lines = new ArrayList<String>();

        super.fileScanner.useDelimiter("\n");

        // Add each lines to an array
        while (super.fileScanner.hasNext()) {
            lines.add(super.fileScanner.next());
        }

        for (int i=0; i < lines.size(); i++) {
            // For each lines : create an array with every char composing the line
            String[] line = lines.get(lines.size()-1-i).split("");

            // Then display each chars starting at the end
            for (int j=0; j < line.length; j++) {
                System.out.print(line[line.length-1-j]);
            }
            System.out.println();
        }
    }


    // Display differences between two plain text files
    public static void comparePlainTextFiles(FileReader file1, FileReader file2) {
        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
    }
}