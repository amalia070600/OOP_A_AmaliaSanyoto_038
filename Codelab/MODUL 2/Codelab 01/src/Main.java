class Animal { //I use this class for room or structure to create an object
    //these are the attributes, and it only can accessed by the animal class
    private String name;
    private String type;
    private String sound;

    //this is a constructor, its like a method to initialize the object when its created
    public Animal(String name, String type, String sound) {
        this.name = name; //this mean to assign the passed name to the object name attributes
        this.type = type;
        this.sound = sound;
    }

    // here is method to display animal info
    public void displayInfo() {
        System.out.printf("Animal Information:\n Name: %s\n Type: %s\n Sound: %s\n\n", name, type, sound);
    }
}

public class Main { //main method I use to execute the code
    public static void main(String[] args) {
        // here I have two objects of animal class
        Animal animal1 = new Animal("Cat", "Mammal", "Nyann~~"); //represent a cat
        Animal animal2 = new Animal("Dog", "Mammal", "Woof-Woof!!"); //represent a dog

        // here is displayInfo to print each object
        animal1.displayInfo(); //to print object 1, which is cat
        animal2.displayInfo(); //to print object 2, which is dog
    }
}
