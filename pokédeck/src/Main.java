import back.*;
import front.Home;

public class Main {
    public static void main (String[] args) throws Exception {
        System.out.println("============Pokédeck============");
        Collection collection = Collection.getInstance();

        new Home();
    }
}