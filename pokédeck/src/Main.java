import back.*;
import front.Menu;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) throws Exception {
        System.out.println("============Pokédeck============");
        Collection collection = Collection.getInstance();

        new Menu();
    }
}