/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DSSXZ
 */
public class Usuarios extends javax.swing.JFrame {

    conectar cc = new conectar();
    Connection cn = cc.conexion();
    
    /**
     * Creates new form Privilegios
     */
    public Usuarios() {
        initComponents();
        setLocationRelativeTo(null);
        mostrartabla();
        mostrarcomboarea();
        mostrarcombopuesto();
        tipoUsuario();

        
        jTabbedPane2.setEnabledAt(2,false);
        jTabbedPane3.setEnabledAt(1,false);
        jTabbedPane4.setEnabledAt(1,false);
      
 btnprivi.setEnabled(false);
    }
void usuario(JLabel a){
lblUsuario.setText(a.getText());
}
    public int obtenerIdPer(JTextField txtcurp/**/){
    int resultado=0;
    String valor= txtcurp.getText();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idPersona FROM Persona WHERE Curp_Per='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
} 
    
    public int obtenerIdPuesto(JComboBox cmbpuesto/**/){
    int resultado=0;
    String valor= cmbpuesto.getSelectedItem().toString();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idPuesto FROM Puestos WHERE Nom_Pues='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
    public int obtenerIdTusuario(JComboBox cmbtusuario/**/){
    int resultado=0;
    String valor= cmbtusuario.getSelectedItem().toString();
    
    try {
            
            Statement statement = cn.createStatement();
            ResultSet obtenerId = statement.executeQuery("SELECT idTipo_Usr FROM tipo_usr WHERE Nombre_TipoUsr='"+valor+"'");
            while (obtenerId.next()) {
                resultado=obtenerId.getInt(1);
            }//FIN WHILE
            
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return resultado;
}
     
    
    public void insertarPersona(JTextField Nombre,JTextField Paterno,JTextField Materno,JTextField CURP,String Fecha,JTextField Calle,JTextField Colonia,JTextField CP,JTextField Telefono,JTextField NoLic,JTextField Cred){
    String nombre= Nombre.getText();
    String paterno = Paterno.getText();
    String materno = Materno.getText();
    String curp = CURP.getText();
    String calle = Calle.getText();
    String colonia = Colonia.getText();
    String cp = CP.getText();
    String tel = Telefono.getText();
    String lic = NoLic.getText();
    String cred = Cred.getText();
    String fecha=Fecha;
    
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Persona(Nombre_Per,Ape_Pat_Per,Ape_Mat_Per,Curp_Per,Fecha_Nac_Per,Calle_Per,Colonia_Per,CP_Per,Tel_Per,NoLic_Per,NoCred_Per) VALUES ('"+nombre+"','"+paterno+"','"+materno+"','"+curp+"','"+fecha+"','"+calle+"','"+colonia+"',"+cp+","+tel+","+lic+","+cred+")");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}
    public void actualizarPersona(JTextField Nombre,JTextField Paterno,JTextField Materno,JTextField CURP,String Fecha,JTextField Calle,JTextField Colonia,JTextField CP,JTextField Telefono,JTextField NoLic,JTextField Cred){
    String nombre= Nombre.getText();
    String paterno = Paterno.getText();
    String materno = Materno.getText();
    String curp = CURP.getText();
    String calle = Calle.getText();
    String colonia = Colonia.getText();
    String cp = CP.getText();
    String tel = Telefono.getText();
    String lic = NoLic.getText();
    String cred = Cred.getText();
   int idd =obtenerIdPer(txtcurp2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Persona SET Nombre_Per='"+nombre+"',Ape_Pat_Per='"+paterno+"',Ape_Mat_Per='"+materno+"',Curp_Per='"+curp+"',Fecha_Nac_Per='"+Fecha+"',Calle_Per='"+calle+"',Colonia_Per='"+colonia+"',CP_Per='"+cp+"',Tel_Per='"+tel+"',NoLic_Per='"+lic+"',NoCred_Per='"+cred+"'\n" +
"WHERE idPersona='"+idd+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

 public void eliminarPersona(){
    int idd =obtenerIdPer(txtcurp2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Persona WHERE idPersona='"+idd+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}
    
public void insertarEmpleado(JTextField RFC){
    String rfc=RFC.getText();
    int idper=obtenerIdPer(txtcurp);
    int idpues = obtenerIdPuesto(cmbpuesto);
    
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Empleado(RFC_Emp,Puestos_idPuesto,Persona_idPersona) VALUES ('"+rfc+"',"+idpues+","+idper+")");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void actualizarEmpleado(JTextField RFC){
    String rfc=RFC.getText();
   int idpues = obtenerIdPuesto(cmbpuesto2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Empleado SET Puestos_idPuesto='"+idpues+"'\n" +
"WHERE RFC_Emp='"+rfc+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void eliminarEmpleado(JTextField RFC){
    String rfc=RFC.getText();
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Empleado WHERE RFC_Emp='"+rfc+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void insertarUsuario(JTextField RFC,JTextField Contraseña){
    String usuario=RFC.getText();
    String contraseña = Contraseña.getText();
    int idtusuario = obtenerIdTusuario(cmbtusuario);
    
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("INSERT INTO Usuario(Password_Usr,Empleado_RFC_Emp,Tipo_Usr_idTipo_Usr) VALUES ('"+contraseña+"','"+usuario+"',"+idtusuario+")");            

    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

public void actualizarUsuario(JTextField RFC,JTextField Contraseña){
    String usuario=RFC.getText();
    String contraseña = Contraseña.getText();
    int idtusuario = obtenerIdTusuario(cmbtusuario2);
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("UPDATE Usuario SET Password_Usr='"+contraseña+"',Tipo_Usr_idTipo_Usr='"+idtusuario+"'\n" +
"WHERE Empleado_RFC_Emp='"+usuario+"'");            
    
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}
/*void imagen(){
ImageIcon img= new ImageIcon(getClass().getResource("/img/fondoLog.jpeg"));
ImageIcon imagen= new ImageIcon(img.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight(),Image.SCALE_DEFAULT));
}*/
public void eliminarUsuario(JTextField RFC){
    String usuario=RFC.getText();
    try {    
        Statement statement = cn.createStatement();
        statement.executeUpdate("DELETE FROM Usuario WHERE Empleado_RFC_Emp='"+usuario+"'");            
    }catch (SQLException ex) {
            ex.printStackTrace();
        }        
}

    void mostrartabla(){
       
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Usuario");
            modelo.addColumn("Tipo-Usuario");
            
            tabladatos.setModel(modelo);
            
            String sql="SELECT CONCAT(persona.Nombre_Per,' ',persona.Ape_Pat_Per, ' ',persona.Ape_Mat_Per) as Nombre , usuario.Empleado_RFC_Emp, tipo_usr.Nombre_TipoUsr FROM usuario\n" +
"INNER JOIN tipo_usr ON tipo_usr.idTipo_Usr=usuario.Tipo_Usr_idTipo_Usr\n" +
"INNER JOIN empleado ON empleado.RFC_Emp=usuario.Empleado_RFC_Emp\n" +
"INNER JOIN persona ON persona.idPersona=empleado.Persona_idPersona";
            
            
            String datos[] = new String [3];
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                 datos [1]=rs.getString(2);
                 datos [2]=rs.getString(3);
                 
            modelo.addRow(datos);
            }
            tabladatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
       void mostrartablaBuscar(String id){
       
            DefaultTableModel modelo= new DefaultTableModel();
            modelo.addColumn("Nombre");
            modelo.addColumn("Usuario");
            modelo.addColumn("Tipo-Usuario");
            
            tabladatos.setModel(modelo);
            
            String sql="SELECT CONCAT(persona.Nombre_Per,' ',persona.Ape_Pat_Per, ' ',persona.Ape_Mat_Per) as Nombre , usuario.Empleado_RFC_Emp, tipo_usr.Nombre_TipoUsr FROM usuario\n" +
"INNER JOIN tipo_usr ON tipo_usr.idTipo_Usr=usuario.Tipo_Usr_idTipo_Usr\n" +
"INNER JOIN empleado ON empleado.RFC_Emp=usuario.Empleado_RFC_Emp\n" +
"INNER JOIN persona ON persona.idPersona=empleado.Persona_idPersona WHERE usuario.Empleado_RFC_Emp LIKE '"+id+"%' OR Persona.Nombre_Per LIKE '"+id+"%' OR Persona.Ape_Pat_Per LIKE '"+id+"%' OR tipo_usr.Nombre_TipoUsr LIKE '"+id+"%'";
            
            
            String datos[] = new String [3];
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                 datos [1]=rs.getString(2);
                 datos [2]=rs.getString(3);
                 
            modelo.addRow(datos);
            }
            tabladatos.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
      void mostrarPersona(int valor){
       
           
            
            String sql="SELECT * FROM Persona WHERE idPersona="+valor+"";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
               txtnombre2.setText(rs.getString(2));
               txtpaterno2.setText(rs.getString(3));
               txtmaterno2.setText(rs.getString(4));
               txtcurp2.setText(rs.getString(5));
               jXDatePicker2.setDate(rs.getDate(6));
               txtcalle2.setText(rs.getString(7));
               txtcolonia2.setText(rs.getString(8));
               txtcp2.setText(rs.getString(9));
               txttelefono2.setText(rs.getString(10));
               txtnolic2.setText(rs.getString(11));
               txtcred2.setText(rs.getString(12));
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
 void mostrararea(int idp){
 String sql="SELECT * FROM Puestos WHERE idPuesto='"+idp+"'";

            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
           
            
            
            int idu=0;
            String id="";
            String ida="";
            while(rs.next()){
               
               idu=rs.getInt(4);
          id=rs.getString(2);          
            }
            
  String sql2="SELECT * FROM Area WHERE idArea='"+idu+"'";
  
  Statement rr= cn.createStatement();
  ResultSet rt=rr.executeQuery(sql2);
            while(rt.next()){
               
            ida=rt.getString(2);
            }
            
            cmbarea2.setSelectedItem(ida);
            cmbpuesto2.setSelectedItem(id);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 
 }
 
 
      void mostrarEmpleado(String RFC){
       
           
            
            String sql="SELECT * FROM Empleado WHERE RFC_Emp='"+RFC+"'";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            int idp=0;
            int idpu=0;
            int idu=0;
            mostrarpuesto();
            while(rs.next()){
               txtrfc2.setText(rs.getString(1));
               idp=Integer.parseInt(rs.getString(3));
               idpu=Integer.parseInt(rs.getString(2));
               cmbpuesto2.setSelectedIndex(idpu);
               mostrararea(idpu);
               mostrarPersona(idp);
               mostrartusuario(RFC);
                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
         void mostrartusuario(String id){
       
            String sql="SELECT * FROM Usuario WHERE Empleado_RFC_Emp='"+id+"'";
            
           try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            
            int idu=0;
            while(rs.next()){
              idu=Integer.parseInt(rs.getString(4));  
              txtcontraseña2.setText(rs.getString(2));
            }
            if(idu>3){
            cmbtusuario2.addItem(txtrfc2.getText());
            cmbtusuario2.setSelectedItem(txtrfc2.getText());
            }
            else{cmbtusuario2.setSelectedIndex(idu);
            int c=cmbtusuario2.getItemCount()-1;
            
            while(c>3){
            cmbtusuario2.removeItemAt(c);
            c--;}}
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
         
          
          
   
    
     
     
     
    void mostrarcomboarea(){
       
           
    
    
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           
            cmbarea.setModel(modelo);
             cmbarea2.setModel(modelo);
           
           String sql="SELECT Nombre_Area FROM Area GROUP BY Nombre_Area       ";
            
            
            ArrayList datos[] = new ArrayList [1];
           modelo.addElement("Seleccione un Area");
            cmbarea.setModel(modelo);
            cmbarea2.setModel(modelo);
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo.addElement(rs.getObject("Nombre_Area"));
                cmbarea.setModel(modelo);
                cmbarea2.setModel(modelo);
                 
            
            }
            cmbarea.setModel(modelo);
            cmbarea2.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
     
    
void mostrarcombopuesto(){
       
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            
             String a = cmbarea.getSelectedItem().toString();
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
            
            
            String sql="SELECT puestos.Nom_Pues FROM puestos \n" +
"Inner JOIN area ON puestos.Area_idArea=area.idArea\n" +
"WHERE area.Nombre_Area= '"+ a+"'   " ;
            
            ArrayList datos2[] = new ArrayList [1];
           modelo2.addElement("Seleccione un Puesto");
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
            
            try {
               Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                modelo2.addElement(rs.getObject("Nom_Pues"));
                cmbpuesto.setModel(modelo2);
                cmbpuesto2.setModel(modelo2);
                 
            
            }
            cmbpuesto.setModel(modelo2);
            cmbpuesto2.setModel(modelo2);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
}
    

void tipoUsuario(){
        try {
            Statement statement = cn.createStatement();
            ResultSet usuario = statement.executeQuery("SELECT Nombre_TipoUsr FROM Tipo_Usr WHERE idTipo_Usr <4");
            while (usuario.next()) {
                cmbtusuario.addItem(usuario.getString(1));
                cmbtusuario2.addItem(usuario.getString(1));
            }//FIN WHILE
        }catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

void mostrarpuesto(){
        try {
            Statement statement = cn.createStatement();
            ResultSet usuario = statement.executeQuery("SELECT Nom_Pues FROM Puestos");
            while (usuario.next()) {
                cmbpuesto2.addItem(usuario.getString(1));
            }//FIN WHILE
        }catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void mostrararea(){
        try {
            Statement statement = cn.createStatement();
            ResultSet usuario = statement.executeQuery("SELECT Nombre_Area FROM Area");
            while (usuario.next()) {
                cmbarea2.addItem(usuario.getString(1));
            }//FIN WHILE
        }catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
void limpiar(){
txtnombre.setText("");
txtpaterno.setText("");
txtmaterno.setText("");
txtcurp.setText("");
txtcalle.setText("");
txtcolonia.setText("");
txtcp.setText("");
txttelefono.setText("");
txtnolic.setText("");
txtcred.setText(""); 
txtrfc.setText("");
txtcontraseña.setText("");
cmbarea.setSelectedIndex(0);
cmbpuesto.setSelectedIndex(0);
cmbtusuario.setSelectedIndex(0);
txtnombre2.setText("");
txtpaterno2.setText("");
txtmaterno2.setText("");
txtcurp2.setText("");
txtcalle2.setText("");
txtcolonia2.setText("");
txtcp2.setText("");
txttelefono2.setText("");
txtnolic2.setText("");
txtcred2.setText(""); 
txtrfc2.setText("");
txtcontraseña2.setText("");
cmbarea2.setSelectedIndex(0);
cmbpuesto2.setSelectedIndex(0);
cmbtusuario2.setSelectedIndex(0);
jXDatePicker1.setDate(null);
jXDatePicker2.setDate(null);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        btnprivi = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtpaterno = new javax.swing.JTextField();
        txtmaterno = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtcalle = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        txtcp = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtcurp = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtnolic = new javax.swing.JTextField();
        txtcred = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        btnSiguiente1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtrfc = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cmbarea = new javax.swing.JComboBox<>();
        cmbpuesto = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cmbtusuario = new javax.swing.JComboBox<>();
        btnAgregar1 = new javax.swing.JButton();
        txtcontraseña = new javax.swing.JPasswordField();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtnombre2 = new javax.swing.JTextField();
        txtpaterno2 = new javax.swing.JTextField();
        txtmaterno2 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtcalle2 = new javax.swing.JTextField();
        txtcolonia2 = new javax.swing.JTextField();
        txtcp2 = new javax.swing.JTextField();
        btnLimpiar2 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtcurp2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txttelefono2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtnolic2 = new javax.swing.JTextField();
        txtcred2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        btnSiguiente2 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txtrfc2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        cmbarea2 = new javax.swing.JComboBox<>();
        cmbpuesto2 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        cmbtusuario2 = new javax.swing.JComboBox<>();
        btnAgregar2 = new javax.swing.JButton();
        txtcontraseña2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, 104));

        jTabbedPane2.setBackground(new java.awt.Color(255, 241, 215));

        jPanel2.setToolTipText("");

        txtbuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscarFocusGained(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
        });

        jLabel1.setText("Buscar:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        tabladatos.setBackground(new java.awt.Color(253, 253, 252));
        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabladatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabladatosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        btnprivi.setText("Privilegios");
        btnprivi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpriviActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnprivi)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscar)
                    .addComponent(btnprivi)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Usuarios", jPanel2);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Nombre");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 64, -1));

        jLabel22.setText("Ap. Paterno");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 64, -1));

        jLabel24.setText("Ap. Materno");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 71, 64, -1));

        txtnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombreFocusLost(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        jPanel10.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 16, 420, -1));

        txtpaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpaternoFocusLost(evt);
            }
        });
        txtpaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaternoKeyTyped(evt);
            }
        });
        jPanel10.add(txtpaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 42, 420, -1));

        txtmaterno.setToolTipText("");
        txtmaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmaternoFocusLost(evt);
            }
        });
        txtmaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmaternoKeyTyped(evt);
            }
        });
        jPanel10.add(txtmaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 68, 420, -1));

        jSeparator3.setToolTipText("Direccion");
        jPanel10.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 257, 514, -1));

        jLabel25.setText("Calle");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, -1, 15));

        jLabel26.setText("Colonia");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 187, -1, -1));

        jLabel27.setText("CP");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 218, 35, -1));

        txtcalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcalleFocusLost(evt);
            }
        });
        txtcalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcalleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcalleKeyTyped(evt);
            }
        });
        jPanel10.add(txtcalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 158, 418, -1));

        txtcolonia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcoloniaFocusLost(evt);
            }
        });
        txtcolonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcoloniaKeyTyped(evt);
            }
        });
        jPanel10.add(txtcolonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 184, 418, -1));

        txtcp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcpFocusLost(evt);
            }
        });
        txtcp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcpKeyTyped(evt);
            }
        });
        jPanel10.add(txtcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 215, 418, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel10.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 348, 147, -1));

        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("TODOS LOS CAMPOS OBLIGATORIOS");
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 447, 514, -1));

        jLabel28.setText("CURP");
        jPanel10.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 94, 40, -1));

        txtcurp.setToolTipText("");
        txtcurp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcurpFocusLost(evt);
            }
        });
        txtcurp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcurpKeyTyped(evt);
            }
        });
        jPanel10.add(txtcurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 94, 420, -1));

        jLabel29.setText("Telefono");
        jPanel10.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 249, 56, -1));

        txttelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefonoFocusLost(evt);
            }
        });
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });
        jPanel10.add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 246, 418, -1));

        jLabel30.setText("NoLic");
        jPanel10.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 287, 40, -1));

        txtnolic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnolicFocusLost(evt);
            }
        });
        txtnolic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnolicKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnolicKeyTyped(evt);
            }
        });
        jPanel10.add(txtnolic, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 284, 416, -1));

        txtcred.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcredFocusLost(evt);
            }
        });
        txtcred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcredKeyTyped(evt);
            }
        });
        jPanel10.add(txtcred, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 416, -1));

        jLabel31.setText("# Credencial");
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 313, -1, -1));

        jSeparator6.setToolTipText("Direccion");
        jPanel10.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 152, 514, -1));

        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });
        jPanel10.add(btnSiguiente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 348, 147, -1));

        jLabel36.setText("Fecha Nac.");
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, -1, 15));
        jPanel10.add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 124, -1, -1));

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 546, -1));

        jTabbedPane3.addTab("Persona", jPanel6);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setText("Contraseña");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, 90, -1));

        txtrfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrfcFocusLost(evt);
            }
        });
        jPanel7.add(txtrfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 11, 238, -1));

        jLabel34.setText("RFC");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 90, -1));
        jPanel7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 105, 1, 10));

        jLabel35.setText("Area");
        jPanel7.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 90, -1));

        jLabel38.setText("Puesto");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 90, -1));

        cmbarea.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbareaItemStateChanged(evt);
            }
        });
        cmbarea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbareaFocusLost(evt);
            }
        });
        cmbarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbareaActionPerformed(evt);
            }
        });
        jPanel7.add(cmbarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 42, 238, -1));

        cmbpuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpuestoItemStateChanged(evt);
            }
        });
        cmbpuesto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbpuestoFocusLost(evt);
            }
        });
        cmbpuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbpuestoMouseClicked(evt);
            }
        });
        cmbpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpuestoActionPerformed(evt);
            }
        });
        jPanel7.add(cmbpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 76, 238, -1));

        jLabel39.setText("Tipo de Usuario");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        cmbtusuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo" }));
        cmbtusuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtusuarioItemStateChanged(evt);
            }
        });
        cmbtusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbtusuarioFocusLost(evt);
            }
        });
        cmbtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtusuarioMouseClicked(evt);
            }
        });
        cmbtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtusuarioActionPerformed(evt);
            }
        });
        jPanel7.add(cmbtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 187, 238, -1));

        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 296, 147, -1));

        txtcontraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraseñaKeyTyped(evt);
            }
        });
        jPanel7.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 218, 238, -1));

        jTabbedPane3.addTab("Empleado", jPanel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jTabbedPane3)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3))
        );

        jTabbedPane2.addTab("Nuevo", jPanel4);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setText("Nombre");
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 5, 64, -1));

        jLabel42.setText("Ap. Paterno");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 31, 64, -1));

        jLabel43.setText("Ap. Materno");
        jPanel14.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 57, 64, -1));

        txtnombre2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombre2FocusLost(evt);
            }
        });
        txtnombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre2KeyTyped(evt);
            }
        });
        jPanel14.add(txtnombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 2, 420, -1));

        txtpaterno2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpaterno2FocusLost(evt);
            }
        });
        txtpaterno2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpaterno2KeyTyped(evt);
            }
        });
        jPanel14.add(txtpaterno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 28, 420, -1));

        txtmaterno2.setToolTipText("");
        txtmaterno2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmaterno2FocusLost(evt);
            }
        });
        txtmaterno2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmaterno2KeyTyped(evt);
            }
        });
        jPanel14.add(txtmaterno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 54, 420, -1));

        jSeparator8.setToolTipText("Direccion");
        jPanel14.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 243, 514, -1));

        jLabel44.setText("Calle");
        jPanel14.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 147, -1, 15));

        jLabel45.setText("Colonia");
        jPanel14.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 173, -1, -1));

        jLabel46.setText("CP");
        jPanel14.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 204, 35, -1));

        txtcalle2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcalle2FocusLost(evt);
            }
        });
        txtcalle2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcalle2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcalle2KeyTyped(evt);
            }
        });
        jPanel14.add(txtcalle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 144, 418, -1));

        txtcolonia2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcolonia2FocusLost(evt);
            }
        });
        txtcolonia2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcolonia2KeyTyped(evt);
            }
        });
        jPanel14.add(txtcolonia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 170, 418, -1));

        txtcp2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcp2FocusLost(evt);
            }
        });
        txtcp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcp2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcp2KeyTyped(evt);
            }
        });
        jPanel14.add(txtcp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 201, 418, -1));

        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        jPanel14.add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 334, 147, -1));

        jLabel47.setForeground(new java.awt.Color(255, 0, 0));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("TODOS LOS CAMPOS OBLIGATORIOS");
        jPanel14.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 451, 514, -1));

        jLabel48.setText("CURP");
        jLabel48.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel48KeyTyped(evt);
            }
        });
        jPanel14.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 83, 45, -1));

        txtcurp2.setToolTipText("");
        txtcurp2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcurp2FocusLost(evt);
            }
        });
        txtcurp2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcurp2KeyTyped(evt);
            }
        });
        jPanel14.add(txtcurp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 80, 420, -1));

        jLabel49.setText("Telefono");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 235, 56, -1));

        txttelefono2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttelefono2FocusLost(evt);
            }
        });
        txttelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttelefono2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefono2KeyTyped(evt);
            }
        });
        jPanel14.add(txttelefono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 232, 418, -1));

        jLabel50.setText("NoLic");
        jPanel14.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 273, 40, -1));

        txtnolic2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnolic2FocusLost(evt);
            }
        });
        txtnolic2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnolic2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnolic2KeyTyped(evt);
            }
        });
        jPanel14.add(txtnolic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 270, 416, -1));

        txtcred2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcred2FocusLost(evt);
            }
        });
        txtcred2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcred2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcred2KeyTyped(evt);
            }
        });
        jPanel14.add(txtcred2, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 296, 416, -1));

        jLabel51.setText("# Credencial");
        jPanel14.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 299, -1, -1));

        jSeparator9.setToolTipText("Direccion");
        jPanel14.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 138, 514, -1));

        btnSiguiente2.setText("Siguiente");
        btnSiguiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente2ActionPerformed(evt);
            }
        });
        jPanel14.add(btnSiguiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 334, 147, -1));

        jLabel40.setText("Fecha Nac.");
        jPanel14.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 114, -1, 15));
        jPanel14.add(jXDatePicker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 110, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 546, 479));

        jTabbedPane4.addTab("Persona", jPanel13);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setText("Contraseña");
        jPanel15.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 218, 90, -1));

        txtrfc2.setEditable(false);
        txtrfc2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrfc2FocusLost(evt);
            }
        });
        jPanel15.add(txtrfc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 11, 238, -1));

        jLabel54.setText("RFC");
        jPanel15.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 90, -1));
        jPanel15.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 105, 1, 10));

        jLabel55.setText("Area");
        jPanel15.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 90, -1));

        jLabel56.setText("Puesto");
        jPanel15.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 90, -1));

        cmbarea2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbarea2ItemStateChanged(evt);
            }
        });
        cmbarea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbarea2FocusLost(evt);
            }
        });
        cmbarea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbarea2ActionPerformed(evt);
            }
        });
        jPanel15.add(cmbarea2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 42, 238, -1));

        cmbpuesto2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbpuesto2ItemStateChanged(evt);
            }
        });
        cmbpuesto2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbpuesto2FocusLost(evt);
            }
        });
        cmbpuesto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbpuesto2MouseClicked(evt);
            }
        });
        cmbpuesto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpuesto2ActionPerformed(evt);
            }
        });
        jPanel15.add(cmbpuesto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 76, 238, -1));

        jLabel57.setText("Tipo de Usuario");
        jPanel15.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        cmbtusuario2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo" }));
        cmbtusuario2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtusuario2ItemStateChanged(evt);
            }
        });
        cmbtusuario2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbtusuario2FocusLost(evt);
            }
        });
        cmbtusuario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbtusuario2MouseClicked(evt);
            }
        });
        cmbtusuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtusuario2ActionPerformed(evt);
            }
        });
        jPanel15.add(cmbtusuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 187, 238, -1));

        btnAgregar2.setText("Actualizar");
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });
        jPanel15.add(btnAgregar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 299, 147, -1));

        txtcontraseña2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraseña2KeyTyped(evt);
            }
        });
        jPanel15.add(txtcontraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 218, 238, -1));

        jTabbedPane4.addTab("Empleado", jPanel15);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jTabbedPane4)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane4))
        );

        jTabbedPane2.addTab("Modificar", jPanel11);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, 20));
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 120, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

