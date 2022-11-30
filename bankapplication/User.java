package bankapplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class User {
    
    private final File usersFile = new File("src/usersFile.txt");
    private String  forename;
    private String  surname;
    private String  id;
    private int     age;
    
    private ArrayList<Account> accounts = new ArrayList<>();
    
    public User(String forename, String surname, int age) throws Exception {
        
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.id = generateID();
        
        this.writeUser();
        
    }
        
    public void writeUser() throws Exception {
        
        FileWriter fw = new FileWriter(usersFile, true);

        fw.write(id + "#");
        fw.write(forename + "#");
        fw.write(surname + "#");
        fw.write(Integer.toString(age) + "\n");

        fw.close();
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
  
}
