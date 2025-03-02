import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        System.out.print("Enter your choice: ");
        int loginType = scanner.nextInt();
        scanner.nextLine();

        if (loginType == 1) {
            System.out.print("Enter admin username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String adminPassword = scanner.nextLine();

            String validAdminUsername = "Admin038";
            String validAdminPassword = "Password038";

            if (adminUsername.equals(validAdminUsername) && adminPassword.equals(validAdminPassword)) {
                System.out.println("Admin login successful!");
            } else {
                System.out.println("Login failed! Wrong username or password.");
            }
        } else if (loginType == 2) {
            System.out.print("Enter your name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();

            if (studentName.equals("Amalia Sanyoto") && studentID.equals("202410370110038")) {
                System.out.println("Student Login Successful!");
                System.out.println("Name: " + studentName);
                System.out.println("Student ID: " + studentID);
            } else {
                System.out.println("Login Failed! Wrong name or student ID.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
