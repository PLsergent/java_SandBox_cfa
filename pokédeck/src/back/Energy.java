package back;


public class Energy extends Card {
    
    public Energy(String cardType, String cardName, String type) throws Exception {
        super(cardType, cardName, type);
    }

    Long getCardNumber() {
        return null;
    }

    public String getExpansionName() {
        return "Base";
    }
}