

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DSSXZ
 */
public class Control extends javax.swing.JFrame {
Usuarios u= new Usuarios();
InterfazProductos p= new InterfazProductos();
conectar cc=new conectar();
Connection cn=cc.conexion();


    /**
     * Creates new form Control
     */
    public Control() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnSolicitudes = new javax.swing.JButton();
        btnprivi = new javax.swing.JButton();
        txtusuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 104));

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 80, -1));

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        btnSolicitudes.setText("Solicitudes");
        btnSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudesActionPerformed(evt);
            }
        });
        getContentPane().add(btnSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        btnprivi.setText("Privilegios");
        btnprivi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpriviActionPerformed(evt);
            }
        });
        getContentPane().add(btnprivi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));
        getContentPane().add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 120, 20));

        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
if(txtusuario.getText().equals("")){
Usuarios priv= new Usuarios(); 
priv.setVisible(true);

}else{
        
// TODO add your handling code here:
String a,a2,b,b2,c,c2,d,d2;
   //usuario idmodulo 1
   String us=txtusuario.getText();
   int valor= tipousuario(us);
   a=obtenerAPmod1(valor);
    b=obtenerBPmod1(valor);
    c=obtenerAcPmod1(valor);
    d=obtenerVPmod1(valor);
    
    Usuarios priv= new Usuarios(); 
    if(a.equals("S")) { priv.agregar(); }else{priv.agregar2();} 
         if(b.equals("S")) { priv.eliminar();}else{priv.eliminar2();}
         if(c.equals("S")){  priv.modificar();}else {priv.modificar2();}
         if(d.equals("S")) { priv.vizualizar(); }else{priv.vizualizar2();}
        
         
         priv.botonprivilegios();
       priv.usuario(txtusuario);
       priv.setVisible(true);}

    }//GEN-LAST:event_btnUsuariosActionPerformed
 //-------------------------------------------------------------------------Usuarios------------------------------------//
     public int tipousuario(String usuario){
   
   String usu=usuario;
  
   
      int resultado=0;
      try {
            
            Statement statement = cn.createStatement();
            ResultSet tipousuario = statement.executeQuery("SELECT Tipo_Usr_idTipo_Usr FROM `Usuario` WHERE Empleado_RFC_Emp = '"+usu+"'");
            while (tipousuario.next()) {
                resultado=tipousuario.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
     
   public String obtenerAPmod1(int resultado1){
    String resultado="";
     String us=txtusuario.getText();
     
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Agregar_Priv from usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '1' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"' ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
     public String obtenerBPmod1(int resultado1){
    String resultado="";
  String us=txtusuario.getText();
     
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Borrar_Priv from usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '1' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'    ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
    
    
 
      public String obtenerAcPmod1(int resultado1){
    String resultado="";
    String us=txtusuario.getText();
      
    int valor= tipousuario(us); 
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Actualizar_Priv FROM usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '1' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'  ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
 
      public String obtenerVPmod1(int resultado1 ){
    String resultado="";
      String us=txtusuario.getText();
      
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Visualizar_Priv FROM usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '1' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}    
 
    
    
    
    
    
    
    
    
    
    
    //-------------------------------------------------------------------------Usuarios------------------------------------//
    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed

    if(txtusuario.getText().equals("")){
    InterfazProductos priv= new  InterfazProductos();
    priv.setVisible(true);
    priv.usuario(txtusuario);
    }else{
        String a,a2,b,b2,c,c2,d,d2;
   //usuario idmodulo 1
    String us=txtusuario.getText();
    
    int valor= tipousuario(us);
    a=obtenerAPmod2(valor);
    b=obtenerBPmod2(valor);
    c=obtenerAcPmod2(valor);
    d=obtenerVPmod2(valor);
    
    InterfazProductos priv= new  InterfazProductos();
    priv.usuario(txtusuario);
    if(a.equals("S")) { priv.agregar(); }else{priv.agregar2();} 
         if(b.equals("S")) { priv.eliminar();}else{priv.eliminar2();}
         if(c.equals("S")){  priv.modificar();}else {priv.modificar2();}
         if(d.equals("S")) { priv.vizualizar(); }else{priv.vizualizar2();}
        
        priv.setVisible(true);   }     // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    //-------------------------------------------------------------------------Productos-----------------------------------//
     
    
     
   public String obtenerAPmod2(int resultado1){
    String resultado="";
     String us=txtusuario.getText();
     
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Agregar_Priv from usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '2' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"' ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
     public String obtenerBPmod2(int resultado1){
    String resultado="";
  String us=txtusuario.getText();
     
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Borrar_Priv from usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '2' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'    ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
    
    
 
      public String obtenerAcPmod2(int resultado1){
    String resultado="";
    String us=txtusuario.getText();
      
    int valor= tipousuario(us); 
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Actualizar_Priv FROM usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '2' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'  ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
 
      public String obtenerVPmod2(int resultado1 ){
    String resultado="";
      String us=txtusuario.getText();
      
    int valor= tipousuario(us);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Visualizar_Priv FROM usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '2' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}    
 
    
    
    
    
    
    
    
    
    
    
    private void btnSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudesActionPerformed
        Solicitudes s = new Solicitudes();
        s.setVisible(true);
    }//GEN-LAST:event_btnSolicitudesActionPerformed

    private void btnpriviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpriviActionPerformed
 AsigPrivi p= new AsigPrivi();
        p.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnpriviActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
this.dispose();
        Login l=new Login();
l.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed
public void btnprivilegios(){
btnprivi.setVisible(false);
}
    
void usuario(JTextField a){
txtusuario.setText(a.getText());

}


public void btnSolicitudes(){
btnSolicitudes.setVisible(true);
}

public void btnSolicitudes2(){
btnSolicitudes.setVisible(false);
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
            java.util.logging.Logger.getLogger(Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Control.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnprivi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel txtusuario;
    // End of variables declaration//GEN-END:variables
}
