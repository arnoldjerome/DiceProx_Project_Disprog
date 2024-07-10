/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_parking;

import diceprox_main.MainForm;
import diceprox_main.UserSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows
 */
public class konfirmasiBookParking extends javax.swing.JFrame implements Runnable {

    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    
    private int parkingLotID;
    private String parkingSlot;
    private String reservationDate;
    private String plateNumber;
    int idUser = UserSession.getUserId();
    
    /**
     * Creates new form bookParkir2
     */
    public konfirmasiBookParking(int parkingLotID, String parkingSlot, String reservationDate, String plateNumber) {
        try {
            this.parkingLotID = parkingLotID;
            this.parkingSlot = parkingSlot;
            this.reservationDate = reservationDate;
            this.plateNumber = plateNumber;
            
            initComponents();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            // Maximize the frame
            setExtendedState(bookParking.MAXIMIZED_BOTH);
            
            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();
            
            refreshTable();
            dateText.setText(reservationDate);
            policeNumberText.setText(plateNumber);
            parkingSlotText.setText(parkingSlot);
            
            parkingLotNameText.setEditable(false);
            dateText.setEditable(false);
            policeNumberText.setEditable(false);
            parkingSlotText.setEditable(false);
            parkingTypeText.setEditable(false);
            
        } catch (IOException ex) {
            System.out.println("Error di Konfirmasi Book Parkir: " + ex);
        }
    }
    
