


import Administrador.Administrador_interfaz;
import Empleado.Empleado_interfaz;
import JefeDpto.JefeDpto_interfaz;
import JefeSistemas.Sistemas;
import Presidencia.Presidencia_interfaz;
import Secretaria.Secretaria_interfaz;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.*;
import Usuarios.usuarios_controlador;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raulrcg
 */
public class Login extends javax.swing.JFrame {
 Control c = new Control();
 
    /**
     * Creates new form Login
     */
    
 
 
 conectar cc=new conectar();
Connection cn=cc.conexion();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        //cn = mysql.MySQLConnect();
        /*************/
   jButton1.setVisible(false);
        
      
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcontraseña = new javax.swing.JPasswordField();
        btningresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IEE CVV");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistema de Control de Inventarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entrar al sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 3, 18))); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel1FocusLost(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuario.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusuarioFocusLost(evt);
            }
        });
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 89, 620, 50));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 157, -1, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        jLabel4.setText("Usuario");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 51, -1, -1));

        txtcontraseña.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 201, 620, 50));

        btningresar.setText("Ingresar");
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btningresarMouseClicked(evt);
            }
        });
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel1.add(btningresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 269, 300, 66));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 308, -1, -1));

        jLabel5.setText("Instituto tecnológico de Tepic - ISC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(134, 134, 134)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(381, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
    
    }//GEN-LAST:event_btningresarMouseClicked

    private void txtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusuarioFocusLost
     
    }//GEN-LAST:event_txtusuarioFocusLost
