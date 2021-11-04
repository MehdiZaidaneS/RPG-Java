import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

    public class Game {
        Random r = new Random();
        boolean fighting = true;
        Scanner sc = new Scanner(System.in);
        Character gameCharacter = new Character("empty", 0, 500);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Item> itemsToGet = new ArrayList<>();
        ArrayList<Enemy> enemyToFight = new ArrayList<>();
        Area areaGame = new Area();
        Enemy enemyGame = new Enemy("", 0, 0);
        Enemy vampire = new Enemy("Vampire", 0, 0);
        Enemy mystery = new Enemy("Mystery Man", 0, 0);
        Enemy dragon = new Enemy("Dragon", 0, 0);
        Item knife = new Item("Knife", 1);
        Item potion = new Item("Potion", 1);
        Item slingshot = new Item("Slingshot", 1);
        Item pear = new Item("Pear", 1);
        Item shovel = new Item("Shovel", 1);
        Item key = new Item("Key", 1);
        Item trash = new Item("Trash", 5);
        Item map = new Item("Map", 1);
        Item gun = new Item("Sniper", 1);
        Item explosion = new Item("Grenade", 1);
        Item apple = new Item("Magic Apple", 1);

        public Game() {
        }

        public void startGame() {
            setName();
            setAge();
            System.out.println("Character stats: \n" + gameCharacter.toString());
            System.out.println("");
            setLevel();
            System.out.println("Welcome to the Action Game!\nYou just lost your family, you have to find them and save them from the person who kidnapped them.!");
            System.out.println("");
            stageOne();
            stageTwo();
            stageThree();
            System.out.println("Congratulations you have successfully completed all the stages and you have saved your family.");
        } //All the logical structure of the game

        //game stages:
        public void setName() {
            System.out.println("Welcome!\nEnter a name for your character:");
            String characterName = sc.nextLine();
            gameCharacter.setName(characterName);
        } //to set the name of character
        public void setAge() {
            System.out.println("Set age of character:");
            int age = sc.nextInt();
            sc.nextLine();
            gameCharacter.setAge(age);
            if (age < 18) {
                System.out.println("You cannot not play, you have to be an adult!");
                setAge();
            } else if (age >= 75) {
                System.out.println("You are too old to live this experience!");
                setAge();
            }
        }  // to set the age of character
        public void setLevel() {
            System.out.println("Set level: \nType: Easy, Medium or Hard.");
            String level = sc.nextLine();
            switch (level) {
                case "Easy":
                    System.out.println("You selected Easy Mode!");
                    enemyGame.setAttack(10);
                    enemyGame.setHp(55);
                    vampire.setAttack(18);
                    vampire.setHp(80);
                    mystery.setHp(600);
                    mystery.setAttack(50);
                    System.out.println("");
                    break;
                case "Medium":
                    System.out.println("You selected Medium Mode!");
                    enemyGame.setAttack(13);
                    enemyGame.setHp(65);
                    vampire.setAttack(24);
                    vampire.setHp(90);
                    mystery.setHp(800);
                    mystery.setAttack(75);
                    System.out.println("");
                    break;
                case "Hard":
                    System.out.println("You selected Hard Mode!");
                    enemyGame.setAttack(20);
                    enemyGame.setHp(100);
                    vampire.setAttack(30);
                    vampire.setHp(150);
                    mystery.setHp(1500);
                    mystery.setAttack(100);
                    System.out.println("");
                    break;
                default:
                    System.out.println("--------------------Enter a valid number!-------------------");
                    setLevel();
            }
        }// to set the level of game
        public void stageOne() {
            list.add("Jump");//Adding to the list the movements of the character depending on where he is. The list will be printed when you type Hint
            list.add("Sing");
            list.add("Sit");
            list.add("Little walk");
            enemyToFight.add(enemyGame);
            areaGame.setDescription("You are in the middle of a large jungle with creatures and all kinds of plants.");
            areaGame.setName("Jungle");//Setting area of game
            enemyGame.setName("Zombie"); // Setting stage enemy
            itemsToGet.add(knife);
            System.out.println("You have appeared in: " + areaGame.toString() + "\n(Inspect area) to find the hidden secrets of the " + areaGame.getName() + ".");
            list.add("Inspect area");
            list.add("See inventory");
            action();
            list.add("Pick item");
            list.remove("Inspect area");
            action();
            list.remove("Pick item");
            System.out.println("You will need to fight the " + enemyGame.getName() + " to move forward.");
            list.add("Use knife");
            list.add("Attack");
            list.remove("Jump");
            list.remove("Sing");
            list.remove("Sit");
            list.remove("Little walk");
            fight(enemyGame);
            list.remove("Attack");
            list.remove("Use knife");
            list.add("Jump");
            list.add("Sing");
            list.add("Sit");
            list.add("Little walk");
            System.out.println("Now (Sleep) or (Eat pear) to heal yourself.");
            list.add("Sleep");
            list.add("Eat pear");
            action();
            System.out.println("");
            System.out.println("STAGE ONE MISSION:");
            System.out.println("Your dog is in a big danger you need to rescue him immediately.\nIf you want to save him you need to guess this question:");
            stageOneMission();
            System.out.println("");
            System.out.println("Now (Walk) straight forward for the next stage!");
            list.add("Walk");
            list.remove("Sleep");
            list.remove("Eat pear");
            action();
        } // Stage one story and missions
        public void stageTwo() {
            fighting = true;
            enemyToFight.remove(enemyGame);
            enemyToFight.add(vampire);
            areaGame.setName("Beach");
            areaGame.setDescription("Big blue sea with sharks and crocodiles.");
            itemsToGet.add(potion);
            itemsToGet.add(slingshot);
            System.out.println("Your location now is: " + areaGame.toString() + "\n(Inspect area) to find the hidden secrets of the " + areaGame.getName() + ".");
            list.remove("Walk");
            list.add("Inspect area");
            action();
            list.add("Pick item");
            list.remove("Inspect area");
            action();
            list.remove("Pick item");
            itemsToGet.remove(potion);
            itemsToGet.remove(slingshot);
            System.out.println("");
            System.out.println("You will need to fight the " + vampire.getName() + " to move forward.");
            list.add("Attack");
            list.add("Use slingshot");
            list.add("Use knife");
            list.remove("Jump");
            list.remove("Sing");
            list.remove("Sit");
            list.remove("Little walk");
            fight(vampire);
            list.remove("Use knife");
            list.remove("Attack");
            list.remove("Use slingshot");
            list.add("Jump");
            list.add("Sing");
            list.add("Sit");
            list.add("Little walk");
            System.out.println("Now (Sleep) or (Eat pear) to heal yourself.");
            list.add("Sleep");
            list.add("Eat pear");
            action();
            list.remove("Sleep");
            list.remove("Eat pear");
            list.add("Pick up wooden sticks");
            list.add("Make fire");
            makeFireMission();
            list.remove("Pick up wooden sticks");
            list.remove("Make fire");
            System.out.println("");
            System.out.println("STAGE TWO MISSION:");
            System.out.println("Your son is in a big danger you need to rescue him immediately.\nIf you want to save him you need to find the Pirate treasure chest");
            stageTwoMission();
            System.out.println("");
            System.out.println("Now (Walk) for the next stage, and good luck for the hardest mission ever!");
            list.add("Walk");
            action();
        } // Stage two of the story with different area, items, enemy etc
        public void stageThree() {
            fighting = true;
            enemyToFight.remove(vampire);
            enemyToFight.add(dragon);
            areaGame.setName("City");
            areaGame.setDescription("First floor of a big building.");
            itemsToGet.add(explosion);
            itemsToGet.add(gun);
            System.out.println("Welcome to Stage Three!");
            System.out.println("You are now in: " + areaGame.toString() + "\n(Inspect area) to find the hidden secrets of the " + areaGame.getName() + ".");
            list.remove("Walk");
            list.add("Inspect area");
            action();
            list.remove("Inspect area");
            list.add("Pick item");
            action();
            enemyToFight.remove(dragon);
            System.out.println("There is a bar nearby, (Visit bar) so you can have a drink with your old friend.");
            list.add("Visit bar");
            list.remove("Pick item");
            action();
            list.remove("Visit bar");
            System.out.println("(Talk with friend) to have a conversation with your friend.");
            list.add("Talk with friend");
            action();
            list.remove("Talk with friend");
            System.out.println("");
            stageThreeMission();
        } // Stage three of the story with different area, items, enemy etc




        public void action() {
            System.out.println("What action would you like to do? Type (Hint) for help.");
            String movement = sc.nextLine();
            switch (movement) {
                case "Hint":
                    System.out.println(list);
                    action();
                    break;
                case "Jump":
                    System.out.println(gameCharacter.getName() + " is jumping.");
                    action();
                    break;
                case "Sing":
                    System.out.println(gameCharacter.getName() + " is singing.");
                    action();
                    break;
                case "Sit":
                    System.out.println(gameCharacter.getName() + " is sitting.");
                    action();
                    break;
                case "Little walk":
                    System.out.println(gameCharacter.getName() + " is walking.");
                    action();
                    break;
                case "Use magic apple":
                    System.out.println(gameCharacter.getName() + " used magic apple to save his brother, so he is back to life again.");
                    break;
                case "Use gun":
                    gameCharacter.useGun(gun, mystery);
                    break;
                case "Use grenade":
                    if (explosion.amount > 0) {
                        gameCharacter.useGrenade(explosion, mystery);
                        explosion.amount -= 1;
                        list.remove("Use grenade");
                    } else {
                        System.out.println("You have no more grenades.");
                        list.remove("Use grenade");
                    }
                    break;
                case "Use slingshot":
                    if (areaGame.name.equals("Beach")) {
                        gameCharacter.useSlingshot(enemyToFight);
                    } else
                        System.out.println("There are no stones nearby.");
                    break;

                case "Knock door":
                    System.out.println(gameCharacter.getName() + " is knocking the door.");
                    break;
                case "Go room 119":
                    System.out.println(gameCharacter.getName() + " he is now in front of Room 119");
                    break;
                case "Take taxi":
                    System.out.println(gameCharacter.getName() + " you are in taxi going to Miami Beach Hotel.");
                    break;
                case "Inspect area":
                    gameCharacter.watchArea(itemsToGet, enemyToFight);
                    break;
                case "Walk":
                    gameCharacter.walk();
                    break;
                case "Use potion":
                    if (potion.amount > 0){
                        gameCharacter.usePotion(potion);
                        potion.amount -=1;
                        list.remove("Use potion");
                    } else {
                        System.out.println("You have no more potions.");

                    }

                    break;
                case "Pick item":
                    gameCharacter.addItem(itemsToGet);
                    break;
                case "Add item":
                    gameCharacter.addItem(itemsToGet);
                    break;
                case "Sleep":
                    gameCharacter.sleep();
                    break;
                case "Use knife":
                    gameCharacter.useKnife(enemyToFight);
                    break;
                case "See inventory":
                    gameCharacter.inventory();
                    action();
                    break;
                case "Eat pear":
                    gameCharacter.eat(pear);
                    itemsToGet.remove(pear);
                    break;
                case "Attack":
                    gameCharacter.attack(enemyToFight);
                    if (enemyToFight.get(0).hp > 1) {
                        System.out.println(enemyToFight.get(0).name + " hp is now " + enemyToFight.get(0).hp);
                    } else {
                        System.out.println(enemyToFight.get(0).name + " hp is 0.\nYou have defeated the " + enemyToFight.get(0).name);
                    }
                    break;
                case "Pick up wooden sticks":
                    System.out.println(gameCharacter.getName() + " is picking up wooden sticks.");
                    break;
                case "Swim":
                    if (areaGame.getName().equals("Beach")) {
                        gameCharacter.swim(areaGame);
                    } else {
                        System.out.println("You cannot swim here, you are in wrong place.");
                        action();
                    }
                    break;
                case "Make fire":
                    gameCharacter.makeFire();
                    break;

                case "Pick trash":
                    if (trash.amount == 0) {
                        System.out.println("There is no more trash.");
                    } else if (trash.amount == 1) {
                        System.out.println("There is " + trash.amount + " garbage left in one different place. Type (Pick trash) to pick them.");
                        trash.amount = trash.amount - 1;
                        action();
                    } else {
                        System.out.println("There are " + trash.amount + " garbage left in different places. Type (Pick trash) to pick them.");
                        trash.amount = trash.amount - 1;
                        action();
                    }
                    break;
                case "Read map":
                    System.out.println("Is reading the map, " + gameCharacter.getName() + " found the exact location.");
                    break;
                case "Dig":
                    System.out.println(gameCharacter.getName() + " is digging with shovel.");
                    break;
                case "Open chest":
                    System.out.println(gameCharacter.getName() + " is opening the chest.");
                    break;
                case "Search Mystery Man":
                    System.out.println("You found the Mystery Man and you made trade successfully!");
                    break;
                case "Speak":
                    System.out.println(gameCharacter.getName() + " is speaking...");
                    break;
                case "Visit bar":
                    System.out.println(gameCharacter.getName() + " is now in the bar...");
                    break;
                case "Talk with friend":
                    System.out.println("-" + gameCharacter.getName() + ": Hello hello!. ");
                    System.out.println("-Friend: Hello " + gameCharacter.getName() + " was a long time without seeing you. How are you?");
                    System.out.println("Choose answer:");
                    System.out.println("A= Im fine, thanks.\nB= I cant complain!\nC= Very bad, i have been suffering to save my dog and my son!");
                    String answer = sc.nextLine();
                    switch (answer){
                        case "A":
                            System.out.println("-" + gameCharacter.getName() + ": Im fine, thanks! ");
                            System.out.println("-Friend: I heard you saved your son and your dog...");
                            System.out.println("Choose answer:");
                            System.out.println("A= It wasn't an easy case but thank god i managed.\nB= I had to guess the first president of Finland, luckily im smart!.\nC= I saved a drowning kid to get the Pirate treasure!");
                            String answer2 = sc.nextLine();
                            if (answer2.equals("A")){
                                System.out.println("-" + gameCharacter.getName() + ": It wasn't an easy case but thank god i managed.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer3 = sc.nextLine();
                                if(answer3.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer3.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else if (answer2.equals("B")){
                                System.out.println("-" + gameCharacter.getName() + ": I had to guess the first president of Finland, luckily im smart!.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer3 = sc.nextLine();
                                if(answer3.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer3.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else {
                                System.out.println("-" + gameCharacter.getName() + ": I saved a drowning kid to get the Pirate treasure! ");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer3 = sc.nextLine();
                                if(answer3.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer3.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            }
                            break;
                        case "B":
                            System.out.println("-" + gameCharacter.getName() + ": I cant complain!");
                            System.out.println("-Friend: I heard you saved your son and your dog...");
                            System.out.println("Choose answer:");
                            System.out.println("A= It wasn't an easy case but thank god i managed.\nB= I had to guess the first president of Finland, luckily im smart!.\nC= I saved a drowning kid to get the Pirate treasure!");
                            String answer3 = sc.nextLine();
                            if (answer3.equals("A")){
                                System.out.println("-" + gameCharacter.getName() + ": It wasn't an easy case but thank god i managed.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer6 = sc.nextLine();
                                if(answer6.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer6.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else if (answer3.equals("B")){
                                System.out.println("-" + gameCharacter.getName() + ": I had to guess the first president of Finland, luckily im smart!.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer6 = sc.nextLine();
                                if(answer6.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer6.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else {
                                System.out.println("-" + gameCharacter.getName() + ": I saved a drowning kid to get the Pirate treasure! ");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer6 = sc.nextLine();
                                if(answer6.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer6.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            }
                            break;
                        case "C":
                            System.out.println("-" + gameCharacter.getName() + ": Very bad, i have been suffering to save my dog and my son!");
                            System.out.println("-Friend: I heard you saved your son and your dog...");
                            System.out.println("Choose answer:");
                            System.out.println("A= It wasn't an easy case but thank god i managed.\nB= I had to guess the first president of Finland, luckily im smart!.\nC= I saved a drowning kid to get the Pirate treasure!");
                            String answer4 = sc.nextLine();
                            if (answer4.equals("A")){
                                System.out.println("-" + gameCharacter.getName() + ": It wasn't an easy case but thank god i managed.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer7 = sc.nextLine();
                                if(answer7.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer7.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else if (answer4.equals("B")){
                                System.out.println("-" + gameCharacter.getName() + ": I had to guess the first president of Finland, luckily im smart!.");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer7 = sc.nextLine();
                                if(answer7.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer7.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            } else {
                                System.out.println("-" + gameCharacter.getName() + ": I saved a drowning kid to get the Pirate treasure! ");
                                System.out.println("-Friend: Who did this to you? Do you have a clue?");
                                System.out.println("Choose answer:");
                                System.out.println("A= I have no idea! \nB= It may be karma! \nC= Because I am unlucky!");
                                String answer7 = sc.nextLine();
                                if(answer7.equals("A")){
                                    System.out.println("-" + gameCharacter.getName() + ": I have no idea!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else if (answer7.equals("B")){
                                    System.out.println("-" + gameCharacter.getName() + ": It may be karma!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                } else {
                                    System.out.println("-" + gameCharacter.getName() + ": Because I am unlucky!");
                                    System.out.println("-Friend: Sorry this happened to you, lets have a drink so you can forget this!\n-Friend: So you saved your dog and your son, who is the next one to be saved?");
                                    System.out.println("Choose answer:");
                                    System.out.println("A= My wife! \nB= I have to save my wife but i don't know where my brother is. Maybe i should also look for him! \nC= I don't know!");
                                    String answer9 = sc.nextLine();
                                    if (answer9.equals("A")){
                                        System.out.println("-" + gameCharacter.getName() + ": My wife!");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else if (answer9.equals("B")){
                                        System.out.println("-" + gameCharacter.getName() + ": I have to save my wife but i don't know where my brother is. Maybe i should also look for him! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    } else {
                                        System.out.println("-" + gameCharacter.getName() + ": To be honest i don't know! ");
                                        System.out.println("Friend: Oooh, there is a big job in front of you. Good luck!");
                                        System.out.println("");
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println("--------------------Enter a valid number!-------------------");
                            action();
                    }
                    break;
                default:
                    action();
            }
        } // The action method where all the possible movements and actions that the user can do are included. If you write "Attack", the attack method will be executed.



        // All the big mission of each stages
        public void stageOneMission() {
            System.out.println("Who was the first president of Finland?");
            System.out.println("A= Kaarlo Juho Ståhlberg. \nB= Sauli Niinistö. \nC= Kyösti Kallio.");
            String answer = sc.nextLine();
            if (answer.equals("A") || answer.equals("Kaarlo Juho Ståhlberg")) {
                System.out.println("Congratulations you were right! You were able to save your dog in time!");
            } else if (answer.equals("B") || answer.equals("Sauli Niinistö")) {
                System.out.println("Incorrect, try again!");
                stageOneMission();
            } else {
                System.out.println("Incorrect, try again!");
                stageOneMission();
            }
        }
        public void makeFireMission() {
            System.out.println("Now you have to make the fire, go and (Pick up wooden sticks)! Be careful you might find black mambas.");
            action();
            System.out.println("Now that you have picked the sticks, (Make fire) by rubbing those sticks together!");
            action();


        }
        public void stageTwoMission() {

            System.out.println("Instruction 1:\n -Get shovel: You will need to (Walk) to the coffee shop called Varia and talk with Dani.");
            list.add("Walk");
            action();
            System.out.println("You arrived in Coffee Shop Varia. Now go and (Speak) with Dani.");
            list.remove("Walk");
            list.add("Speak");
            action();
            System.out.println("After a long talk, Dani gave you the " + shovel.getName());
            itemsToGet.add(shovel);
            gameCharacter.addItem(itemsToGet);
            System.out.println("");
            System.out.println("Instruction 2:\n -Get key: A kid is drowning, (Swim) and save him.");
            list.add("Swim");
            list.remove("Speak");
            action();
            System.out.println("You have saved the drowning kid, he gave you the KEY as gift!");
            itemsToGet.add(key);
            gameCharacter.addItem(itemsToGet);
            System.out.println("");
            System.out.println("Instruction :\n -Get map: You will need to (Pick trash) from the beach.");
            list.add("Pick trash");
            list.remove("Swim");
            action();
            itemsToGet.add(map);
            gameCharacter.addItem(itemsToGet);
            System.out.println("");
            System.out.println("You have successfully got all the items, now (Read map) to find the exact location of the chest!");
            list.remove("Pick trash");
            list.add("Read map");
            action();
            gameCharacter.removeItem(map);
            list.remove("Read map");
            System.out.println("Now that you know the location, (Walk) to get there.");
            list.add("Walk");
            action();
            System.out.println(gameCharacter.getName() + " is in the exact location of the treasure chest.");
            list.remove("Walk");
            System.out.println("(Dig) to find the pirate treasure chest!");
            list.add("Dig");
            action();
            gameCharacter.removeItem(shovel);
            list.remove("Dig");
            System.out.println("You found the chest, (Open chest)!");
            list.add("Open chest");
            action();
            gameCharacter.removeItem(key);
            list.remove("Open chest");
            System.out.println("There are a lot of expensive diamonds and gold, (Add item) to add them to inventory.");
            list.add("Add item");
            action();
            System.out.println("");
            System.out.println("Final Instruction:\n-Trade: You need to exchange the pirate treasure chest that you have in order to save your son..");
            System.out.println("(Walk) to the Beach Castle and search for the MYSTERY MAN.");
            list.remove("Add item");
            list.add("Walk");
            action();
            System.out.println("You are now in the Beach Castle. (Search Mystery Man)!");
            list.remove("Walk");
            list.add("Search Mystery Man");
            action();
            list.remove("Search Mystery Man");
            System.out.println("Congratulations you completed the mission so you have saved your lovely son!");


        }
        public void stageThreeMission() {
            enemyToFight.add(mystery);
            System.out.println("Welcome to the final mission!\nIf you want to save your wife and become a family again, you will need to fight the Mystery Man!.\n(Take taxi) to Hotel Miami Beach.");
            list.add("Take taxi");
            action();
            System.out.println("You are now in Hotel Miami Beach reception!");
            System.out.println("-" + gameCharacter.getName() + ": Can you tell me which is the room where Maria Lee is staying?");
            System.out.println("-Receptionist: Sorry i couldn't find any Maria Lee here but i found one name that matches with her last name!");
            System.out.println("-" + gameCharacter.getName() + ": Is it Jani Lee, my brother?");
            System.out.println("-Receptionist: Exactly its him, he is in the Room 119");
            System.out.println("-" + gameCharacter.getName() + ": Okay, thank you!");
            list.remove("Take taxi");
            System.out.println("(Go room 119) to find your brother!");
            list.add("Go room 119");
            action();
            System.out.println("(Knock door) to see your brother!");
            list.add("Knock door");
            list.remove("Go room 119");
            action();
            System.out.println("The Mystery Man opened the door...");
            System.out.println("-" + gameCharacter.getName() + ": Oh you are already here, so you took my wife and my brother, im going to kill you!!");
            list.remove("Knock door");
            list.remove("Jump");
            list.remove("Sing");
            list.remove("Sit");
            list.remove("Little walk");
            list.add("Attack");
            list.add("Use gun");
            list.add("Use knife");
            list.add("Use grenade");
            list.add("Use potion");
            list.add("Use slingshot");
            fight(mystery);
            if (mystery.hp <= 0) {
                System.out.println("The Mystery Man lost, so YOU WON!!!. Your hp now is " + gameCharacter.hp);
                System.out.println("The Mystery Man identity is revealed and you recognize that it is your brother, Jani Lee, who has betrayed your family...");
                System.out.println("");
                System.out.println("Congratulations you saved your wife and again you became a family!");
                System.out.println("Before you leave the hotel, would you like to revive your brother? (Yes) or (No)");
                String answer = sc.next();
                if (answer.equals("Yes")) {
                    itemsToGet.add(apple);
                    System.out.println("Magic apple was added to inventory.");
                    System.out.println("(Use magic apple) to revive your brother!");
                    list.add("Use magic apple");
                    list.remove("Attack");
                    list.remove("Use gun");
                    list.remove("Use knife");
                    list.remove("Use grenade");
                    list.remove("Use potion");
                    list.remove("Use slingshot");
                    action();
                } else {
                    System.out.println("You don't want to save your brother, so he will be dead forever ...");
                }
            } else if (gameCharacter.hp <= 0) {
                fighting = false;
                System.out.println(gameCharacter.getName() + " you have lost");
                stageThreeMission();
                gameCharacter.hp = 500;
            }
        }



        public void fight(Enemy enemy) {
            System.out.println("Fight started...Type (Hint) to see all your fighting options!");
            while (fighting) {
                action();
                if (enemy.getHp() > 1) {
                    System.out.println("Try to (Dodge) the enemy attack now!");
                    String dodge = sc.nextLine();
                    if (dodge.equals(("Dodge"))) {
                        int defense = r.nextInt(2) + 1;
                        switch (defense) {
                            case 1:
                                System.out.println(gameCharacter.getName() + " has dodged the enemy attack.");
                                System.out.println("Its your turn to attack.");
                                break;

                            case 2:
                                gameCharacter.hp = gameCharacter.hp - enemy.attack;
                                System.out.println(enemy.getName() + " has attacked you. Your hp now is " + gameCharacter.hp);
                                System.out.println("Its your turn to attack!");
                                break;
                        }
                    } else {
                        gameCharacter.hp = gameCharacter.hp - enemy.attack;
                        System.out.println(enemy.getName() + " has attacked you. Your hp now is " + gameCharacter.hp);
                        System.out.println(enemyToFight.get(0).name + " hp is " + enemyToFight.get(0).hp + ". Its your turn to (Attack)!");
                    }

                }
                if (enemy.getHp() <= 0) {
                    fighting = false;
                    System.out.println("You won the fight! You have also won a " + pear.getName()+ " as a reward");
                    itemsToGet.add(pear);
                    gameCharacter.addItem(itemsToGet);

                } else if (gameCharacter.hp <= 0) {
                    fighting = false;
                    System.out.println(gameCharacter.getName() + " you have lost.");
                    if (areaGame.name.equals("Jungle")){
                        fight(enemyGame);
                        gameCharacter.hp = 500;
                    } else if (areaGame.name.equals("Beach")){
                        fight(vampire);
                        gameCharacter.hp= 500;
                    } else {

                    }
                }
            }
        }// the fighting method included dodge, and losing system.
    }








