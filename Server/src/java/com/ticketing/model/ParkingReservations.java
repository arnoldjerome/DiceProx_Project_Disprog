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
    private String ParkingSlot;
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

    public String getParkingSlot() {
        return ParkingSlot;
    }

    public void setParkingSlot(String ParkingSlot) {
        this.ParkingSlot = ParkingSlot;
    }

    public Boolean getIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }

    public ParkingReservations(int ReservationID, int UserID, int ParkingLotID, String ReservationDate, String PoliceNumber, String ParkingSlot, Boolean IsAvailable) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.ParkingLotID = ParkingLotID;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.ParkingSlot = ParkingSlot;
        this.IsAvailable = IsAvailable;
    }
    
    public ParkingReservations(int ReservationID, int UserID, int ParkingLotID, String ReservationDate, String PoliceNumber, String ParkingSlot) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.ParkingLotID = ParkingLotID;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.ParkingSlot = ParkingSlot;
    }
    
    public ParkingReservations(int ReservationID, int ParkingLotID, String ParkingSlot) {
        this.ReservationID = ReservationID;
        this.ParkingLotID = ParkingLotID;
        this.ParkingSlot = ParkingSlot;
    }

    public ParkingReservations() {
    }
    
    public void updateCheckOutReservations(int ReservationID, int UserID) {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "UPDATE parkingreservations SET UserID=null, ReservationDate=null, PoliceNumber=null, "
                                + "IsAvailable='1' WHERE ReservationID= ? and UserID=?");
                sql.setInt(1, ReservationID);
                sql.setInt(2, UserID);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di update check out reservations: " + e);
        }
    }
    
    public int userIdForCheckOut(int ReservationID) {
        try {
            int userId = 0;
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "SELECT pr.UserID FROM parkingreservations pr INNER JOIN users u ON pr.UserID = u.UserID WHERE pr.ReservationID = ?");
                sql.setInt(1, ReservationID);
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    userId = this.result.getInt("UserID");
                }
                
                return userId;
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di user check out reservationid: " + e);
        }
        
        return 0;
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
    
    //Query dicoba di SQL bisa cuman di RefreshTable ngga muncul
    public ArrayList<Object> viewListDataType(int ParkingLotID) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
//                this.result = this.statement.executeQuery("select pr.ReservationID, pr.UserID, pr.ParkingLotID, "
//                    + "pr.PoliceNumber, pr.LocationID as ParkingLotCode "
//                    + "from parkingreservations pr"
//                    + "left join users u on pr.UserID = u.userid "
//                    + "join parkinglots pl on pr.ParkingLotID = pl.ParkingLotID"
//                    + "where pl.ParkingLotID = " + ParkingLotID + "and pr.UserID is null");
                this.result = this.statement.executeQuery("SELECT pr.ReservationID, pl.LocationName, tp.ParkingSlot FROM parkinglots pl LEFT JOIN typeparkings tp ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID WHERE pl.ParkingLotID = " + (ParkingLotID+1) + " AND pr.UserID IS NULL GROUP BY pr.ReservationID, pl.LocationName, tp.ParkingSlot, pl.TotalSlots;");
              

            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ReservationID"),
                        this.result.getInt("LocationName"),
                        this.result.getString("ParkingSlot")
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data tipe: " + e);
        }
        return listOfReservations;
    }
}
