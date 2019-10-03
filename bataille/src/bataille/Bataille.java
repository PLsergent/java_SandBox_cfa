package bataille;

import java.util.*;

/**
 * Bataille
 */
public class Bataille {

    public static void main(String[] args) {
        // Create two players
        Player player1 = new Player();
        Player player2 = new Player();

        // Create main deck
        ArrayList<Card> mainDeck = Card.createMainDeck();

        // and shuffle it
        Collections.shuffle(mainDeck);

        // Give cards to player to have two seperates decks
        Player.createPlayersDeck(mainDeck, player1, player2);

        // Start playing : for each cards of players deck
        int numberOfEven = Player.play(player1, player2);

        // Display result
        Player.gameResult(player1, player2, numberOfEven);
    }
}