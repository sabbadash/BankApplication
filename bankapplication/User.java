package bankapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class User {
    
    public File usersFile = new File("src/usersFile.txt");
    private ArrayList<Account> accounts = new ArrayList<>();
    private String  
            forename,
            surname,
            id;
    private int age;
    
    public User() { }
    
    public User(String forename, String surname, int age) throws Exception {
        this.id = generateID();
        this.forename = forename;
        this.surname = surname;
        this.age = age;

        addUser();
    }
        
    public void addUser() throws Exception {
        FileWriter fw = new FileWriter(usersFile, true);
        
        fw.write(id + "#");
        fw.write(forename + "#");
        fw.write(surname + "#");
        fw.write(Integer.toString(age) + "\n");
        fw.close();
    }
    
    public double getUserBalance(String accountNumber) throws Exception {
        FileReader fr = new FileReader(new Account().accountsFile);
        BufferedReader br = new BufferedReader(fr);
        
        String data, balance = "";
        while ((data = br.readLine()) != null) {
            StringTokenizer st1 = new StringTokenizer(data, "\n");
            
            while(st1.hasMoreTokens()) {
                String fullLine = st1.nextToken();
                String idCheck = Character.toString(fullLine.charAt(0));    //id
                
                if(idCheck.equals(this.getId())) {
                    StringTokenizer st2 = new StringTokenizer(fullLine, "#");
                    
                    while(st2.hasMoreTokens()) {
                        String id = st2.nextToken();
                        String accNumber = st2.nextToken();
                        balance = st2.nextToken();
                        
                        if(accNumber.equals(accountNumber)) {
                            br.close();
                            fr.close();
                            return Double.parseDouble(balance);
                        }
                    }
                }
            }
        }
        return Double.parseDouble(balance);
    }
    
    public boolean hasEnoughAmount(String accNumber, double amount) throws Exception {
        double balance = getUserBalance(accNumber);
        if(balance >= amount) {
            return true;
        } else {
            return false;
        }
    }
        
    private String generateID() throws Exception {
        if(!usersFile.exists()) {
            return "1";
        }

        String currentLine, lastLine = null;
        
        FileReader fr = new FileReader(usersFile);
        BufferedReader br = new BufferedReader(fr);

        while((currentLine = br.readLine()) != null) {
            lastLine = currentLine;
        }
        br.close();
        fr.close();

        StringTokenizer st = new StringTokenizer(lastLine, "#");
        String lastId = st.nextToken();
        String currentId = Integer.toString(Integer.parseInt(lastId) + 1);
        
        return currentId;
    }

    public String getId() {
        return id;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

}
