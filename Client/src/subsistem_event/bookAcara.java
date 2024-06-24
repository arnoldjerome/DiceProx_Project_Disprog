/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_event;

import diceprox_main.MainForm;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yosef
 */
public class bookAcara extends javax.swing.JFrame {

    /**
     * Creates new form bookAcara
     */
    public bookAcara() {
        initComponents();

        refreshTable();

        //untuk center
        this.setLocationRelativeTo(null);

        // Maximize the frame
        setExtendedState(bookAcara.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reservationButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAcaraTabel = new javax.swing.JTable();
        back = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        totalQuotaLabel = new javax.swing.JLabel();
        availableReservationLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        totalQuotaText = new javax.swing.JTextField();
        locationText = new javax.swing.JTextField();
        availableTicketText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservationButton.setBackground(new java.awt.Color(187, 224, 253));
        reservationButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reservationButton.setText("Reservation");
        reservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationButtonActionPerformed(evt);
            }
        });
        getContentPane().add(reservationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 840, 360, 110));

        jAcaraTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Date", "Location", "Total Quota", "Available Tickets"
            }
        ));
        jAcaraTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcaraTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jAcaraTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 850, 910));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconBack.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(120, 125));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 70, 70));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(57, 62, 70));
        nameLabel.setText("Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 140, -1));

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(57, 62, 70));
        dateLabel.setText("Date");
        getContentPane().add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 140, -1));

        locationLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(57, 62, 70));
        locationLabel.setText("Location");
        getContentPane().add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 140, -1));

        totalQuotaLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalQuotaLabel.setForeground(new java.awt.Color(57, 62, 70));
        totalQuotaLabel.setText("Total Quota");
        getContentPane().add(totalQuotaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 190, -1));

        availableReservationLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        availableReservationLabel.setForeground(new java.awt.Color(57, 62, 70));
        availableReservationLabel.setText("Available Tickets");
        getContentPane().add(availableReservationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, 280, -1));

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        idLabel.setForeground(new java.awt.Color(57, 62, 70));
        idLabel.setText("ID");
        getContentPane().add(idLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 140, -1));

        idText.setBackground(new java.awt.Color(207, 219, 229));
        idText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        idText.setText("ID");
        idText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                idTextFocusLost(evt);
            }
        });
        getContentPane().add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 500, 67));

        totalQuotaText.setBackground(new java.awt.Color(207, 219, 229));
        totalQuotaText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalQuotaText.setText("Total Quota");
        totalQuotaText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                totalQuotaTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                totalQuotaTextFocusLost(evt);
            }
        });
        getContentPane().add(totalQuotaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 620, 500, 67));

        locationText.setBackground(new java.awt.Color(207, 219, 229));
        locationText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        locationText.setText("Location");
        locationText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                locationTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationTextFocusLost(evt);
            }
        });
        getContentPane().add(locationText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 500, 67));

        availableTicketText.setBackground(new java.awt.Color(207, 219, 229));
        availableTicketText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        availableTicketText.setText("Available Tickets");
        availableTicketText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                availableTicketTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                availableTicketTextFocusLost(evt);
            }
        });
        getContentPane().add(availableTicketText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 720, 500, 67));

        nameText.setBackground(new java.awt.Color(207, 219, 229));
        nameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        nameText.setText("Name");
        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameTextFocusLost(evt);
            }
        });
        getContentPane().add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 500, 67));

        dateText.setBackground(new java.awt.Color(207, 219, 229));
        dateText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dateText.setText("Date");
        dateText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dateTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dateTextFocusLost(evt);
            }
        });
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 500, 67));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationButtonActionPerformed
        // Pengecekan jika available tickets sudah habis
        if (availableTicketText.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Tickets are no longer available for this event.", "Reservation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            klaimTiketAcara windowPlane = new klaimTiketAcara();

            if (windowPlane == null || !windowPlane.isVisible()) {
                windowPlane.setVisible(true);
            }

            this.dispose();
        }
    }//GEN-LAST:event_reservationButtonActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        MainForm windowPlane = new MainForm();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void idTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idTextFocusGained
        if (idText.getText().equals("ID")) {
            idText.setText("");
        }
    }//GEN-LAST:event_idTextFocusGained

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jAcaraTabel.getModel();
        model.setRowCount(0);
        Object[] rowData = new Object[6]; //total kolom tampil

        for (com.ticketing.services.Events obj : selectAllEvents()) {
            rowData[0] = obj.getEventID();
            rowData[1] = obj.getEventName();
            rowData[2] = obj.getEventDate();
            rowData[3] = obj.getEventLocation();
            rowData[4] = obj.getTotalQuota();
            rowData[5] = obj.getAvailableTickets();
            model.addRow(rowData);
        }
    }

    private void idTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idTextFocusLost
        if (idText.getText().equals("")) {
            idText.setText("ID");
        }
    }//GEN-LAST:event_idTextFocusLost

    private void totalQuotaTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalQuotaTextFocusGained
        if (totalQuotaText.getText().equals("Total Quota")) {
            totalQuotaText.setText("");
        }
    }//GEN-LAST:event_totalQuotaTextFocusGained

    private void totalQuotaTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_totalQuotaTextFocusLost
        if (totalQuotaText.getText().equals("")) {
            totalQuotaText.setText("Total Quota");
        }
    }//GEN-LAST:event_totalQuotaTextFocusLost

    private void locationTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationTextFocusGained
        if (locationText.getText().equals("Location")) {
            locationText.setText("");
        }
    }//GEN-LAST:event_locationTextFocusGained

    private void locationTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationTextFocusLost
        if (locationText.getText().equals("")) {
            locationText.setText("Location");
        }
    }//GEN-LAST:event_locationTextFocusLost

    private void availableTicketTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_availableTicketTextFocusGained
        if (availableTicketText.getText().equals("Available Tickets")) {
            availableTicketText.setText("");
        }
    }//GEN-LAST:event_availableTicketTextFocusGained

    private void availableTicketTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_availableTicketTextFocusLost
        if (availableTicketText.getText().equals("")) {
            availableTicketText.setText("Available Tickets");
        }
    }//GEN-LAST:event_availableTicketTextFocusLost

    private void nameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusGained
        if (nameText.getText().equals("Name")) {
            nameText.setText("");
        }
    }//GEN-LAST:event_nameTextFocusGained

    private void nameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusLost
        if (nameText.getText().equals("")) {
            nameText.setText("Name");
        }
    }//GEN-LAST:event_nameTextFocusLost

    private void dateTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTextFocusGained
        if (dateText.getText().equals("Date")) {
            dateText.setText("");
        }
    }//GEN-LAST:event_dateTextFocusGained

    private void dateTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTextFocusLost
        if (dateText.getText().equals("")) {
            dateText.setText("Date");
        }
    }//GEN-LAST:event_dateTextFocusLost

    private void jAcaraTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcaraTabelMouseClicked
        // TODO add your handling code here:

        DefaultTableModel RecordTable = (DefaultTableModel) jAcaraTabel.getModel();
        int SelectedRows = jAcaraTabel.getSelectedRow();

        idText.setEditable(false);
        nameText.setEditable(false);
        dateText.setEditable(false);
        locationText.setEditable(false);
        totalQuotaText.setEditable(false);
        availableTicketText.setEditable(false);

        idText.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        nameText.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        dateText.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        locationText.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        totalQuotaText.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        availableTicketText.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    }//GEN-LAST:event_jAcaraTabelMouseClicked

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
            java.util.logging.Logger.getLogger(bookAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookAcara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availableReservationLabel;
    private javax.swing.JTextField availableTicketText;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idText;
    private javax.swing.JTable jAcaraTabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationText;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton reservationButton;
    private javax.swing.JLabel totalQuotaLabel;
    private javax.swing.JTextField totalQuotaText;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<com.ticketing.services.Events> selectAllEvents() {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.selectAllEvents();
    }
}
