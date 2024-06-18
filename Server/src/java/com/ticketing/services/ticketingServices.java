/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ticketing.services;

import account.Account;
import java.sql.Timestamp;
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
    public Boolean checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        a = new Account(username, password);
        return a.check_login(); //bisa true atau false
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkRegister")
    public Boolean checkRegister(@WebParam(name = "email") String email) {
        a = new Account(email);
        return a.check_register();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertDataRegister")
    @Oneway
    public void insertDataRegister(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "fullname") String fullName, @WebParam(name = "email") String email, @WebParam(name = "dateOfBirth") Timestamp dateOfBirth) {
        a = new Account(username, password, fullName, email, dateOfBirth);
        a.insertData();
    }

    /**
     * Web ser
     * /*
    @WebMethod(operationName = "insertData")
    public void insertData(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "dateOfBirth") Timestamp dateOfBirth) {
        //TODO write your implementation code here:
        a = new Account(username, password, email, dateOfBirth);
        a.insertData();
    }
    * */
}
