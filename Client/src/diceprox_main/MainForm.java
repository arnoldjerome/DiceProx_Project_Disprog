/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package diceprox_main;

import javax.swing.JOptionPane;
import subsistem_event.bookAcara;
import subsistem_event.bookAcara;
import subsistem_event.bookAcara;
import subsistem_event.klaimTiketAcara;
import subsistem_parking.bookParkir;

/**
 *
 * @author Yosef
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form mainForm
     */
    public MainForm() {
        initComponents();

        //untuk center
        this.setLocationRelativeTo(null);

        // Maximize the frame
        setExtendedState(MainForm.MAXIMIZED_BOTH);

        namaLabel.setText(UserSession.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        logoParking = new javax.swing.JLabel();
        logoEvent = new javax.swing.JLabel();
        parkingTicketButton = new javax.swing.JButton();
        eventTicketButton = new javax.swing.JButton();
        sambutanLabel2 = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        klaimTicketButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 62, 70));
        jLabel1.setText("DICEPROX TICKET SERVICE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(57, 62, 70));
        jLabel3.setText("Welcome to our service, what would you do today?");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        logoParking.setBackground(new java.awt.Color(187, 187, 187));
        logoParking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoParking.png"))); // NOI18N
        getContentPane().add(logoParking, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 330, 430, 410));

        logoEvent.setBackground(new java.awt.Color(187, 187, 187));
        logoEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoEvent.png"))); // NOI18N
        getContentPane().add(logoEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 430, 410));

        parkingTicketButton.setBackground(new java.awt.Color(187, 224, 253));
        parkingTicketButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingTicketButton.setText("Find Parking Lot");
        parkingTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parkingTicketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(parkingTicketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 780, 360, 110));

        eventTicketButton.setBackground(new java.awt.Color(187, 224, 253));
        eventTicketButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        eventTicketButton.setText("Find Event Tickets");
        eventTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventTicketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(eventTicketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 780, 360, 110));

        sambutanLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        sambutanLabel2.setForeground(new java.awt.Color(57, 62, 70));
        sambutanLabel2.setText("Hello");
        sambutanLabel2.setToolTipText("");
        getContentPane().add(sambutanLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 160, -1, -1));

        namaLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        namaLabel.setForeground(new java.awt.Color(57, 62, 70));
        namaLabel.setText("Akun Tamu");
        namaLabel.setToolTipText("");
        getContentPane().add(namaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 160, -1, -1));

        logoutButton.setBackground(new java.awt.Color(187, 224, 253));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 150, 150, -1));

        klaimTicketButton.setBackground(new java.awt.Color(187, 224, 253));
        klaimTicketButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        klaimTicketButton.setText("Claim Ticket");
        klaimTicketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klaimTicketButtonActionPerformed(evt);
            }
        });
        getContentPane().add(klaimTicketButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 80, 310, -1));

        exitButton.setBackground(new java.awt.Color(187, 224, 253));
        exitButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 150, 150, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parkingTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parkingTicketButtonActionPerformed
        bookParkir windowPlane = new bookParkir();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_parkingTicketButtonActionPerformed

    private void eventTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventTicketButtonActionPerformed
        bookAcara windowPlane = new bookAcara();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_eventTicketButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            // Reset user session
            UserSession.resetSession();

            // Buka form login
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);

            // Tutup form utama (MainForm)
            this.dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            // Reset user session
            UserSession.resetSession();

            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void klaimTicketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klaimTicketButtonActionPerformed
        klaimTiketAcara windowPlane = new klaimTiketAcara();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_klaimTicketButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JButton eventTicketButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton klaimTicketButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoEvent;
    private javax.swing.JLabel logoParking;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton parkingTicketButton;
    private javax.swing.JLabel sambutanLabel2;
    // End of variables declaration//GEN-END:variables
}
