package back;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Collection {

    final String DATAPATH = "src/back/data.json";

    ArrayList<Card> cards;

    private Collection(){ this.cards = new ArrayList<Card>(); }

    private static Collection INSTANCE = null;

    public static synchronized Collection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Collection();
            INSTANCE.getData();
        }
        return INSTANCE;
    }

    public ArrayList<Card> getCards() { return this.cards; }

    // Get data from Json file
    public void getData() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(DATAPATH)) {
            // Read JSON file
            JSONArray array  = (JSONArray) parser.parse(reader);

            for (Object item : array) {
                JSONObject currentObj = (JSONObject) item;

                if (currentObj.get("cardType").toString().toLowerCase().equals("pokémon")) {

                    // Handle previous and next evolution pokemon object
                    Card previousEvol = null;
                    Card nextEvol = null;

                    for (Card c : this.cards) {
                        if (currentObj.get("previousEvol") == null) {
                            previousEvol = new Pokemon();
                        } else if (c.getCardName().toLowerCase().equals(currentObj.get("previousEvol").toString().toLowerCase())) {
                            previousEvol = c;
                        }

                        if (currentObj.get("nextEvol") == null ) {
                            nextEvol = new Pokemon();
                        } else if (c.getCardName().toLowerCase().equals(currentObj.get("nextEvol").toString().toLowerCase())) {
                            nextEvol = c;
                        }
                    }

                    // Handle spells
                    JSONArray arraySpell = (JSONArray) currentObj.get("spells");
                    ArrayList<Spell> spellArrayList = new ArrayList<Spell>();

                    for (Object o : arraySpell) {
                        JSONObject spell = (JSONObject) o;
                        JSONArray arrayEnergy = (JSONArray) spell.get("energyNeeded");
                        ArrayList<Energy> energiesList = new ArrayList<Energy>();

                        for (Object value : arrayEnergy) {
                            JSONObject attribut = (JSONObject) value;
                            energiesList.add(new Energy(attribut.get("cardType").toString(), attribut.get("cardName").toString(), attribut.get("type").toString()));
                        }
                        Energy[] energies = energiesList.toArray(new Energy[0]);
                        spellArrayList.add(new Spell(spell.get("name").toString(), energies, spell.get("damage").toString(), spell.get("description").toString()));
                    }

                    // Create current card
                    Card card = new Pokemon(currentObj.get("cardType").toString(), currentObj.get("cardName").toString(), currentObj.get("type").toString(),
                            (Long) currentObj.get("HP"), (Long) currentObj.get("stage"), (Pokemon) previousEvol, (Pokemon) nextEvol, (Long) currentObj.get("cardNumber"),
                            currentObj.get("expansionName").toString(), spellArrayList);

                    // Add card to the collection
                    this.cards.add(card);

                } else if (currentObj.get("cardType").toString().toLowerCase().equals("trainer")) {

                    Card card = new Trainer(currentObj.get("cardType").toString(), currentObj.get("cardName").toString(), currentObj.get("type").toString(),
                            currentObj.get("description").toString(), currentObj.get("trainerRule").toString(), (Long) currentObj.get("cardNumber"),
                            currentObj.get("expansionName").toString());
                    this.cards.add(card);
                } else if (currentObj.get("cardType").toString().toLowerCase().equals("energy")){

                    Card card = new Energy(currentObj.get("cardType").toString(), currentObj.get("cardName").toString(), currentObj.get("type").toString());
                    this.cards.add(card);
                } else if (!currentObj.get("cardType").toString().equals("None")){
                    throw new Exception("Error in data.json parsing!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add a card to the collection and save it to data.json
    @SuppressWarnings("unchecked")
    public void addToCollection(Card card) {
        try {
            // Read data.json
            File file = new File(DATAPATH);
            FileReader reader = new FileReader(file);
            // Parse to json
            JSONParser parser = new JSONParser();
            JSONArray array  = (JSONArray) parser.parse(reader);
            // Close the reader
            reader.close();

            // Get all the fields and values from the card
            HashMap<String, Object> fields = card.getFieldsValues();
            // New object that we are going to append to the array
            JSONObject newObj = new JSONObject();
            for (Map.Entry<String, Object> entry : fields.entrySet()) {
                newObj.put(entry.getKey(), entry.getValue());
            }

            // Add the newObject to the JsonArray
            array.add(newObj);
            // Create writer, and parse the array using org.com.JSONArray to have the pretty display
            BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            org.json.JSONArray json = new org.json.JSONArray(array.toJSONString());
            bufferWriter.write(json.toString(4));
            bufferWriter.close();

            this.cards.add(card);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}