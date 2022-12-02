package bankapplication;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) throws Exception {
    
        User user1 = new User("James", "Gosling", 18);
        User user2 = new User("Linus", "Torvalds", 18);
        User user3 = new User("Donald", "Knuth", 18);
        User user4 = new User("Anders", "Hejlsberg", 18);
        
        
        Account acc1 = new Account(user1, 10.0d, "1111");
        Account acc2 = new Account(user2, 1.0d, "2222");
        Account acc3 = new Account(user3, 100.0d, "3333");
        Account acc4 = new Account(user4, 0.0d, "4444");
        
        acc1.addAccount();
        acc2.addAccount();
        acc3.addAccount();
        acc4.addAccount();
        
        Transaction txn = new Transaction(user1, "1111", user2, "2222", 10.0d);
        Transaction txn2 = new Transaction(user2, "2222", user3, "3333", 5.0d);
        Transaction txn3 = new Transaction(user3, "3333", user4, "4444", 6.0d);
        
    }
    
}
