/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public class ParkingLot extends MyModel {
    private int parkingLotsID;
    private String parkingLotsName;
    private int totalSlots;

    public ParkingLot(int parkingLotsID, String parkingLotsName, int totalSlots) {
        this.parkingLotsID = parkingLotsID;
        this.parkingLotsName = parkingLotsName;
        this.totalSlots = totalSlots;
    }
    public ParkingLot() {
    }

    public int getParkingLotsID() {
        return parkingLotsID;
    }

    public void setParkingLotsID(int parkingLotsID) {
        this.parkingLotsID = parkingLotsID;
    }

    public String getParkingLotsName() {
        return parkingLotsName;
    }

    public void setParkingLotsName(String parkingLotsName) {
        this.parkingLotsName = parkingLotsName;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
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
