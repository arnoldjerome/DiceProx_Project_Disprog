/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ticketing.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public abstract class MyModel {

    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;

    public MyModel() {
        this.conn = this._getConnection(); //akan dipakai di semua kelas yang terkoneksi database
        this.statement = null;
        this.result = null;
    }

    private Connection _getConnection() {
        //untuk koneksi ke alamat db
        if (MyModel.conn == null) { //jika pertama kali koneksi
            try {
                Class.forName(
                        "com.mysql.cj.jdbc.Driver")
                        .newInstance();
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost/diceprox_ticketing",
                        "root",
                        "");
            } catch (Exception e) {
                System.out.println("Error di getConnection : " + e);
            }
        }
        return MyModel.conn;
    }

    public abstract void insertData();

    public abstract void updateData();

    public abstract void deleteData();

    public abstract ArrayList<Object> viewListData();
}
