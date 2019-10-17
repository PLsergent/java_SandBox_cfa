package arraylist;


public class ArrayListCustom<Type> {

    private Node<Type> firstNode;
    private Node<Type> lastNode;
    private int size = 0;

    private class Node<Type> {

        private Type data;
        private Node<Type> nextNode;

        Node (Type data, Node<Type> nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }
    }

    ArrayListCustom(){
        this.firstNode = null;
        this.lastNode = firstNode;
        this.size = 0;
    }


    public boolean add(Type e) {
        if (this.firstNode == null){
            this.firstNode = new Node<Type>(e, null);
            this.lastNode = this.firstNode;
            size++;
            return true;
        } else {
            Node<Type> newNode = new Node<Type>(e, null);
            this.lastNode.nextNode = newNode;
            this.lastNode = newNode;
            size++;
            return true;
        }
    }

    public int size(){
        return this.size;
    }

    public Type get(int index){
        int i = 0;
        Node<Type> currentNode = this.firstNode;

        while (true) {
            if (index == i) {
                return currentNode.data;
            } else if (currentNode.nextNode == null) {
                System.out.println("Out of array;");
                return null;
            } else {
                currentNode = currentNode.nextNode;
                i ++;
            }
        }
    }
}