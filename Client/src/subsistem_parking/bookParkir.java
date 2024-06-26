/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_parking;

import diceprox_main.MainForm;

/**
 *
 * @author Yosef
 */
public class bookParkir extends javax.swing.JFrame {

    /**
     * Creates new form bookParkir
     */
    public bookParkir() {
        initComponents();

        //untuk center
        this.setLocationRelativeTo(null);

        // Maximize the frame
        setExtendedState(bookParkir.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonCancel = new javax.swing.JButton();
        buttonBook = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        labelBrand = new javax.swing.JLabel();
        labelPlateNumber = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        textPlateNumber = new javax.swing.JTextField();
        textBrand = new javax.swing.JTextField();
        textClass = new javax.swing.JTextField();
        textColor = new javax.swing.JTextField();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonCancel.setText("Cancel Booking");
        getContentPane().add(buttonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 242, 200, -1));

        buttonBook.setText("Book Parking");
        getContentPane().add(buttonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 242, 200, -1));

        jLabel5.setText("Color");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 180, -1, -1));

        jLabel4.setText("Class");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 146, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Number Plate", "Brand", "Class", "Color"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 44, -1, -1));

        labelBrand.setText("Brand");
        getContentPane().add(labelBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 115, -1, -1));

        labelPlateNumber.setText("Number Plate");
        getContentPane().add(labelPlateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 81, -1, -1));

        textId.setEnabled(false);
        getContentPane().add(textId, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 44, 237, -1));

        labelID.setText("ID");
        getContentPane().add(labelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 47, -1, -1));
        getContentPane().add(textPlateNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 78, 291, -1));
        getContentPane().add(textBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 112, 291, -1));
        getContentPane().add(textClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 146, 291, -1));
        getContentPane().add(textColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 180, 291, -1));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconBack.png"))); // NOI18N
        back.setPreferredSize(new java.awt.Dimension(120, 125));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 70, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(bookParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bookParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bookParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bookParkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bookParkir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JButton buttonBook;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBrand;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelPlateNumber;
    private javax.swing.JTable table;
    private javax.swing.JTextField textBrand;
    private javax.swing.JTextField textClass;
    private javax.swing.JTextField textColor;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textPlateNumber;
    // End of variables declaration//GEN-END:variables
}
