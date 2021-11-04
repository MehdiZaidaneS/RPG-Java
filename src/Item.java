public class Item {
    String name;
    int amount;

    public Item(String n, int a){
        this.name = n;
        this.amount = a;
    }

    public String getName(){
        return name;
    }



    @Override
    public String toString(){
        return name;
}
}
