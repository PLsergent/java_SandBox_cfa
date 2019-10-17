package arraylist;


public class ArrayListMain {

    public static void main (String[] args) {
        ArrayListCustom<String> listString = new ArrayListCustom<String>();

        listString.add("Salut");
        listString.add("Ca va ?");

        System.out.println(listString.get(1));
    }
}