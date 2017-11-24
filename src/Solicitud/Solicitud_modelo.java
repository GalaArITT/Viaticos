/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitud;

import Conexion.Conexion;
import Usuarios.usuarios_modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author oliver
 */
public class Solicitud_modelo {

     private java.sql.Date fechaSalida;
     private String personalViatico;
     private int diasViatico;
     private String lugarViatico;
     private String actividadViatico;
     private String pernoctado;
     private String statusViatico;
     private int idUsuario;
     private int idVehiculo;
     private int idSolicitud;
     
     
    
    Conexion con = new Conexion();
    Connection conn = con.getConexion();
    
    public Solicitud_modelo() {
        
    }
    public Solicitud_modelo(Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                            String pernoctado,String statusViatico,int idUsuario,int idVehiculo) 
    {   
        this.fechaSalida = new java.sql.Date(fechaSalida.getTime());
        this.personalViatico=personalViatico;
        this.diasViatico=diasViatico;
        this.lugarViatico=lugarViatico;
        this.actividadViatico=actividadViatico;
        this.pernoctado=pernoctado;
        this.statusViatico=statusViatico;
        this.idUsuario=idUsuario;
        this.idVehiculo=idVehiculo;
        
        
    }
    
    public Solicitud_modelo(int idSolicitud,Date fechaSalida,String personalViatico, int diasViatico,String lugarViatico,String actividadViatico,
                            String pernoctado,String statusViatico,int idUsuario,int idVehiculo) 
    {   
        this.idSolicitud=idSolicitud;
        this.fechaSalida = new java.sql.Date(fechaSalida.getTime());
        this.personalViatico=personalViatico;
        this.diasViatico=diasViatico;
        this.lugarViatico=lugarViatico;
        this.actividadViatico=actividadViatico;
        this.pernoctado=pernoctado;
        this.statusViatico=statusViatico;
        this.idUsuario=idUsuario;
        this.idVehiculo=idVehiculo;
        
        
    }
    
    public void insertaSolicitud()
    {
        try
        {
            String sqlSol="insert into solicitudes_viaticos("
                    + "fechaSolViatico,"
                    + "fechaSalidaViatico,"
                    + "personalViatico,"
                    + "diasViatico,"
                    + "lugarViatico,"
                    + "actividadViatico,"
                    + "pernoctado,"
                    + "statusViatico,"
                    + "idUsuario,"
                    + "idVehiculo"
                    + ")"
                    + "values(now(),?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sqlSol); 
            
            pst.setDate(1,fechaSalida);
            pst.setString(2,personalViatico);
            pst.setInt(3,diasViatico);
            pst.setString(4,lugarViatico);
            pst.setString(5,actividadViatico);
            pst.setString(6,pernoctado);
            pst.setString(7,statusViatico);
            pst.setInt(8,idUsuario);
            pst.setInt(9,idVehiculo);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Solicitud enviada para su revisión");
        }
    }
    
        public void modificaSolicitud()
    {
        try
        {
            
            String sqlModSol="update solicitudes_viaticos set"
                    + "lugarViatico=?,"
                    + "actividadViatico=?,"
                    + "idVehiculo=?,"
                    + "pernoctado=?,"
                    + "fechaSalida=?,"
                    + "personalViatico=?,"
                    + "diasViatico=?"
                    + "where idSolViatico=?";
            
            PreparedStatement pst = conn.prepareStatement(sqlModSol); 
            
            pst.setString(1,lugarViatico);
            pst.setString(2,actividadViatico);
            pst.setInt(3,idVehiculo);
            pst.setString(4,pernoctado);
            pst.setDate(5,fechaSalida);
            pst.setString(6,personalViatico);
             pst.setInt(7,diasViatico);
            pst.setInt(8,idSolicitud);
            
            pst.executeUpdate();
       }

        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,ex);
        } 

        finally 
        {
            JOptionPane.showMessageDialog(null,"Solicitud modificada exitosamente");
        }
    }
    
    
     public String [][] traerSolicitudesViaticos()
    {
       int filas=obtenerCantidadSolicitudes();
        String arregloSolicitudes[][]=new String[filas][12];
        try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select idSolViatico,folViatico,fechaSalidaViatico,personalViatico,"
                     + "diasViatico,lugarViatico,actividadViatico,pernoctado,statusViatico,"
                     + "idUsuario,nom_prod,idVehiculo "
                     + "from solicitudes_viaticos "
                     + "inner join productos ON productos.idProductos=solicitudes_viaticos.idVehiculo";
            
             ResultSet resul=stm.executeQuery(sql);
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

               while(resul.next())
      {        
               int fila=resul.getRow()-1;
               int idSolViatico=resul.getInt("idSolViatico");
               String folViatico=resul.getString("folViatico");
               Date fechaSalidaViatico=resul.getDate("fechaSalidaViatico");
               String personalViatico=resul.getString("personalViatico");
               int diasViatico=resul.getInt("diasViatico");
               String lugarViatico=resul.getString("lugarViatico");
               String actividadViatico=resul.getString("actividadViatico");
               String pernoctado=resul.getString("pernoctado");
               String statusViatico=resul.getString("statusViatico");
               int idUsuario=resul.getInt("idUsuario");
               String nom_prod=resul.getString("nom_prod");
               int idVehiculo=resul.getInt("idVehiculo");
          
         
               arregloSolicitudes[fila][0]=String.valueOf(idSolViatico);
               arregloSolicitudes[fila][1]=String.valueOf(folViatico);
               arregloSolicitudes[fila][2]=df.format(fechaSalidaViatico);
               arregloSolicitudes[fila][3]=personalViatico;
               arregloSolicitudes[fila][4]=String.valueOf(diasViatico);
               arregloSolicitudes[fila][5]=lugarViatico;
               arregloSolicitudes[fila][6]=actividadViatico;
               arregloSolicitudes[fila][7]=pernoctado;
               arregloSolicitudes[fila][8]=statusViatico;
               arregloSolicitudes[fila][9]=String.valueOf(idUsuario);
               arregloSolicitudes[fila][10]=nom_prod;
               arregloSolicitudes[fila][11]=String.valueOf(idVehiculo);
            
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      return arregloSolicitudes;
    }
    
    public int obtenerCantidadSolicitudes()
    {
       int cantidadSol=0;
       try {
            Conexion con=new Conexion();
            Connection conn=con.getConexion();
            Statement stm=conn.createStatement();
            
             String sql="select count(*) as cantidad from solicitudes_viaticos";
            
             ResultSet resul=stm.executeQuery(sql);
             
               while(resul.next())
      {
         cantidadSol=resul.getInt("cantidad");
      }
           
        } catch (SQLException ex) {
            Logger.getLogger(usuarios_modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
       return cantidadSol;
    }
    
}
