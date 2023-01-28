package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import JAVAPROJET.TableauProduit;

@SuppressWarnings("serial")
public class UserBase implements Serializable {

	static ArrayList<User> users = new ArrayList<>();
    static ArrayList<String> emails = new ArrayList<>();
    
    static File usersFile = new File("users.txt");
    static File emailsFile = new File("emails.txt");
    static int connected; 

    public static void createFiles() {
        try {
            emailsFile.createNewFile();
            usersFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
	public static void loadSession() {
        createFiles();
        try {
            FileInputStream fis1 = new FileInputStream(usersFile);
            FileInputStream fis2 = new FileInputStream(emailsFile);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            users = (ArrayList<User>) ois1.readObject();
            emails = (ArrayList<String>) ois2.readObject();
            ois1.close();
            ois2.close();
            fis1.close();
            fis2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void saveSession(){
        try {
        	
            FileOutputStream fos1 = new FileOutputStream(usersFile);
            FileOutputStream fos2 = new FileOutputStream(emailsFile);
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            oos1.writeObject(users);
            oos2.writeObject(emails);
            oos1.flush();
            oos2.flush();
            oos1.close();
            oos2.close();
            fos1.close();
            fos2.close();
        } catch (IOException e) {
            System.out.println("save error\n"+e);
        }
    }
    
    

    
    
    public static String addUser(User user) {
        if (!emails.contains(user.getemail())) {
            users.add(user);
            emails.add(user.getemail());
            return "votre compte a ete cree";
        } else {
            return "compte existant!";
        }
    }
    public static User findUser(String email){
        return users.get(emails.indexOf(email));
    }
    public static boolean userExists(String email){
        if(emails.contains(email)){
            return true;
        }
        return false;
    }
    public static boolean checkCredentials(User user){
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
        	User usr = it.next();
            if (user.compare(usr)){
            	connected = users.indexOf(usr);
            	TableauProduit.userData =usr.userData;
                return true;
            }
        }
        return false;
    }


}
