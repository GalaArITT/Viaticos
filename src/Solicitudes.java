

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
public class Solicitudes extends javax.swing.JFrame {
    
    public String nomUsuario;
    
    public Solicitudes(String nom) {
        initComponents();
        //Verificamos las solicitudes que tiene el        conectar cc = new conectar();
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        
        //Solicitudes al usuario
        //Variables para aguardar los valores de la solicitud
        String estatus, fecha, tipo, id;
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery("SELECT idSolicitudes, Status_Sol, Tipo_Sol, Fecha_Sol FROM Solicitudes s"
                    + " WHERE (SELECT idUsuario FROM Usuario WHERE Empleado_RFC_Emp LIKE \'"+nom+"\') = s.idUsuario_Sol");
            while (obtenerAP.next()) {
                id = obtenerAP.getString(1);
                estatus = obtenerAP.getString(2);
                tipo = obtenerAP.getString(3);
                fecha = obtenerAP.getString(4);
                
                DefaultTableModel temp = (DefaultTableModel) jtbSol.getModel();
                Object nuevo[]= {id, estatus, tipo, fecha};
                temp.addRow(nuevo);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void agregarSolicitud(String est, String fecha, String tipo, String desc){
        DefaultTableModel temp = (DefaultTableModel) jtbSol.getModel();
        Object nuevo[]= {fecha, tipo, };
        temp.addRow(nuevo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbSol = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        btnVerMas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jtbSol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Solicitud", "Estado", "Asunto", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbSol);
        if (jtbSol.getColumnModel().getColumnCount() > 0) {
            jtbSol.getColumnModel().getColumn(0).setResizable(false);
            jtbSol.getColumnModel().getColumn(1).setResizable(false);
            jtbSol.getColumnModel().getColumn(2).setResizable(false);
            jtbSol.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Nueva.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Eliminar.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(204, 0, 0));

        btnVerMas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVerMas.setText("Ver mas.");
        btnVerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMasActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerMas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnVerMas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Solicitudes.", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMasActionPerformed
        if(jtbSol.getSelectedRows().length != 1){
            showMessageDialog(this, "Solo debe seleccionar una fila para poder verla.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vales v = new Vales();
        v.setTextResBoton("Crear vale");
        v.setTextSalBoton("Crear vale");
        v.setTextRecBoton("Crear vale");
        //Se verifica que tipo de asunto es la solicitud
        switch((String)jtbSol.getValueAt(jtbSol.getSelectedRow(), 2)) {
            case "Solicitud de Recoleccion":{
                v.jtbVales.setEnabledAt(0, true);
                v.jtbVales.setEnabledAt(1, false);
                v.jtbVales.setEnabledAt(2, false);
                v.jtbVales.setSelectedIndex(0);
                crearSolRec(v, jtbSol.getSelectedRow());
                break;
            }
            case "Solicitud de Resguardo":{
                v.jtbVales.setEnabledAt(0, false);
                v.jtbVales.setEnabledAt(1, false);
                v.jtbVales.setEnabledAt(2, true);
                v.jtbVales.setSelectedIndex(2);
                crearSolRes(v, jtbSol.getSelectedRow());
                break;
            }
            case "Solicitud de Salida de Almacen":{
                v.jtbVales.setEnabledAt(0, false);
                v.jtbVales.setEnabledAt(1, true);
                v.jtbVales.setEnabledAt(2, false);
                v.jtbVales.setSelectedIndex(1);
                crearSolSal(v, jtbSol.getSelectedRow());
                break;
            }
        }
        v.setVisible(true);
    }//GEN-LAST:event_btnVerMasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Primero se verfica si hay columnas a eliminar
        if(jtbSol.getSelectedRows().length == 0){
            showMessageDialog(this, "No se ha seleccionado solicitudes a eliminar.", "Detalles.",JOptionPane.ERROR_MESSAGE);
        }
        if(JOptionPane.showConfirmDialog(this, "¿Esta  seguro que quiere eliminar?") != JOptionPane.OK_OPTION){
            return;
        }
        //Se almacenan los idSolicitudes
        String []idSolicitud = new String[jtbSol.getSelectedRows().length];
        for(int i = 0; i < idSolicitud.length; i++){
            idSolicitud[i] = jtbSol.getValueAt(jtbSol.getSelectedRows()[i], 0)+"";
        }
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        Statement statement;
        
        DefaultTableModel temp = (DefaultTableModel) jtbSol.getModel();
        int []filas = jtbSol.getSelectedRows();
        
        try {
            int tempFilas = 0;
            for(String id:idSolicitud){
                //Eliminar las solicitudes de la tabla
                statement = cn.createStatement();
                String query = "DELETE FROM Solicitudes WHERE idSolicitudes = "+id;
                statement.executeUpdate(query);
                
                temp.removeRow(filas[tempFilas]);
                tempFilas++;
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        showMessageDialog(this, "Solicitudes eliminadas correctamente.", "Detalles.",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Vales v = new Vales();
        v.setTextResBoton("Crear solicitud");
        v.setTextSalBoton("Crear solicitud");
        v.setTextRecBoton("Crear solicitud");
        v.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    public void crearSolRec(Vales v, int fila){
        String productos, descripcion;
        productos = descripcion = "";
        
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery("SELECT Descripcion_Sol FROM Solicitudes"
                    + " WHERE "+jtbSol.getValueAt(fila, 0)+" = idSolicitudes");
            while (obtenerAP.next()) {
                descripcion = obtenerAP.getString(1);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        descripcion = descripcion.replace("Responsable:\t", "");
        descripcion = descripcion.replace("Cargo:\t", "");
        descripcion = descripcion.replace("Area:\t", "");
        descripcion = descripcion.replace("Tipo de uso:\t", "");
        descripcion = descripcion.replace("Municipio:\t", "");
        descripcion = descripcion.replace("Localidad:\t", "");
        descripcion = descripcion.replace("Mobiliario y equipo de computo\n", "");
        String []f = descripcion.split("\n");
        
        for(int i = 6; i < f.length; i++){
            productos += f[i];
        }
        v.crearValeRec(f[0], f[1], f[2], f[3], f[4], f[5], productos);
    }
    public void crearSolRes(Vales v, int fila){
        String productos, descripcion;
        productos = descripcion = "";
        
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery("SELECT Descripcion_Sol FROM Solicitudes"
                    + " WHERE "+jtbSol.getValueAt(fila, 0)+" = idSolicitudes");
            while (obtenerAP.next()) {
                descripcion = obtenerAP.getString(1);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        descripcion = descripcion.replace("Responsable:\t", "");
        descripcion = descripcion.replace("Cargo:\t", "");
        descripcion = descripcion.replace("Area:\t", "");
        descripcion = descripcion.replace("Tipo de uso:\t", "");
        descripcion = descripcion.replace("Municipio:\t", "");
        descripcion = descripcion.replace("Localidad:\t", "");
        descripcion = descripcion.replace("Mobiliario y equipo de computo\n", "");
        String []f = descripcion.split("\n");
        
        for(int i = 6; i < f.length; i++){
            productos += f[i];
        }
        v.crearValeRes(f[0], f[1], f[2], f[3], f[4], f[5], productos);
    }
    public void crearSolSal(Vales v, int fila){
        String productos, descripcion;
        productos = descripcion = "";
        
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery("SELECT Descripcion_Sol FROM Solicitudes"
                    + " WHERE "+jtbSol.getValueAt(fila, 0)+" = idSolicitudes");
            while (obtenerAP.next()) {
                descripcion = obtenerAP.getString(1);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        descripcion = descripcion.replace("Nombre:\t", "");
        String []f = descripcion.split("\n");
        
        for(int i = 6; i < f.length; i++){
            productos += f[i];
        }
        v.crearValeSal(f[0], productos);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerMas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtbSol;
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables
}
