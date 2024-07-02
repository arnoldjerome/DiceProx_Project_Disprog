/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.PreparedStatement;
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
    private int ParkingLotID;
    private String ReservationDate;
    private String PoliceNumber;
    private String LocationID;
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

    public String getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(String ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public String getPoliceNumber() {
        return PoliceNumber;
    }

    public void setPoliceNumber(String PoliceNumber) {
        this.PoliceNumber = PoliceNumber;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    public Boolean getIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations(int ReservationID, int UserID, int ParkingLotID, String ReservationDate, String PoliceNumber, String LocationID, Boolean IsAvailable) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.ParkingLotID = ParkingLotID;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.LocationID = LocationID;
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations() {
    }
    
    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "UPDATE parkingreservations SET UserID=?, ReservationDate=?, PoliceNumber=?, IsAvailable=2 WHERE ReservationID= ?");
                
                sql.setInt(1, this.getUserID());
                sql.setString(2, this.getReservationDate());
                sql.setString(2, this.getPoliceNumber());
                sql.setInt(4, this.getReservationID());
               
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di Update data: " + e);
        }
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
                    + "pr.PoliceNumber, pr.LocationID as ParkingLotCode, pr.IsAvailable "
                    + "from parkingreservations pr"
                    + "join users u on pr.UserID = u.userid "
                    + "join parkinglots pl on pr.ParkingLotID = pl.ParkingLotID");

            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ReservationID"),
                        this.result.getInt("UserID"),
                        this.result.getInt("ParkingLotID"),
                        this.result.getString("reservationDate"),
                        this.result.getString("PoliceNumber"),
                        this.result.getString("locationID"),
                        this.result.getBoolean("IsAvailable")
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data: " + e);
        }
        return listOfReservations;
    }
    
    public ArrayList<Object> viewListDataType(String ParkingLotID) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("select pr.ReservationID, u.Username, pl.LocationName, "
                    + "pr.PoliceNumber, pr.LocationID as ParkingLotCode, pr.IsAvailable "
                    + "from parkingreservations pr"
                    + "join users u on pr.UserID = u.userid "
                    + "join parkinglots pl on pr.ParkingLotID = pl.ParkingLotID"
                    + "where pl.ParkingLotID = " + ParkingLotID);

            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ReservationID"),
                        this.result.getInt("UserID"),
                        this.result.getInt("ParkingLotID"),
                        this.result.getString("reservationDate"),
                        this.result.getString("PoliceNumber"),
                        this.result.getString("locationID"),
                        this.result.getBoolean("IsAvailable")
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data tipe: " + e);
        }
        return listOfReservations;
    }
}
