package bankapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Transaction {
    
    public File transactionsFile = new File("src/transactionsFile.txt");
    private File temporaryFile = new File("src/temporaryFile.txt");
    public File accountsFile = new File(new Account().accountsFile.toString());
    private User 
            senderObj, 
            receiverObj;
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
    

    public Transaction(
            User    sender, 
            String  senderAccNum, 
            User    receiver, 
            String  receiverAccNum, 
            double  amount
    ) throws Exception {
        
        senderObj = sender;
        senderID = sender.getId();
        this.senderAccNumber = senderAccNum;
        
        receiverObj = receiver;
        receiverID = receiver.getId();
        this.receiverAccNumber = receiverAccNum;
        
        txnAmount = amount;
        
        processingTxn();
    }
    
    private void processingTxn() throws Exception {
        if(senderObj.hasEnoughAmount(senderAccNumber, txnAmount)) {
            FileReader fr = new FileReader(accountsFile);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(temporaryFile);
                    
            String line;
            while((line = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(line, "\n");
                
                while(st1.hasMoreTokens()) {
                    String currentLine = st1.nextToken();
                    StringTokenizer st2 = new StringTokenizer(currentLine, "#");
                    
                    while(st2.hasMoreTokens()) {
                        String id = st2.nextToken();
                        String accNumber = st2.nextToken();
                        double balance = Double.parseDouble(st2.nextToken());
                        
                        if(id.equals(senderID) && accNumber.equals(senderAccNumber)) {
                            double newBalance1 = balance - txnAmount;
                            fw.write(senderID + "#" + senderAccNumber + "#" + newBalance1 + "\n");
                        } else if(id.equals(receiverID) && accNumber.equals(receiverAccNumber)) {
                            double newBalance2 = balance + txnAmount;
                            fw.write(receiverID + "#" + receiverAccNumber + "#" + newBalance2 + "\n");
                        } else {
                            fw.write(currentLine + "\n");
                        } 
                    }
                }
            }
            br.close();
            fr.close();
            fw.close();
            accountsFile.delete();
            temporaryFile.renameTo(accountsFile);
            
        } else {
            System.out.println("Sender doesn't have enough money");
        }
    }
    
}
