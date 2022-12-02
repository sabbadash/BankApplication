package bankapplication;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) throws Exception {
    
        User user1 = new User("James", "Gosling", 18);
        User user2 = new User("Linus", "Torvalds", 18);
        User user3 = new User("Donald", "Knuth", 18);
        User user4 = new User("Anders", "Hejlsberg", 18);
        
        
        Account acc3 = new Account(user3);
        Account acc4 = new Account(user4);
        Account acc1 = new Account(user1);
        Account acc2 = new Account(user2);
        
        acc1.addAccount();
        acc2.addAccount();
        acc3.addAccount();
        acc4.addAccount();
        
        Scanner console = new Scanner(System.in);
        
        String senderAccNum = console.nextLine();
        String receiverAccNum = console.nextLine();
        Transaction txn = new Transaction(user1, senderAccNum, user2, receiverAccNum, 10.0d);
    }
    
}
