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
        if(this.deck.size() > 0){
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
}