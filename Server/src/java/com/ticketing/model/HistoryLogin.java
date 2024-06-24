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
