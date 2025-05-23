package com.praktikum.users;

import com.praktikum.actions.StudentActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends User implements StudentActions {

    public Student(String name, String studentID) {
        super(name, studentID);
    }

    @Override
    public boolean login(String name, String studentID) {
        return getName().equals(name) && getStudentID().equals(studentID);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nStudent Menu:");
            System.out.println("1. Report Found/Lost Items");
            System.out.println("2. View Report List");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                continue;
            }
            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logging out");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();
        System.out.print("Enter last known location: ");
        String location = scanner.nextLine();
        Item item = new Item(name, description, location, "Reported");
        LoginSystem.reportedItems.add(item);
        System.out.println("Item Reported Successfully!");
    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("No item reported yet");
            return;
        }
        int idx = 0;
        for (Item item : LoginSystem.reportedItems) {
            System.out.printf("%d. %s | %s | %s | Status: %s\n", idx, item.getItemName(), item.getDescription(), item.getLocation(), item.getStatus());
            idx++;
        }
    }
}
