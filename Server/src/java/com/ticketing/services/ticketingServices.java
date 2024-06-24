/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ticketing.services;

import com.ticketing.model.Account;
import com.ticketing.model.Events;
import com.ticketing.model.Tickets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @WebMethod(operationName = "insertTicket")
    @Oneway
    public void insertTicket(@WebParam(name = "ticketID") int ticketID, @WebParam(name = "userID") int userID, @WebParam(name = "eventID") int eventID, @WebParam(name = "ticketTypeID") int ticketTypeID, @WebParam(name = "hargaTotal") int hargaTotal, @WebParam(name = "isClaimed") boolean isClaimed) {
        t = new Tickets(ticketID, userID, eventID, ticketTypeID, hargaTotal, isClaimed);
        t.insertData();
    }

    @WebMethod
    public ArrayList<Events> selectAllEvents() {
        System.out.println("Calling selectAllEvents...");
        Events even = new Events();
        ArrayList<Events> eventList = new ArrayList<>();
        for (Object obj : even.viewListData()) {
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
        Events even = new Events();
        ArrayList<Events> eventList = new ArrayList<>();
        for (Object obj : even.viewListDataType(eventId)) {
            if (obj instanceof Events) {
                eventList.add((Events) obj);
            }
        }
        System.out.println("Returned event list with size: " + eventList.size());
        return eventList;
    }

}