boolean b(JTextField a){
if(a.getText().equals("")){return true;}
return false;
}

boolean b(JComboBox a){
if(a.getSelectedIndex()==0){return true;}
return false;
}
    private void txtcontraseña2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseña2KeyTyped
        if(txtcontraseña2.getText().length()==45){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseña2KeyTyped

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed

        if(b(cmbarea2)||b(cmbpuesto2)||b(cmbtusuario2)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Seleccionar");}
        else if(b(txtrfc2)||b(txtcontraseña2)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Llenar");}
        else{
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(jXDatePicker2.getDate());
            actualizarPersona(txtnombre2,txtpaterno2,txtmaterno2,txtcurp2,fecha,txtcalle2,txtcolonia2,txtcp2,txttelefono2,txtnolic2,txtcred2);
            actualizarEmpleado(txtrfc2);
            actualizarUsuario(txtrfc2,txtcontraseña2);
            mostrartabla();
            JOptionPane.showMessageDialog(rootPane,"Se Actualizo Correctamente");
            jTabbedPane2.setSelectedIndex(0);
            jTabbedPane2.setEnabledAt(2,false);
            jTabbedPane3.setEnabledAt(1,false);
            jTabbedPane4.setEnabledAt(1,false);
            limpiar();}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void cmbtusuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtusuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2ActionPerformed

    private void cmbtusuario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtusuario2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2MouseClicked

    private void cmbtusuario2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtusuario2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2FocusLost

    private void cmbtusuario2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtusuario2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuario2ItemStateChanged

    private void cmbpuesto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuesto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2ActionPerformed

    private void cmbpuesto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbpuesto2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2MouseClicked

    private void cmbpuesto2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbpuesto2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2FocusLost

    private void cmbpuesto2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpuesto2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuesto2ItemStateChanged

    private void cmbarea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbarea2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2ActionPerformed

    private void cmbarea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbarea2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2FocusLost

    private void cmbarea2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbarea2ItemStateChanged
        mostrarcombopuesto();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbarea2ItemStateChanged

    private void txtrfc2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrfc2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrfc2FocusLost

    private void btnSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente2ActionPerformed
        try{
            if(b(txtnombre2)||b(txtpaterno2)||b(txtmaterno2)||b(txtcurp2)||b(txtnombre2)||b(txtcalle2)||b(txtcolonia2)||b(txtcp2)||b(txttelefono2)||b(txtnolic2)||b(txtcred2)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Llenar");}
            else{
                jTabbedPane4.setEnabledAt(1,true);
                jTabbedPane4.setSelectedIndex(1);}
        } catch(NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Se debe Seleccionar una Fecha de Nacimiento", "Error!", JOptionPane.ERROR_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente2ActionPerformed

    private void txtcred2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcred2KeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtcred2.getText().length()==20){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtcred2KeyTyped

    private void txtcred2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcred2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcred2KeyPressed

    private void txtcred2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcred2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcred2FocusLost

    private void txtnolic2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolic2KeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtnolic2.getText().length()==20){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtnolic2KeyTyped

    private void txtnolic2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolic2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolic2KeyPressed

    private void txtnolic2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnolic2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolic2FocusLost

    private void txttelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefono2KeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txttelefono2.getText().length()==12){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txttelefono2KeyTyped

    private void txttelefono2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefono2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono2KeyPressed

    private void txttelefono2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefono2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefono2FocusLost

    private void txtcurp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcurp2KeyTyped
        if(txtcurp2.getText().length()==20){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcurp2KeyTyped

    private void txtcurp2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcurp2FocusLost
        txtcurp2.setText(txtcurp2.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtcurp2FocusLost

    private void jLabel48KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel48KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48KeyTyped

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        limpiar();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void txtcp2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcp2KeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtcp2.getText().length()==11){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtcp2KeyTyped

    private void txtcp2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcp2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcp2KeyPressed

    private void txtcp2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcp2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcp2FocusLost

    private void txtcolonia2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcolonia2KeyTyped
        if(txtcolonia2.getText().length()==45){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcolonia2KeyTyped

    private void txtcolonia2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcolonia2FocusLost
        txtcolonia2.setText(txtcolonia2.getText().toUpperCase());     // TODO add your handling code here:
    }//GEN-LAST:event_txtcolonia2FocusLost

    private void txtcalle2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalle2KeyTyped
        if(txtcalle2.getText().length()==45){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalle2KeyTyped

    private void txtcalle2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalle2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalle2KeyReleased

    private void txtcalle2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcalle2FocusLost
        txtcalle2.setText(txtcalle2.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalle2FocusLost

    private void txtmaterno2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmaterno2KeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtmaterno2.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtmaterno2KeyTyped

    private void txtmaterno2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmaterno2FocusLost
        txtmaterno2.setText(txtmaterno2.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaterno2FocusLost

    private void txtpaterno2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaterno2KeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtpaterno2.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtpaterno2KeyTyped

    private void txtpaterno2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpaterno2FocusLost
        txtpaterno2.setText(txtpaterno2.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaterno2FocusLost

    private void txtnombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre2KeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtnombre2.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtnombre2KeyTyped

    private void txtnombre2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombre2FocusLost
        txtnombre2.setText(txtnombre2.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre2FocusLost

    private void txtcontraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraseñaKeyTyped
        if(txtcontraseña.getText().length()==45){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontraseñaKeyTyped

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        if(b(cmbarea)||b(cmbpuesto)||b(cmbtusuario)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Seleccionar");}
        else if(b(txtrfc)||b(txtcontraseña)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Llenar");}
        else{
            String fecha = new SimpleDateFormat("yyyy-MM-dd").format(jXDatePicker1.getDate());
            insertarPersona(txtnombre,txtpaterno,txtmaterno,txtcurp,fecha,txtcalle,txtcolonia,txtcp,txttelefono,txtnolic,txtcred);
            insertarEmpleado(txtrfc);
            insertarUsuario(txtrfc,txtcontraseña);
            mostrartabla();

            JOptionPane.showMessageDialog(rootPane,"Se Agrego Correctamente");

            jTabbedPane2.setEnabledAt(2,false);
            jTabbedPane3.setEnabledAt(1,false);
            jTabbedPane3.setSelectedIndex(0);
            jTabbedPane4.setEnabledAt(1,false);
            jTabbedPane2.setSelectedIndex(0);
            limpiar();}
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void cmbtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioActionPerformed

    private void cmbtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbtusuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioMouseClicked

    private void cmbtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbtusuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioFocusLost

    private void cmbtusuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtusuarioItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtusuarioItemStateChanged

    private void cmbpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoActionPerformed

    private void cmbpuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbpuestoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoMouseClicked

    private void cmbpuestoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbpuestoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoFocusLost

    private void cmbpuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbpuestoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpuestoItemStateChanged

    private void cmbareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbareaActionPerformed
        mostrarcombopuesto();        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaActionPerformed

    private void cmbareaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbareaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaFocusLost

    private void cmbareaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbareaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbareaItemStateChanged

    private void txtrfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrfcFocusLost
        txtrfc.setText(txtrfc.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtrfcFocusLost

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed
        try{
            if(b(txtnombre)||b(txtpaterno)||b(txtmaterno)||b(txtcurp)||b(txtnombre)||b(txtcalle)||b(txtcolonia)||b(txtcp)||b(txttelefono)||b(txtnolic)||b(txtcred)){JOptionPane.showMessageDialog(rootPane,"Faltan Campos por Llenar");}
            else{
                jTabbedPane3.setEnabledAt(1,true);
                jTabbedPane3.setSelectedIndex(1);}
        } catch(NullPointerException ex) {

            JOptionPane.showMessageDialog(this, "Falta Seleccionar una Fecha de Nacimiento", "Error!", JOptionPane.ERROR_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void txtcredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcredKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtcred.getText().length()==20){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtcredKeyTyped

    private void txtcredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcredKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredKeyPressed

    private void txtcredFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcredFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcredFocusLost

    private void txtnolicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolicKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtnolic.getText().length()==20){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtnolicKeyTyped

    private void txtnolicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnolicKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolicKeyPressed

    private void txtnolicFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnolicFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnolicFocusLost

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9')evt.consume();
        if(txttelefono.getText().length()==12){
            evt.consume(); }

        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txttelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoKeyPressed

    private void txttelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttelefonoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoFocusLost

    private void txtcurpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcurpKeyTyped
        if(txtcurp.getText().length()==20){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcurpKeyTyped

    private void txtcurpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcurpFocusLost
        txtcurp.setText(txtcurp.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtcurpFocusLost

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();// TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtcpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyTyped
        char c = evt.getKeyChar();
        if(c<'0' || c >'9') evt.consume();
        if(txtcp.getText().length()==11){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtcpKeyTyped

    private void txtcpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpKeyPressed

    private void txtcpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcpFocusLost

    private void txtcoloniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcoloniaKeyTyped
        if(txtcolonia.getText().length()==45){
            evt.consume(); }        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoloniaKeyTyped

    private void txtcoloniaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcoloniaFocusLost
        txtcolonia.setText(txtcolonia.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoloniaFocusLost

    private void txtcalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalleKeyTyped
        if(txtcalle.getText().length()==45){
            evt.consume(); }   // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleKeyTyped

    private void txtcalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcalleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleKeyReleased

    private void txtcalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcalleFocusLost
        txtcalle.setText(txtcalle.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtcalleFocusLost

    private void txtmaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmaternoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtmaterno.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtmaternoKeyTyped

    private void txtmaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmaternoFocusLost
        txtmaterno.setText(txtmaterno.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaternoFocusLost

    private void txtpaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpaternoKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtpaterno.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtpaternoKeyTyped

    private void txtpaternoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpaternoFocusLost
        txtpaterno.setText(txtpaterno.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtpaternoFocusLost

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c >'Z') && c!=evt.VK_SPACE ) evt.consume();
        if(txtnombre.getText().length()==45){
            evt.consume(); }// TODO add your handling code here:
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtnombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombreFocusLost
        txtnombre.setText(txtnombre.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarUsuario(txtrfc2);
        eliminarEmpleado(txtrfc2);
        eliminarPersona();
        JOptionPane.showMessageDialog(rootPane,"Se Elimino Correctamente");
        jTabbedPane2.setSelectedIndex(0);
        jTabbedPane2.setEnabledAt(2,false);
        jTabbedPane3.setEnabledAt(1,false);
        jTabbedPane4.setEnabledAt(1,false);
        mostrartabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnpriviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpriviActionPerformed
        PriviUsuarios p= new PriviUsuarios();
        p.usuario(txtrfc2);
        if(usuP(txtrfc2)){usuarioP(txtrfc2);
        p.Insert();
        }
        
        p.mostrartipousuario(txtrfc2.getText());
        
        p.setVisible(true);  
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpriviActionPerformed

    void usuarioP(JTextField a){
    String usuario=a.getText();
    
    try {   
        Statement co=cn.createStatement();
        int c = 3;
        Statement statement = cn.createStatement();
        
        statement.executeUpdate("INSERT INTO Tipo_Usr(Nombre_TipoUsr) VALUES ('"+usuario+"')");            

    }catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    boolean usuP(JTextField a){
    String usuario=a.getText();
    
    try {   
        Statement co=cn.createStatement();
        int c = 3;
        String s="";
        Statement statement = cn.createStatement();
        ResultSet usu =statement.executeQuery("SELECT Nombre_TipoUsr FROM Tipo_Usr WHERE Nombre_TipoUsr='"+usuario+"'");
         while (usu.next()) {
                s=usu.getString(1);
            }           
if(s.equals("")){return true;}
    }catch (SQLException ex) {
            ex.printStackTrace();
        }
    return false;
    }
    private void tabladatosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMousePressed
        if (evt.getClickCount() > 0) {
            Point point = evt.getPoint();
            int row = tabladatos.rowAtPoint(point);
            int column = tabladatos.columnAtPoint(point);
            TableModel model = tabladatos.getModel();
            String a=model.getValueAt(row,1).toString();
            String b=model.getValueAt(row, column).toString();
    
            btnprivi.setEnabled(true);
            mostrarEmpleado(a);

        }
        if (evt.getClickCount() > 1 && tabladatos.isEnabled()==true) {
            Point point = evt.getPoint();
            int row = tabladatos.rowAtPoint(point);
            int column = tabladatos.columnAtPoint(point);
            TableModel model = tabladatos.getModel();
            String a="Usario: "+model.getValueAt(row,1).toString();
            JOptionPane.showMessageDialog(this, a);
           // btnModificar.setEnabled(true);
            mostrarEmpleado(a);

            jTabbedPane2.setEnabledAt(2,true);
            jTabbedPane2.setSelectedIndex(2);
            jTabbedPane4.setSelectedIndex(0);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabladatosMousePressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(txtbuscar.getText().equals("")){mostrartabla();}
        else{mostrartablaBuscar(txtbuscar.getText());}        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        mostrartablaBuscar(txtbuscar.getText());   // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarFocusGained

  
    
    
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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }
public void botonprivilegios(){
   btnprivi.setVisible(false);
    
    }


public void sinnada(){
jTabbedPane2.setEnabledAt(0, false);
jTabbedPane2.setEnabledAt(1, false);
jTabbedPane2.setEnabledAt(2, false);
jTabbedPane2.setEnabledAt(3, false);
jTabbedPane2.setEnabledAt(4, false);

}

public void agregar(){
jTabbedPane2.setEnabledAt(1, true);
jTabbedPane3.setEnabledAt(0, true);
}

public void vizualizar(){
jTabbedPane2.setEnabledAt(0, true);
}

public void modificar(){
tabladatos.setEnabled(true);
}
public void eliminar(){
tabladatos.setEnabled(true);
btnEliminar.setEnabled(true);
btnEliminar.setVisible(true);
}

public void agregar2(){
jTabbedPane2.setEnabledAt(1, false);
jTabbedPane2.setEnabledAt(0, false);
}

public void vizualizar2(){
jTabbedPane2.setEnabledAt(0, false);
}

public void modificar2(){
jTabbedPane2.setEnabledAt(2, false);
tabladatos.setEnabled(false);
}
public void eliminar2(){
btnEliminar.setEnabled(false);
btnEliminar.setVisible(false);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnSiguiente2;
    private javax.swing.JButton btnprivi;
    private javax.swing.JComboBox<String> cmbarea;
    private javax.swing.JComboBox<String> cmbarea2;
    private javax.swing.JComboBox<String> cmbpuesto;
    private javax.swing.JComboBox<String> cmbpuesto2;
    private javax.swing.JComboBox<String> cmbtusuario;
    private javax.swing.JComboBox<String> cmbtusuario2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcalle;
    private javax.swing.JTextField txtcalle2;
    private javax.swing.JTextField txtcolonia;
    private javax.swing.JTextField txtcolonia2;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JPasswordField txtcontraseña2;
    private javax.swing.JTextField txtcp;
    private javax.swing.JTextField txtcp2;
    private javax.swing.JTextField txtcred;
    private javax.swing.JTextField txtcred2;
    private javax.swing.JTextField txtcurp;
    private javax.swing.JTextField txtcurp2;
    private javax.swing.JTextField txtmaterno;
    private javax.swing.JTextField txtmaterno2;
    private javax.swing.JTextField txtnolic;
    private javax.swing.JTextField txtnolic2;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombre2;
    private javax.swing.JTextField txtpaterno;
    private javax.swing.JTextField txtpaterno2;
    private javax.swing.JTextField txtrfc;
    private javax.swing.JTextField txtrfc2;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttelefono2;
    // End of variables declaration//GEN-END:variables
}
