/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import servertcp_diceprox.model.MyModel;

/**
 *
 * @author Rome
 */
public class Events extends MyModel {

    // <editor-fold desc="Data Members">
    private int EventID;
    private String EventName;
    private Date EventDate;
    private String EventLocation;
    // </editor-fold>

    // <editor-fold desc="Constructors">
    public Events(int EventID, String EventName, Date EventDate, String EventLocation) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
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

    public Date getEventDate() {
        return EventDate;
    }

    public void setEventDate(Date EventDate) {
        this.EventDate = EventDate;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String EventLocation) {
        this.EventLocation = EventLocation;
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

    @Override
    public ArrayList<Object> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // </editor-fold>

}
