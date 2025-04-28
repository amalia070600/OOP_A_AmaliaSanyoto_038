package library;

public class fiction extends book{
    private String genre;

    public fiction(String title, String author, String genre){
        super(title, author);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction Book: " + title + " by " + author + " (Genre: " + genre + ")");
    }
}
