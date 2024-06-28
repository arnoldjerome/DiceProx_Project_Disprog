/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author Rome
 */
public class ParkingReservations extends MyModel {

    private int ReservationID;
    private int UserID;
    private String reservationDate;
    private String PoliceNumber;

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }
    private String locationID;
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

    

    public boolean isIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations(int ReservationID, int UserID, String reservationDate, String PoliceNumber, String locationID, boolean IsAvailable) {
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
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery(
                    "select pr.ReservationID, u.Username, pl.LocationName, "
                    + "pr.PoliceNumber, pr.LocationID, pr.IsAvailable "
                    + "from parkingreservations pr"
                    + "join users u on pr.UserID = u.userid "
                    + "join parkinglots pl on pr.ParkingLotID = pl.ParkingLotID");

            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ReservationID"),
                        this.result.getInt("UserID"),
                        this.result.getString("ReservationDate"),
                        this.result.getString("PoliceNumber"),
                        this.result.getString("LocationID"),
                        this.result.getBoolean("IsAvailable")
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data: " + e);
        }
        return listOfReservations;
    }
}
