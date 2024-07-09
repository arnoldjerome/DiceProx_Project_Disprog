/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ticketing.services;

import com.ticketing.model.Account;
import com.ticketing.model.Events;
import com.ticketing.model.HistoryLogin;
import com.ticketing.model.Tickets;
import com.ticketing.model.ParkingReservations;
import com.ticketing.model.ParkingLots;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sun.security.krb5.internal.Ticket;

/**
 *
 * @author fransxeagle
 */
@WebService(serviceName = "ticketingServices")
public class ticketingServices {

    Account a;
    Events ev;
    Tickets t;
    HistoryLogin h;
    ParkingReservations pr;
    ParkingLots pl;
            
    public ticketingServices() {
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkLoginAndGetUserId")
    public int checkLoginAndGetUserId(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
        a = new Account(username, password, email);
        return a.check_login_and_get_user_id();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkRegister")
    public Boolean checkRegister(@WebParam(name = "email") String email) {
        a = new Account(email);
        return a.check_register(email);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertAccRegist")
    @Oneway
    public void insertAccRegist(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "fullname") String fullname, @WebParam(name = "email") String email, @WebParam(name = "dateOfBirth") String dateOfBirth) {
        a = new Account(username, password, fullname, email, dateOfBirth);
        a.insertData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateAvailableTickets")
    @Oneway
    public void updateAvailableTickets(@WebParam(name = "ticketTypeID") int ticketTypeID,
            @WebParam(name = "ticketsReserved") int ticketsReserved) {
        t = new Tickets();
        t.updateAvailableTickets(ticketTypeID, ticketsReserved);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertTicket")
    @Oneway
    public void insertTicket(@WebParam(name = "ticketID") int ticketID, @WebParam(name = "userID") int userID, @WebParam(name = "eventID") int eventID, @WebParam(name = "ticketTypeID") int ticketTypeID, @WebParam(name = "jumlahTiket") int jumlahTiket, @WebParam(name = "hargaTotal") int hargaTotal, @WebParam(name = "isClaimed") boolean isClaimed) {
        t = new Tickets(ticketID, userID, eventID, ticketTypeID, jumlahTiket, hargaTotal, isClaimed);
        t.insertData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertHistoryLogin")
    @Oneway
    public void insertHistoryLogin(@WebParam(name = "userID") int userID) {
        h = new HistoryLogin(userID);
        h.insertData();
    }

    @WebMethod
    public ArrayList<Events> selectAllEvents() {
        System.out.println("Calling selectAllEvents...");
        ev = new Events();
        ArrayList<Events> eventList = new ArrayList<>();
        for (Object obj : ev.viewListData()) {
            if (obj instanceof Events) {
                eventList.add((Events) obj);
            }
        }
        System.out.println("Returned event list with size: " + eventList.size());
        return eventList;
    }

    @WebMethod
    public ArrayList<Events> selectAllEventsType(String eventId) {
        System.out.println("Calling selectAllEventsType...");
        ev = new Events();
        ArrayList<Events> eventList = new ArrayList<>();
        for (Object obj : ev.viewListDataType(eventId)) {
            if (obj instanceof Events) {
                eventList.add((Events) obj);
            }
        }
        System.out.println("Returned event list with size: " + eventList.size());
        return eventList;
    }

    @WebMethod
    public ArrayList<Tickets> selectAllTicketUser(String userID) {
        System.out.println("Calling selectAllTicketUser...");
        t = new Tickets();
        ArrayList<Tickets> ticketList = new ArrayList<>();
        for (Object obj : t.viewListData(userID)) {
            if (obj instanceof Tickets) {
                ticketList.add((Tickets) obj);
            }
        }
        System.out.println("Returned ticket list with size: " + ticketList.size());
        return ticketList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getEventDetails")
    public Events getEventDetails(@WebParam(name = "eventId") int eventId) {
        ev = new Events();
        return ev.getEventDetails(eventId);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateClaimStatus")
    @Oneway
    public void updateClaimStatus(@WebParam(name = "ticketID") int ticketID, @WebParam(name = "userID") int userID) {
        t = new Tickets();
        t.updateClaimStatus(ticketID, userID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetchEventDate")
    public String fetchEventDate(@WebParam(name = "ticketID") int ticketID) {
        //TODO write your implementation code here:
        t = new Tickets();
        String eventDate = t.fetchEventDate(ticketID);
        
        return eventDate;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetchEventName")
    public String fetchEventName(@WebParam(name = "ticketID") int ticketID) {
        //TODO write your implementation code here:
        t = new Tickets();
        String eventName = t.fetchEventName(ticketID);
        
        return eventName;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkClaimStatus")
    public boolean checkClaimStatus(@WebParam(name = "ticketID") int ticketID) {
        //TODO write your implementation code here:
        t = new Tickets();
        boolean statusClaimed = t.checkClaimStatus(ticketID);
        
        return statusClaimed;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "userIdForClaimTicket")
    public int userIdForClaimTicket(@WebParam(name = "ticketID") int ticketID) {
        //TODO write your implementation code here:
        t = new Tickets();
        int userId = t.userIdForClaimTicket(ticketID);
        
        return userId;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectAllUserTicketID")
    public ArrayList<Integer> selectAllUserTicketID(@WebParam(name = "userID") int userID) {
        //TODO write your implementation code here:
        t = new Tickets();
        ArrayList<Integer> listOfTicketIDs = new ArrayList<>();
        for (Integer ticketID : t.selectAllUserTicketID(userID)) {
            if (ticketID instanceof Integer) {
                listOfTicketIDs.add(ticketID);
            }
        }   
        return listOfTicketIDs;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectAllReservationsType")
    public ArrayList<ParkingReservations> selectAllReservationsType(@WebParam(name = "ParkingLotID") int ParkingLotID, @WebParam(name = "ReservationDate") String ReservationDate) {
        System.out.println("Calling selectAllReservationsType...");
        pr = new ParkingReservations();
        ArrayList<ParkingReservations> reservationsList = new ArrayList<>();
        for (Object obj : pr.viewListDataType(ParkingLotID, ReservationDate)) {
            if (obj instanceof ParkingReservations) {
                reservationsList.add((ParkingReservations) obj);
            }
        }
        System.out.println("Returned reservations list with size: " + reservationsList.size());
        return reservationsList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateCheckOutReservation")
    @Oneway
    public void updateCheckOutReservation(@WebParam(name = "ReservationID") int ReservationID, @WebParam(name = "UserID") int UserID) {
        pr = new ParkingReservations();
        pr.updateCheckOutReservations(ReservationID, UserID);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "userIdForCheckOut")
    public int userIdForCheckOut(@WebParam(name = "ReservationID") int ReservationID) {
        pr = new ParkingReservations();
        int userID = pr.userIdForCheckOut(ReservationID);
        
        return userID;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectAllReservationsConfirm")
    public ArrayList<ParkingReservations> selectAllReservationsConfirm(@WebParam(name = "ReservationID") int ReservationID) {
        System.out.println("Calling selectAllReservationsConfirm...");
        pr = new ParkingReservations();
        ArrayList<ParkingReservations> reservationsList = new ArrayList<>();
        for (Object obj : pr.viewListDataConfirm(ReservationID)) {
            if (obj instanceof ParkingReservations) {
                reservationsList.add((ParkingReservations) obj);
            }
        }
        System.out.println("Returned reservations list with size: " + reservationsList.size());
        return reservationsList;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateParking")
    @Oneway
    public void updateParking(@WebParam(name = "UserID") int UserID, @WebParam(name = "ReservationDate") String ReservationDate, @WebParam(name = "NumberPolice") String NumberPolice, @WebParam(name = "ReservationID") int ReservationID) {
        pr = new ParkingReservations(UserID, ReservationDate, NumberPolice, ReservationID);
        pr.updateData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateBookingReservation")
    @Oneway
    public void updateBookingReservation(@WebParam(name = "UserID") int UserID, @WebParam(name = "ReservationDate") String ReservationDate, @WebParam(name = "NumberPolice") String NumberPolice, @WebParam(name = "ReservationID") int ReservationID) {
        pr = new ParkingReservations(UserID, ReservationDate, NumberPolice, ReservationID);
        pr.updateData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "selectAllReservationPemesanan")
    public ArrayList<ParkingReservations> selectAllReservationPemesanan(@WebParam(name = "UserID") int UserID) {
        System.out.println("Calling selectAllReservationPemesanan...");
        pr = new ParkingReservations();
        ArrayList<ParkingReservations> reservationsList = new ArrayList<>();
        for (Object obj : pr.viewListDataPemesanan(UserID)) {
            if (obj instanceof ParkingReservations) {
                reservationsList.add((ParkingReservations) obj);
            }
        }
        System.out.println("Returned reservations list with size: " + reservationsList.size());
        return reservationsList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fetchReservationDate")
    public String fetchReservationDate(@WebParam(name = "ReservationDate") String ReservationDate, @WebParam(name = "ParkingLotID") int ParkingLotID, @WebParam(name = "ParkingSlot") String ParkingSlot) {
        pr = new ParkingReservations();
        String reservationDate = pr.fetchReservationDate(ReservationDate, ParkingLotID, ParkingSlot);
        
        return reservationDate;
    }
    
}
