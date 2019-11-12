package file_reader;
import java.io.File; 
import java.util.Scanner;
import java.util.ArrayList;
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

    public void closeScanner() {
        this.fileScanner.close();
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


    // Used in reverseContent and CompareFiles
    public ArrayList<String> readLines() {
        ArrayList<String> lines = new ArrayList<String>();

        this.fileScanner.useDelimiter("\n");

        // Add each lines to an array
        while (this.fileScanner.hasNext()) {
            lines.add(this.fileScanner.next());
        }

        return lines;
    }


    // Implemented in subclasses
    public abstract void reverseLinesContent();
    public abstract void reverseContent();
}