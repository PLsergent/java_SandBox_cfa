package rpg_pixel_game;
import java.util.Scanner;


public class PlayMain {
    
    public static void main(String[] args) {
        System.out.println("============START GAME============");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a character name: ");
        String char_name = reader.nextLine(); // Scans the next token of the input as an int.
        reader.close();

        System.out.println(char_name);

    }
}