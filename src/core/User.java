package core;

import java.io.Serializable;
import java.util.ArrayList;

import JAVAPROJET.Produit;


public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String email;
    public String password;
    public ArrayList<Produit> userData = new ArrayList<>();
    public User(String email, String password){
    
        this.email = email;
        this.password = password;
    }
    public String getemail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public boolean compare(User user){
        if((user.getPassword().equals(this.getPassword())) && (user.getemail().equals(this.getemail()))){
            return true;
        }
        return false;
    }
}
