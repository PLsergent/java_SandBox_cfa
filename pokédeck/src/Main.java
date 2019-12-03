import back.*;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws Exception {
        System.out.println("============Pokédeck============");
        Collection collection = Collection.getInstance();

        Card card = new Pokemon();
        collection.addToCollection(card);
    }
}