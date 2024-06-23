/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public class Tickets extends MyModel {
    int TicketID;
    int UserID;
    int EventID;
    private String TicketType;
    private Timestamp ReservationDate;
    private Boolean IsClaimed;
    private Timestamp created_at;

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

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public Timestamp getReservationDate() {
        return ReservationDate;
    }

    public void setReservationDate(Timestamp ReservationDate) {
        this.ReservationDate = ReservationDate;
    }

    public Boolean getIsClaimed() {
        return IsClaimed;
    }

    public void setIsClaimed(Boolean IsClaimed) {
        this.IsClaimed = IsClaimed;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Tickets(int TicketID, int UserID, int EventID, String TicketType, Timestamp ReservationDate, Boolean IsClaimed, Timestamp created_at) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketType = TicketType;
        this.ReservationDate = ReservationDate;
        this.IsClaimed = IsClaimed;
        this.created_at = created_at;
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
