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
    // Two params : the two cards that have been won
    // The winner of each duels takes both cards and put them under his deck
    public void hasWinDuel(Card card1, Card card2){
        this.deck.add(0, card1);
        this.deck.add(0, card2);
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

        while (true){

            // Stop playing if one of the two players has no more cards
            if (player1.getDeck().size() == 0 || player2.getDeck().size() == 0){
                return numberOfEven;
            }

            // Each player draw a card
            Card player1Card = player1.drawCard();
            Card player2Card = player2.drawCard();

            System.out.println("1 : " + player1Card.getColor() + " " + player1Card.getValue());
            System.out.println("2 : " + player2Card.getColor() + " " + player2Card.getValue());

            // We compare both cards
            int cardCompare = player1Card.whoWinDuel(player2Card);

            // Give points to the winner of the duel
            if (cardCompare == 1){
                System.out.println("Player 1 win duel");
                player1.hasWinDuel(player1Card, player2Card);
            }else if (cardCompare == 0){
                System.out.println("Player 2 win duel");
                player2.hasWinDuel(player1Card, player2Card);
            }else{
                // If the duel is even we put back both cards under their deck
                System.out.println("Draw!");
                player1.getDeck().add(0, player1Card);
                player2.getDeck().add(0, player2Card);
                numberOfEven++;
            }

            System.out.println("=================");

            // Stop playing if one of the two players reach 1000 points
            if (player1.getPoints() > 1000 || player2.getPoints() > 1000){
                return numberOfEven;
            }
        }
    }

    // Display game result
    public static void gameResult(Player player1, Player player2, int numberOfEven) {
        // Display number of cards within each decks
        System.out.println("Deck 1 : " + player1.getDeck().size() + " cards");
        System.out.println("Deck 2 : " + player2.getDeck().size() + " cards");

        // Display points
        System.out.println("Player 1 : " + player1.getPoints() + " points");
        System.out.println("Player 2 : " + player2.getPoints() + " points");
        System.out.println("Number of even duel : " + numberOfEven);

        // Display winner
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