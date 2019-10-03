package bataille;

import java.util.*;

/**
 * Player
 */
public class Player{
    private ArrayList<Card> deck;
    private int points;

    // ==== Constructors ====

    Player(){
        this.deck = new ArrayList<Card>();
        this.points = 0;
    }

    Player(ArrayList<Card> deck, int points){
        this.deck = deck;
        this.points = points;
    }

    // ==== Getters ====

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public int getPoints(){
        return this.points;
    }

    // ==== Useful methods ====

    // Add card to deck
    public void addCard(Card card){
        this.deck.add(card);
    }

    // Draw a card during a game
    public Card drawCard(){
        if (this.deck.size() > 0){
            Card card = this.deck.get(deck.size() - 1);
            this.deck.remove(deck.size() - 1);
            return card;
        }else{
            System.out.println("No more cards.");
            return null;
        }
    }

    // Give points when winning a duel
    public void hasWinDuel(){
        this.points += 2;
    }

    // Create players deck
    public static void createPlayersDeck(ArrayList<Card> mainDeck, Player player1, Player player2){
        for (Card i : mainDeck){
            if (mainDeck.indexOf(i) < 26) {
                player1.addCard(i);
            }else{
                player2.addCard(i);
            }
        }
    }

    // Playing method
    public static int play(Player player1, Player player2){
        // Number of even duels
        int numberOfEven = 0;
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
        return numberOfEven;
    }

    // Display game result
    public static void gameResult(Player player1, Player player2, int numberOfEven) {
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