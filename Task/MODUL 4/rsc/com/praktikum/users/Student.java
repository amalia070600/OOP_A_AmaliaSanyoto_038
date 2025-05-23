package com.praktikum.users;

import com.praktikum.actions.StudentActions;
import java.util.Scanner;

public class Student extends User implements StudentActions {

    private String name;
    private String studentID;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    @Override
    public boolean login(String name, String studentID) {
        return this.name.equals(name) && this.studentID.equals(studentID);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nStudent Menu:");
            System.out.println("1. Report Item");
            System.out.println("2. View Reported Items");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            switch (choice) {
                case 1 -> reportItem();
                case 2 -> viewReportedItems();
                case 0 -> System.out.println("Logging out");
                default -> {
                    if (choice != 0) System.out.println("Invalid choice");
                }
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Item Description: ");
        String description = scanner.nextLine();
        System.out.print("Last Seen/Found Location: ");
        String location = scanner.nextLine();
        System.out.println("Report submitted for item: " + itemName);
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> View Reported Items feature is not available <<");
    }
}
