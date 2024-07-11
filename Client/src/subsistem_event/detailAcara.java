/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_event;

import com.ticketing.services.Events;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author asus
 */
public class detailAcara extends javax.swing.JFrame {

    private String eventId;

    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;

    /**
     * Creates new form detailAcara
     */
    public detailAcara(String eventId) {
        try {
            initComponents();

            this.eventId = eventId;

            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();

            //untuk center
            this.setLocationRelativeTo(null);

            // Maximize the frame
            setExtendedState(bookAcara.MAXIMIZED_BOTH);

            System.out.println(eventId);

            loadEventDetails(eventId);
        } catch (IOException ex) {
            System.out.println("Error di detail acara: " + ex);
        }
    }

    private void start() {
        if (t == null) {
            t = new Thread("detailAcara");
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

        gambarEvents = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLocationLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDetailTextArea = new javax.swing.JTextArea();
        eventLabel = new javax.swing.JLabel();
        viewOnMapButton = new javax.swing.JButton();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gambarEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/512.png"))); // NOI18N
        gambarEvents.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(gambarEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 510, 510));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconBack.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(120, 125));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 70, 70));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(57, 62, 70));
        nameLabel.setText("Event Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 630, -1));

        addressLocationLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        addressLocationLabel.setForeground(new java.awt.Color(57, 62, 70));
        addressLocationLabel.setText("Event Address + Event Location");
        getContentPane().add(addressLocationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 650, -1));

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(57, 62, 70));
        dateLabel.setText("Event Date");
        getContentPane().add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 630, -1));

        jScrollPane1.setForeground(new java.awt.Color(255, 204, 51));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jDetailTextArea.setEditable(false);
        jDetailTextArea.setColumns(20);
        jDetailTextArea.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jDetailTextArea.setLineWrap(true);
        jDetailTextArea.setRows(5);
        jDetailTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jDetailTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 1080, 400));

        eventLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(57, 62, 70));
        eventLabel.setText("EVENT DETAIL");
        getContentPane().add(eventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, -1));

        viewOnMapButton.setBackground(new java.awt.Color(187, 224, 253));
        viewOnMapButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        viewOnMapButton.setText("View On Map");
        viewOnMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOnMapButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewOnMapButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 810, 310, 60));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        bookAcara windowPlane = new bookAcara();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void viewOnMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOnMapButtonActionPerformed
        // Dapatkan event details termasuk latitude dan longitude

        Events event = getEventDetails(Integer.parseInt(eventId));

        if (event != null) {
            Double latitude = event.getLatitude();
            Double longitude = event.getLongitude();
            String eventId = String.valueOf(event.getEventID());

            viewMapAcara windowPlane = new viewMapAcara(eventId, latitude, longitude);

            if (windowPlane == null || !windowPlane.isVisible()) {
                windowPlane.setVisible(true);
            }

            this.dispose();

        } else {
            System.out.println("Event not found.");
        }
    }//GEN-LAST:event_viewOnMapButtonActionPerformed

    private void loadEventDetails(String eventId) {
        Events event = getEventDetails(Integer.parseInt(eventId));
        System.out.println(event);
        if (event != null) {
            nameLabel.setText(event.getEventName());
            dateLabel.setText(event.getEventDate());
            addressLocationLabel.setText(event.getEventAddress() + ", " + event.getEventLocation());
            jDetailTextArea.setText(event.getEventDetails());

            String namaGambar = event.getEventImage();
            gambarEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/" + namaGambar + ".png")));
        } else {
            System.out.println("Event not found.");
        }
    }

//    private void updateLabelSize(javax.swing.JLabel label, String text) {
//        label.setText(text);  // Mengatur teks pada JLabel
//        FontMetrics metrics = label.getFontMetrics(label.getFont());  // Mendapatkan metrik font
//        int width = metrics.stringWidth(text);  // Menghitung lebar teks
//        int height = metrics.getHeight();  // Menghitung tinggi teks
//
//        label.setPreferredSize(new Dimension(width, height));  // Mengatur ukuran preferensi JLabel
//        label.revalidate();  // Memperbarui tata letak komponen
//        label.repaint();  // Menggambar ulang komponen
//    }
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
            java.util.logging.Logger.getLogger(detailAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detailAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detailAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detailAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String eventId = "1";
                new detailAcara(eventId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLocationLabel;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JLabel gambarEvents;
    private javax.swing.JTextArea jDetailTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton viewOnMapButton;
    // End of variables declaration//GEN-END:variables

    private static Events getEventDetails(int eventId) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.getEventDetails(eventId);
    }

}
