/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_parking;

import diceprox_main.MainForm;
/**
 *
 * @author Windows
 */
public class bookParkir2 extends javax.swing.JFrame {

    /**
     * Creates new form bookParkir2
     */
    public bookParkir2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        comboBoxLokasi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAcaraTabel = new javax.swing.JTable();
        denahParkir = new javax.swing.JLabel();
        reservationID = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        userID = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        parkingLotID = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        reservationDate = new javax.swing.JLabel();
        parkingLotIDText = new javax.swing.JTextField();
        PoliceNumber = new javax.swing.JLabel();
        policeNumberText = new javax.swing.JTextField();
        locationID = new javax.swing.JLabel();
        locationText = new javax.swing.JTextField();
        availableTicketText1 = new javax.swing.JTextField();
        availableReservationLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        nameLabel.setText("Pilih Lokasi");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 190, -1));

        comboBoxLokasi.setBackground(new java.awt.Color(207, 219, 229));
        comboBoxLokasi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        comboBoxLokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arif Rahman Hakim", "Mayjend Sungkono" }));
        comboBoxLokasi.setMinimumSize(new java.awt.Dimension(72, 20));
        comboBoxLokasi.setPreferredSize(new java.awt.Dimension(72, 20));
        comboBoxLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxLokasiActionPerformed(evt);
            }
        });
        getContentPane().add(comboBoxLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 75, 380, 70));

        jAcaraTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ReservationID", "UserID", "ParkingLotID", "ReservationDate", "PoliceNumber", "LocationID", "IsAvailable"
            }
        ));
        jAcaraTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcaraTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jAcaraTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 550, 860, 370));

        denahParkir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MayjendSungkono3x3.jpg"))); // NOI18N
        getContentPane().add(denahParkir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 50, 500, 450));

        reservationID.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reservationID.setForeground(new java.awt.Color(57, 62, 70));
        reservationID.setText("ReservationID");
        getContentPane().add(reservationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 250, -1));

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
        getContentPane().add(idText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 500, 67));

        userID.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        userID.setForeground(new java.awt.Color(57, 62, 70));
        userID.setText("UserID");
        getContentPane().add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 140, -1));

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
        getContentPane().add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 500, 67));

        parkingLotID.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingLotID.setForeground(new java.awt.Color(57, 62, 70));
        parkingLotID.setText("ParkingLotID");
        getContentPane().add(parkingLotID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 210, -1));

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
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 500, 67));

        reservationDate.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reservationDate.setForeground(new java.awt.Color(57, 62, 70));
        reservationDate.setText("Reservation Date");
        getContentPane().add(reservationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 290, -1));

        parkingLotIDText.setBackground(new java.awt.Color(207, 219, 229));
        parkingLotIDText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingLotIDText.setText("ParkingLotID");
        parkingLotIDText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                parkingLotIDTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                parkingLotIDTextFocusLost(evt);
            }
        });
        getContentPane().add(parkingLotIDText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 500, 67));

        PoliceNumber.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        PoliceNumber.setForeground(new java.awt.Color(57, 62, 70));
        PoliceNumber.setText("PoliceNumber");
        getContentPane().add(PoliceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, 230, -1));

        policeNumberText.setBackground(new java.awt.Color(207, 219, 229));
        policeNumberText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        policeNumberText.setText("Police Number");
        policeNumberText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                policeNumberTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                policeNumberTextFocusLost(evt);
            }
        });
        getContentPane().add(policeNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 650, 500, 67));

        locationID.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        locationID.setForeground(new java.awt.Color(57, 62, 70));
        locationID.setText("LocationID");
        getContentPane().add(locationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 760, 280, -1));

        locationText.setBackground(new java.awt.Color(207, 219, 229));
        locationText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        locationText.setText("Location ID");
        locationText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                locationTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationTextFocusLost(evt);
            }
        });
        getContentPane().add(locationText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 750, 500, 67));

        availableTicketText1.setBackground(new java.awt.Color(207, 219, 229));
        availableTicketText1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        availableTicketText1.setText("Available Tickets");
        availableTicketText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                availableTicketText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                availableTicketText1FocusLost(evt);
            }
        });
        getContentPane().add(availableTicketText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 850, 500, 67));

        availableReservationLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        availableReservationLabel1.setForeground(new java.awt.Color(57, 62, 70));
        availableReservationLabel1.setText("IsAvailable");
        getContentPane().add(availableReservationLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 860, 280, -1));

        submitButton.setBackground(new java.awt.Color(187, 224, 253));
        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 970, 250, 60));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        MainForm windowPlane = new MainForm();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void jAcaraTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcaraTabelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jAcaraTabelMouseClicked

    private void idTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idTextFocusGained
        if (idText.getText().equals("ID")) {
            idText.setText("");
        }
    }//GEN-LAST:event_idTextFocusGained

    private void idTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idTextFocusLost
        if (idText.getText().equals("")) {
            idText.setText("ID");
        }
    }//GEN-LAST:event_idTextFocusLost

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

    private void parkingLotIDTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotIDTextFocusGained
        if (parkingLotIDText.getText().equals("ParkingLotID")) {
            parkingLotIDText.setText("");
        }
    }//GEN-LAST:event_parkingLotIDTextFocusGained

    private void parkingLotIDTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotIDTextFocusLost
        if (parkingLotIDText.getText().equals("")) {
            parkingLotIDText.setText("ParkingLotID");
        }
    }//GEN-LAST:event_parkingLotIDTextFocusLost

    private void policeNumberTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_policeNumberTextFocusGained
        if (policeNumberText.getText().equals("Police Number")) {
            policeNumberText.setText("");
        }
    }//GEN-LAST:event_policeNumberTextFocusGained

    private void policeNumberTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_policeNumberTextFocusLost
        if (policeNumberText.getText().equals("")) {
            policeNumberText.setText("Police Number");
        }
    }//GEN-LAST:event_policeNumberTextFocusLost

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

    private void availableTicketText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_availableTicketText1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_availableTicketText1FocusGained

    private void availableTicketText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_availableTicketText1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_availableTicketText1FocusLost

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void comboBoxLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLokasiActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) comboBoxLokasi.getSelectedItem();
                
        String iconPath = "";
        if (selectedItem.equals("Arif Rahman Hakim")) {
            iconPath = "DiceProx_Project_Disprog\\Client\\src\\img\\ArifRahmanHakim4x2.jpg";
        } else if (selectedItem.equals("Mayjend Sungkono")) {
            iconPath = "DiceProx_Project_Disprog\\Client\\src\\img\\MayjendSungkono3x3.jpg";
        }
        
//        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
//        denahParkir.setIcon(icon);
    }//GEN-LAST:event_comboBoxLokasiActionPerformed

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
            java.util.logging.Logger.getLogger(bookParkir2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookParkir2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookParkir2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookParkir2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookParkir2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PoliceNumber;
    private javax.swing.JLabel availableReservationLabel1;
    private javax.swing.JTextField availableTicketText1;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JComboBox<String> comboBoxLokasi;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel denahParkir;
    private javax.swing.JTextField idText;
    private javax.swing.JTable jAcaraTabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationID;
    private javax.swing.JTextField locationText;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel parkingLotID;
    private javax.swing.JTextField parkingLotIDText;
    private javax.swing.JTextField policeNumberText;
    private javax.swing.JLabel reservationDate;
    private javax.swing.JLabel reservationID;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel userID;
    // End of variables declaration//GEN-END:variables
}
