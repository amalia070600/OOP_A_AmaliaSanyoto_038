package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String username, String password) {
        return getName().equals(username) && getStudentID().equals(password);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Item Reports");
            System.out.println("2. Manage Student Data");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                continue;
            }

            switch (choice) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> System.out.println("Logging out");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    @Override
    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("No item reported yet");
            return;
        }
        System.out.println("List for all reports: ");
        int idx = 0;
        for (Item item : LoginSystem.reportedItems) {
            System.out.printf("%d. %s | %s | %s | Status: %s\n", idx, item.getItemName(), item.getDescription(), item.getLocation(), item.getStatus());
            idx++;
        }

        System.out.println("1. Mark item already claimed (Claimed)");
        System.out.println("0. Exit");
        System.out.print("Select : ");
        String opt = scanner.nextLine();
        if (opt.equals("1")) {
            System.out.print("Enter the item index number: ");
            try {
                int itemIdx = Integer.parseInt(scanner.nextLine());
                if (itemIdx < 0 || itemIdx >= LoginSystem.reportedItems.size()) {
                    throw new IndexOutOfBoundsException();
                }
                Item item = LoginSystem.reportedItems.get(itemIdx);
                if (item.getStatus().equals("Claimed")) {
                    System.out.println("Already Claimed.");
                } else {
                    item.setStatus("Claimed");
                    System.out.println("Status changed successfully as Claimed.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index");
            }
        }
    }

    @Override
    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\nManage Student Data:");
            System.out.println("1. Add Data Mahasiswa");
            System.out.println("2. Delete Data Mahasiswa");
            System.out.println("0. Exit");
            System.out.print("Select : ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input must be number");
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM Mahasiswa: ");
                    String nim = scanner.nextLine();

                    boolean exists = false;
                    for (User user : LoginSystem.userList) {
                        if (user instanceof Student && user.getName().equals(nama) && user.getStudentID().equals(nim)) {
                            exists = true;
                            break;
                        }
                    }
                    if (exists) {
                        System.out.println("Student already registered");
                    } else {
                        LoginSystem.userList.add(new Student(nama, nim));
                        System.out.println("Student successfuly added");
                    }
                }
                case 2 -> {
                    System.out.print("Enter student ID/NIM about to delete: ");
                    String nim = scanner.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < LoginSystem.userList.size(); i++) {
                        User user = LoginSystem.userList.get(i);
                        if (user instanceof Student && user.getStudentID().equals(nim)) {
                            LoginSystem.userList.remove(i);
                            removed = true;
                            System.out.println("Student data successfuly deleted");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student not found");
                    }
                }
                case 0 -> System.out.println("Back to Admin menu.");
                default -> System.out.println("Invalid input");
            }
        } while (choice != 0);
    }
}
