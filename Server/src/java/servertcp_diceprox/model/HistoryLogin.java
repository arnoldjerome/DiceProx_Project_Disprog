/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servertcp_diceprox.model;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class HistoryLogin extends MyModel {
    
    private int user_id;
    private String username;
    private Timestamp time_login;
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime_login() {
        return time_login;
    }

    public void setTime_login(Timestamp time_login) {
        this.time_login = time_login;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement)MyModel.conn.prepareStatement(
                        "INSERT INTO historylogins(UserID) VALUES ('?');");
                sql.setInt(1, this.user_id);
                sql.executeUpdate();
                sql.close();
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di insert historylogins: " + e);
        }
    }

    @Override
    public void updateData() {
        
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
