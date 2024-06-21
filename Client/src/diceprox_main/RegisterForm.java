/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package diceprox_main;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import subsistem_event.*;
import com.ticketing.services.TicketingServices_Service;
import com.ticketing.services.TicketingServices;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yosef
 */
public class RegisterForm extends javax.swing.JFrame implements Runnable {

    
    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    
    /**
     * Creates new form register
     */
    public RegisterForm() {
        try {
            initComponents();
            
            //untuk center
            this.setLocationRelativeTo(null);
            
            // Maximize the frame
            setExtendedState(LoginForm.MAXIMIZED_BOTH);
            
            client = new Socket("localhost", 5005);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new DataOutputStream(client.getOutputStream());
            start();
        } 
        
        catch (IOException ex) {
            System.out.println("Error di register form: " + ex);;
        }
    }
    
    private void start() {
        if (t == null) {
            t = new Thread(this, "RegisterForm");
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

        logoUsername = new javax.swing.JLabel();
        logoEmail = new javax.swing.JLabel();
        logoRepeatPassword = new javax.swing.JLabel();
        logoPassword = new javax.swing.JLabel();
        logoUsername1 = new javax.swing.JLabel();
        logoUsername2 = new javax.swing.JLabel();
        termsCheckbox = new javax.swing.JCheckBox();
        privacyCheckbox = new javax.swing.JCheckBox();
        daftarButton = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        fullnameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        repeatPasswordText = new javax.swing.JPasswordField();
        jDateOfBirth = new com.toedter.calendar.JDateChooser();
        logo = new javax.swing.JLabel();
        salamLabel = new javax.swing.JLabel();
        bagian_kanan = new javax.swing.JLabel();
        background_kiri = new javax.swing.JLabel();
        background_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_username.png"))); // NOI18N
        logoUsername.setText("jLabel4");
        getContentPane().add(logoUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 340, 50, 50));

        logoEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_email.png"))); // NOI18N
        logoEmail.setText("jLabel4");
        getContentPane().add(logoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 450, 50, 50));

        logoRepeatPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_password.png"))); // NOI18N
        logoRepeatPassword.setText("jLabel4");
        getContentPane().add(logoRepeatPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 670, 50, 50));

        logoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_password.png"))); // NOI18N
        logoPassword.setText("jLabel4");
        getContentPane().add(logoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 560, 50, 50));

        logoUsername1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_fullname.png"))); // NOI18N
        logoUsername1.setText("jLabel4");
        getContentPane().add(logoUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 230, 50, 50));

        logoUsername2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_dob.png"))); // NOI18N
        logoUsername2.setText("jLabel4");
        getContentPane().add(logoUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 780, 50, 50));

        termsCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        termsCheckbox.setForeground(new java.awt.Color(57, 62, 70));
        termsCheckbox.setText("Menyetujui Kebijakan Privasi");
        termsCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termsCheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(termsCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 870, -1, -1));

        privacyCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        privacyCheckbox.setForeground(new java.awt.Color(57, 62, 70));
        privacyCheckbox.setText("Menyetujui Ketentuan Layanan Kami");
        privacyCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privacyCheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(privacyCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 920, -1, -1));

        daftarButton.setBackground(new java.awt.Color(187, 224, 253));
        daftarButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        daftarButton.setText("Daftar");
        daftarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(daftarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 890, 210, -1));

        usernameText.setBackground(new java.awt.Color(207, 219, 229));
        usernameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        usernameText.setText("Username");
        usernameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTextFocusLost(evt);
            }
        });
        getContentPane().add(usernameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 1020, 67));

        emailText.setBackground(new java.awt.Color(207, 219, 229));
        emailText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        emailText.setText("Email");
        emailText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFocusLost(evt);
            }
        });
        getContentPane().add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 1020, 67));

        fullnameText.setBackground(new java.awt.Color(207, 219, 229));
        fullnameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        fullnameText.setText("Fullname");
        fullnameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fullnameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fullnameTextFocusLost(evt);
            }
        });
        getContentPane().add(fullnameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 1020, 67));

        passwordText.setBackground(new java.awt.Color(207, 219, 229));
        passwordText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        passwordText.setText("Password");
        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTextFocusLost(evt);
            }
        });
        getContentPane().add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 1020, 70));

        repeatPasswordText.setBackground(new java.awt.Color(207, 219, 229));
        repeatPasswordText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        repeatPasswordText.setText("RepeatPassword");
        repeatPasswordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                repeatPasswordTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                repeatPasswordTextFocusLost(evt);
            }
        });
        repeatPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatPasswordTextActionPerformed(evt);
            }
        });
        getContentPane().add(repeatPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 660, 1020, 70));

        jDateOfBirth.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        getContentPane().add(jDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 770, 1020, 70));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        salamLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        salamLabel.setForeground(new java.awt.Color(57, 62, 70));
        salamLabel.setText("SELAMAT DATANG DI DICEPROX !");
        getContentPane().add(salamLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagian_kanan.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 310, 430, 410));

        background_kiri.setBackground(new java.awt.Color(187, 187, 187));
        background_kiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(background_kiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 1080));

        background_kanan.setBackground(new java.awt.Color(187, 187, 187));
        background_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kanan.png"))); // NOI18N
        getContentPane().add(background_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 0, 510, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void termsCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termsCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_termsCheckboxActionPerformed

    private void privacyCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privacyCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_privacyCheckboxActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed

        try {
            
            if (!termsCheckbox.isSelected() || !privacyCheckbox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Anda harus menyetujui kebijakan privasi dan ketentuan layanan kami !!!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            
            else {
                String username = usernameText.getText();
                String password = String.valueOf(passwordText.getPassword());
                String rePassword = String.valueOf(repeatPasswordText.getPassword());
                String fullname = fullnameText.getText();
                String email = emailText.getText();
                Date dOB = jDateOfBirth.getDate();
                SimpleDateFormat dateOfBirth = new SimpleDateFormat("yyyy-MM-dd");
                String regisDOB = dateOfBirth.format(dOB);
                
                String formattedMessage = "REGISTER~" + fullname + "~" + username + "~" + email + "~" + password + "~" + rePassword + "~" + regisDOB;
                
                out.writeBytes(formattedMessage);
                
                boolean register = checkRegister(email);
                
                if (register) {    
                    
                    if (password.equals(rePassword)) {
                        
                        String response = in.readLine();
                        
                        JOptionPane.showMessageDialog(this, response);
                        
                        //JOptionPane.showMessageDialog(this, "Registrasi sukses!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                        
                        insertAccRegist(username, password, fullname, email, regisDOB);                 
                        
                        LoginForm windowPlane = new LoginForm();
                        
                        if (windowPlane == null || !windowPlane.isVisible()) {
                            windowPlane.setVisible(true);
                        }
                        
                        this.dispose();
                    }
                }  
                
                else {
                    
                    JOptionPane.showMessageDialog(this, "Email ini sudah digunakan, mohon gunakan email lain!", "Warning", JOptionPane.WARNING_MESSAGE);
//                    fullnameText.setText("");
//                    usernameText.setText("");
//                    emailText.setText("");
//                    passwordText.setText("");
//                    repeatPasswordText.setText("");
//                    jDateOfBirth.setDateFormatString("");
                    
                }
            }
        }
        
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saat menyimpan data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_daftarButtonActionPerformed

    private void usernameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusGained
        if (usernameText.getText().equals("Username")) {
            usernameText.setText("");
        }
    }//GEN-LAST:event_usernameTextFocusGained

    private void usernameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTextFocusLost
        if (usernameText.getText().equals("")) {
            usernameText.setText("Username");
        }
    }//GEN-LAST:event_usernameTextFocusLost

    private void emailTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFocusGained
        if (emailText.getText().equals("Email")) {
            emailText.setText("");
        }
    }//GEN-LAST:event_emailTextFocusGained

    private void emailTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFocusLost
        if (emailText.getText().equals("")) {
            emailText.setText("Email");
        }
    }//GEN-LAST:event_emailTextFocusLost

    private void passwordTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusGained
        if (passwordText.getText().equals("Password")) {
            passwordText.setText("");
        }
    }//GEN-LAST:event_passwordTextFocusGained

    private void passwordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusLost
        if (passwordText.getText().equals("")) {
            passwordText.setText("Password");
        }
    }//GEN-LAST:event_passwordTextFocusLost

    private void repeatPasswordTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repeatPasswordTextFocusGained
        if (repeatPasswordText.getText().equals("RepeatPassword")) {
            repeatPasswordText.setText("");
        }
    }//GEN-LAST:event_repeatPasswordTextFocusGained

    private void repeatPasswordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repeatPasswordTextFocusLost
        if (repeatPasswordText.getText().equals("")) {
            repeatPasswordText.setText("RepeatPassword");
        }
    }//GEN-LAST:event_repeatPasswordTextFocusLost

    private void repeatPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repeatPasswordTextActionPerformed

    private void fullnameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameTextFocusGained
        if (fullnameText.getText().equals("Fullname")) {
            fullnameText.setText("");
        }
    }//GEN-LAST:event_fullnameTextFocusGained

    private void fullnameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fullnameTextFocusLost
        if (fullnameText.getText().equals("")) {
            fullnameText.setText("Fullname");
        }
    }//GEN-LAST:event_fullnameTextFocusLost

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_kanan;
    private javax.swing.JLabel background_kiri;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JButton daftarButton;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField fullnameText;
    private com.toedter.calendar.JDateChooser jDateOfBirth;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoEmail;
    private javax.swing.JLabel logoPassword;
    private javax.swing.JLabel logoRepeatPassword;
    private javax.swing.JLabel logoUsername;
    private javax.swing.JLabel logoUsername1;
    private javax.swing.JLabel logoUsername2;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JCheckBox privacyCheckbox;
    private javax.swing.JPasswordField repeatPasswordText;
    private javax.swing.JLabel salamLabel;
    private javax.swing.JCheckBox termsCheckbox;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables

    
    private static Boolean checkRegister(java.lang.String email) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.checkRegister(email);
    }
    
    private static void insertAccRegist(java.lang.String username, java.lang.String password, java.lang.String fullname, java.lang.String email, java.lang.String dateOfBirth) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.insertAccRegist(username, password, fullname, email, dateOfBirth);
    }

    @Override
    public void run() {
        try {
            
        } catch (Exception e) {
        }
    }
}
