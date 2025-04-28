package library;

public abstract class book{
    protected String title;
    protected String author;

    public book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public abstract void displayInfo();
}
