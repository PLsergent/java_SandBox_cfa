package file_reader;
import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class PlainText extends FileReader {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Constructor
    PlainText(File fileObj) throws FileNotFoundException, Exception {
        super(fileObj);
        // Throw an exception if the file extension is not related to this contructor
        if (!FileReader.getFileExtension(super.fileObj).equals("txt"))
            throw new Exception("Invalid file extension.");
    }


    // Display content with reversed lines
    public void reverseLinesContent() {
        ArrayList<String> lines = super.readLines();

        for (int i=0; i < lines.size(); i++) {
            // Display each lines starting at the end of the array "lines"
            System.out.println(lines.get(lines.size()-1-i));
        }
    }


    // Display content with reversed characters and lines
    public void reverseContent() {
        ArrayList<String> lines = super.readLines();

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
    public static void comparePlainTextFiles(PlainText file1, PlainText file2) {
        /**
         * Keep count of differences counting +1 for:
         *  - a different letter within a word
         *  - a whole new word whitin a line
         *  - a whole new line 
         */
        int diff = 0;
        
        // Create two arrays with each lines of each files        
        ArrayList<String> lines1 = file1.readLines();
        ArrayList<String> lines2 = file2.readLines();

        // Make sure that the main file is the longest one
        if (lines2.size() > lines1.size()) {
            ArrayList<String> temp = lines1;
            lines1 = lines2;
            lines2 = temp;
        }

        /**
         * for each line in lines:
         *      create an other array with each words of line
         *      for each word in line:
         *          create an other array with each letters of word
         * 
         * Example of how it works with one iteration of each loop:
         * 
         * lines1 = ["palindrome oui", "ceci n'est pas un palindrome", "kayak"]
         *      words1 = ["palindrome", "oui"]
         *          letters1 = ["p", "a", "l", "i", "n", "d", "r", "o", "m", "e"]
         * 
         * After that we can compare each files and find differences in each level : line, word or letter
         */

        for (int i=0; i < lines1.size(); i++) {
            if (i < lines1.size() && i < lines2.size()) {
                // if lines2[i] exists
                // Create two arrays with each word of each lines  
                String[] words1 = lines1.get(i).split(" ");
                String[] words2 = lines2.get(i).split(" ");

                // Make sure that the main line is the longest one
                if (words2.length > words1.length) {
                    String[] temp = words1;
                    words1 = words2;
                    words2 = temp;
                }
                
                for (int j=0; j < words1.length; j++) {
                    if (j < words1.length && j < words2.length) {
                        // if words2[j] exists
                        // Create two arrays with each letters of each words  
                        String[] letters1 = words1[j].split("");
                        String[] letters2 = words2[j].split("");

                        // Make sure that the main word is the longest one
                        if (letters2.length > letters1.length) {
                            String[] temp = letters1;
                            letters1 = letters2;
                            letters2 = temp;
                        }

                        for (int k=0; k < letters1.length; k++) {
                            if (k < letters1.length && k < letters2.length) {
                                // if letters2[k] exists
                                if (letters1[k].equals(letters2[k])) {
                                    // if two letters are equals display it in green
                                    System.out.print(ANSI_GREEN + letters1[k] + ANSI_RESET);
                                } else {
                                    // else display it in red
                                    System.out.print(ANSI_RED + letters1[k] + ANSI_RESET);
                                    diff++;
                                }
                            } else {
                                // else display the letters[1] in red
                                System.out.print(ANSI_RED + letters1[k] + ANSI_RESET);
                                diff++;
                            }
                        }
                        // End of a word
                        System.out.print(" ");
                    } else {
                        // else display words1[j] in red
                        System.out.print(ANSI_RED + words1[j] + ANSI_RESET);
                        diff++;
                        // End of a word
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                // else display lines1[i] in red
                System.out.print(ANSI_RED+ lines1.get(i) + ANSI_RESET);
                diff++;
                // End of a line
                System.out.println();
            }
        }
        System.out.println("Number of differences : " + diff);
    }
}