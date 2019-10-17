package file_reader;
import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.io.FileNotFoundException; 

public class PlainText extends FileReader {

    private File fileObj;
    private Scanner fileScanner;
    private String path;
    private String type;
    private String name;


    // Constructor
    PlainText(File fileObj) throws FileNotFoundException, Exception {
        super(fileObj);
        // Throw an exception if the file is not related to this contructor
        if (!FileReader.getFileExtension(super.fileObj).equals("txt"))
            throw new Exception("Invalid file extension.");
    }


    // Display content with reversed lines
    public void reverseLinesContent() {

        ArrayList<String> lines = new ArrayList<String>();

        super.fileScanner.useDelimiter("\n");

        while (super.fileScanner.hasNext()) {
            lines.add(super.fileScanner.next());
        }

        for (int i=0; i < lines.size(); i++) {
            System.out.println(lines.get(lines.size()-1-i));
        }
    };


    // Display content with reversed characters and lines
    public void reverseContent() {

        ArrayList<String> lines = new ArrayList<String>();

        super.fileScanner.useDelimiter("\n");

        while (super.fileScanner.hasNext()) {
            lines.add(super.fileScanner.next());
        }

        for (int i=0; i < lines.size(); i++) {
            String[] line = lines.get(lines.size()-1-i).split("");
            for (int j=0; j < line.length; j++) {
                System.out.print(line[line.length-1-j]);
            }
            System.out.println();
        }
    };
}