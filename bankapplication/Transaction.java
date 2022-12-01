package bankapplication;

import java.io.File;

public class Transaction {
    
    public final File transactionsFile = new File("src/transactionsFile.txt");
    private String  
            senderID, 
            receiverID;
    private String  
            senderAccNumber, 
            receiverAccNumber;
    private String  
            txnFullDate, 
            txnDate, 
            txnTime;
    private double  txnAmount;

    public Transaction(User sender, String senderAccNum, User receiver, String receiverAccNum, double amount) {
        senderID = sender.getId();
        this.senderAccNumber = senderAccNumber;
        
        receiverID = receiver.getId();
        this.receiverAccNumber = receiverAccNum;
        
        txnAmount = amount;
    }
    
    private void processingTxn() {
        
    }
    
    private boolean hasEnoughAmount(User sender) {
        
        return true;
    }
    
}
