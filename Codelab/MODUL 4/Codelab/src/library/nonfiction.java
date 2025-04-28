package library;

public class nonfiction extends book {
    private String field;

    public nonfiction(String title, String author, String field){
        super(title, author);
        this.field = field;
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction Book: " + title + " by " + author + " (Field: " + field + ")");
    }
}
