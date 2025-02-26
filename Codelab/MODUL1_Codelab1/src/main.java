import java.util.Scanner;
import java.time.LocalDate; //this import the LocalDate allow us to retrieve the current year to age calculation

public class Main {
    public static void main(String[] args) {
    //to determine the gender output given by the user
        if (genderChar == 'M' || genderChar == 'm') {
            gender = "Male";
        } else if (genderChar == 'F' || genderChar == 'f') {
            gender = "Female";
        } else {
            gender = "Unknown";
        }

        System.out.print("Enter your year of birth: ");
        int yearOfBirth = scanner.nextInt(); //read integer input


        int currentYear = LocalDate.now().getYear(); //retrieves the current year from the system using LocalDate.
        int age = currentYear - yearOfBirth; //calculates a user's age by subtracting their year of birth from the current year.


        scanner.close(); //close the scanner to avoid potential resource leaks

        //display to user
        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
    }
}
