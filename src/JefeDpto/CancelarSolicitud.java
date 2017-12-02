/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeDpto;

import Solicitud.Solicitud_controlador;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class CancelarSolicitud extends javax.swing.JPanel {
int idSolicitud=0;
public String motivoCancelado="";
    /**
     * Creates new form CancelarSolicitud
     */
    public CancelarSolicitud() {
        initComponents();
    }
    
    public void cargarCampos(int idSolicitud)
    {
        this.idSolicitud=idSolicitud;
        lblCancela.setText("Cancela una solicitud (folio "+idSolicitud+")");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCancela = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCancela = new javax.swing.JTextArea();
        btnCancelarSol = new javax.swing.JButton();

        lblCancela.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCancela.setText("Cancela una solicitud (Folio)");

        jLabel2.setText("Motivio de la cancelación (Obligatorio)");

        txtCancela.setColumns(20);
        txtCancela.setRows(5);
        txtCancela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCancelaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtCancela);

        btnCancelarSol.setText("Cancelar solicitud");
        btnCancelarSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancelarSol)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarSol)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSolActionPerformed
      
 
      if(!motivoCancelado.equals(""))
      {
          Solicitud_controlador objControlador=new Solicitud_controlador();
          objControlador.modificarStatus(idSolicitud,"Cancelada");
      }
      
      else
      {
         JOptionPane.showMessageDialog(null,"Debe haber un motivo de cancelación");
      }
    }//GEN-LAST:event_btnCancelarSolActionPerformed

    private void txtCancelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCancelaKeyReleased
        motivoCancelado=txtCancela.getText();
    }//GEN-LAST:event_txtCancelaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelarSol;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCancela;
    private javax.swing.JTextArea txtCancela;
    // End of variables declaration//GEN-END:variables
}
