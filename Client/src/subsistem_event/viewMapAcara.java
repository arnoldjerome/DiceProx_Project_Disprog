/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package subsistem_event;

import java.util.HashSet;
import java.util.Set;
import javax.swing.event.MouseInputListener;
import org.jxmapviewer.VirtualEarthTileFactoryInfo;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

/**
 *
 * @author fransxeagle
 */
public class viewMapAcara extends javax.swing.JFrame {

    private String eventId;
    
    /**
     * Creates new form viewMapAcara
     */
    public viewMapAcara(String eventId, Double latitude, Double longitude) {
        initComponents();
        
        this.eventId = eventId;

        //untuk center
        this.setLocationRelativeTo(null);

        // Maximize the frame
        setExtendedState(bookAcara.MAXIMIZED_BOTH);

        // Mengatur tema map viewer ke Virtual Earth
        TileFactoryInfo virtualEarthInfo = new VirtualEarthTileFactoryInfo(VirtualEarthTileFactoryInfo.MAP);
        DefaultTileFactory virtualEarthFactory = new DefaultTileFactory(virtualEarthInfo);
        jXMapViewer.setTileFactory(virtualEarthFactory);

        // Menentukan lokasi berdasarkan latitude dan longitude
        GeoPosition position = new GeoPosition(latitude, longitude);
        jXMapViewer.setAddressLocation(position);
        jXMapViewer.setZoom(2); // Zoom lebih dekat (nilai lebih kecil berarti lebih dekat)

        // Menambahkan listener untuk interaksi dengan peta
        MouseInputListener mouseListener = new PanMouseInputListener(jXMapViewer);
        jXMapViewer.addMouseListener(mouseListener);
        jXMapViewer.addMouseMotionListener(mouseListener);
        jXMapViewer.addMouseWheelListener(new ZoomMouseWheelListenerCenter(jXMapViewer));

        // Menambahkan penanda lokasi
        Set<Waypoint> waypointSet = new HashSet<>();
        waypointSet.add(new DefaultWaypoint(position));
        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypointSet);
        jXMapViewer.setOverlayPainter(waypointPainter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXMapViewer = new org.jxmapviewer.JXMapViewer();
        logo = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        bagian_kanan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jXMapViewer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 1840, 720));

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

        eventLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(57, 62, 70));
        eventLabel.setText("VIEW ON MAP");
        getContentPane().add(eventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        bagian_kanan.setBackground(new java.awt.Color(187, 187, 187));
        bagian_kanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_main_kiri.png"))); // NOI18N
        getContentPane().add(bagian_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        String eventId = this.eventId;

        detailAcara windowPlane = new detailAcara(eventId);

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
            java.util.logging.Logger.getLogger(viewMapAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewMapAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewMapAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewMapAcara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String eventId = "1";
                Double Latitude = 0.0;
                Double Longitude = 0.0;
                new viewMapAcara(eventId, Latitude, Longitude).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bagian_kanan;
    private javax.swing.JLabel eventLabel;
    private org.jxmapviewer.JXMapViewer jXMapViewer;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
