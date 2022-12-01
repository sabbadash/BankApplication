package bankapplication;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) throws Exception {
    
        User user1 = new User("James", "Gosling", 18);
        User user2 = new User("Linus", "Torvalds", 18);
        User user3 = new User("Donald", "Knuth", 18);
        User user4 = new User("Anders", "Hejlsberg", 18);
        
        Account acc1 = new Account(user1);
        Account acc2 = new Account(user2);
        Account acc3 = new Account(user3);
        Account acc4 = new Account(user4);
        
        acc1.addAccount();
        acc2.addAccount();
        acc3.addAccount();
        acc4.addAccount();
        
        Scanner console = new Scanner(System.in);
        String a = "";
        while(!a.equals(" ")) {
            a = console.nextLine();
            System.out.println("user1:" + user1.getUserBalance(a));
            System.out.println("user2:" + user2.getUserBalance(a));
            System.out.println("user3:" + user3.getUserBalance(a));
            System.out.println("user4:" + user4.getUserBalance(a));
        }

    }
    
}
