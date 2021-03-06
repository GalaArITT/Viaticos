
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oscar
 */
public class InterfazCarEsp extends javax.swing.JFrame {
    DefaultTableModel modelo;
    String tipoClas="";
    conectar cc=new conectar();
    Connection cn=cc.conexion();
    
    /**
     * Creates new form InterfazCarEsp
     */
    public InterfazCarEsp() {
        initComponents();
        inicio();
        setLocationRelativeTo(null);
        setTitle("InterfazCarEsp");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Caracteristicas Especiales:  ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dato", "Contenido"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione la Caracteristica." }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione el tipo de caracteristicas que desea agregar y rellene la tabla con sus datos correspondientes.");

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(btnContinuar)
                .addGap(151, 151, 151)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel6.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void inicio(){
        //Almacen
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerAlmacen = statement.executeQuery("SELECT Nombre_CarEsp FROM car_esp");
            while (obtenerAlmacen.next()) {
                jComboBox1.addItem(obtenerAlmacen.getString(1));
            }//FIN WHILE
        }catch (SQLException ex) {
            Logger.getLogger(InterfazProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int obtenerIdCar(){
        int resultado=0;
        String valor = jComboBox1.getSelectedItem().toString();
        
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerIdAlmacen = statement.executeQuery("SELECT idCar_Esp FROM car_esp where Nombre_CarEsp='"+valor+"'");
            while (obtenerIdAlmacen.next()) {
                resultado=obtenerIdAlmacen.getInt(1);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }    
    
    public void buscarDatos(){
        modelo= new DefaultTableModel();
        modelo.addColumn("Dato");
        modelo.addColumn("Contenido");
        jTable1.setModel(modelo);
        
        int valor = obtenerIdCar();
        String datos[]= new String [2];
        try {   
            Statement statement = cn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT Nombre_Dat FROM datos_esp where Car_Esp_idCar_Esp='"+valor+"'");
            while (rs.next()) {
                datos[0]= rs.getString("Nombre_Dat");
                datos[1]="";
                modelo.addRow(datos);
            }//FIN WHILE
            jTable1.setModel(modelo);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public int obtenerIdDatEsp(String DatEsp){
        int resultado=0;
        int  idCar=obtenerIdCar();
        try {
            Statement statement = cn.createStatement();
            ResultSet obtenerIdAlmacen = statement.executeQuery("SELECT da.idDatos_Esp FROM datos_esp as da where da.Nombre_Dat='"+DatEsp+"' and da.Car_Esp_idCar_Esp='"+idCar+"'       ");
            while (obtenerIdAlmacen.next()) {
                resultado=obtenerIdAlmacen.getInt(1);
            }//FIN WHILE
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public void insertarContenidoTabla(String dato,int idDatEsp){
        InterfazProductos prod=new InterfazProductos();
        String folioClas_Dato = prod.generarFolioProd(tipoClas);
        
        try {
            Statement statement = cn.createStatement();
            statement.executeUpdate("INSERT into contenido(Contenido_Cont,FolioClas_Cont,Datos_Esp_idDatos_Esp) values('"+dato+"' ,'"+folioClas_Dato+"' ,"+idDatEsp+") ");
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean verificarTabla(){
        TableModel modeloN = jTable1.getModel();
        boolean es=false;
        for(int i=0; i< modeloN.getRowCount(); i++){
            if(modeloN.getValueAt(i,1)!=""){
                es= true;
            }else{
                es=false;
            }
        }
        return es;
    }
    
    public void eliminarResiduos(){
        InterfazProductos prod=new InterfazProductos();
        String folioClas_Dato = prod.generarFolioProd(tipoClas);
        
        try {
            Statement statement = cn.createStatement();
            statement.executeUpdate("delete from contenido where FolioClas_Cont='"+folioClas_Dato+"' ");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        
        jTable1.setFocusable(false);
        try{
            TableModel modeloN = jTable1.getModel();
            for(int i=0; i<modeloN.getRowCount(); i++){
                if(modeloN.getValueAt(i,1)!="" ){
                    int id=obtenerIdDatEsp(modelo.getValueAt(i, 0).toString() );
                    insertarContenidoTabla(modelo.getValueAt(i, 1).toString(), id);
                }else{
                    showMessageDialog(null, "Inserte el campo "+(i+1)+" de la tabla");
                }
            }
            if (verificarTabla() ){
                this.setVisible(false);
            }
        
        }catch(NullPointerException e){
            showMessageDialog(null,"Asegurese de haber insertado");
        }
        
       
        
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        
        
    }//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if(jComboBox1.getSelectedIndex()!=0){
            buscarDatos();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        TableModel modeloN = jTable1.getModel();
        for(int i=0; i<modeloN.getRowCount(); i++){
            modelo.setValueAt(modelo.getValueAt(i, 1).toString().toUpperCase(), i, 1);
            if(modelo.getValueAt(i, 1).toString().length()==45){
                evt.consume(); 
            }
        }    
    }//GEN-LAST:event_jTable1KeyTyped

    
   
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
            java.util.logging.Logger.getLogger(InterfazCarEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCarEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCarEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCarEsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCarEsp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables



    public void usuario(JLabel a){
        lblUsuario.setText(a.getText());
    }

}