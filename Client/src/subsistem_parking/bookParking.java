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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;

/**
 *
 * @author Windows
 */
public class bookParking extends javax.swing.JFrame implements Runnable {

    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    
    int selectedIndex = 0;
    PlateNumberVerifier verifier = new PlateNumberVerifier();
    /**
     * Creates new form bookParkir
     */
    public bookParking() {
        try {
            initComponents();
            configurePlateNumberField();
            setDefaultDate();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            // Maximize the frame
            setExtendedState(bookParking.MAXIMIZED_BOTH);
            
            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();
            
            int index = comboBoxLokasi.getSelectedIndex();
            refreshTableLoadForm(index);
            refreshTableBasedOnDate(index);
            
            parkingLotNameText.setEditable(false);
            parkingSlotText.setEditable(false);
        } catch (IOException ex) {
            System.out.println("Error di Book Parkir: " + ex);
        }
    }
    
    public void start() {
        if (t == null) {
            t = new Thread(this, "BookParkir");
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
        nameLabel = new javax.swing.JLabel();
        comboBoxLokasi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jParkingTabel = new javax.swing.JTable();
        ParkingLotNameLabel = new javax.swing.JLabel();
        reservationDate = new javax.swing.JLabel();
        parkingLotNameText = new javax.swing.JTextField();
        PoliceNumber = new javax.swing.JLabel();
        ParkingSlotLabel = new javax.swing.JLabel();
        parkingSlotText = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        denahParkirArif = new javax.swing.JLabel();
        denahParkirMayjen = new javax.swing.JLabel();
        dateText = new com.toedter.calendar.JDateChooser();
        policeNumberText = new javax.swing.JFormattedTextField();
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

        jParkingTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ParkingLotName", "ParkingSlot"
            }
        ));
        jParkingTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jParkingTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jParkingTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 550, 860, 370));

        ParkingLotNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ParkingLotNameLabel.setForeground(new java.awt.Color(57, 62, 70));
        ParkingLotNameLabel.setText("Parking Lot Name");
        getContentPane().add(ParkingLotNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 300, -1));

        reservationDate.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reservationDate.setForeground(new java.awt.Color(57, 62, 70));
        reservationDate.setText("Reservation Date");
        getContentPane().add(reservationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 290, -1));

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
        getContentPane().add(parkingLotNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 500, 67));

        PoliceNumber.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        PoliceNumber.setForeground(new java.awt.Color(57, 62, 70));
        PoliceNumber.setText("Police Number");
        getContentPane().add(PoliceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 250, -1));

        ParkingSlotLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ParkingSlotLabel.setForeground(new java.awt.Color(57, 62, 70));
        ParkingSlotLabel.setText("Parking Slot");
        getContentPane().add(ParkingSlotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 280, -1));

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
        getContentPane().add(parkingSlotText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 500, 67));

        submitButton.setBackground(new java.awt.Color(187, 224, 253));
        submitButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 840, 250, 60));

        denahParkirArif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ArifRahmanHakim4x2.jpg"))); // NOI18N
        getContentPane().add(denahParkirArif, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 500, 450));

        denahParkirMayjen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MayjendSungkono3x3.jpg"))); // NOI18N
        getContentPane().add(denahParkirMayjen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 500, 450));

        dateText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 500, 70));

        policeNumberText.setBackground(new java.awt.Color(207, 219, 229));
        policeNumberText.setText("Police Number");
        policeNumberText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        policeNumberText.setPreferredSize(new java.awt.Dimension(298, 54));
        getContentPane().add(policeNumberText, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 505, 500, 60));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1920, 1080));

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
        
        parkingLotNameText.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        parkingSlotText.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    }//GEN-LAST:event_jParkingTabelMouseClicked

    private void parkingLotNameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotNameTextFocusGained
        if (parkingLotNameText.getText().equals("ParkingLotID")) {
            parkingLotNameText.setText("");
        }
    }//GEN-LAST:event_parkingLotNameTextFocusGained

    private void parkingLotNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_parkingLotNameTextFocusLost
        if (parkingLotNameText.getText().equals("")) {
            parkingLotNameText.setText("ParkingLotID");
        }
    }//GEN-LAST:event_parkingLotNameTextFocusLost

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

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            int selectedRow = jParkingTabel.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(this, "Pilih Parking Slot terlebih dahulu.", "Kesalahan Reservasi", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    selectedIndex = (int) comboBoxLokasi.getSelectedIndex();
                    //reservationDate
                    Date reservationDateObj = dateText.getDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String reservationDate = dateFormat.format(reservationDateObj);
                    //parkingSlot
                    String parkingSlot = parkingSlotText.getText();                               
                    //policeNumber
                    String plateNumber = policeNumberText.getText();
                    
                    String formattedMessage = "CHOOSE_PRK~" + parkingLotNameText.getText() + "~" + parkingSlotText.getText() + "~" + reservationDate + "~" + policeNumberText.getText() + "~" + UserSession.getUsername() + "\n";
                           
                    String chkReservationDate = fetchReservationDate(reservationDate, selectedIndex, parkingSlot);
                    
                    if (chkReservationDate == null) {
                        if (plateNumber == "Police Number") {
                            JOptionPane.showMessageDialog(this, "Silahkan isi Police Number terlebih dahulu", "Notification", JOptionPane.WARNING_MESSAGE);
                        } 
                        else if (verifier.verify((JComponent)policeNumberText)) {
                            JOptionPane.showMessageDialog(this, "Sukses Memilih Parking Slot!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                            
                            konfirmasiBookParking windowPlane = new konfirmasiBookParking(selectedIndex, parkingSlot, reservationDate, plateNumber);

                            if (windowPlane == null || !windowPlane.isVisible()) {
                                windowPlane.setVisible(true);
                            }

                            this.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Slot sudah terisi untuk tanggal ini", "Notification", JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
        } catch (Exception e) {
            System.out.println("Error di button book parkir: " + e);
            JOptionPane.showMessageDialog(this, "Error Melakukan Submit Data Parking !!");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void comboBoxLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxLokasiActionPerformed
        // TODO add your handling code here:
        selectedIndex = (int) comboBoxLokasi.getSelectedIndex();
        if(selectedIndex == 0)
        {
            denahParkirMayjen.setVisible(false);
            denahParkirArif.setVisible(true);

        }
        else{
            denahParkirArif.setVisible(false);
            denahParkirMayjen.setVisible(true);

        }
        refreshTableBasedOnDate(selectedIndex);
    }//GEN-LAST:event_comboBoxLokasiActionPerformed

    //RefreshTable sudah muncul di form
    public void refreshTableLoadForm(int selectedIndex) {
        if (selectedIndex == 0 || selectedIndex == 1) {
            DefaultTableModel model = (DefaultTableModel) jParkingTabel.getModel();
            model.setRowCount(0); // Reset table

            Object[] rowData = new Object[2]; // Total kolom tampil

            // Mengambil data berdasarkan selectedIndex
            for (com.ticketing.services.ParkingReservations obj : selectAllReservationsType(selectedIndex, convertDefaultDate())) {
                rowData[0] = obj.getParkingLotName();
                rowData[1] = obj.getParkingSlot();
                model.addRow(rowData);
            }
        } else {
            System.out.println("No item selected");
        }
    }
    
    public void refreshTableBasedOnDate(int selectedIndex) {
        if (selectedIndex == 0 || selectedIndex == 1) {
            DefaultTableModel model = (DefaultTableModel) jParkingTabel.getModel();
            model.setRowCount(0); // Reset table
            
            Date reservationDateObj = dateText.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String reservationDate = dateFormat.format(reservationDateObj);
            
            Object[] rowData = new Object[2]; // Total kolom tampil

            // Mengambil data berdasarkan selectedIndex
            for (com.ticketing.services.ParkingReservations obj : selectAllReservationsType(selectedIndex, reservationDate)) {
                rowData[0] = obj.getParkingLotName();
                rowData[1] = obj.getParkingSlot();
                model.addRow(rowData);
            }
        } else {
            System.out.println("No item selected");
        }
    }
    
    private void configurePlateNumberField() {
        try {
            // Define the mask with flexible parts
            MaskFormatter formatter = new MaskFormatter("UU-####-UUU");
            formatter.setPlaceholderCharacter('_');
            formatter.install(policeNumberText);  // Assume plateNumberField is your JFormattedTextField
        } catch (java.text.ParseException e) {
            System.out.println("error di verifier" + e);
        }

        // Add an input verifier for validation
        policeNumberText.setInputVerifier(new PlateNumberVerifier());
    }

    private class PlateNumberVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            JFormattedTextField policeNumberText = (JFormattedTextField) input;
            String text = policeNumberText.getText().trim().replaceAll("_", "").replaceAll("-", " ");

            // Regex to match the flexible format: 1-2 letters, 1-4 digits, 2-3 letters
            String regex = "^[A-Z]{1,2} \\d{1,4} [A-Z]{2,3}$";
            
            if (text.matches(regex)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    private Date getDefaultDate() {
        Date currentDate = new Date();
        return currentDate;
    }

    private void setDefaultDate() {
        dateText.setDate(new Date());
    }

    private String convertDefaultDate() {
        Date currentDate = getDefaultDate();
        SimpleDateFormat todayDate = new SimpleDateFormat("yyyy-MM-dd");
        String defaultDate = todayDate.format(currentDate);

        return defaultDate;
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
            java.util.logging.Logger.getLogger(bookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookParking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new bookParking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ParkingLotNameLabel;
    private javax.swing.JLabel ParkingSlotLabel;
    private javax.swing.JLabel PoliceNumber;
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JComboBox<String> comboBoxLokasi;
    private com.toedter.calendar.JDateChooser dateText;
    private javax.swing.JLabel denahParkirArif;
    private javax.swing.JLabel denahParkirMayjen;
    private javax.swing.JTable jParkingTabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField parkingLotNameText;
    private javax.swing.JTextField parkingSlotText;
    private javax.swing.JFormattedTextField policeNumberText;
    private javax.swing.JLabel reservationDate;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<com.ticketing.services.ParkingReservations> selectAllReservationsType(int parkingLotID, java.lang.String reservationDate) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.selectAllReservationsType(parkingLotID, reservationDate);
    } 

    private static String fetchReservationDate(java.lang.String reservationDate, int parkingLotID, java.lang.String parkingSlot) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.fetchReservationDate(reservationDate, parkingLotID, parkingSlot);
    }

    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
        }
    }
}
