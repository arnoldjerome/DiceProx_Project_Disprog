/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servertcp_diceprox;

/**
 *
 * @author asus
 */
public class UserSession {

    private static int userId;
    private static String username = "Guest Default"; // Nilai default
    private static String email = "Guest Default";

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserSession.userId = userId;
    }

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
        userId = -1;
        username = null;
        email = null;
    }
}
