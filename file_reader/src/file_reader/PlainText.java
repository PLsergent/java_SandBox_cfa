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

    PlainText(File fileObj) throws FileNotFoundException, Exception {
        super(fileObj);
        if (!FileReader.getFileExtension(super.fileObj).equals("txt"))
            throw new Exception("Invalid file extension.");
    }

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

    public void reverseContent() {
        ArrayList<String> lines = new ArrayList<String>();

        super.fileScanner.useDelimiter("\n");

        while (super.fileScanner.hasNext()) {
            lines.add(super.fileScanner.next());
        }

        for (int i=0; i < lines.size(); i++) {
            String[] line = lines.get(lines.size()-1-i).split("");
            for (int j=0; j < line.length; j++){
                System.out.print(line[line.length-1-j]);
            }
            System.out.println();
        }
    };

}