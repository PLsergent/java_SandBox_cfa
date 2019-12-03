package back;


public class Trainer extends Card {
    String description;
    String trainerRule;
    Long cardNumber;
    String expansionName;

    Trainer(String cardType, String cardName, String type, String description, String trainerRule,
            Long cardNumber, String expansionName) throws Exception {
        super(cardType, cardName, type);
        this.description = description;
        this.trainerRule = trainerRule;
        this.cardNumber = cardNumber;
        this.expansionName = expansionName;
    }

    public String getDescription() {
        return description;
    }

    public String getTrainerRule() {
        return trainerRule;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public String toString() {
        return "Trainer{" +
                "description='" + description + '\'' +
                ", trainerRule='" + trainerRule + '\'' +
                '}';
    }
}