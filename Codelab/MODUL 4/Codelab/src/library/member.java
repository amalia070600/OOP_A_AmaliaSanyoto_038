package library;

public class member implements borrowing{
    private String name;
    private String memberId;

    public member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public void displayInfo() {
        System.out.println("Member: " + name + " (ID: " + memberId + ")");
    }

    @Override
    public void peminjamanBuku(String title) {
        System.out.println(name + " is borrowing the book titled: " + title);
    }

    public void peminjamanBuku(String title, int durationDays) { // Overloading
        System.out.println(name + " is borrowing the book \"" + title + "\" for " + durationDays + " days.");
    }

    @Override
    public void pengembalianBuku(String title) {
        System.out.println(name + " is returning the book titled: " + title);
    }
}
