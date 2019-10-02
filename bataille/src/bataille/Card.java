package bataille;

import java.util.*;

/**
 * Card
 */
public class Card{
    public static final ArrayList<String> colors = new ArrayList<String>(Arrays.asList(new String[]{"coeur", "trefle", "carreau", "pique"}));
    public static final ArrayList<String> values = new ArrayList<String>(Arrays.asList(new String[]{"as", "roi", "dame", "valet", "dix", "neuf", "huit", "sept", "six", "cinq", "quatre", "trois", "deux"}));
    private String color;
    private String value;
    
    // ==== Constructors ====

    Card(){
        this.color = "";
        this.value = "";
    }

    Card(String color, String value){
        this.color = color;
        this.value = value;
    }

    // ==== Getters ==== 

    public String getCard() {
        return value + " de " + color;
    }

    public String getValue() {
        return this.value;
    }

    public String getColor() {
        return this.color;
    }

    // ==== Setter ====

    public void setCard(String new_color, String new_value){
        this.color = new_color;
        this.value = new_value;
    }

    // ==== Useful methods to know who win a duel ====

    public int whoWinDuel(Card card_adv){
        int value1 = values.indexOf(this.value);
        int value2 = values.indexOf(card_adv.getValue());
        if(value1 < value2){
            return 1;
        }else{
            if(value1 == value2){
                return 2;
            }else{
                return 0;
            }
        }
    }
}