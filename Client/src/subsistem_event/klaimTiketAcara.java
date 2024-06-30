/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_event;

import com.ticketing.services.Events;
import diceprox_main.MainForm;
import diceprox_main.UserSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class klaimTiketAcara extends javax.swing.JFrame implements Runnable {
    
    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    /**
     * Creates new form klaimTiketAcara
     */
    public klaimTiketAcara() {        
        try {
            initComponents();
            
            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            // Maximize the frame
            setExtendedState(klaimTiketAcara.MAXIMIZED_BOTH);
        } catch (IOException ex) {
            System.out.println("Error di klaim tiket acara: " + ex);
        }
    }
    
    private void start() {
        if (t == null) {
            t = new Thread(this, "klaimTiketAcara");
            t.start();
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

        salamTiket = new javax.swing.JLabel();
        ticketText = new javax.swing.JTextField();
        cekButton = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salamTiket.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        salamTiket.setForeground(new java.awt.Color(57, 62, 70));
        salamTiket.setText("ENTER YOUR TICKET CODE");
        getContentPane().add(salamTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        ticketText.setBackground(new java.awt.Color(207, 219, 229));
        ticketText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ticketText.setText("Ticket Code");
        ticketText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ticketTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ticketTextFocusLost(evt);
            }
        });
        getContentPane().add(ticketText, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 1020, 67));

        cekButton.setBackground(new java.awt.Color(187, 224, 253));
        cekButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        cekButton.setText("Check");
        cekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cekButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 220, 210, 70));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconBack.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(120, 125));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 70, 70));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ticketTextFocusGained
        if (ticketText.getText().equals("Ticket Code")) {
            ticketText.setText("");
        }
    }//GEN-LAST:event_ticketTextFocusGained

    private void ticketTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ticketTextFocusLost
        if (ticketText.getText().equals("")) {
            ticketText.setText("Ticket Code");
        }
    }//GEN-LAST:event_ticketTextFocusLost

    private void cekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekButtonActionPerformed
        try {
            int ticketID = Integer.parseInt(ticketText.getText());
            int userIDClaimTicket = userIdForClaimTicket(ticketID);
            
            Date today = new Date();
            SimpleDateFormat todayDate = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = todayDate.format(today);
            
            String eventName = fetchEventName(ticketID);
            String eventDate = fetchEventDate(ticketID);
            
            if (userIDClaimTicket == UserSession.getUserId()) {
                
                if (currentDate.equals(eventDate)) {    
                    
                    if (checkClaimStatus(ticketID) == false) {
                        
                        String formattedMessage = "EVNT_CLM_TIX~" + ticketText.getText() + "~" + eventName + "~" + eventDate + "~" + UserSession.getUsername() + "\n";

                        updateClaimStatus(ticketID, UserSession.getUserId());

                        out.writeBytes(formattedMessage);

                        JOptionPane.showMessageDialog(this, "Sukses Mengklaim Ticket Event!", "Notification", JOptionPane.INFORMATION_MESSAGE);

    //                    MainForm windowPlane = new MainForm();
    //
    //                    if (windowPlane == null || !windowPlane.isVisible()) {
    //                        windowPlane.setVisible(true);
    //                    }
    //
    //                    this.dispose();
                    }

                    else {
                        JOptionPane.showMessageDialog(this, "Ticket Sudah Diklaim!", "Gagal Mengklaim Tiket", JOptionPane.WARNING_MESSAGE);
                    }        
                }

                else {
                    JOptionPane.showMessageDialog(this, "Ticket Hanya Bisa Diklaim Pada Tanggal Event Diadakan!", "Gagal Mengklaim Tiket", JOptionPane.WARNING_MESSAGE);
                }
            }
            
            else {
                JOptionPane.showMessageDialog(this, "Pastikan Kode Tiket Sudah Sesuai Dengan Reservasimu!", "Kode Tiket Tidak Valid", JOptionPane.WARNING_MESSAGE);
            }            
            
            ticketText.setText("Ticket Code");  
            ticketText.selectAll();
        } 
        
        catch (Exception e) {
            System.out.println("Error di button cek: " + e);
        }
    }//GEN-LAST:event_cekButtonActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        MainForm windowPlane = new MainForm();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

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
            java.util.logging.Logger.getLogger(klaimTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(klaimTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(klaimTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(klaimTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new klaimTiketAcara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JButton cekButton;
    private javax.swing.JLabel salamTiket;
    private javax.swing.JTextField ticketText;
    // End of variables declaration//GEN-END:variables

    private static void updateClaimStatus(int ticketID, int userID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.updateClaimStatus(ticketID, userID);
    }   
    
    private static int userIdForClaimTicket(int ticketID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.userIdForClaimTicket(ticketID);
    }
    
    private static String fetchEventName(int ticketID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.fetchEventName(ticketID);
    }
    
    private static String fetchEventDate(int ticketID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.fetchEventDate(ticketID);
    } 
    
    private static boolean checkClaimStatus(int ticketID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.checkClaimStatus(ticketID);
    }
    
    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
        }
    }
}
