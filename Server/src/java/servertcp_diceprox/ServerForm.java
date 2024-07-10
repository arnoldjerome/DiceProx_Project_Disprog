/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package servertcp_diceprox;

import com.ticketing.model.Account;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ServerForm extends javax.swing.JFrame implements Runnable {

    
    String chatClient, chatServer;
    Account acc;
    String fullname, username, email, password, rePassword, regisDOB;
    String eventName, eventDate, eventLoc, ticketType, ticketQty, ticketPrice, totalPrice;
    String ticketId;
    String parkingLotName, parkingSlot, reservationDate, policeNumber;
    String parkingType, parkingPrice;
    String parkingId;
    Socket incoming;
    ServerSocket s;
    Thread t;
    ArrayList<HandleSocket> clients = new ArrayList<>();
    
    HandleSocket confirmClient;
    /**
     * Creates new form FormServer
     */
    public ServerForm() {
        try {
            initComponents();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            s = new ServerSocket(5005);
            //getChat();
            if (t == null) {
                t = new Thread(this, "ServerForm");
                t.start();
            }
        } catch (IOException ex) {
            System.out.println("Error di server form: " + ex);
        }
    }
    
    public void run() {
        try {
            while (true) {
                incoming = s.accept();
                HandleSocket hs = new HandleSocket(this, incoming);
                hs.start();
                hs.sendChat("Welcome to DiceProx!");
                
                if (confirmClient == null) {
                    System.out.println("masuk ini");
                    confirmClient = hs;
                }
                
                System.out.println("berhasil");
                clients.add(hs);
            }
        } catch (Exception e) {
            System.out.println("Error di run: " + e);
        }
    }
    
    public void showChat(String msg) {
        if (msg.contains("LOGIN~")) {
            String msgSplit[] = msg.split("~");
            username = msgSplit[1];
            email = msgSplit[2];
            password = msgSplit[3];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses melakukan login!" + "\n");
            broadCast(msg);
            
            //confirmClient.sendChat("Login sukses!");
            //confirmClient = null;
        }
        
        else if (msg.contains("REGISTER~")) {
            String msgSplit[] = msg.split("~");
            fullname = msgSplit[1];
            username = msgSplit[2];
            email = msgSplit[3];
            password = msgSplit[4];
            rePassword = msgSplit[5];
            regisDOB = msgSplit[6];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses melakukan registrasi!" + "\n");
            broadCast(msg);
            
            //confirmClient.sendChat("Registrasi sukses!");          
            //confirmClient = null;
        }
        
        else if (msg.contains("MENU_EVNT~")) {
            String msgSplit[] = msg.split("MENU_EVNT~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengakses menu event!" + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("DETAIL_EVNT~")) {
            String msgSplit[] = msg.split("~");
            eventName = msgSplit[1];
            username = msgSplit[2];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses membuka detail event " + eventName + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("CHOOSE_EVNT~")) {
            String msgSplit[] = msg.split("~");
            eventName = msgSplit[1];
            username = msgSplit[2];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses memilih event " + eventName + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("RESERVE_EVNT~")) {
            String msgSplit[] = msg.split("~");
            eventName = msgSplit[1];
            eventDate = msgSplit[2];
            eventLoc = msgSplit[3];
            ticketType = msgSplit[4];
            ticketQty = msgSplit[5];
            ticketPrice = msgSplit[6];
            totalPrice = msgSplit[7];
            username = msgSplit[8];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses melakukan reservasi event " + eventName + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("MENU_PRK~")) {
            String msgSplit[] = msg.split("MENU_PRK~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengakses menu parking!" + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("CHOOSE_PRK~")) {
            String msgSplit[] = msg.split("~");
            parkingLotName = msgSplit[1];
            parkingSlot = msgSplit[2];
            reservationDate = msgSplit[3];
            policeNumber = msgSplit[4];
            username = msgSplit[5];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses memilih parking slot " + parkingSlot + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("RESERVE_PRK")) {
            String msgSplit[] = msg.split("~");
            parkingLotName = msgSplit[1];
            reservationDate = msgSplit[2];
            policeNumber = msgSplit[3];
            parkingSlot = msgSplit[4];
            parkingType = msgSplit[5];
            parkingPrice = msgSplit[6];
            username = msgSplit[7];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses melakukan reservasi parking slot " + parkingSlot + " untuk tanggal " + reservationDate + " di " + parkingLotName + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("MENU_CLM~")) {
            String msgSplit[] = msg.split("MENU_CLM~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengakses menu klaim event ticket!" + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("EVNT_CLM_TIX~")) {
            String msgSplit[] = msg.split("~");
            ticketId = msgSplit[1];
            eventName = msgSplit[2];
            eventDate = msgSplit[3];
            username = msgSplit[4];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengklaim ticket event " + eventName + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("MENU_CHKOUT")) {
            String msgSplit[] = msg.split("MENU_CHKOUT~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengakses menu checkout parking ticket!" + "\n");
        }
        
        else if (msg.contains("PRK_CHKOUT_TIX~")) {
            String msgSplit[] = msg.split("~");
            parkingId = msgSplit[1];
            parkingSlot = msgSplit[2];
            policeNumber = msgSplit[3];
            parkingLotName = msgSplit[4];
            username = msgSplit[5];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses checkout ticket parking slot " + parkingSlot + " untuk plat nomor " + policeNumber + " di " + parkingLotName +"\n");
            broadCast(msg);
        }
        
        else if (msg.contains("ORD_TIX~")) {
            String msgSplit[] = msg.split("ORD_TIX~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses mengakses menu pemesanan ticket!" + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("LOGOUT~")) {
            String msgSplit[] = msg.split("LOGOUT~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses melakukan logout!" + "\n");
            broadCast(msg);
        }
        
        else if (msg.contains("EXIT~")) {
            String msgSplit[] = msg.split("EXIT~");
            username = msgSplit[1];
            
            chatTxt.append(msg + "\n");
            chatTxt.append(username + " sukses keluar dari aplikasi!" + "\n");
            broadCast(msg);
        }
        
        else {
            System.out.println("Error displaying page!");
        }
    }
    
    public void broadCast(String msg) {
        for (HandleSocket client : clients) {
            client.sendChat(msg);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatTxt = new javax.swing.JTextArea();
        salamLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(175, 186, 255));
        setMinimumSize(new java.awt.Dimension(790, 500));
        setPreferredSize(new java.awt.Dimension(721, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chatTxt.setColumns(20);
        chatTxt.setRows(5);
        jScrollPane1.setViewportView(chatTxt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 663, 360));

        salamLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        salamLabel.setForeground(new java.awt.Color(57, 62, 70));
        salamLabel.setText("SERVER");
        getContentPane().add(salamLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea chatTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel salamLabel;
    // End of variables declaration//GEN-END:variables

}
