package com.praktikum.users;

public abstract class User {
    // Tidak ada atribut login di sini, karena beda tiap subclass

    // Method login abstrak dengan parameter sesuai subclass
    public abstract boolean login(String id, String passwordOrStudentID);

    // Menu aplikasi
    public abstract void displayAppMenu();
}
