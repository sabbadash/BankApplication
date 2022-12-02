package bankapplication;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Objects;

public class Account {
    
    public File accountsFile = new File("src/accountsFile.txt");
    private String  
            holderID, 
            holderName, 
            accountNumber;
    private double  balance;

    public Account() { }
        
    public Account(User user) throws Exception {
        holderID = user.getId();
        holderName = user.getForename() + user.getSurname();
        accountNumber = generateAccNumber();
        balance = 0.0d;
    }
    
    public void addAccount() throws Exception {
        FileWriter fw = new FileWriter(accountsFile, true);
        
        fw.write(holderID + "#");
        fw.write(accountNumber + "#");
        fw.write(Double.toString(balance) + "\n");
        fw.close();
    }
    
    private String generateAccNumber() throws Exception {
        Thread.sleep(100);
        int randNum = (int) ((new Date()).getTime() % 10000);
        return String.format("%04d", randNum);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + Objects.hashCode(this.holderID);
        hash = 31 * hash + Objects.hashCode(this.holderName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.holderID, other.holderID)) {
            return false;
        }
        return Objects.equals(this.holderName, other.holderName);
    }
    
}
