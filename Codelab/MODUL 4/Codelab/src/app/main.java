package app;

import library.*;

public class main {
    public static void main(String[] args){
        nonfiction NonFiction = new nonfiction("Madilog", "Tan Malaka", "History and Science");
        fiction Fiction = new fiction("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Folktale");

        NonFiction.displayInfo();
        Fiction.displayInfo();
        System.out.println();

        member member1 = new member("Amalia Sanyoto", "A038");
        member member2 = new member("Nabila Izati", "A325");

        member1.displayInfo();
        member2.displayInfo();
        System.out.println();

        member1.peminjamanBuku("Madilog");
        member2.peminjamanBuku("Hainuwele: Sang Putri Kelapa", 7);
        System.out.println();

        member1.pengembalianBuku("Madilog");
        member2.pengembalianBuku("Hainuwele: Sang Putri Kelapa");
    }
}
