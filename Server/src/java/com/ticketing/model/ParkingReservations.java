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
    int ReservationID;
    int UserID;
    int ParkingLotID;
    private Timestamp ReservationDate;
    int SlotNumber;
    private Boolean IsAvailable;

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

    public int getParkingLotID() {
        return ParkingLotID;
    }

    public void setParkingLotID(int ParkingLotID) {
        this.ParkingLotID = ParkingLotID;
    }

    public Timestamp getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Timestamp ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public int getSlotNumber() {
        return SlotNumber;
    }

    public void setSlotNumber(int SlotNumber) {
        this.SlotNumber = SlotNumber;
    }

    public Boolean getIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations(int ReservationID, int UserID, int ParkingLotID, Timestamp ReservationDate, int SlotNumber, Boolean IsAvailable) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.ParkingLotID = ParkingLotID;
        this.ReservationDate = ReservationDate;
        this.SlotNumber = SlotNumber;
        this.IsAvailable = IsAvailable;
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