/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import java.util.ArrayList;
import model.MyModel;

/**
 *
 * @author Rome
 */
public class Account extends MyModel{
    
    int UserID;
    private String Username;
    private String Password;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Account(int UserID, String Username, String Password) {
        this.UserID = UserID;
        this.Username = Username;
        this.Password = Password;
    }
    
    
    

   
    
}
