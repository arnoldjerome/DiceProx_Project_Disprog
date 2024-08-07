/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Rome
 */
public class ParkingReservations extends MyModel {

    private int ReservationID;
    private int UserID;
    private int ParkingLotID;
    private String TypeParkingID;
    private String ReservationDate;
    private String PoliceNumber;
    private Boolean IsCheckedOut;
    private String ParkingSlot;
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

    public String getTypeParkingID() {
        return TypeParkingID;
    }

    public void setTypeParkingID(String TypeParkingID) {
        this.TypeParkingID = TypeParkingID;
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

    public Boolean getIsCheckedOut() {
        return IsCheckedOut;
    }

    public void setIsCheckedOut(Boolean IsCheckedOut) {
        this.IsCheckedOut = IsCheckedOut;
    }

    public String getParkingSlot() {
        return ParkingSlot;
    }

    public void setParkingSlot(String ParkingSlot) {
        this.ParkingSlot = ParkingSlot;
    }

    public String getParkingLotName() {
        return ParkingLotName;
    }

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
    
    //buatInsert
    public ParkingReservations(int ReservationID, int UserID, int ParkingLotID, String TypeParkingID, String ReservationDate, String PoliceNumber, Boolean IsCheckedOut) {
        this.ReservationID = ReservationID;
        this.UserID = UserID;
        this.ParkingLotID = ParkingLotID;
        this.TypeParkingID = TypeParkingID;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.IsCheckedOut = IsCheckedOut;
    }
    
    //formBookParking
    public ParkingReservations(String ParkingLotName, String ParkingSlot) {
        this.ParkingLotName = ParkingLotName;
        this.ParkingSlot = ParkingSlot;
    }
    
    //formPemesanan
    public ParkingReservations(int ReservationID, String Username, String ParkingLotName, String ReservationDate, String PoliceNumber, String ParkingSlot, String ParkingType, int HargaParking, Boolean IsCheckedOut) {
        this.ReservationID = ReservationID;
        this.Username = Username;
        this.ParkingLotName = ParkingLotName;
        this.ReservationDate = ReservationDate;
        this.PoliceNumber = PoliceNumber;
        this.ParkingSlot = ParkingSlot;
        this.ParkingType = ParkingType;
        this.HargaParking = HargaParking;
        this.IsCheckedOut = IsCheckedOut;
    }
    
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
    
    public boolean checkStatusCheckOut(int ReservationID) {
        try {
            int statusCheckOut = 0;
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT IsCheckedOut FROM parkingReservations WHERE ReservationID=?");
                sql.setInt(1, ReservationID); 
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    statusCheckOut = this.result.getInt("IsCheckedOut");
                    
                    if (statusCheckOut == 1) {
                        return true;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error di check status checkout: " + e);
        }
        
        return false;
    }
   
    //jadi update status IsCheckedOut
    public void updateCheckOutReservations(int ReservationID, int UserID) {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "UPDATE parkingreservations SET IsCheckedOut=1 WHERE ReservationID=? and UserID=?");
                sql.setInt(1, ReservationID);
                sql.setInt(2, UserID);
                sql.executeUpdate();
                sql.close();
                
                this.setIsCheckedOut((Boolean) true);
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
    
    public void insertDataReservation() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "INSERT INTO parkingreservations (ReservationID, UserID, ParkingLotID, TypeParkingID, ReservationDate, PoliceNumber, IsCheckedOut) VALUES (?, ?, ?, ?, ?, ?, ?);");

                sql.setInt(1, this.getReservationID());
                sql.setInt(2, this.getUserID());
                sql.setInt(3, this.getParkingLotID());
                sql.setString(4, this.getTypeParkingID());
                sql.setString(5, this.getReservationDate());
                sql.setString(6, this.getPoliceNumber());
                sql.setBoolean(7, this.getIsCheckedOut());

                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di insert data reservation: " + e);
        }
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
    
    public ArrayList<Object> viewListDataPemesananParking(int UserID) {
        ArrayList<Object> listOfReservations = new ArrayList<>();
        try {
             this.statement = (Statement) MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("SELECT pr.ReservationID, u.Username, pl.ParkingLotName, pr.ReservationDate, pr.PoliceNumber, tp.ParkingSlot, tp.ParkingType, tp.HargaParking, pr.IsCheckedOut FROM parkingreservations pr LEFT JOIN users u ON pr.UserID = u.UserID LEFT JOIN parkinglots pl ON pr.ParkingLotID = pl.ParkingLotID LEFT JOIN typeparkings tp ON pr.TypeParkingID = tp.TypeParkingID WHERE u.UserID = " + (UserID));
              
            while (this.result.next()) {
                ParkingReservations pr = new ParkingReservations(
                    this.result.getInt("ReservationID"),
                    this.result.getString("Username"),
                    this.result.getString("ParkingLotName"),
                    this.result.getString("ReservationDate"),
                    this.result.getString("PoliceNumber"),
                    this.result.getString("ParkingSlot"),
                    this.result.getString("ParkingType"),
                    this.result.getInt("HargaParking"),
                    this.result.getBoolean("IsCheckedOut")
                );
                
                listOfReservations.add(pr);
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di view list data pemesanan: " + e);
        }
        return listOfReservations;
    }
    
    public ArrayList<Integer> selectAllUserRSVID(int UserID) {
        ArrayList<Integer> listOfRSVID = new ArrayList<>();
        int rsvID = 0;
        
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                   "SELECT ReservationID FROM parkingreservations WHERE UserID=?");
                sql.setInt(1, UserID);
                this.result = sql.executeQuery();
                
                while (this.result.next()) {
                    rsvID = this.result.getInt("ReservationID");
                }
                
                listOfRSVID.add(rsvID);
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di select all reservation id: " + e);
        }
        
