package back;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class Card {

    private final static String[] possibleCardType = { "pokémon", "trainer", "energy" };
    List<String> possibleCardTypeList = Arrays.asList(possibleCardType);

    private final static String[] possibleTypeEnrgPok = { 
        "colorless", "darkness", "dragon", "fairy", "fighting", "fire", "grass", "lightning", "metal", "psychic", "water"
    };
    List<String> possibleTypeEnrgPokList = Arrays.asList(possibleTypeEnrgPok);

    private final static String[] possibleTypeTrainer = {
        "item", "stadium", "pokémon tool", "supporter", "technical machine", "ace spec", "rocket's secret machine", "goldenrod game corner"
    };
    List<String> possibleTypeTrainerList = Arrays.asList(possibleTypeTrainer);

    protected String cardType; // pokemon, trainer, energy
    protected String cardName; // for energy cards 'energy fire'
    protected String type; // pokemon type (fire, water, ...), trainer type (item, ...) and energy type (fire, water, ...)

    Card() {
        this.cardType = "None";
        this.cardName = "None";
        this.type = "None";
    }

    Card(String cardType, String cardName, String type) throws Exception {
        this.cardType = cardType;
        this.cardName = cardName;
        this.type = type;

        // Throw an exception if any attributes doesn't match provided arrays 
        if (!possibleCardTypeList.contains(cardType.toLowerCase())) {
            throw new Exception("Invalid card type.");
        } else if (cardType.toLowerCase().equals("pokémon") && !(possibleTypeEnrgPokList.contains(type.toLowerCase()))) {
            throw new Exception("Invalid type.");
        } else if (cardType.toLowerCase().equals("trainer") && !(possibleTypeTrainerList.contains(type.toLowerCase()))) {
            throw new Exception("Invalid type.");
        } else if (cardType.toLowerCase().equals("energy")) {
            this.cardName = this.capitalize(type) + " " + cardType.toLowerCase();
        }
    }

    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public String getType() {
        return type;
    }


    public String toString() {
        return "Card{" +
                "cardType='" + cardType + '\'' +
                ", cardName='" + cardName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


    // Method to get all the fields and values from the current object.
    // Return a HashMap<fieldName, value>
    public HashMap<String, Object> getFieldsValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Get fields from super class and current class (pokémon, trainer, energy)
        String[] superFields = {"cardType", "cardName", "type"};
        Field[] fields = this.getClass().getDeclaredFields();
        // Create the return variable
        HashMap<String, Object> mapFields = new HashMap<>();

        // For each fields we are going to add both the field name and the value corresponding to the map
        // To get the values we are using getDeclareMethod using the field name to then invoke a getter method
        for (String field : superFields) {
            Method method = Card.class.getDeclaredMethod("get" + this.capitalize(field));
            mapFields.put(field, method.invoke(this));
        }

        for (Field f : fields) {
            String[] field = f.toString().split(" ");
            String[] fieldArray = field[1].split("\\.");
            String fieldName = fieldArray[fieldArray.length-1];

            Method method = this.getClass().getDeclaredMethod("get" + this.capitalize(fieldName));
            mapFields.put(fieldName, method.invoke(this));
        }

        return mapFields;
    }
}