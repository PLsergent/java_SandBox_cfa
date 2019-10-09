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

}