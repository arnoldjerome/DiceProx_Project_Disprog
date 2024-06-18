/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servertcp_diceprox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class HandleSocket extends Thread {
    
    FormServer parent;
    Socket client;
    DataOutputStream out;
    BufferedReader in;
    
    public HandleSocket(FormServer _parent, Socket _client) {
        this.parent = _parent;
        this.client = _client;
        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println("Errornya di HS : " + e);
        }
    }
    
    public void run(){
        while (true) {
            try {
                String msg = in.readLine();
                parent.showChat(msg);
            } catch (Exception e) {
                System.out.println("Error di run HS : " + e);
            }
        }
    }
    public void sendChat(String msg) {
        try {
            out.writeBytes(msg + "\n");
        } catch (Exception e) {
            System.out.println("Error di sendChat: " + e);
        }
    }
}
