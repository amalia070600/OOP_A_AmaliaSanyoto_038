//GameCharacter is the mother class, for character
class GameCharacter {

    private String name; //variable to store name string
    private int health; //variable to store health int

    //this is constructor to create object
    public GameCharacter(String name, int health) {
        this.name = name; //stores the name value when the object is created
        this.health = health; //stores the name value when the object is created
    }

    //this is getter, we use getter for method to take charter name
    public String getName() {
        return name;
    }

    //this is setter, we use it for change the name
    public void setName(String name) {
        this.name = name;
    }

    //this is also getter for health, have the same function as getter name
    public int getHealth() {
        return health;
    }

    //this is also setter, but for health. Have the same function as setter name
    public void setHealth(int health) {
        this.health = health;
    }
    //we use getters and setters as methods to access and change the values of name and health. This is necessary because the name and health attributes are private.

    //this is method to attack another character
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks " + target.getName() + "!"); //we gonna change this to enemy or hero in the next line
    }
}

//this is subclass from GameCharacter and inherits all attributes and methods from the mother class
class Hero extends GameCharacter {
    public Hero(String name, int health) { //hero, receives name and health
        super(name, health); //we use super to store name and health data
    }

    @Override
    public void attack(GameCharacter target) { //this method accepts one parameter (target), which is the GameCharacter object to be attacked
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike!"); //take the name of the attacking hero, and also take the enemy name
        target.setHealth(target.getHealth() - 20); //reduces the health of the target by 20
        System.out.println(target.getName() + " now has " + target.getHealth() + " health.");
    }
}

//this is subclass from GameCharacter and inherits all attributes and methods from the mother class
class Enemy extends GameCharacter {
    public Enemy(String name, int health) { //this is the constructor we'll call when we make object
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " using Snake Bite!"); //take the name of attacking and the target name
        target.setHealth(target.getHealth() - 15); //reduce the target health by 15
        System.out.println(target.getName() + " now has " + target.getHealth() + " health.");
    }
}

class BattleSimulation {
    public static void main(String[] args) { //class main that will run the program
        GameCharacter general = new GameCharacter("General Character", 100); //create a General Character object with 100 health
        Hero hero = new Hero("Brimstone", 150); //create a hero object named Brimstone with 150 health
        Enemy enemy = new Enemy("Viper", 200); //create an enemy object named Viper with 200 health

        System.out.println("Initial status:");
        System.out.println(hero.getName() + " has health: " + hero.getHealth()); //print the hero name and health
        System.out.println(enemy.getName() + " has health: " + enemy.getHealth()); //print the enemy name and health

        System.out.println("\nBattle Begins!");
        hero.attack(enemy); //"attack()" in class Hero going to run
        hero.attack(enemy); //"attack()" in clas Hero is going to run again
        enemy.attack(hero); //"attack()" in class Hero is going t run again, but now hero is the object that going to get attacked
    }
}
