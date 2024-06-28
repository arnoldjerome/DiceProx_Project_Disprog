/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.Date;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rome
 */
public class Events extends MyModel {

    // <editor-fold desc="Data Members">
    private int TypeTicketID;
    private int EventID;
    private String EventName;
    private String EventDate;
    private String EventLocation;
    private int TotalQuota;
    private int AvailableTickets;
    private String TicketType;
    private int HargaTikets;
    private String EventDetails;
    private String EventImage;
    // </editor-fold>

    // <editor-fold desc="Constructors">
    public Events(int TypeTicketID, String EventName, String EventDate, String EventLocation, String TicketType, int HargaTikets, int TotalQuota, int AvailableTickets) {
        this.TypeTicketID = TypeTicketID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.TicketType = TicketType;
        this.HargaTikets = HargaTikets;
        this.TotalQuota = TotalQuota;
        this.AvailableTickets = AvailableTickets;
    }

    public Events(int EventID, String EventName, String EventDate, String EventLocation, int TotalQuota, int AvailableTickets) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.TotalQuota = TotalQuota;
        this.AvailableTickets = AvailableTickets;
    }

    public Events(int EventID, String EventName, String EventDate, String EventLocation, String EventDetails, String EventImage, int TotalQuota, int AvailableTickets) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.EventDetails = EventDetails;
        this.EventImage = EventImage;
        this.TotalQuota = TotalQuota;
        this.AvailableTickets = AvailableTickets;
    }

    public Events() {

    }
    // </editor-fold>

    // <editor-fold desc="Properties">
    public int getTypeTicketID() {
        return TypeTicketID;
    }

    public void setTypeTicketID(int TypeTicketID) {
        this.TypeTicketID = TypeTicketID;
    }

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

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String TicketType) {
        this.TicketType = TicketType;
    }

    public int getHargaTikets() {
        return HargaTikets;
    }

    public void setHargaTikets(int HargaTikets) {
        this.HargaTikets = HargaTikets;
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

    public String getEventDetails() {
        return EventDetails;
    }

    public void setEventDetails(String EventDetails) {
        this.EventDetails = EventDetails;
    }

    public String getEventImage() {
        return EventImage;
    }

    public void setEventImage(String EventImage) {
        this.EventImage = EventImage;
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

    public ArrayList<Object> viewListDataType(String eventId) {
        ArrayList<Object> listOfEvents = new ArrayList<>();
        try {

            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery(
                    "SELECT t.TypeTicketID, e.EventName, e.EventDate, e.EventLocation, t.TicketType, t.HargaTikets, t.TotalQuota, t.AvailableTickets "
                    + "FROM events e "
                    + "JOIN typeTickets t ON e.EventID = t.EventID "
                    + "WHERE e.EventID = " + eventId);

            while (this.result.next()) {
                Events ev = new Events(
                        this.result.getInt("TypeTicketID"),
                        this.result.getString("EventName"),
                        this.result.getString("EventDate"),
                        this.result.getString("EventLocation"),
                        this.result.getString("TicketType"),
                        this.result.getInt("HargaTikets"),
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

    public Events getEventDetails(int eventId) {
        Events eventDetails = null;
        try {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery(
                    "SELECT e.EventID, e.EventName, e.EventDate, e.EventLocation, e.EventDetails, e.EventImage, "
                    + "SUM(t.TotalQuota) AS TotalQuota, "
                    + "SUM(t.AvailableTickets) AS AvailableTickets "
                    + "FROM events e "
                    + "JOIN typeTickets t ON e.EventID = t.EventID "
                    + "WHERE e.EventID = " + eventId
                    + " GROUP BY e.EventID, e.EventName, e.EventDate, e.EventLocation");

            if (this.result.next()) {
                eventDetails = new Events(
                        this.result.getInt("EventID"),
                        this.result.getString("EventName"),
                        this.result.getString("EventDate"),
                        this.result.getString("EventLocation"),
                        this.result.getString("EventDetails"),
                        this.result.getString("EventImage"),
                        this.result.getInt("TotalQuota"),
                        this.result.getInt("AvailableTickets")
                );
            }
        } catch (Exception e) {
            System.out.println("Error di getEventDetails: " + e);
        }
        return eventDetails;
    }

    // </editor-fold>
}
