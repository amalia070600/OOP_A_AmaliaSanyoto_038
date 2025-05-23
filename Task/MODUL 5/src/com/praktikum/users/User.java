package com.praktikum.users;

public abstract class User {
    private String name;
    private String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public String getStudentID() { return id; }

    public abstract boolean login(String name, String id);
    public abstract void displayAppMenu();
}
