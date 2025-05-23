package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.User;
import java.util.Scanner;

public class LoginSystem {
    private Admin admin;
    private Student student;

    public LoginSystem() {
        admin = new Admin("Admin2024", "satuduatigaempat");
        student = new Student("Amalia Sanyoto", "202410370110038");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System Login");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        User loggedInUser = null;

        if (choice.equals("1")) {
            System.out.print("Username: ");
            String uname = scanner.nextLine();
            System.out.print("Password: ");
            String pwd = scanner.nextLine();

            if (admin.login(uname, pwd)) {
                loggedInUser = admin;
            } else {
                System.out.println("Login failed for Admin.");
            }
        } else if (choice.equals("2")) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Student ID: ");
            String id = scanner.nextLine();

            if (student.login(name, id)) {
                loggedInUser = student;
            } else {
                System.out.println("Login failed for Student.");
            }
        } else {
            System.out.println("Invalid option.");
        }

        if (loggedInUser != null) {
            loggedInUser.displayAppMenu();
        }
    }

    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();
        system.run();
    }
}
