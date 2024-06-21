/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ticketing.services;

import account.Account;
import java.sql.Timestamp;
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
}
