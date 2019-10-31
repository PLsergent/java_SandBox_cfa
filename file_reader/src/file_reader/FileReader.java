package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.lang.Exception;
import java.io.FileNotFoundException;

public abstract class FileReader implements FileReaderInterface {

    protected File fileObj;
    protected Scanner fileScanner;
    protected String path;
    protected String type;
    protected String name;


    // Constructor
    FileReader(File fileObj) throws FileNotFoundException {
        this.fileObj = fileObj;
        this.fileScanner = new Scanner(fileObj);
        this.path = fileObj.getPath();
        this.type = getFileExtension(fileObj);
        this.name = fileObj.getName();
    }


    // Static methods to determine file extension
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            return "";
        } 
    }


    // Useful methods
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


    // Used to go back to first line of the file
    public void resetScanner() throws FileNotFoundException{
        this.fileScanner.close();
        this.fileScanner = new Scanner(this.fileObj);
    }

    
    // Display content of the whole file
    public void displayContent() {
        System.out.println(this.fileScanner.next());
    }

    public String toString() {
        return this.getName() + " " + this.getPath() + " " + this.getType();
    }


    // Implemented in subclasses
    public void reverseLinesContent() {};
    public void reverseContent() {};
}