/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package account;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.MyModel;

/**
 *
 * @author Rome
 */
public class Account extends MyModel {

    // <editor-fold desc="Data Members">
    private int UserID;
    private String Username;
    private String Password;
    private String Fullname;
    private String Email;
    private Timestamp DateOfBirth;
    // </editor-fold>

    // <editor-fold desc="Constructors">
    public Account(int UserID, String Username, String Password, String Email, Timestamp DateOfBirth) {
        this.UserID = UserID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.DateOfBirth = DateOfBirth;
    }

    //untuk login constructors
    public Account(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    //untuk register constructors check email
    public Account(String Email) {
        this.Email = Email;
    }

    //untuk register constructors
    public Account(String Username, String Password, String Fullname, String Email, Timestamp DateOfBirth) {
        this.Username = Username;
        this.Password = Password;
        this.Fullname = Fullname;
        this.Email = Email;
        this.DateOfBirth = DateOfBirth;
    }
    // </editor-fold>

    // <editor-fold desc="Properties">
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Timestamp getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Timestamp DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }
    // </editor-fold>

    // <editor-fold desc="Methods">
    public boolean check_login() {
        boolean status = false;
        try {
            if (!MyModel.conn.isClosed()) { //jika sudah terbentuk koneksi
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT * FROM users WHERE Username = ? AND Password = ?"
                );

                sql.setString(1, this.Username);
                sql.setString(2, this.Password);
                this.result = sql.executeQuery();
                if (this.result.next()) {
                    status = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error di check login : " + e);
        }
        return status;
    }

    public boolean check_register() {
        boolean status = false;
        try {
            if (!MyModel.conn.isClosed()) { //jika sudah terbentuk koneksi
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT * FROM users WHERE Email = ?"
                );

                sql.setString(1, this.Email);
                this.result = sql.executeQuery();
                if (this.result.next()) {
                    status = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error di check login : " + e);
        }
        return status;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) { //jika sudah terbentuk koneksi
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "INSERT into users(Username, Password, Fullname, Email, DateOfBirth)"
                        + "VALUES(?, ?, ?, ?, ?)");

                sql.setString(1, this.Username);
                sql.setString(2, this.Password);
                sql.setString(3, this.Fullname);
                sql.setString(4, this.Email);
                sql.setString(5, String.valueOf(this.DateOfBirth));
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception e) {
            System.out.println("Error di insert data : " + e);
        }
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
        ArrayList<Object> collections = new ArrayList<>();
        try {
            // Kode di dalam blok try
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        return collections;
    }
// </editor-fold>
}
