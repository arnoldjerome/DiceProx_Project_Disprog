/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diceprox_main;

/**
 *
 * @author asus
 */
public class UserSession {
    private static String username = "Guest Default"; // Nilai default
    private static String email = "Guest Default";
    
    public static String getUsername() {
        return username;
    }
    
    public static String getEmail() {
        return email;
    }

    public static void setUsername(String username) {
        UserSession.username = username;
    }
    
    public static void setEmail(String email) {
        UserSession.email = email;
    }
    
    public static void resetSession() {
        username = null;
        email = null;
    }
}