    private void start() {
        if (t == null) {
            t = new Thread(this, "KonfirmasiBookParkir");
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

        back = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jParkingTabel = new javax.swing.JTable();
        parkingLotNameLabel = new javax.swing.JLabel();
        reservationDateLabel = new javax.swing.JLabel();
        dateText = new javax.swing.JTextField();
        PoliceNumber = new javax.swing.JLabel();
        policeNumberText = new javax.swing.JTextField();
        ParkingSlotLabel = new javax.swing.JLabel();
        parkingSlotText = new javax.swing.JTextField();
        parkingTypeText = new javax.swing.JTextField();
        parkingTypeLabel = new javax.swing.JLabel();
        ConfirmButton = new javax.swing.JButton();
        denahParkirArif = new javax.swing.JLabel();
        denahParkirMayjen = new javax.swing.JLabel();
        parkingLotNameText = new javax.swing.JTextField();
        eventLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        parkingPriceText = new javax.swing.JLabel();
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

        jParkingTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ParkingLotID", "ParkingLotName", "ParkingSlot", "ParkingPrice", "ParkingType"
            }
        ));
        jParkingTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jParkingTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jParkingTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 550, 860, 240));

        parkingLotNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingLotNameLabel.setForeground(new java.awt.Color(57, 62, 70));
        parkingLotNameLabel.setText("Parking Lot Name");
        getContentPane().add(parkingLotNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 310, -1));

        reservationDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reservationDateLabel.setForeground(new java.awt.Color(57, 62, 70));
        reservationDateLabel.setText("Reservation Date");
        getContentPane().add(reservationDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 290, -1));

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
        dateText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTextActionPerformed(evt);
            }
        });
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 500, 67));

        PoliceNumber.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        PoliceNumber.setForeground(new java.awt.Color(57, 62, 70));
        PoliceNumber.setText("Police Number");
        getContentPane().add(PoliceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 260, -1));

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
        getContentPane().add(policeNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 500, 67));

        ParkingSlotLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ParkingSlotLabel.setForeground(new java.awt.Color(57, 62, 70));
        ParkingSlotLabel.setText("Parking Slot");
        getContentPane().add(ParkingSlotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 280, -1));

        parkingSlotText.setBackground(new java.awt.Color(207, 219, 229));
        parkingSlotText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingSlotText.setText("Parking Slot");
        parkingSlotText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                parkingSlotTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                parkingSlotTextFocusLost(evt);
            }
        });
        getContentPane().add(parkingSlotText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 500, 67));

        parkingTypeText.setBackground(new java.awt.Color(207, 219, 229));
        parkingTypeText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingTypeText.setText("Parking Type");
        parkingTypeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                parkingTypeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                parkingTypeTextFocusLost(evt);
            }
        });
        getContentPane().add(parkingTypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, 500, 67));

        parkingTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingTypeLabel.setForeground(new java.awt.Color(57, 62, 70));
        parkingTypeLabel.setText("Parking Type");
        getContentPane().add(parkingTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, 280, -1));

        ConfirmButton.setBackground(new java.awt.Color(187, 224, 253));
        ConfirmButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ConfirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 830, 250, 60));

        denahParkirArif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ArifRahmanHakim4x2.jpg"))); // NOI18N
        getContentPane().add(denahParkirArif, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 500, 450));

        denahParkirMayjen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MayjendSungkono3x3.jpg"))); // NOI18N
        getContentPane().add(denahParkirMayjen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 500, 450));

        parkingLotNameText.setBackground(new java.awt.Color(207, 219, 229));
        parkingLotNameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        parkingLotNameText.setText("Parking Lot Name");
        parkingLotNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                parkingLotNameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                parkingLotNameTextFocusLost(evt);
            }
        });
        getContentPane().add(parkingLotNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 500, 67));

        eventLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(57, 62, 70));
        eventLabel.setText("CONFIRMATION RESERVATION");
        getContentPane().add(eventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(57, 62, 70));
        priceLabel.setText("Parking Price");
        getContentPane().add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 740, 280, -1));

        parkingPriceText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        parkingPriceText.setForeground(new java.awt.Color(240, 51, 51));
        parkingPriceText.setText("Rp .......");
        getContentPane().add(parkingPriceText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 740, 280, -1));

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

    private void jParkingTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jParkingTabelMouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jParkingTabel.getModel();
        int SelectedRows = jParkingTabel.getSelectedRow();
        
        parkingLotNameText.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        parkingSlotText.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        parkingPriceText.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        parkingTypeText.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        
        updateTotalHarga();
    }//GEN-LAST:event_jParkingTabelMouseClicked

    private void dateTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTextFocusGained
        if (dateText.getText().equals("ParkingLotID")) {
            dateText.setText("");
        }
    }//GEN-LAST:event_dateTextFocusGained

    private void dateTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dateTextFocusLost
        if (dateText.getText().equals("")) {
            dateText.setText("ParkingLotID");
        }
    }//GEN-LAST:event_dateTextFocusLost

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

    private void parkingSlotTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingSlotTextFocusGained
        if (parkingSlotText.getText().equals("Location")) {
            parkingSlotText.setText("");
        }
    }//GEN-LAST:event_parkingSlotTextFocusGained

    private void parkingSlotTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingSlotTextFocusLost
        if (parkingSlotText.getText().equals("")) {
            parkingSlotText.setText("Location");
        }
    }//GEN-LAST:event_parkingSlotTextFocusLost

    private void parkingTypeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingTypeTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_parkingTypeTextFocusGained

    private void parkingTypeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingTypeTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_parkingTypeTextFocusLost

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        try {
            int selectedRow = jParkingTabel.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih Reservation Parking terlebih dahulu.", "Kesalahan Reservasi", JOptionPane.WARNING_MESSAGE);
            } else {
                String formattedMessage = "RESERVE_PRK~" + parkingLotNameText.getText() + "~" + reservationDate + "~" + plateNumber + "~" + parkingSlot + "~" + parkingTypeText.getText() + "~" + parkingPriceText.getText() + "~" + UserSession.getUsername() + "\n";
               
                //ReservationID
                LocalDateTime now = LocalDateTime.now();

                int currentSecond = now.getSecond();
                int currentMinute = now.getMinute();
                int currentHour = now.getHour();
                int currentDay = now.getDayOfMonth();
                int currentMonth = now.getMonthValue();
                int currentYear = now.getYear() - 2000; // Assuming year 2000 as the starting point

                // Encode the components into a single int
                int reservationID = (currentYear << 26) | (currentMonth << 22) | (currentDay << 17)
                                 | (currentHour << 12) | (currentMinute << 6) | currentSecond;
                //UserID (ambil dari global variable)
                //ParkingLotID (ambil dari global variable)
                int parkingLotIDInsert = fetchParkingLotID(reservationDate, parkingLotID, parkingSlot);
                //TypeParkingID
                String typeParkingID = fetchTypeParkingID(reservationDate, parkingLotID, parkingSlot);
                //ReservationDate
                String date = dateText.getText();
                //PoliceNumber
                String nopol = policeNumberText.getText().trim().replace("-", " ").replace("_", " ");
                //Harga
                String numericString = parkingPriceText.getText().replace("Rp", "").replace(".", "").trim();
                //IsCheckOutStatus
                boolean statusCheckOut = false;
                
                insertDataReservation(reservationID, idUser, parkingLotIDInsert, typeParkingID, date, nopol, false);
                   
                JOptionPane.showMessageDialog(this, "Sukses Melakukan Reservasi!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Jangan lupa Check Out saat sudah keluar dari Parkiran!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                
                out.writeBytes(formattedMessage);
                
                MainForm windowPlane = new MainForm();

                    if (windowPlane == null || !windowPlane.isVisible()) {
                        windowPlane.setVisible(true);
                    }
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println("Error di button confirm book Parkir: " + e);
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void parkingLotNameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotNameTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_parkingLotNameTextFocusGained

    private void parkingLotNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotNameTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_parkingLotNameTextFocusLost

    private void dateTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateTextActionPerformed

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jParkingTabel.getModel();
        model.setRowCount(0); // Reset table

        Object[] rowData = new Object[5]; // Total kolom tampil

        // Mengambil data berdasarkan selectedIndex
        for (com.ticketing.services.ParkingReservations obj : selectAllReservationsConfirm(reservationDate, parkingLotID, parkingSlot)) {
            rowData[0] = obj.getParkingLotID();
            rowData[1] = obj.getParkingLotName();
            rowData[2] = obj.getParkingSlot();
            rowData[3] = obj.getHargaParking();
            rowData[4] = obj.getParkingType();
            model.addRow(rowData);
        }
    }
    
    private void updateTotalHarga() {
        try {
            double hargaParkir = Double.parseDouble(parkingPriceText.getText());

            // Format total harga menggunakan NumberFormat
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMAN);
            String formattedTotalHarga = numberFormat.format(hargaParkir);

            parkingPriceText.setText("Rp " + formattedTotalHarga);
        } catch (NumberFormatException e) {
            parkingPriceText.setText("Rp .......");
        }
    }
  
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
            java.util.logging.Logger.getLogger(konfirmasiBookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(konfirmasiBookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(konfirmasiBookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(konfirmasiBookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String ReservationDate = "";
                String ParkingSlot = "";
                String NumberPolice = "";
                int ParkingLotID = 0;
                new konfirmasiBookParking(ParkingLotID, ParkingSlot, ReservationDate, NumberPolice).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JLabel ParkingSlotLabel;
    private javax.swing.JLabel PoliceNumber;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel denahParkirArif;
    private javax.swing.JLabel denahParkirMayjen;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JTable jParkingTabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel parkingLotNameLabel;
    private javax.swing.JTextField parkingLotNameText;
    private javax.swing.JLabel parkingPriceText;
    private javax.swing.JTextField parkingSlotText;
    private javax.swing.JLabel parkingTypeLabel;
    private javax.swing.JTextField parkingTypeText;
    private javax.swing.JTextField policeNumberText;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel reservationDateLabel;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<com.ticketing.services.ParkingReservations> selectAllReservationsConfirm(java.lang.String reservationDate, int parkingLotID, java.lang.String parkingSlot) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.selectAllReservationsConfirm(reservationDate, parkingLotID, parkingSlot);
    }
       
    private static int fetchParkingLotID(java.lang.String reservationDate, int parkingLotID, java.lang.String parkingSlot) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.fetchParkingLotID(reservationDate, parkingLotID, parkingSlot);
    }

    private static String fetchTypeParkingID(java.lang.String reservationDate, int parkingLotID, java.lang.String parkingSlot) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.fetchTypeParkingID(reservationDate, parkingLotID, parkingSlot);
    }
    
    private static void insertDataReservation(int reservationID, int userID, int parkingLotID, java.lang.String typeParkingID, java.lang.String reservationDate, java.lang.String policeNumber, boolean isCheckedOut) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.insertDataReservation(reservationID, userID, parkingLotID, typeParkingID, reservationDate, policeNumber, isCheckedOut);
    }

    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
        }
    }
}
