/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.Date;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public class Events extends MyModel {

    // <editor-fold desc="Data Members">
    private int EventID;
    private String EventName;
    private String EventDate;
    private String EventLocation;
    private int TotalQuota;
    private int AvailableTickets;
    // </editor-fold>

    // <editor-fold desc="Constructors">
    public Events(int EventID, String EventName, String EventDate, String EventLocation, int TotalQuota, int AvailableTickets) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.TotalQuota = TotalQuota;
        this.AvailableTickets = AvailableTickets;
    }

    public Events() {

    }
    // </editor-fold>

    // <editor-fold desc="Properties">
    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String EventDate) {
        this.EventDate = EventDate;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String EventLocation) {
        this.EventLocation = EventLocation;
    }

    public int getTotalQuota() {
        return TotalQuota;
    }

    public void setTotalQuota(int TotalQuota) {
        this.TotalQuota = TotalQuota;
    }

    public int getAvailableTickets() {
        return AvailableTickets;
    }

    public void setAvailableTickets(int AvailableTickets) {
        this.AvailableTickets = AvailableTickets;
    }
    // </editor-fold>

    // <editor-fold desc="Methods">
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

    public ArrayList<Object> viewListData() {
        ArrayList<Object> listOfEvents = new ArrayList<>();
        try {
//            // untuk select
//            // statement -> create statement -> resultset
//            this.statement = (Statement) MyModel.conn.createStatement();
//            this.result = this.statement.executeQuery("SELECT * FROM events");
//
//            while (this.result.next()) {
//                Events ev = new Events(
//                        this.result.getInt("EventID"),
//                        this.result.getString("EventName"),
//                        this.result.getString("EventDate"),
//                        this.result.getString("EventLocation")
//                );
//
//                listOfVehicles.add(ev);

            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery(
                    //                    "SELECT e.EventID, e.EventName, e.EventDate, e.EventLocation, t.TotalQuota, t.AvailableTickets "
                    //                    + "FROM events e "
                    //                    + "JOIN typeTickets t ON e.EventID = t.EventID");

                    "SELECT e.EventID, e.EventName, e.EventDate, e.EventLocation, "
                    + "SUM(t.TotalQuota) AS TotalQuota, "
                    + "SUM(t.AvailableTickets) AS AvailableTickets "
                    + "FROM events e "
                    + "JOIN typeTickets t ON e.EventID = t.EventID "
                    + "GROUP BY e.EventID, e.EventName, e.EventDate, e.EventLocation");

            while (this.result.next()) {
                Events ev = new Events(
                        this.result.getInt("EventID"),
                        this.result.getString("EventName"),
                        this.result.getString("EventDate"),
                        this.result.getString("EventLocation"),
                        this.result.getInt("TotalQuota"),
                        this.result.getInt("AvailableTickets")
                );
                listOfEvents.add(ev);

            }

        } catch (Exception e) {
            System.out.println("Error di view list data: " + e);
        }

        return listOfEvents;
    }
    // </editor-fold>

}
