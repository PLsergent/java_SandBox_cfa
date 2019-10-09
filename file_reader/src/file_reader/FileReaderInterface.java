package file_reader;

public interface FileReaderInterface{

    String getType();
    String getPath();
    String getName();

    void readFile();
    void displayContent();
    
    void reverseLinesContent();
    void reverseContent();
}