/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public class ParkingReservations extends MyModel {

    private int ReservationID;
    private int UserID;
    private String reservationDate;
    private String PoliceNumber;
    private int locationID;
    private boolean IsAvailable;
    
    public int getReservationID() {
        return ReservationID;
    }

    public void setReservationID(int ReservationID) {
        this.ReservationID = ReservationID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getPoliceNumber() {
        return PoliceNumber;
    }

    public void setPoliceNumber(String PoliceNumber) {
        this.PoliceNumber = PoliceNumber;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public boolean isIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations(int ReservationID, int UserID, String reservationDate, String PoliceNumber, int locationID, boolean IsAvailable) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.reservationDate = reservationDate;
        this.PoliceNumber = PoliceNumber;
        this.locationID = locationID;
        this.IsAvailable = IsAvailable;
    }
    public ParkingReservations()
    {
    }
    
    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    
}
