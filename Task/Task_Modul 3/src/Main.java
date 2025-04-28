import java.util.Scanner;

// Superclass User
class User {
    private String name;
    private String studentID;

    //Constructor
    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    //Getter and Setter, we use this to access private data
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public boolean login(String name, String studentID) {
        return false; //we're going to override it in subclass, return false just a placeholder
    }

    public void displayInfo() { //create a displayinfo here just to have the default, and this displayinfo can reuse by subclas with super.displayinfo
        System.out.println("User Information:");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
    }
    //we're gonna override it letter
}

// Subclass Admin
class Admin extends User {
    private String username;
    private String password;

    public Admin(String username, String password) {
        super("Admin2024", "000000"); //Admin is derived from User, so it is mandatory to call the User constructor. That's why super("Admin2024", "000000") is still used, even though Admin has its own username & password.
        //simply all admin is user, admin have to call the User constructor  which is contains name and ID, even thought admin dont need it. Thats why the name id Admin2024 and the ID is dummy, because admin don't need it, just for a placeholder
        this.username = username;
        this.password = password;
        //don't have to super the username and password because it's only the Admin vied, all admin is user, but not all user is admin
    }

    @Override //login() simply accepts input and checks for compatibility. The output is a boolean, telling whether the login was successful.
    //simply override just a custom methode
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login as Admin Successful");
    }
}

// Subclass Student
class Student extends User {
    public Student(String name, String studentID) {
        super(name, studentID);
    }

    @Override
    public boolean login(String name, String studentID) {
        return getName().equals(name) && getStudentID().equals(studentID);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login as Student Successful");
        System.out.println("Name: " + getName());
        System.out.println("Student ID: " + getStudentID());
    }
}

// systemLogin class
class systemLogin {
    private Admin admin;
    private Student student;

    public systemLogin() {
        admin = new Admin("Admin2024", "satuduatigaempat");
        student = new Student("Amalia Sanyoto", "202410370110038");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("System Login");
        System.out.println("1. Login as an Admin");
        System.out.println("2. Login as a Student");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (admin.login(username, password)) {
                admin.displayInfo();
            } else {
                System.out.println("Login as Admin failed. Please enter the correct username and password.");
            }
        } else if (choice.equals("2")) {
            System.out.print("Enter your name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter your ID: ");
            String studentID = scanner.nextLine();

            if (student.login(studentName, studentID)) {
                student.displayInfo();
            } else {
                System.out.println("Login as Student failed. Please enter the correct name and ID.");
            }
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        systemLogin system = new systemLogin(); //This line creates an object system from the class systemLogin. Now we can call methods on system.
        system.run();
    }
}
