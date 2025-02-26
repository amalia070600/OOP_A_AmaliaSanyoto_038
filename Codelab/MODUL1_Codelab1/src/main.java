import java.util.Scanner;
import java.time.LocalDate; //imports the LocalDate, which is used to retrieve the current year for age calculation.

public class Main {
    public static void main(String[] args) { //entry point of the program
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: "); //displays a prompt asking the user to enter their name
        String name = scanner.nextLine(); //reads the entire line entered by the user and stores it in the variable name

        System.out.print("Enter your gender (M/F): ");
        char genderChar = scanner.next().charAt(0); //reads the word input by user, and also extract the first charter from the user input
        String gender;

        // this code block, checks the user input and assigns the appropriate value to the gender variable
        if (genderChar == 'M' || genderChar == 'm') {
            gender = "Male";
        } else if (genderChar == 'F' || genderChar == 'f') {
            gender = "Female";
        } else {
            gender = "Unknown";
        }

        System.out.print("Enter your year of birth: ");
        int yearOfBirth = scanner.nextInt(); //read an integer input from user

        int currentYear = LocalDate.now().getYear(); // retrieves the current year
        int age = currentYear - yearOfBirth; //calculates a user's age by subtracting their year of birth from the current year


        scanner.close(); //closing the scanner, to avoid potential resource leaks

        // display user details
        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
    }
}