void cerrar(){

}
    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
     
     usuarios_controlador objUsuario =new usuarios_controlador();
     
     String us=txtusuario.getText();
     String cont=txtcontraseña.getText();
      
     if(objUsuario.comprobarExistenciaUsuario(us,cont))
     {
      int idUsuario=objUsuario.traerIdUsuario(us,cont);
      //traer el tipo de usuario
      String tipoUsuario=objUsuario.tipoUsuario(us);

      if(tipoUsuario.equals("JefeDepartamentoViatico"))
      {
          JefeDpto_interfaz pantalla=new JefeDpto_interfaz(idUsuario);
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      
      if(tipoUsuario.equals("SecretariaViatico"))
      {
          Secretaria_interfaz pantalla=new Secretaria_interfaz(idUsuario);
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      
      if(tipoUsuario.equals("PresidenciaViatico"))
      {
          Presidencia_interfaz pantalla=new Presidencia_interfaz(idUsuario);
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      
      if(tipoUsuario.equals("EmpleadoViatico"))
      {
          Empleado_interfaz pantalla=new Empleado_interfaz(idUsuario);
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      
      if(tipoUsuario.equals("AdministradorViatico"))
      {
          Administrador_interfaz pantalla=new Administrador_interfaz(idUsuario);
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      
      if(tipoUsuario.equals("JefeInformaticoViatico"))
      {
          Sistemas pantalla=new Sistemas();
          pantalla.setVisible(true);
          this.setVisible(false);
      }
      //determinar a que pantalla ira
     }
     
     else
     {
       int valor= tipousuario(us,cont);
    String ap=obtenerAPmod3(valor);
    
    String usuar=usuario(us);
     String contraseña=contraseña(cont);
        
        
     if(txtusuario.getText().equals("") || txtcontraseña.getText().equals("")){
         JOptionPane.showMessageDialog(null,"Acceso denegado");
        }   
     
     
     else if(usuar.equals(us) && contraseña.equals(cont) ){
        
       Usuarios u= new Usuarios();
       u.botonprivilegios();
       
       
        Control c = new Control();
       c.btnprivilegios();
        c.setVisible(true);    
        c.usuario(txtusuario);
        c.setVisible(true);
        this.dispose();
       if(ap.equals("S")) { c.btnSolicitudes(); }else{c.btnSolicitudes2();} 
        /*if(bp.equals("S")) { c.eliminar();}else{c.eliminar2();}
        if(acp.equals("S")){  c.modificar();}else {c.modificar2();}
        if(vp.equals("S")) { c.vizualizar(); }else{c.vizualizar2();}
         c.botonprivilegios();
         */
        
        }
        
        else if(txtusuario.getText().equals("superAdmin") && txtcontraseña.getText().equals("1234")){
      
        c.setVisible(true);    
        this.dispose();
        
       
        }
        
        else {JOptionPane.showMessageDialog(null,"Acceso denegado");}
     }  
    }//GEN-LAST:event_btningresarActionPerformed

    
    public String obtenerAPmod3(int resultado1){
    String resultado="";
     String us=txtusuario.getText();
     
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT p.Agregar_Priv from usuario as u inner join tipo_usr as tu on (u.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) inner join privilegios as p on (p.Tipo_Usr_idTipo_Usr=tu.idTipo_Usr) WHERE p.Modulo_idModulo= '3' and p.Tipo_Usr_IdTipo_Usr = '"+valor+"' ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
    
    public int tipousuario(String usuario,String contraseña){
   
   String usu=usuario;
   String contra= contraseña;
   
      int resultado=0;
      try {
            
            Statement statement = cn.createStatement();
            ResultSet tipousuario = statement.executeQuery("SELECT Tipo_Usr_idTipo_Usr FROM `Usuario` WHERE Password_Usr = '"+contra+"' and Empleado_RFC_Emp = '"+usu+"'");
            while (tipousuario.next()) {
                resultado=tipousuario.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
    
    
    //
    //
    //
    public String usuario(String contraseña){
   
String contra= contraseña;
   String us=contraseña;
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
   
      String resultado="";
      try {
            
            Statement statement = cn.createStatement();
            ResultSet tipousuario = statement.executeQuery("SELECT Empleado_RFC_Emp FROM Usuario WHERE Tipo_Usr_idTipo_Usr = '"+valor+"' AND Password_Usr='"+cont+"' AND Empleado_RFC_Emp='"+txtusuario.getText()+"'");
            while (tipousuario.next()) {
                resultado=tipousuario.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
    public String contraseña(String usuario){
   
   String usu=usuario;
   String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
   
      String resultado="";
      try {
            
            Statement statement = cn.createStatement();
            ResultSet tipousuario = statement.executeQuery("SELECT Password_Usr FROM Usuario WHERE Tipo_Usr_idTipo_Usr = '"+valor+"' AND Empleado_RFC_Emp='"+us+"'");
            while (tipousuario.next()) {
                resultado=tipousuario.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
    
    //
    //
    //
    
   
    
    
     
    
     public String obtenerAP(int resultado1/**/){
    String resultado="";
     String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Agregar_Priv FROM Privilegios INNER JOIN Tipo_Usr on Privilegios.Tipo_Usr_idTipo_Usr = Tipo_Usr.idTipo_Usr where Tipo_Usr_idTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
    }
    
    
    
    
     public String obtenerBP(int resultado1/**/){
    String resultado="";
  String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Borrar_Priv FROM Privilegios INNER JOIN Tipo_Usr on Privilegios.Tipo_Usr_idTipo_Usr = Tipo_Usr.idTipo_Usr where Tipo_Usr_idTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
    
 
     
      public String obtenerAcP(int resultado1){
    String resultado="";
    String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont); 
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Actualizar_Priv FROM Privilegios INNER JOIN Tipo_Usr on Privilegios.Tipo_Usr_idTipo_Usr = Tipo_Usr.idTipo_Usr where Tipo_Usr_idTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
     
    
   
     
    public String obtenerVP(int resultado1){
    String resultado="";
      String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerAP = statement.executeQuery(" SELECT Visualizar_Priv FROM Privilegios INNER JOIN Tipo_Usr on Privilegios.Tipo_Usr_idTipo_Usr = Tipo_Usr.idTipo_Usr where Tipo_Usr_idTipo_Usr = '"+valor+"'   ");
            while (obtenerAP.next()) {
                resultado=obtenerAP.getString(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}    
    
    
    
    
    private void txtusuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusuarioFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtusuarioFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String us=txtusuario.getText();
      String cont=txtcontraseña.getText();
    int valor= tipousuario(us,cont);
    String a=obtenerAP(valor);
    String b=obtenerBP(valor);
    String c=obtenerAcP(valor);
    String d=obtenerVP(valor);
    String usuar=usuario(us);
     String contraseña=contraseña(cont);
    
    JOptionPane.showMessageDialog(null, valor+a+b+c+d+usuar+contraseña);
   
    






        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusLost
    
    }//GEN-LAST:event_jPanel1FocusLost

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
       // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

  
    
    public void msg(String cad){
        javax.swing.JOptionPane.showMessageDialog(null,cad);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
