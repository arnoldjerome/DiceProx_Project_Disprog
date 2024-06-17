/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.MyModel;

/**
 *
 * @author Rome
 */
public class Events extends MyModel{
    int EventID;
    private String EventName;
    private Date EventDate;
    private String EventLocation;
    int Quota;
    int VIPQuota;
    int FestivalQuota;
    int TribunQuota;
    private Timestamp created_at;

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

    public int getQuota() {
        return Quota;
    }

    public void setQuota(int Quota) {
        this.Quota = Quota;
    }

    public int getVIPQuota() {
        return VIPQuota;
    }

    public void setVIPQuota(int VIPQuota) {
        this.VIPQuota = VIPQuota;
    }

    public int getFestivalQuota() {
        return FestivalQuota;
    }

    public void setFestivalQuota(int FestivalQuota) {
        this.FestivalQuota = FestivalQuota;
    }

    public int getTribunQuota() {
        return TribunQuota;
    }

    public void setTribunQuota(int TribunQuota) {
        this.TribunQuota = TribunQuota;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Events(int EventID, String EventName, Date EventDate, String EventLocation, int Quota, int VIPQuota, int FestivalQuota, int TribunQuota, Timestamp created_at) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.Quota = Quota;
        this.VIPQuota = VIPQuota;
        this.FestivalQuota = FestivalQuota;
        this.TribunQuota = TribunQuota;
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
