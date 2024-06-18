/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servertcp_diceprox.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rome
 */
public abstract class MyModel {
    // <editor-fold desc="Data Members">
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;
    // </editor-fold>

    // <editor-fold desc="Constructor">
    public MyModel(Statement statement, ResultSet result) {
        this.statement = statement;
        this.result = result;
    }

    public MyModel() {
        this.conn = this._getConnection();
        this.statement = null;
        this.result = null;
    }
// </editor-fold>

    // <editor-fold desc="Properties">
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        MyModel.conn = conn;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    // </editor-fold>
    
    // <editor-fold desc="Methods">
    private Connection _getConnection() {
        if (MyModel.conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost/diceprox_ticketing", "root", "");
            } catch (Exception ex) {
                System.out.println("Error di getConnection : " + ex);
            }
        }
        return MyModel.conn;
    }

    public abstract void insertData();

    public abstract void updateData();

    public abstract void deleteData();

    public abstract ArrayList<Object> viewListData();
    // </editor-fold>
}
