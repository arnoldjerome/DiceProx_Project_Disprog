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

    private int TicketID;
    private int UserID;
    private int EventID;
    private int TicketTypeID;
    private int HargaTotal;
    private Timestamp ReservationDate;
    private Boolean IsClaimed;

    public Tickets(int TicketID, int UserID, int EventID, int TicketTypeID, int HargaTotal, Timestamp ReservationDate, Boolean IsClaimed) {
        this.TicketID = TicketID;
        this.UserID = UserID;
        this.EventID = EventID;
        this.TicketTypeID = TicketTypeID;
        this.HargaTotal = HargaTotal;
        this.ReservationDate = ReservationDate;
        this.IsClaimed = IsClaimed;
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
