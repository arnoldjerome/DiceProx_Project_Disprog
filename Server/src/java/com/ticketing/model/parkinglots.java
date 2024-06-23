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
public class parkinglots extends MyModel {
    int ParkingLotID;
    private String LocationName;
    int TotalSlots;
    int BlockedSlots;

    public int getParkingLotID() {
        return ParkingLotID;
    }

    public void setParkingLotID(int ParkingLotID) {
        this.ParkingLotID = ParkingLotID;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }

    public int getTotalSlots() {
        return TotalSlots;
    }

    public void setTotalSlots(int TotalSlots) {
        this.TotalSlots = TotalSlots;
    }

    public int getBlockedSlots() {
        return BlockedSlots;
    }

    public void setBlockedSlots(int BlockedSlots) {
        this.BlockedSlots = BlockedSlots;
    }

    public parkinglots(int ParkingLotID, String LocationName, int TotalSlots, int BlockedSlots) {
        this.ParkingLotID = ParkingLotID;
        this.LocationName = LocationName;
        this.TotalSlots = TotalSlots;
        this.BlockedSlots = BlockedSlots;
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
