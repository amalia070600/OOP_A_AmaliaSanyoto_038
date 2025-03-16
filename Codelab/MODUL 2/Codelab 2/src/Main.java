class BankAccount { //this is clas BankAccount, I use this to create some objects
    private String accountNumber; //here we have three variable, the private keyword use to hide the data from being accessed directly outside the class
    private String ownerName;
    private double balance;

    //this is a constructor, its a special method that runs when an object is created
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    //this method print account number, account name, and balance
    public void displayInfo() {
        System.out.println("Nomor Rekening: " + accountNumber);
        System.out.println("Nama Pemilik: " + ownerName);
        System.out.println("Saldo: Rp" + balance);
        System.out.println(); 
    }

    public void depositMoney(double amount) {
        balance += amount; //Adds money to the account
        System.out.println(ownerName + " menyetor Rp" + amount + ". Saldo sekarang: Rp" + balance);
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println(ownerName + " menarik Rp" + amount + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + balance);
        } else {
            balance -= amount;
            System.out.println(ownerName + " menarik Rp" + amount + ". (Berhasil) Saldo sekarang: Rp" + balance);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        //create 2 bank account
        BankAccount account1 = new BankAccount("202410370110038", "Amalia Aulia", 500000);
        BankAccount account2 = new BankAccount("202410370110325", "Nabila Izati", 1000000);

        //Calls the displayInfo() method
        account1.displayInfo();
        account2.displayInfo();

        account1.depositMoney(200000);
        account2.depositMoney(500000);

        account1.withdrawMoney(800000);
        account2.withdrawMoney(300000);

        //prints the updated account details after transactions
        System.out.println();
        account1.displayInfo();
        account2.displayInfo();
    }
}
