public class Enemy {
    String name;
    int hp, attack;

    public Enemy(String n, int h, int a){
        this.name = n;
        this.hp = h;
        this.attack = a;
    }
// basic getter and setter for enemy class
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getHp() {
        return hp;
    }
    public void setHp(int health) {
        this.hp = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }


@Override
    public String toString(){
        return "Name: " + name + "\nHealth: " + hp + "\nAttack: " + attack ;
}


}
