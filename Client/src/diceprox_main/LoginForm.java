/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package diceprox_main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Yosef
 */
public class LoginForm extends javax.swing.JFrame implements Runnable {

    Socket client;
    BufferedReader in;
    DataOutputStream out;
    Thread t;
    private boolean isPasswordVisible = false;

    /**
     * Creates new form login
     */
    public LoginForm() {
        try {
            if (isServerActive()) {
                JOptionPane.showMessageDialog(this, "Connected To Server!", "Koneksi Sukses", JOptionPane.INFORMATION_MESSAGE);
                initComponents();

                client = new Socket("localhost", 5005);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out = new DataOutputStream(client.getOutputStream());
                start();

                //untuk center
                this.setLocationRelativeTo(null);

                // Maximize the frame
                setExtendedState(LoginForm.MAXIMIZED_BOTH);
            } 
            
            else {
                JOptionPane.showMessageDialog(this, "Make Sure Server Form Is Active!", "Koneksi Gagal", JOptionPane.WARNING_MESSAGE);
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println("Error di login form: " + ex);
            JOptionPane.showMessageDialog(this, "Error di login form: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isServerActive() {
        try (Socket socketClient = new Socket("localhost", 5005)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void start() {
        if (t == null) {
            t = new Thread(this, "LoginForm");
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

        logoPassword = new javax.swing.JLabel();
        logoUsername = new javax.swing.JLabel();
        logoEmail = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        masukButton = new javax.swing.JButton();
        setujuText = new javax.swing.JCheckBox();
        salamLabel = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        bagian_kanan = new javax.swing.JLabel();
        background_kiri = new javax.swing.JLabel();
        background_kanan = new javax.swing.JLabel();
        background_kiri1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_password.png"))); // NOI18N
        logoPassword.setText("jLabel4");
        logoPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(logoPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 730, 50, 50));

        logoUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_username.png"))); // NOI18N
        logoUsername.setText("jLabel4");
        getContentPane().add(logoUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 360, 50, 50));

        logoEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_email.png"))); // NOI18N
        logoEmail.setText("jLabel4");
        getContentPane().add(logoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 540, 50, 50));

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
        getContentPane().add(usernameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 1020, 67));

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
        getContentPane().add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 1020, 67));

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
        getContentPane().add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, 1020, 70));

        masukButton.setBackground(new java.awt.Color(0, 102, 255));
        masukButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        masukButton.setForeground(new java.awt.Color(204, 204, 204));
        masukButton.setText("Masuk");
        masukButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukButtonActionPerformed(evt);
            }
        });
        getContentPane().add(masukButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 880, 200, -1));

        setujuText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setujuText.setForeground(new java.awt.Color(57, 62, 70));
        setujuText.setText("Setuju Ketentuan Layanan, Syarat, dan Kebijakan Privasi");
        getContentPane().add(setujuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 890, -1, -1));

        salamLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        salamLabel.setForeground(new java.awt.Color(57, 62, 70));
        salamLabel.setText("SELAMAT DATANG DI DICEPROX !");
        getContentPane().add(salamLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logo.setPreferredSize(new java.awt.Dimension(120, 125));
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 200));

        registerButton.setBackground(new java.awt.Color(255, 51, 51));
        registerButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        registerButton.setForeground(new java.awt.Color(204, 204, 204));
        registerButton.setText("Register");
        registerButton.setToolTipText("");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 880, 200, -1));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bagian_kanan.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 310, 430, 410));

        background_kiri.setBackground(new java.awt.Color(187, 187, 187));
        background_kiri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(background_kiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1410, 1080));

        background_kanan.setBackground(new java.awt.Color(187, 187, 187));
        background_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kanan.png"))); // NOI18N
        getContentPane().add(background_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 0, 510, 1080));

        background_kiri1.setBackground(new java.awt.Color(187, 187, 187));
        background_kiri1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(background_kiri1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, -60, 1410, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void masukButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukButtonActionPerformed

        try {
            if (setujuText.isSelected()) {
                String username = usernameText.getText();
                String email = emailText.getText();
                String password = String.valueOf(passwordText.getPassword());

                String formattedMessage = "LOGIN~" + username + "~" + email + "~" + password + "\n";

                int userId = checkLoginAndGetUserId(username, password, email);

                if (userId != -1) {
                    JOptionPane.showMessageDialog(this, "Login Sukses!", "Notification", JOptionPane.INFORMATION_MESSAGE);

                    out.writeBytes(formattedMessage);

                    String response = in.readLine();
                    JOptionPane.showMessageDialog(this, response);

                    //JOptionPane.showMessageDialog(this, "Login Sukses!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    UserSession.setUserId(userId);
                    UserSession.setUsername(username);
                    UserSession.setEmail(email);

                    boolean userExists = false; // Penanda untuk menentukan apakah user sudah ada

                    for (Integer IDUser : selectAllUserIDLogin()) {
                        if (IDUser instanceof Integer) {
                            System.out.println(IDUser);
                            System.out.println(UserSession.getUserId());
                            if (UserSession.getUserId() == IDUser) {
                                updateTimeLogin(UserSession.getUserId());
                                userExists = true; // Tandai bahwa user sudah ada
                                break; // Keluar dari loop setelah menemukan kecocokan
                            }
                        }
                    }

                    // Jika tidak ada kecocokan ditemukan setelah loop
                    if (!userExists) {
                        insertHistoryLogin(UserSession.getUserId());
                    }

                    MainForm windowPlane = new MainForm();
                    if (windowPlane == null || !windowPlane.isVisible()) {
                        windowPlane.setVisible(true);
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Username, Email, atau Password salah!", "Warning", JOptionPane.WARNING_MESSAGE);
                    usernameText.setText("");
                    emailText.setText("");
                    passwordText.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Setujui persyaratan terlebih dahulu!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            System.out.println("Error di Button Login : " + ex);
            JOptionPane.showMessageDialog(null, "Error di Button Login !!");
        }
    }//GEN-LAST:event_masukButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        RegisterForm windowPlane = new RegisterForm();

        if (windowPlane == null || !windowPlane.isVisible()) {
            windowPlane.setVisible(true);
        }

        this.dispose();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void logoPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoPasswordMouseClicked
        // TODO add your handling code here:
        if (isPasswordVisible) {
            passwordText.setEchoChar('*'); // Menyembunyikan password
        } else {
            passwordText.setEchoChar((char) 0); // Menampilkan password
        }
        isPasswordVisible = !isPasswordVisible;
    }//GEN-LAST:event_logoPasswordMouseClicked

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_kanan;
    private javax.swing.JLabel background_kiri;
    private javax.swing.JLabel background_kiri1;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoEmail;
    private javax.swing.JLabel logoPassword;
    private javax.swing.JLabel logoUsername;
    private javax.swing.JButton masukButton;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel salamLabel;
    private javax.swing.JCheckBox setujuText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {

        } catch (Exception e) {
        }
    }

    private static int checkLoginAndGetUserId(java.lang.String username, java.lang.String password, java.lang.String email) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.checkLoginAndGetUserId(username, password, email);
    }

    private static void insertHistoryLogin(int userID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.insertHistoryLogin(userID);
    }

    private static void updateTimeLogin(int userID) {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        port.updateTimeLogin(userID);
    }

    private static java.util.List<java.lang.Integer> selectAllUserIDLogin() {
        com.ticketing.services.TicketingServices_Service service = new com.ticketing.services.TicketingServices_Service();
        com.ticketing.services.TicketingServices port = service.getTicketingServicesPort();
        return port.selectAllUserIDLogin();
    }
}
