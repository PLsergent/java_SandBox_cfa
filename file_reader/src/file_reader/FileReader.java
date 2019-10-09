package file_reader;
import java.io.File; 
import java.util.Scanner; 

public abstract class FileReader implements FileReaderInterface {

    protected File fileObj;
    protected Scanner fileScanner;
    protected String path;
    protected String type;
    protected String name;

    
    FileReader(File fileObj, Scanner fileScanner) {
        this.fileObj = fileObj;
        this.fileScanner = fileScanner;
        this.path = fileObj.getPath();
        this.type = getFileExtension(fileObj);
        this.name = fileObj.getName();
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public String getType() {
        return getFileExtension(this.fileObj);
    }

    public String getPath() {
        return this.fileObj.getPath();
    }

    public String getAbsolutePath() {
        return this.fileObj.getAbsolutePath();
    }

    public String getName() {
        return this.fileObj.getName();
    }

    public void readFile() {
        this.fileScanner.useDelimiter("\\Z");
    }

    public void displayContent() {
        System.out.println(this.fileScanner.next());
    }

    public String toString() {
        return this.getName() + " " + this.getPath() + " " + this.getType();
    }

    public void reverseLinesContent() {};
    public void reverseContent() {};
}