package arraylist;


public class ArrayList<Type> {

    private Type[] data;
    private int size = 0;

    ArrayList(){
        data = new Type[10];
    }

    public boolean add(Type[] e) {
        if (Type[Object.lenght-1] != null){
            return false;
        }
        for (Type o : this.data){
            if (o == null){
                o = e;
                return true;
            }
        }
    }

    public int size(){
        for (Type o : this.data){
            if (o == null){
                return this.size;
            } else {
                size++;
            }
        }
    }

    public Type[] get(int index){
        if (Type[index] != null) {
            return Type[index];
        } else {
            
        }
    }
}