/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.PreparedStatement;
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

    public Tickets(int TicketID, int UserID, int EventID, int TicketTypeID, int HargaTotal, String ReservationDate, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketTypeID = TicketTypeID;
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

    public void set(int HargaTotal) {
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

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "INSERT INTO tickets (TicketID, UserID, EventID, TypeTicketID, JumlahTiket, HargaTotal, IsClaimed) VALUES (?, ?, ?, ?, ?, ?)");

                sql.setInt(1, this.TicketID);
                sql.setInt(2, this.UserID);
                sql.setInt(3, this.EventID);
                sql.setInt(4, this.TicketTypeID);
                sql.setInt(5, this.JumlahTiket);
                sql.setInt(6, this.HargaTotal);
                sql.setBoolean(7, this.IsClaimed);

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

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