        return listOfRSVID;
    }
    
    public String fetchParkingSlot(int reservationID) {
        try {
            String parkingSlot = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT tp.ParkingSlot FROM typeparkings tp INNER JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID WHERE pr.ReservationID = ?");
                sql.setInt(1, reservationID);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    parkingSlot = this.result.getString("ParkingSlot");
                }
                
                return parkingSlot;
            }
        } catch (Exception e) {
            System.out.println("Error di fetch parking slot: " + e);
        }
        
        return null;
    }
    
    public String fetchPoliceNumber(int reservationID) {
        try {
            String policeNumber = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                     "SELECT pr.PoliceNumber FROM parkingreservations pr WHERE pr.ReservationID = ?");
                sql.setInt(1, reservationID);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    policeNumber = this.result.getString("PoliceNumber");
                }
                
                return policeNumber;
            }
        } catch (Exception e) {
            System.out.println("Error di fetch police number: " + e);
        }
        
        return null;
    }
    
    public String fetchParkingLotName(int reservationID) {
        try {
            String parkingLotName = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT pl.ParkingLotName FROM parkinglots pl INNER JOIN parkingreservations pr ON pl.ParkingLotID = pr.ParkingLotID WHERE pr.ReservationID = ?");
                sql.setInt(1, reservationID);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    parkingLotName = this.result.getString("ParkingLotName");
                }
                
                return parkingLotName;
            }
        } catch (Exception e) {
            System.out.println("Error di fetch parking lot name: " + e);
        }
        
        return null;
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
    
    public String fetchTypeParkingID(String ReservationDate, int ParkingLotID, String ParkingSlot) {
        try {
            String typeParkingID = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT tp.TypeParkingID FROM parkinglots pl LEFT JOIN typeparkings tp ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID AND pr.ReservationDate = ? WHERE pl.ParkingLotID = ? AND tp.ParkingSlot = ? GROUP BY pl.ParkingLotName, tp.ParkingSlot;");
                sql.setString(1, ReservationDate);
                sql.setInt(2, ParkingLotID+1);
                sql.setString(3, ParkingSlot);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    typeParkingID = this.result.getString("TypeParkingID");
                }
                return typeParkingID;
            }
        } 
        catch (Exception e) {
            System.out.println("Error di fetch parking lot name: " + e);
        }
        return null;
    }
    
    public int fetchParkingLotID(String ReservationDate, int ParkingLotID, String ParkingSlot) {
        try {
            int parkingLotID = 0;
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT tp.ParkingLotID FROM typeparkings tp LEFT JOIN parkinglots pl ON pl.ParkingLotID = tp.ParkingLotID LEFT JOIN parkingreservations pr ON tp.TypeParkingID = pr.TypeParkingID AND pr.ReservationDate = ? WHERE pl.ParkingLotID = ? AND tp.ParkingSlot = ? GROUP BY pl.ParkingLotName, tp.ParkingSlot;");
                sql.setString(1, ReservationDate);
                sql.setInt(2, ParkingLotID+1);
                sql.setString(3, ParkingSlot);
                
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    parkingLotID = this.result.getInt("ParkingLotID");
                }
                return parkingLotID;
            }
        } 
        catch (Exception e) {
            System.out.println("Error di fetch parking lot id: " + e);
        }
        return 0;
    }
    
    public String fetchReservationDateCheckOut(int ReservationID) {
        try {
            String reservationDate = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT ReservationDate FROM parkingreservations WHERE ReservationID=?");
                sql.setInt(1, ReservationID);          
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    Date rsv_date = this.result.getDate("ReservationDate");
                    SimpleDateFormat rsv_date_format = new SimpleDateFormat("yyyy-MM-dd");
                    reservationDate = rsv_date_format.format(rsv_date);
                }
                
                return reservationDate;
            }
        } 
        catch (Exception e) {
            System.out.println("Error di fetch reservation date check out: " + e);
        }
        
        return null;
    }
}
