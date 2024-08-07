/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_event;

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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class bookTiketAcara extends javax.swing.JFrame implements Runnable {

    private String eventId;
    private int TicketTypeID;
    
    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    /**
     * Creates new form bookTiketAcara
     */
    public bookTiketAcara(String eventId) {
        try {
            this.eventId = eventId;
            initComponents();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            // Maximize the frame
            setExtendedState(bookAcara.MAXIMIZED_BOTH);
            
            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();
            
            nameText.setEditable(false);
            dateText.setEditable(false);
            locationText.setEditable(false);
            availableTicketText.setEditable(false);
            tipeText.setEditable(false);
            hargaText.setEditable(false);
            
            refreshTable();
            
            // Tambahkan listener ke jSpinnerTotalTiket
            jSpinnerTotalTiket.addChangeListener(new javax.swing.event.ChangeListener() {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    updateTotalHarga();
                }
            });
        } catch (IOException ex) {
            System.out.println("Error di book tiket acara: " + ex);
        }
    }
    
    private void start() {
        if (t == null) {
            t = new Thread("Book Tiket Acara");
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

        nameText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        locationText = new javax.swing.JTextField();
        logo = new javax.swing.JLabel();
        reserveButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        hargaTotal = new javax.swing.JLabel();
        hargaTotalLabel = new javax.swing.JLabel();
        totalTiketLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        availableReservationLabel = new javax.swing.JLabel();
        availableTicketText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jAcaraTabel = new javax.swing.JTable();
        back = new javax.swing.JLabel();
        hargaText = new javax.swing.JTextField();
        tipeText = new javax.swing.JTextField();
        hargaLabel = new javax.swing.JLabel();
        tipeLabel = new javax.swing.JLabel();
        jSpinnerTotalTiket = new javax.swing.JSpinner();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 400, 67));

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
        getContentPane().add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 400, 67));

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
        getContentPane().add(locationText, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 60, 390, 67));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        reserveButton.setBackground(new java.awt.Color(187, 224, 253));
        reserveButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        reserveButton.setText("Reserve");
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(reserveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 250, 60));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(57, 62, 70));
        nameLabel.setText("Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 140, -1));

        hargaTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        hargaTotal.setForeground(new java.awt.Color(240, 51, 51));
        hargaTotal.setText("Rp .......");
        getContentPane().add(hargaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 280, 410, -1));

        hargaTotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        hargaTotalLabel.setForeground(new java.awt.Color(57, 62, 70));
        hargaTotalLabel.setText("Harga Total");
        getContentPane().add(hargaTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 280, 230, -1));

        totalTiketLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalTiketLabel.setForeground(new java.awt.Color(57, 62, 70));
        totalTiketLabel.setText("Total Tiket");
        getContentPane().add(totalTiketLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 230, -1));

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(57, 62, 70));
        dateLabel.setText("Date");
        getContentPane().add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 140, -1));

        locationLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(57, 62, 70));
        locationLabel.setText("Location");
        getContentPane().add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 70, 140, -1));

        availableReservationLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        availableReservationLabel.setForeground(new java.awt.Color(57, 62, 70));
        availableReservationLabel.setText("Available Tickets");
        getContentPane().add(availableReservationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 150, 280, -1));

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
        getContentPane().add(availableTicketText, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 140, 390, 67));

        jAcaraTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Date", "Location", "Tipe", "Harga", "Total Quota", "Available Tickets"
            }
        ));
        jAcaraTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcaraTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jAcaraTabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 1800, 460));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconBack.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(120, 125));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 70, 70));

        hargaText.setBackground(new java.awt.Color(207, 219, 229));
        hargaText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        hargaText.setText("Harga");
        hargaText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hargaTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hargaTextFocusLost(evt);
            }
        });
        getContentPane().add(hargaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 400, 67));

        tipeText.setBackground(new java.awt.Color(207, 219, 229));
        tipeText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tipeText.setText("Tipe");
        tipeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tipeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tipeTextFocusLost(evt);
            }
        });
        getContentPane().add(tipeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 400, 67));

        hargaLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        hargaLabel.setForeground(new java.awt.Color(57, 62, 70));
        hargaLabel.setText("Harga");
        getContentPane().add(hargaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 140, -1));

        tipeLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tipeLabel.setForeground(new java.awt.Color(57, 62, 70));
        tipeLabel.setText("Tipe");
        getContentPane().add(tipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 140, -1));

        jSpinnerTotalTiket.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSpinnerTotalTiket.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(jSpinnerTotalTiket, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 270, 220, 60));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveButtonActionPerformed
        // Pengecekan jika available tickets sudah habis
        try {
            int selectedRow = jAcaraTabel.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih tiket terlebih dahulu.", "Kesalahan Reservasi", JOptionPane.WARNING_MESSAGE);
            } 

            else {

                int avaiTikets = Integer.parseInt(availableTicketText.getText());
                int ticketsReserved = (int) jSpinnerTotalTiket.getValue();
                if (ticketsReserved <= avaiTikets) {
                    LocalDateTime now = LocalDateTime.now();

                    int currentSecond = now.getSecond();
                    int currentMinute = now.getMinute();
                    int currentHour = now.getHour();
                    int currentDay = now.getDayOfMonth();
                    int currentMonth = now.getMonthValue();
                    int currentYear = now.getYear() - 2000; // Assuming year 2000 as the starting point

                    // Encode the components into a single int
                    int code = (currentYear << 26) | (currentMonth << 22) | (currentDay << 17)
                            | (currentHour << 12) | (currentMinute << 6) | currentSecond;

                    int userID = UserSession.getUserId();
                    int eventID = Integer.parseInt(eventId);
                    boolean isClaimed = false;
                    String numericString = hargaTotal.getText().replace("Rp", "").replace(".", "").trim();
                    int totalHarga = Integer.parseInt(numericString);

                    String formattedMessage = "RESERVE_EVNT~" + nameText.getText() + "~" + dateText.getText() + "~" + locationText.getText() + "~" + tipeText.getText() + "~" + jSpinnerTotalTiket.getValue() + " tiket" + "~" + "Rp. " + hargaText.getText() + "~" + hargaTotal.getText() + "~" + UserSession.getUsername() + "\n";

                    out.writeBytes(formattedMessage);

                    insertTicket(code, userID, eventID, TicketTypeID, ticketsReserved, totalHarga, isClaimed);
                    updateAvailableTickets(TicketTypeID, ticketsReserved);

                    JOptionPane.showMessageDialog(this, "Sukses Melakukan Reservasi!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(this, "Silakan Cek Kode Reservasi Pada Menu Pemesanan!", "Notification", JOptionPane.INFORMATION_MESSAGE);

                    MainForm windowPlane = new MainForm();

                    if (windowPlane == null || !windowPlane.isVisible()) {
                        windowPlane.setVisible(true);
                    }

                    this.dispose();
                } 

                else {

                    if (avaiTikets == 0) {
                        JOptionPane.showMessageDialog(this, "Stok Tiket yang dipilih telah habis.", "Kesalahan Reservasi", JOptionPane.WARNING_MESSAGE);
                    } 
                    
                    else {
                        JOptionPane.showMessageDialog(this, "Terlalu banyak jumlah tiket yang ingin di reservasi.", "Kesalahan Reservasi", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error di button reservasi event: " + e);
        }
    }//GEN-LAST:event_reserveButtonActionPerformed

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

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) jAcaraTabel.getModel();
        model.setRowCount(0);
        Object[] rowData = new Object[8]; //total kolom tampil

        for (com.ticketing.services.Events obj : selectAllEventsType(eventId)) {
            rowData[0] = obj.getTypeTicketID();
            rowData[1] = obj.getEventName();
            rowData[2] = obj.getEventDate();
            rowData[3] = obj.getEventLocation();
            rowData[4] = obj.getTicketType();
            rowData[5] = obj.getHargaTikets();
            rowData[6] = obj.getTotalQuota();
            rowData[7] = obj.getAvailableTickets();
            model.addRow(rowData);
        }
    }

    private void jAcaraTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcaraTabelMouseClicked
        // TODO add your handling code here:

        DefaultTableModel RecordTable = (DefaultTableModel) jAcaraTabel.getModel();
        int SelectedRows = jAcaraTabel.getSelectedRow();

        nameText.setEditable(false);
        dateText.setEditable(false);
        locationText.setEditable(false);
        availableTicketText.setEditable(false);
        tipeText.setEditable(false);
        hargaText.setEditable(false);

        nameText.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        dateText.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
        locationText.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
        tipeText.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
        hargaText.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
        availableTicketText.setText(RecordTable.getValueAt(SelectedRows, 7).toString());

        jSpinnerTotalTiket.setValue(1);

        TicketTypeID = Integer.parseInt(RecordTable.getValueAt(SelectedRows, 0).toString());
        updateTotalHarga();
    }//GEN-LAST:event_jAcaraTabelMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        bookAcara windowPlane = new bookAcara();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void hargaTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hargaTextFocusGained
        if (hargaText.getText().equals("Harga")) {
            hargaText.setText("");
        }
    }//GEN-LAST:event_hargaTextFocusGained

    private void hargaTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hargaTextFocusLost
        if (hargaText.getText().equals("")) {
            hargaText.setText("Harga");
        }
    }//GEN-LAST:event_hargaTextFocusLost

    private void tipeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipeTextFocusGained
        if (tipeText.getText().equals("Tipe")) {
            tipeText.setText("");
        }
    }//GEN-LAST:event_tipeTextFocusGained

    private void tipeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipeTextFocusLost
        if (tipeText.getText().equals("")) {
            tipeText.setText("Tipe");
        }
    }//GEN-LAST:event_tipeTextFocusLost

    private void updateTotalHarga() {
        try {
            int jumlahTiket = (int) jSpinnerTotalTiket.getValue();
            double hargaTiket = Double.parseDouble(hargaText.getText());
            double totalHarga = jumlahTiket * hargaTiket;

            // Format total harga menggunakan NumberFormat
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMAN);
            String formattedTotalHarga = numberFormat.format(totalHarga);

            hargaTotal.setText("Rp " + formattedTotalHarga);
        } catch (NumberFormatException e) {
            hargaTotal.setText("Rp .......");
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
            java.util.logging.Logger.getLogger(bookTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookTiketAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String eventId = "1";
                new bookTiketAcara(eventId).setVisible(true);
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
    private javax.swing.JLabel hargaLabel;
    private javax.swing.JTextField hargaText;
    private javax.swing.JLabel hargaTotal;
    private javax.swing.JLabel hargaTotalLabel;
    private javax.swing.JTable jAcaraTabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerTotalTiket;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JTextField locationText;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JButton reserveButton;
    private javax.swing.JLabel tipeLabel;
    private javax.swing.JTextField tipeText;
    private javax.swing.JLabel totalTiketLabel;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<com.ticketing.services.Events> selectAllEventsType(java.lang.String arg0) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.selectAllEventsType(arg0);
    }

    private static void updateAvailableTickets(int ticketTypeID, int ticketsReserved) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.updateAvailableTickets(ticketTypeID, ticketsReserved);
    }

    private static void insertTicket(int ticketID, int userID, int eventID, int ticketTypeID, int jumlahTiket, int hargaTotal, boolean isClaimed) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.insertTicket(ticketID, userID, eventID, ticketTypeID, jumlahTiket, hargaTotal, isClaimed);
    }

    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
        }
    }
}
