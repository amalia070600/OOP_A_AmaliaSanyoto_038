package com.praktikum.main;

import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.User;
import com.praktikum.data.Item;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    public LoginSystem() {
        userList.add(new Admin("Admin2024", "satuduatigaempat"));
        userList.add(new Student("Amalia Sanyoto", "202410370110038"));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSystem Login");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("Exiting");
                break;
            }

            User loggedInUser = null;
            if (choice.equals("1")) {
                System.out.print("Username: ");
                String uname = scanner.nextLine();
                System.out.print("Password: ");
                String pwd = scanner.nextLine();

                for (User user : userList) {
                    if (user instanceof Admin && user.login(uname, pwd)) {
                        loggedInUser = user;
                        break;
                    }
                }
                if (loggedInUser == null) {
                    System.out.println("Login failed for Admin.");
                }
            } else if (choice.equals("2")) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Student ID: ");
                String id = scanner.nextLine();
                for (User user : userList) {
                    if (user instanceof Student && user.login(name, id)) {
                        loggedInUser = user;
                        break;
                    }
                }
                if (loggedInUser == null) {
                    System.out.println("Login failed for Student.");
                }
            } else {
                System.out.println("Invalid option.");
            }

            if (loggedInUser != null) {
                loggedInUser.displayAppMenu();
            }
        }
    }

    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();
        system.run();
    }
}
