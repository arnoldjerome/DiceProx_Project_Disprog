/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class HistoryLogin extends MyModel {
    
    private int HistoryLoginID;   
    private Timestamp TimeLogin;
    private int UserID;  
    
    public HistoryLogin() {
    }
    
    public HistoryLogin(int UserID){
        this.UserID = UserID;
    }
    
    public int getHistoryLoginID() {
        return HistoryLoginID;
    }

    public void setHistoryLoginID(int HistoryLoginID) {
        this.HistoryLoginID = HistoryLoginID;
    }

    public Timestamp getTimeLogin() {
        return TimeLogin;
    }

    public void setTimeLogin(Timestamp TimeLogin) {
        this.TimeLogin = TimeLogin;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    public void updateDataUserLogin(int userID) {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement)MyModel.conn.prepareStatement(
                        "UPDATE historylogins SET TimeLogin = current_timestamp() WHERE UserID= ?");
                sql.setInt(1, userID);
                sql.executeUpdate();
                sql.close();
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di update historylogins: " + e);
        }
    }
    
    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement)MyModel.conn.prepareStatement(
                        "INSERT INTO historylogins(UserID) VALUES (?)");
                sql.setInt(1, this.UserID);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<Integer> selectAllUserIDLogin() {
        ArrayList<Integer> listOfUserIDs = new ArrayList<>();
        Integer userID;
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "SELECT UserID FROM historylogins ");

                this.result = sql.executeQuery();
                
                while (this.result.next()) {
                    userID = this.result.getInt("UserID");
                    listOfUserIDs.add(userID);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("error di select all user id login " + e);
        }
        return listOfUserIDs;
    }
}
