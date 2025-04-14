import java.util.Scanner;

class Admin {
    private String username;
    private String password;

    //this is constructor, this will help you to create some object
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    //This boolean login is the one that will be called when the user chooses the login method for admin. It will check whether the entered username and password match or not
    public boolean login(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }
}

class Student{
    private String studentName;
    private String studentID;

    public Student(String studentName, String studentID){
        this.studentName = studentName;
        this.studentID = studentID;
    }

    public boolean login(String studentName, String studentID){
        return this.studentName.equals(studentName) && this.studentID.equals(studentID);
    }

    //This displayInfo will be shown and called if the login as a student is successful. It will display the name and student ID.
    public void displayInfo(){
        System.out.println("Login as an Student Successful");
        System.out.println("Name : " + studentName);
        System.out.println("Student ID " + studentID);
    }
}

class systemLogin{
    private Admin admin;
    private Student student;

    //Here we will create some object in Admin and Student
    public systemLogin(){
        admin = new Admin ("Admin2024", "satuduatigaempat");
        student = new Student("Amalia Sanyoto", "202410370110038");
    }

    //This one will be displayed when we call it
    public void run(){
        Scanner scanner = new Scanner (System.in); //will read the user input through the keyboard

        System.out.println("System Login");
        System.out.println("1. Login as an Admin");
        System.out.println("2. Login as an Student");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        if(choice.equals("1")){
            System.out.print("Enter your username :");
            String username = scanner.nextLine();
            System.out.print("Enter your password : ");
            String password = scanner.nextLine();

            if(admin.login(username, password)){
                System.out.println("Login as an Admin Successful");
            }
            else{
                System.out.println("Login as Admin failed. Please enter the correct username and password");
            }
        }else if(choice.equals("2")){
            System.out.print("Enter your name :");
            String studentName = scanner.nextLine();
            System.out.print("Enter your ID : ");
            String studentID = scanner.nextLine();
            if(student.login(studentName, studentID)){
                student.displayInfo();
            }else{
                System.out.println("Login as Student failed. Please enter the correct name and ID");
            }
        }else{
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        systemLogin system = new systemLogin(); //simply this one is like calling the constructor to create the object, like preparing the object
        system.run();
    }
}