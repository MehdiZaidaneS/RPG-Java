import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Character {
    Random r = new Random();
    String name;
    int age, hp;
    int attack = r.nextInt(80)+1;
    ArrayList<Item> inventory = new ArrayList<>();

public Character(String n, int a, int h){
    this.name = n;
    this.age = a;
    this.hp = h;
}

//getter and setter
public String getName() {
        return name;
    }
public void setName(String newName){
    this.name = newName;

}
public void setAge(int newAge){
    this.age = newAge;
}


// All character actions
public void addItem(ArrayList<Item> items) {
    System.out.println("You have added the item to the inventory.");
    for (int i=0; i<items.size(); i++){
        inventory.add(items.get(i));
    }
    for (int i=0; i<items.size(); i++){
        items.remove(i);
    }

}
public void watchArea(ArrayList<Item> items, ArrayList<Enemy> enemy) {
    if (items.size() == 1) {
        System.out.println("You are inspecting the area...");
        System.out.println("You found a " + items.get(0).getName() + ". Do you want to (Pick item)?. There is a " + enemy.get(0).name + " nearby. ");
    } else{
        System.out.println("You are inspecting the area...");
        System.out.println("You found a " + items.get(0).getName() + " and a " + items.get(1).getName() + ". Do you want to (Pick item)?. There is a " + enemy.get(0).name + " near. ");
    }
}
public void removeItem(Item item){
        System.out.println( item.getName() + " was removed from the inventory.");
        inventory.remove(item);
}
public void inventory(){
    System.out.println("Inventory: " + inventory);
}
public void walk(){
    System.out.println("You are walking...");
}
public void sleep(){
    System.out.println(name + " is sleeping...");
    hp +=50;
    System.out.println("The hp of " + name + " now is " + hp + ".");
}
public void eat(Item item){
        System.out.println("You ate a " + item.name + " you have restored 10 hp");
        hp +=10;
        System.out.println(name + " hp now is " + hp);
        inventory.remove(item);
    }
    public void swim(Area area){
        System.out.println(name + " is swimming.");
        hp +=10;
        System.out.println("You restored 10 hp with the swim. ");
    }
    public void makeFire(){
        System.out.println("You are making the fire...");
        hp +=20;
        System.out.println("Congratulations you made the fire!\nYou restored 20 hp with the fire!");
    }

    // All the fighting methods
    public void attack(ArrayList<Enemy> enemy){
        enemy.get(0).hp = enemy.get(0).hp - attack;

    }
    public void useSlingshot(ArrayList<Enemy> enemy ){
        enemy.get(0).hp-= 10;
        if (enemy.get(0).hp>0) {
            System.out.println("You have used the Slingshot " + "...The hp of " + enemy.get(0).name + " is " + enemy.get(0).hp);
        } else {
            System.out.println("You have used the Slingshot " +  "...The hp of " + enemy.get(0).name + " is 0.");
        }
    }
    public void useKnife(ArrayList<Enemy> enemy){
        enemy.get(0).hp-= 40;
        if (enemy.get(0).hp>0) {
            System.out.println("You have stubbed " + enemy.get(0).name + "...The hp of " + enemy.get(0).name + " is " + enemy.get(0).hp);
        } else {
            System.out.println("You have stubbed " + enemy.get(0).name + "...The hp of " + enemy.get(0).name + " is 0.");
        }
    }
    public void useGun(Item item, Enemy enemy){
        System.out.println("You have shot with the " + item.name + "." );
        enemy.hp-=200;
        if( enemy.hp >0) {
            System.out.println(enemy.name + " hp is now " + enemy.hp);
        } else {
            System.out.println(enemy.name + " hp is now 0." );
        }

    }
    public void useGrenade(Item item, Enemy enemy){
        System.out.println("You are using the " + item.name );
        enemy.hp-=150;
        if( enemy.hp >0) {
            System.out.println(enemy.name + " hp is now " + enemy.hp);
            inventory.remove(item);
        } else {
            System.out.println(enemy.name + " hp is now 0." );
        }

    }
public void usePotion(Item item){
    System.out.println("You are using " + item.name + "...");
    hp+=50;
    System.out.println("Your hp now is " + hp);

}



@Override
    public String toString(){
    return "Name: " + name + "\nAge: " + age + "\nHP: " + hp;
}


}


