package back;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;


public class Pokemon extends Card {
    Long HP;
    Long stage;
    Pokemon previousEvol;
    Pokemon nextEvol;
    Long cardNumber;
    String expansionName;
    ArrayList<Spell> spells;

    public Pokemon() {
        super("Pokémon", "Fire");
        this.HP = 0L;
        this.stage = 0L;
        this.previousEvol = null;
        this.nextEvol = null;
        this.cardNumber = 0L;
        this.expansionName = "None";
        this.spells = new ArrayList<>();
    }

    public Pokemon(String cardType, String cardName, String type,
            Long HP, Long stage, Pokemon previousEvol, Pokemon nextEvol,
            Long cardNumber, String expansionName, ArrayList<Spell> spells) throws Exception {
        super(cardType, cardName, type);
        this.HP = HP;
        this.stage = stage;
        this.previousEvol = previousEvol;
        this.nextEvol = nextEvol;
        this.cardNumber = cardNumber;
        this.expansionName = expansionName;
        this.spells = spells;
    }

    public Long getHP() {
        return HP;
    }

    public Long getStage() {
        return stage;
    }

    public Pokemon getPreviousEvol() {
        return previousEvol;
    }

    public Pokemon getNextEvol() {
        return nextEvol;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public String toString() {
        return "Pokemon{" +
                "HP=" + HP +
                ", stage=" + stage +
                ", previousEvol=" + previousEvol +
                ", nextEvol=" + nextEvol +
                ", cardNumber=" + cardNumber +
                ", expansionName='" + expansionName + '\'' +
                ", spells=" + spells +
                '}';
    }
}