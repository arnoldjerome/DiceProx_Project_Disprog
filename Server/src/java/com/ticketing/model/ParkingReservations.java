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
    private String ParkingLotName;
    private String Username;
    private String ParkingType;
    private int HargaParking;

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
    
    /**
     * @return the ParkingLotName
     */
    public String getParkingLotName() {
        return ParkingLotName;
    }

    /**
     * @param ParkingLotName the ParkingLotName to set
     */
    public void setParkingLotName(String ParkingLotName) {
        this.ParkingLotName = ParkingLotName;
    }
    
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getParkingType() {
        return ParkingType;
    }

    public void setParkingType(String ParkingType) {
        this.ParkingType = ParkingType;
    }
    
    public int getHargaParking() {
        return HargaParking;
    }

    public void setHargaParking(int HargaParking) {
        this.HargaParking = HargaParking;
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
    
    //formBookParking
    public ParkingReservations(String ParkingLotName, String ParkingSlot) {
        this.ParkingLotName = ParkingLotName;
        this.ParkingSlot = ParkingSlot;
    }
    
    //buatUpdate
    public ParkingReservations(int UserID, String ReservationDate, String PoliceNumber, int ReservationID) {
        this.UserID = UserID;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.ReservationID = ReservationID;
    }
    
    //formPemesanan
    public ParkingReservations(int ReservationID, String Username, String ParkingLotName, String ReservationDate, String PoliceNumber, String ParkingSlot, String ParkingType, int HargaParking) {
        this.ReservationID = ReservationID;
        this.Username = Username;
        this.ParkingLotName = ParkingLotName;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.ParkingSlot = ParkingSlot;
        this.ParkingType = ParkingType;
        this.HargaParking = HargaParking;
    }
    
    //formBookParkir (cons method pengecekan ReservationDate, ParkingSlot)
    public ParkingReservations(int ParkingLotID, String ParkingSlot, String ReservationDate) {
        this.ParkingLotID = ParkingLotID;
        this.ParkingSlot = ParkingSlot;
        this.ReservationDate = ReservationDate;
    }

    //formKonfirmasiBook (method viewListDataKonfirmasi)
    public ParkingReservations(int ParkingLotID, String ParkingLotName, String ParkingSlot, int HargaParking, String ParkingType) {
        this.ParkingLotID = ParkingLotID;
        this.ParkingLotName = ParkingLotName;
        this.ParkingSlot = ParkingSlot;
        this.HargaParking = HargaParking;
        this.ParkingType = ParkingType;
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
    
    public void updateBookingReservation(){
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "UPDATE parkingreservations SET UserID=?, ReservationDate=?, PoliceNumber=?, IsAvailable=0 WHERE ReservationID= ?");
                
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
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                    "UPDATE parkingreservations SET UserID = ?, ReservationDate = ?, PoliceNumber = ? " +
                    "WHERE ReservationID = ?");
                sql.setInt(1, this.UserID);
                sql.setString(2, this.ReservationDate);
                sql.setString(3, this.PoliceNumber);
                sql.setInt(4, this.ReservationID);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di updateData: " + e);
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
    
    //formBookParkir
    public ArrayList<Object> viewListDataType(int ParkingLotID, String ReservationDate) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("SELECT pl.ParkingLotID, pl.ParkingLotName, tp.ParkingSlot FROM parkinglots pl LEFT JOIN typeparkings tp ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID AND pr.ReservationDate = " + (ReservationDate) + " WHERE pl.ParkingLotID = " + (ParkingLotID+1) + " AND pr.ReservationID IS NULL GROUP BY pl.ParkingLotID, pl.ParkingLotName, tp.ParkingSlot;");
              

            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getString("ParkingLotName"),
                        this.result.getString("ParkingSlot")
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data tipe: " + e);
        }
        return listOfReservations;
    }
    
    //formKonfirmasiBookParkir
    public ArrayList<Object> viewListDataConfirm(String ReservationDate, int ParkingLotID, String ParkingSlot) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("select pl.ParkingLotID, pl.ParkingLotName, tp.ParkingSlot, tp.HargaParking, tp.ParkingType FROM parkinglots pl LEFT JOIN typeparkings tp ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID AND pr.ReservationDate = " + (ReservationDate) + " WHERE pl.ParkingLotID = " + (ParkingLotID+1) + " AND tp.ParkingSlot = '" + ParkingSlot + "' GROUP BY pl.ParkingLotName, tp.ParkingSlot;");
              
            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ParkingLotID"),
                        this.result.getString("ParkingLotName"),
                        this.result.getString("ParkingSlot"),
                        this.result.getInt("HargaParking"),
                        this.result.getString("ParkingType") 
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data konfirm: " + e);
        }
        return listOfReservations;
    }
    
    public ArrayList<Object> viewListDataPemesanan(int UserID) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("select pr.ReservationID, u.Username, pl.ParkingLotName, pr.ReservationDate, pr.PoliceNumber, tp.ParkingSlot, tp.ParkingType, tp.HargaParking from parkingreservations pr left join users u on pr.UserID = u.UserID left join parkinglots pl on pr.ParkingLotID = pl.ParkingLotID left join typeparkings tp on pr.TypeParkingID = tp.TypeParkingID where u.UserID = " + (UserID));
              
            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                        this.result.getInt("ReservationID"),
                        this.result.getString("Username"),
                        this.result.getString("ParkingLotName"),
                        this.result.getString("ReservationDate"),
                        this.result.getString("PoliceNumber"),
                        this.result.getString("ParkingSlot"),
                        this.result.getString("ParkingType"),
                        this.result.getInt("HargaParking")
                        
                );
                listOfReservations.add(pr);
            }
        } catch (Exception e) {
            System.out.println("Error di view list data pemesanan: " + e);
        }
        return listOfReservations;
    }
    
    public String fetchReservationDate(String ReservationDate, int ParkingLotID, String ParkingSlot) {
        try {
            String reservationDate = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT pl.ParkingLotName, tp.ParkingSlot, pr.ReservationDate FROM parkinglots pl LEFT JOIN typeparkings tp ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID AND pr.ReservationDate = ? WHERE pl.ParkingLotID = ? AND tp.ParkingSlot = ? GROUP BY pl.ParkingLotName, tp.ParkingSlot;");
                sql.setString(1, ReservationDate);
                sql.setInt(2, ParkingLotID+1);
                sql.setString(3, ParkingSlot);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    reservationDate = this.result.getString("ReservationDate");
                }
                return reservationDate;
            }
        } 
        catch (Exception e) {
            System.out.println("Error di fetch parking lot name: " + e);
        }
        return null;
    }
}
