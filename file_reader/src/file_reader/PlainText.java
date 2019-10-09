package file_reader;
import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;

public class PlainText extends FileReader{

    private File fileObj;
    private Scanner fileScanner;
    private String path;
    private String type;
    private String name;

    PlainText(File fileObj, Scanner fileScanner){ 
        super(fileObj, fileScanner);
    }

    public void reverseLinesContent() {
        ArrayList<String> lines = new ArrayList<String>();
    };

}