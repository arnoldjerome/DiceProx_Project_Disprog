/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public class Tickets extends MyModel {

    private int TicketID;
    private int UserID;
    private int EventID;
    private int TicketTypeID;
    private int JumlahTiket;
    private int HargaTotal;
    private String ReservationDate;
    private Boolean IsClaimed;
    private String Username;
    private String EventName;
    private String TicketType;

    public Tickets(int TicketID, int UserID, int EventID, int TicketTypeID, int HargaTotal, String ReservationDate, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketTypeID = TicketTypeID;
        this.HargaTotal = HargaTotal;
        this.ReservationDate = ReservationDate;
        this.IsClaimed = IsClaimed;
    }

    public Tickets(int TicketID, int UserID, int EventID, int TicketTypeID, int JumlahTiket, int HargaTotal, String ReservationDate, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketTypeID = TicketTypeID;
        this.JumlahTiket = JumlahTiket;
        this.HargaTotal = HargaTotal;
        this.ReservationDate = ReservationDate;
        this.IsClaimed = IsClaimed;
    }

    public Tickets(int TicketID, int UserID, int EventID, int TicketTypeID, int JumlahTiket, int HargaTotal, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketTypeID = TicketTypeID;
        this.JumlahTiket = JumlahTiket;
        this.HargaTotal = HargaTotal;
        this.IsClaimed = IsClaimed;
    }

    public Tickets(int TicketID, String Username, String EventName, String TicketType, int JumlahTiket, int HargaTotal, String ReservationDate, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.Username = Username;
        this.EventName = EventName;
        this.TicketType = TicketType;
        this.JumlahTiket = JumlahTiket;
        this.HargaTotal = HargaTotal;
        this.ReservationDate = ReservationDate;
        this.IsClaimed = IsClaimed;
    }
    
    public Tickets(int TicketID) {
        this.TicketID = TicketID;
    }

    public Tickets() {

    }

    public int getTicketID() {
        return TicketID;
    }

    public void setTicketID(int TicketID) {
        this.TicketID = TicketID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public int getTicketTypeID() {
        return TicketTypeID;
    }

    public void setTicketTypeID(int TicketTypeID) {
        this.TicketTypeID = TicketTypeID;
    }

    public int getHargaTotal() {
        return HargaTotal;
    }

    public void setHargaTotal(int HargaTotal) {
        this.HargaTotal = HargaTotal;
    }

    public int getJumlahTiket() {
        return JumlahTiket;
    }

    public void setJumlahTiket(int JumlahTiket) {
        this.JumlahTiket = JumlahTiket;
    }

    public String getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(String ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public Boolean getIsClaimed() {
        return IsClaimed;
    }

    public void setIsClaimed(Boolean IsClaimed) {
        this.IsClaimed = IsClaimed;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public void updateAvailableTickets(int ticketTypeID, int ticketsReserved) {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "UPDATE typetickets SET AvailableTickets = AvailableTickets - ? WHERE TypeTicketID = ?");
                sql.setInt(1, ticketsReserved);
                sql.setInt(2, ticketTypeID);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di update available tickets: " + e);
        }
    }
    
    public void updateClaimStatus(int ticketID, int userID) {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "UPDATE tickets SET IsClaimed=1 WHERE TicketID=? AND UserID=?;");
                sql.setInt(1, ticketID);
                sql.setInt(2, userID);
                sql.executeUpdate();
                sql.close();
            }
        } 
        catch (Exception e) {
            System.out.println("Error di update claim status: " + e);
        }
    }
    
    public String fetchEventName(int ticketID) {
        try {
            String eventName = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT e.EventName"
                    + "FROM tickets t "
                    + "INNER JOIN events e "
                    + "ON t.EventID = e.EventID "
                    + "WHERE t.TicketID = ?");
                sql.setInt(1, ticketID);
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    return this.result.getString(eventName);
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di fetch event name: " + e);
        }
        
        return null;
    }
    
    public String fetchEventDate(int ticketID) {
        try {
            String eventDate = "";
            
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT e.EventDate"
                    + "FROM tickets t "
                    + "INNER JOIN events e "
                    + "ON t.EventID = e.EventID "
                    + "WHERE t.TicketID = ?");
                sql.setInt(1, ticketID);
                this.result = sql.executeQuery();
                
                if (this.result.next()) {
                    return this.result.getString(eventDate);
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di fetch event date: " + e);
        }
        
        return null;
    }
    
    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "INSERT INTO tickets (TicketID, UserID, EventID, TypeTicketID, JumlahTiket, HargaTotal, IsClaimed) VALUES (?, ?, ?, ?, ?, ?, ?)");

                sql.setInt(1, this.getTicketID());
                sql.setInt(2, this.getUserID());
                sql.setInt(3, this.getEventID());
                sql.setInt(4, this.getTicketTypeID());
                sql.setInt(5, this.getJumlahTiket());
                sql.setInt(6, this.getHargaTotal());
                sql.setBoolean(7, this.getIsClaimed());

                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di insert data: " + e);
        }
    }

    @Override
    public void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public ArrayList<Object> viewListData(String userID) {
//        ArrayList<Object> listOfTickets = new ArrayList<>();
//        try {
//
//            this.statement = (Statement) MyModel.conn.createStatement();
//            this.result = this.statement.executeQuery(
//                    "SELECT TicketID, UserID, EventID, TypeTicketID, JumlahTiket, HargaTotal, ReservationDate, IsClaimed "
//                    + "FROM tickets "
//                    + "WHERE UserID = " + userID);
//
//            while (this.result.next()) {
//                Tickets t = new Tickets(
//                        this.result.getInt("TicketID"),
//                        this.result.getInt("UserID"),
//                        this.result.getInt("EventID"),
//                        this.result.getInt("TypeTicketID"),
//                        this.result.getInt("JumlahTiket"),
//                        this.result.getInt("HargaTotal"),
//                        this.result.getString("ReservationDate"),
//                        this.result.getBoolean("IsClaimed")
//                );
//                listOfTickets.add(t);
//
//            }
//
//        } catch (Exception e) {
//            System.out.println("Error di view list data: " + e);
//        }
//
//        return listOfTickets;
//    }
    public ArrayList<Object> viewListData(String userID) {
        ArrayList<Object> listOfTickets = new ArrayList<>();
        try {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery(
                    "SELECT t.TicketID, u.Username, e.EventName, tt.TicketType, t.JumlahTiket, t.HargaTotal, t.ReservationDate, t.IsClaimed "
                    + "FROM tickets t "
                    + "JOIN users u ON t.UserID = u.UserID "
                    + "JOIN events e ON t.EventID = e.EventID "
                    + "JOIN typeTickets tt ON t.TypeTicketID = tt.TypeTicketID "
                    + "WHERE u.UserID = " + userID);

            while (this.result.next()) {
                Tickets t = new Tickets(
                        this.result.getInt("TicketID"),
                        this.result.getString("Username"),
                        this.result.getString("EventName"),
                        this.result.getString("TicketType"),
                        this.result.getInt("JumlahTiket"),
                        this.result.getInt("HargaTotal"),
                        this.result.getString("ReservationDate"),
                        this.result.getBoolean("IsClaimed")
                );
                listOfTickets.add(t);
            }

        } catch (Exception e) {
            System.out.println("Error di view list data: " + e);
        }

        return listOfTickets;
    }

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
