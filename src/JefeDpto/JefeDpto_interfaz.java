/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeDpto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;

/**
 *
 * @author oliver
 */
public class JefeDpto_interfaz extends javax.swing.JFrame { /**
     * Creates new form JefeDpto_interfaz
     */
    
    public void cambiarPestana(int indice)
    {
        tbNuevaSolicitud.setSelectedIndex(0);
    }
    public JefeDpto_interfaz() {
        initComponents();       
        
        SolicitudNueva pantallaNuevaSolicitud= new SolicitudNueva();
        pantallaNuevaSolicitud.setVisible(true);
        tbNuevaSolicitud.add("Nueva Solicitud",pantallaNuevaSolicitud);  
        
        SolicitudRegistros pantallaRegistrosSolicitud= new SolicitudRegistros();
        pantallaRegistrosSolicitud.setVisible(true);
        tbNuevaSolicitud.add("Solicitudes Elaboradas",pantallaRegistrosSolicitud);  
        
        
       
        }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        tbNuevaSolicitud = new javax.swing.JTabbedPane();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbNuevaSolicitud.setPreferredSize(new java.awt.Dimension(820, 495));
        tbNuevaSolicitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNuevaSolicitudMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbNuevaSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbNuevaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNuevaSolicitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNuevaSolicitudMouseClicked
       
    }//GEN-LAST:event_tbNuevaSolicitudMouseClicked
     /**
     * @param args the command line arguments
     */
    
    public void listen()
    {
        JOptionPane.showMessageDialog(null,"ha cambiado algo");
    }
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
            java.util.logging.Logger.getLogger(JefeDpto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JefeDpto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JefeDpto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JefeDpto_interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JefeDpto_interfaz().setVisible(true);
            }
        });
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label label1;
    private javax.swing.JTabbedPane tbNuevaSolicitud;
    // End of variables declaration//GEN-END:variables

//    private DefaultListModel<String> busquedaListaResponsables(String CadenaTxtResponsable, DefaultListModel<String> modeloResponsables) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
