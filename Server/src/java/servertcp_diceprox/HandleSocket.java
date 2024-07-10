package servertcp_diceprox;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HandleSocket extends Thread {
    
    ServerForm parent;
    Socket client;
    DataOutputStream out;
    BufferedReader in;
    boolean running = true;
    
    public HandleSocket(ServerForm _parent, Socket _client) {
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
        while (running) {
            try {
                String msg = in.readLine();
                if (msg == null) {
                    running = false;
                    break;
                }
                parent.showChat(msg);
            } catch (Exception e) {
                System.out.println("Error di run HS : " + e);
                running = false;
            }
        }
        try {
            client.close();
        } catch (Exception e) {
            System.out.println("Error closing client socket: " + e);
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
