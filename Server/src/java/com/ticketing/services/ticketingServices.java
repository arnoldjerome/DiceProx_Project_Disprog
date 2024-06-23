/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ticketing.services;

import account.Account;
import events.Events;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fransxeagle
 */
@WebService(serviceName = "ticketingServices")
public class ticketingServices {

    Account a;
    Events ev;

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
    @WebMethod(operationName = "checkLogin")
    public Boolean checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        a = new Account(username, password, email);
        return a.check_login(); //bisa true atau false
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
    
    
//    public ArrayList<Events> viewListData() {
//        //TODO write your implementation code here:
//        try {
//            ev = new Events();
//            ArrayList<Object> originalEventsList = ev.viewListData();
//            ArrayList<Events> listOfEvents = new ArrayList<>();
//
//            for (Object obj : originalEventsList) {
//                if (obj instanceof Events) {
//                    listOfEvents.add((Events)obj);
//                }
//            }
//
//            return listOfEvents;
//        } 
//
//        catch (Exception e) {
//            System.out.println("Error di view list data: " + e);
//        }
//
//        return null;
//    }

//    @WebMethod
//    public ArrayList<Events> selectAllEvents() {
//        System.out.println("Calling selectAllEvents...");
//        Events events = new Events();
//        ArrayList<Vehicle> vehicleList = new ArrayList<>();
//        for (Object obj : vehicle.viewListData()) {
//            if (obj instanceof Vehicle) {
//                vehicleList.add((Vehicle) obj);
//            }
//        }
//        System.out.println("Returned vehicle list with size: " + vehicleList.size());
//        return vehicleList;
//    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewListDataEvent")
    public ArrayList viewListDataEvent() {
        //TODO write your implementation code here:
        try {
            ev = new Events();
            ArrayList<Object> originalEventsList = ev.viewListData();
            ArrayList<Events> listOfEvents = new ArrayList<>();

            for (Object obj : originalEventsList) {
                if (obj instanceof Events) {
                    listOfEvents.add((Events)obj);
                }
            }

            return listOfEvents;
        } 

        catch (Exception e) {
            System.out.println("Error di view list data: " + e);
        }

        return null;
    }
}
