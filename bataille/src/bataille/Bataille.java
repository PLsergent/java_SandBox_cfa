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
        ArrayList<Card> mainDeck = new ArrayList<Card>();
        for (String i : Card.colors){
            for (String j : Card.values){
                mainDeck.add(new Card(i, j));
            }
        }

        // and shuffle it
        Collections.shuffle(mainDeck);

        // Give cards to player to have two seperates decks
        for (Card i : mainDeck){
            if (mainDeck.indexOf(i) < 26) {
                player1.addCard(i);
            }else{
                player2.addCard(i);
            }
        }

        // Variable to count number of even duels
        int numberOfEven = 0;

        // Start playing : for each cards of players deck
        for (int i = 0; i < 26; i++){

            // Each player draw a card
            Card player1Card = player1.drawCard();
            Card player2Card = player2.drawCard();

            // They compare both cards
            int cardCompare = player1Card.whoWinDuel(player2Card);

            // Give points to the winner of the duel
            if (cardCompare == 1){
                player1.hasWinDuel();
            }else if (cardCompare == 0){
                player2.hasWinDuel();
            }else{
                numberOfEven++;
            }
        }

        // Display result
        System.out.println("Player 1 : " + player1.getPoints());
        System.out.println("Player 2 : " + player2.getPoints());
        System.out.println("Number of even duel : " + numberOfEven);

        String winner;
        if (player1.getPoints() > player2.getPoints()){
            winner = "player1";
        }else if (player1.getPoints() == player2.getPoints()){
            winner = "Tie Game";
        }else{
            winner = "player2";
        }
        System.out.println("Winner is : " + winner);
    }
}